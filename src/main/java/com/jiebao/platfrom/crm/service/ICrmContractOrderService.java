package com.jiebao.platfrom.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;

import java.util.Date;
import java.util.List;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
public interface ICrmContractOrderService extends IService<CrmContractOrder> {

    /**
     * 查询全部合同详情
     *
     * @param createTimeFrom 开始时间
     * @param createTimeTo   结束时间
     * @param ht_id          订单编号
     * @param waitMoney      待收款金额
     * @return
     */
    List<Map<String, Object>> findContractOrderDetail(String createTimeFrom, String createTimeTo, String ht_id, String waitMoney);

    /**
     * 通过订单编号查详情
     *
     * @param billParentid 订单编号
     * @return
     */
    CrmContractOrder findContractOrderById(String billParentid);
}
