package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.common.domain.JiebaoConstant;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.utils.SortUtil;
import com.jiebao.platfrom.crm.dao.CrmContractOrderMapper;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;
import com.jiebao.platfrom.crm.service.ICrmContractOrderService;
import com.jiebao.platfrom.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import java.util.Date;
import java.util.List;

/**
 * @author Sinliz
 */
@Slf4j
@Service("contractOrderService")
public class CrmContractOrderServiceImpl extends ServiceImpl<CrmContractOrderMapper, CrmContractOrder> implements ICrmContractOrderService {
    @Autowired
    CrmContractOrderMapper crmContractOrderMapper;

  /*  @Override
    public List<CrmOrderMonth> crmContractOrderList( String year, String month) {
        return crmContractOrderMapper.crmContractOrderList( year, month);
    }*/

    @Override
    public List<Map<String, Object>> findContractOrderDetail(String createTimeFrom, String createTimeTo, String ht_id, String waitMoney) {
        try {
            return this.baseMapper.findContractOrderDetail(createTimeFrom, createTimeTo, ht_id, waitMoney);
        } catch (Exception e) {
            log.error("查询数据异常", e);
            return null;
        }

    }

    @Override
    public CrmContractOrder findContractOrderById(String billParentid) {
       // return baseMapper.selectOne(new LambdaQueryWrapper<CrmContractOrder>().eq(CrmContractOrder::getHtId, billParentid));
        return this.baseMapper.findContractOrderById(billParentid);
    }
}
