package com.jiebao.platfrom.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;

import java.util.Date;
import java.util.List;

/**
 * @author Sinliz
 */
public interface ICrmContractOrderService extends IService<CrmContractOrder> {
    List<CrmOrderMonth> crmContractOrderList( String year, String month);  //参数月份
}
