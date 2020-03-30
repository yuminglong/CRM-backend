package com.jiebao.platfrom.crm.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.jiebao.platfrom.common.controller.BaseController;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmBillRecord;
import com.jiebao.platfrom.crm.service.ICrmBillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Sinliz
 */
@RestController
@RequestMapping("/crm/bill-record")
@DS("crm")
public class CrmBillRecordController extends BaseController {
    @Autowired
    ICrmBillRecordService iCrmBillRecordService;



    @GetMapping
    public Map<String, Object> crmBillRecord(QueryRequest queryRequest, CrmBillRecord crmBillRecord) {

        Map<String, Object> dataTable = getDataTable(iCrmBillRecordService.findBillDetail(crmBillRecord, queryRequest));
        //System.out.println(dataTable);
        return dataTable;
    }

}
