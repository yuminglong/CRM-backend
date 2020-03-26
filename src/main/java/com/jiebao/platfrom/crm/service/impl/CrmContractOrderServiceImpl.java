package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.dao.CrmContractOrderMapper;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;
import com.jiebao.platfrom.crm.service.ICrmContractOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Sinliz
 */
@Service
public class CrmContractOrderServiceImpl extends ServiceImpl<CrmContractOrderMapper, CrmContractOrder> implements ICrmContractOrderService {
    @Autowired
    CrmContractOrderMapper crmContractOrderMapper;

    @Override
    public List<CrmOrderMonth> crmContractOrderList( String year, String month) {

        return crmContractOrderMapper.crmContractOrderList( year, month);
    }

}
