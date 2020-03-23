package com.jiebao.platfrom.crm.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.jiebao.platfrom.common.controller.BaseController;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.service.ICrmContractOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
@RestController
@RequestMapping("/crm/contract-order")
@DS("crm")
public class CrmContractOrderController extends BaseController {


    @Autowired
    ICrmContractOrderService iCrmContractOrderService;

    @GetMapping
    public List<Map<String, Object>> collect(String createTimeFrom, String createTimeTo, String ht_id, String waitMoney) {
        List<Map<String, Object>> contractOrderDetail = iCrmContractOrderService.findContractOrderDetail(createTimeFrom, createTimeTo, ht_id, waitMoney);
        return contractOrderDetail;
    }

    @GetMapping("/findContractOrderById/{billParentid}")
    public CrmContractOrder findContractOrderById(@NotBlank(message = "{required}") @PathVariable String billParentid) {
        System.out.println(billParentid + "--------" + iCrmContractOrderService.findContractOrderById(billParentid));
        return iCrmContractOrderService.findContractOrderById(billParentid);
    }


}
