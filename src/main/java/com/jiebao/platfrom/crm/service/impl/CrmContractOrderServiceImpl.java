package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.common.domain.JiebaoConstant;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.utils.SortUtil;
import com.jiebao.platfrom.crm.dao.CrmContractOrderMapper;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.service.ICrmContractOrderService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
@Slf4j
@Service("contractOrderService")
public class CrmContractOrderServiceImpl extends ServiceImpl<CrmContractOrderMapper, CrmContractOrder> implements ICrmContractOrderService {

    @Override
    public List<Map<String, Object>> findContractOrderDetail(String createTimeFrom,String createTimeTo) {
        try {
            return this.baseMapper.findContractOrderDetail(createTimeFrom,createTimeTo);
        }
        catch (Exception e) {
            log.error("查询数据异常", e);
            return null;
        }

    }
}
