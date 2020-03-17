package com.jiebao.platfrom.crm.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.exception.JiebaoException;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;
import com.jiebao.platfrom.crm.service.ICrmContractOrderService;
import com.jiebao.platfrom.system.domain.User;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author Sinliz
 */
@Slf4j
@RestController
@RequestMapping("/crm/contract-order")
@DS("crm")
public class CrmContractOrderController {
    @Autowired
    ICrmContractOrderService orderService;

    //月销售记录整理
    @GetMapping("List")
    public List<CrmOrderMonth> crmContractOrderList(String month, String year) {
        return orderService.crmContractOrderList(year, month);
    }

    @PostMapping("excel")

    public void export(String year, String month, HttpServletResponse response) throws JiebaoException {
        try {
            List<CrmOrderMonth> crmOrderMonths = orderService.crmContractOrderList(year, month);
            ExcelKit.$Export(CrmOrderMonth.class, response).downXlsx(crmOrderMonths, false);
        } catch (Exception e) {
            String message = "导出Excel失败";
            log.error(message, e);
            throw new JiebaoException(message);
        }
    }
}
