package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
@Repository
public interface CrmContractOrderMapper extends BaseMapper<CrmContractOrder> {


    /**
     * 查询所有合同详情
     * @param createTimeFrom 开始时间
     * @param createTimeTo 结束时间
     * @param ht_id 订单编号
     * @param waitMoney 待收款金额
     * @return
     */
    List<Map<String, Object>> findContractOrderDetail( @Param("createTimeFrom") String createTimeFrom,@Param("createTimeTo") String createTimeTo,@Param("ht_id") String ht_id,@Param("waitMoney") String waitMoney);


    /**
     * 根据ID查订单
     * @param billParentid  订单ID
     * @return 订单详情
     */
    CrmContractOrder findContractOrderById(String billParentid);
}
// and c.ht_date like '#{year}'+'/#{month}%'
