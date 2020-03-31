package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiebao.platfrom.crm.domain.CrmReimburse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
public interface CrmReimburseMapper extends BaseMapper<CrmReimburse> {

    List<Map<String, Object>> payDetail(@Param("date") String date);

}
