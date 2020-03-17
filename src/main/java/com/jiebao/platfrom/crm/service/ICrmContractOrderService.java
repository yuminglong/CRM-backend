package com.jiebao.platfrom.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;

import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
public interface ICrmContractOrderService extends IService<CrmContractOrder> {

    /**
     * 查询合同详情
     * @param
     * @param
     * @return IPage
     */
    List<Map<String, Object>> findContractOrderDetail(String createTimeFrom,String createTimeTo);

}
