package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.crm.dao.CrmPurchaseMapper;
import com.jiebao.platfrom.crm.domain.CrmPurchase;
import com.jiebao.platfrom.crm.service.ICrmPurchaseService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
@Service
public class CrmPurchaseServiceImpl extends ServiceImpl<CrmPurchaseMapper, CrmPurchase> implements ICrmPurchaseService {

    @Override
    public List<Map<String, Object>> getcrmPay(String date) {
        return baseMapper.getcrmPay(date);
    }
}
