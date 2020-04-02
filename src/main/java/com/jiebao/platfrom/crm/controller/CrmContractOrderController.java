package com.jiebao.platfrom.crm.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.jiebao.platfrom.common.controller.BaseController;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.exception.JiebaoException;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;
import com.jiebao.platfrom.crm.service.ICrmContractOrderService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
@Slf4j
@RestController
@RequestMapping("/crm/contract-order")
@DS("crm")
public class CrmContractOrderController extends BaseController {


    @Autowired
    ICrmContractOrderService iCrmContractOrderService;

    @GetMapping
    public List<Map<String, Object>> collect(CrmContractOrder crmContractOrder) {
        List<Map<String, Object>> contractOrderDetail = iCrmContractOrderService.findContractOrderDetail(crmContractOrder);
        return contractOrderDetail;
    }

    @GetMapping("/findContractOrderById/{billParentid}")
    public CrmContractOrder findContractOrderById(@NotBlank(message = "{required}") @PathVariable String billParentid) {
        return iCrmContractOrderService.findContractOrderById(billParentid);
    }


    /**
     * 月销售记录整理
     * @param month
     * @param year
     * @return
     */
    @GetMapping("List")
    public List<CrmOrderMonth> crmContractOrderList(String month, String year) {
        return iCrmContractOrderService.crmContractOrderList(year, month);
    }

    @PostMapping("excel")
    public void export(String year, String month, HttpServletResponse response) throws JiebaoException {
        try {
            List<CrmOrderMonth> crmOrderMonths = iCrmContractOrderService.crmContractOrderList(year, month);
            ExcelKit.$Export(CrmOrderMonth.class, response).downXlsx(crmOrderMonths, false);
        } catch (Exception e) {
            String message = "导出Excel失败";
            log.error(message, e);
            throw new JiebaoException(message);
        }
    }
}
