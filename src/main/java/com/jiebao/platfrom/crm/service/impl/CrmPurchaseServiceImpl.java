package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.crm.dao.CrmPurchaseMapper;
import com.jiebao.platfrom.crm.dao.CrmReimburseMapper;
import com.jiebao.platfrom.crm.dao.CrmRevenueExpenditureMapper;
import com.jiebao.platfrom.crm.domain.CrmPurchase;
import com.jiebao.platfrom.crm.service.ICrmPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
@Service
public class CrmPurchaseServiceImpl extends ServiceImpl<CrmPurchaseMapper, CrmPurchase> implements ICrmPurchaseService {

    @Resource
    private CrmReimburseMapper crmReimburseMapper;

    @Resource
    private CrmRevenueExpenditureMapper crmRevenueExpenditureMapper;

    @Override
    public List<Map<String, Object>> getcrmPay(String date) {
        return baseMapper.getcrmPay(date);
    }

    @Override
    public List<Map<String, Object>> payDetail(String date, String choose) {
        date+="-01";
        if (choose != null) {
            switch (choose) {
                case "1":/**开支流水**/
                    return crmRevenueExpenditureMapper.payDetail(date);
                case "2":/**采购支出**/
                    return baseMapper.payDetail(date);
                default:/**费用报销**/
                    return crmReimburseMapper.payDetail(date);
            }
        } else {
            return crmRevenueExpenditureMapper.payDetail(date);
        }

    }
}
