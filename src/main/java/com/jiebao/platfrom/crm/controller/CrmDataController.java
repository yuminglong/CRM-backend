package com.jiebao.platfrom.crm.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.jiebao.platfrom.common.annotation.Log;
import com.jiebao.platfrom.common.controller.BaseController;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.exception.JiebaoException;
import com.jiebao.platfrom.crm.domain.CrmData;
import com.jiebao.platfrom.crm.service.ICrmDataService;
import com.jiebao.platfrom.crm.util.ApiKit;
import com.jiebao.platfrom.system.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 金智CRM数据接口-数据处理
 * @author Sinliz
 */
@RestController
@RequestMapping("/crm/data")
@DS("crm")  //切换数据源
public class CrmDataController extends BaseController {

    private String message;
    @Autowired
    private ICrmDataService iCrmDataService;

    @Value("${jiebao.crm.appid}")
    private String appId;

    @Value("${jiebao.crm.listType}")
    private String listType;

    //默认一次读取数据条数
    private final String pageSize = "50";


    @GetMapping(value = "/crmDataList")
    public Map<String, Object> crmDataList(QueryRequest request, CrmData crmData) {
        return getDataTable(iCrmDataService.getCrmDataList(request, crmData));
    }

    /**
     * 修改接口
     * @param crmData
     * @throws JiebaoException
     */
    @PutMapping
    public void updateUser(@Valid CrmData crmData) throws JiebaoException {
        try {
            this.iCrmDataService.updateById(crmData);
        } catch (Exception e) {
            message = "修改接口失败";
            throw new JiebaoException(message);
        }
    }

    /**
     * 抓取所有需要更新的数据接口信息
     * @return
     * @throws JiebaoException
     */
    @PostMapping(value = "/updateDataByAll")
    public String updateDataByAll () throws JiebaoException {
        String message = "success";
        List<CrmData> list = iCrmDataService.listByUpdate();
        if (null != list && list.size() > 0) {
            list.forEach(crmData -> this.processDomain(crmData, 1));
        } else {
            message = "未查询到需要更新的数据接口!";
            throw new JiebaoException(message);
        }
        return message;
    }

    /**
     * 根据单个数据接口，抓取所有数据信息
     * @param crmData
     * @return
     * @throws JiebaoException
     */
    @PostMapping(value = "updateData")
    public String updateData (CrmData crmData) throws JiebaoException {
        String message = "success";
        if (null != crmData) {
            this.processDomain(crmData, 1);
        } else {
            message = "未查询当前需要更新的数据接口!";
            throw new JiebaoException(message);
        }
        return message;
    }

    /**
     * 根据数据接口信息，分页读取接口数据
     * @param crmData   接口信息
     * @param currentPage   当前页
     */
    private void processDomain (CrmData crmData, Integer currentPage) {
        Map postMap = new LinkedHashMap<>();
        postMap.put("stamp", System.currentTimeMillis() / 1000);
        postMap.put("datatype", crmData.getDataTypeId());
        postMap.put("page", currentPage);
        postMap.put("pagesize", pageSize);
        postMap.put("customerid", "");
        JSONObject jsonObject = ApiKit.request(appId, listType, postMap);
        Integer totalCount = jsonObject.getInteger("totalCount");
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        this.saveDomain(jsonArray, crmData.getBean());
        if (new BigDecimal(currentPage).multiply(new BigDecimal(pageSize)).compareTo(new BigDecimal(totalCount)) < 1) {
            this.processDomain(crmData, ++ currentPage);    //递归
        }
    }

    /**
     * 根据查询到的数据信息 通过java reflect自动识别实体对象, 自动装配json数据. 并保存至数据库
     * TODO：Mybatis-plus 实体类 extends Model<T> 后, T 对象可以直接调用Model父类的方法 如：insert update等.
     * @param jsonArray 接口获取来的json数据
     * @param bean domain文件路径
     */
    private void saveDomain (JSONArray jsonArray, String bean) {
        jsonArray.forEach(detail -> {
            JSONObject json = (JSONObject) detail;
            try {
                JSONObject detailJson = json.getJSONObject("detail");   //jsonObject
                detailJson = this.processDetailJson(detailJson);
                Class domain = Class.forName(bean); //domain.class
                Object object = detailJson.toJavaObject(domain); // jsonObject -> object domain
                Class superClazz = object.getClass().getSuperclass();
                Method method = superClazz.getDeclaredMethod("insert");
                method.invoke(object);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 处理部分json数据与数据库的匹配
     * @param jsonObject
     * @return
     */
    private JSONObject processDetailJson (JSONObject jsonObject) {
        String [] ids = {"fk_buyid", "bill_parentid", "hk_htid"};
        Arrays.stream(ids).forEach(id -> {
            JSONObject childNode = jsonObject.getJSONObject(id);
            String childId = null;
            if (childNode != null && childNode.size() > 0) {
                childId = childNode.getString("id");
            }
            jsonObject.put(id, childId);
        });
        return jsonObject;
    }

}
