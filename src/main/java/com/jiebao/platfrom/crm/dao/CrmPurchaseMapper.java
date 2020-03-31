package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiebao.platfrom.crm.domain.CrmPurchase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */

public interface CrmPurchaseMapper extends BaseMapper<CrmPurchase> {

    List<Map<String, Object>> getcrmPay(@Param("date") String date);

    List<Map<String, Object>> payDetail(@Param("date") String date);
}
