package com.jiebao.platfrom.crm.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.exception.JiebaoException;
import com.jiebao.platfrom.crm.domain.CrmPay;
import com.jiebao.platfrom.crm.service.ICrmDataService;
import com.jiebao.platfrom.crm.service.ICrmPurchaseService;
import com.jiebao.platfrom.system.domain.User;
import com.wuwenze.poi.ExcelKit;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Sinliz
 */
@Slf4j
@RestController
@RequestMapping("/crm/purchase")
@DS("crm")  //切换数据源
public class CrmPurchaseController {

    private String message;

    @Autowired
    private ICrmPurchaseService iCrmPurchaseService;

    @GetMapping(value = "/crmPay")
    public List<Map<String, Object>> crmPay(String queryParams) throws ParseException {
        List<Map<String, Object>> map = null;
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        if (year.equals(queryParams)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();
            map = iCrmPurchaseService.getcrmPay(sdf.format(d));
        } else {
            map = iCrmPurchaseService.getcrmPay(queryParams + "-12-01");
        }

        Map<String, Object> newmap = new HashMap<>();
        Integer purchase = 0;//采购支出
        Integer revenue = 0;//收支流水
        Integer reimburse = 0;//费用报销
        Integer sum = 0;//合计
        for (Map<String, Object> m : map) {
            if (m.get("采购支出") != null)
                purchase += Integer.parseInt(String.valueOf(m.get("采购支出")));
            if (m.get("收支流水") != null)
                revenue += Integer.parseInt(String.valueOf(m.get("收支流水")));
            if (m.get("费用报销") != null)
                reimburse += Integer.parseInt(String.valueOf(m.get("费用报销")));
            if (m.get("总计") != null)
                sum += Integer.parseInt(String.valueOf(m.get("总计")));
        }
        newmap.put("month1", "合计");
        newmap.put("采购支出", purchase);
        newmap.put("收支流水", revenue);
        newmap.put("费用报销", reimburse);
        newmap.put("总计", sum);
        map.add(newmap);
        return map;
    }

    @PostMapping("excel")
    public void export(HttpServletResponse response, @RequestParam(required = false) String queryParams) throws JiebaoException {
        try {
            List<Map<String, Object>> map = null;
            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            if (year.equals(queryParams)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = new Date();
                map = iCrmPurchaseService.getcrmPay(sdf.format(d));
            } else {
                map = iCrmPurchaseService.getcrmPay(queryParams + "-12-01");
            }
            Map<String, Object> newmap = new HashMap<>();
            Integer purchase = 0;//采购支出
            Integer revenue = 0;//收支流水
            Integer reimburse = 0;//费用报销
            Integer sum = 0;//合计
            for (Map<String, Object> m : map) {
                if (m.get("采购支出") != null)
                    purchase += Integer.parseInt(String.valueOf(m.get("采购支出")));
                if (m.get("收支流水") != null)
                    revenue += Integer.parseInt(String.valueOf(m.get("收支流水")));
                if (m.get("费用报销") != null)
                    reimburse += Integer.parseInt(String.valueOf(m.get("费用报销")));
                if (m.get("总计") != null)
                    sum += Integer.parseInt(String.valueOf(m.get("总计")));
            }
            newmap.put("month1", "合计");
            newmap.put("采购支出", purchase);
            newmap.put("收支流水", revenue);
            newmap.put("费用报销", reimburse);
            newmap.put("总计", sum);
            map.add(newmap);
            ExcelKit.$Export(CrmPay.class, response).downXlsx(map, false);

        } catch (Exception e) {
            message = "导出Excel失败";
            log.error(message, e);
            throw new JiebaoException(message);
        }
    }

    @GetMapping("payDetail")
    public List<Map<String, Object>> payDetail(@RequestParam(required = false) String date, @RequestParam(required = false) String choose) throws ParseException {
        return iCrmPurchaseService.payDetail(date, choose);
    }

}
