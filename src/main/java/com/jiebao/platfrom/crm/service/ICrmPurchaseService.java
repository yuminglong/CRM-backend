package com.jiebao.platfrom.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiebao.platfrom.crm.domain.CrmPurchase;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
public interface ICrmPurchaseService extends IService<CrmPurchase> {
    List<Map<String, Object>> getcrmPay(String date);
}
