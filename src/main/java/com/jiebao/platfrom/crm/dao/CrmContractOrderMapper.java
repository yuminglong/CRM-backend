package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
public interface CrmContractOrderMapper extends BaseMapper<CrmContractOrder> {


    /**
     * 查询合同详情
     * @param
     * @param
     * @return
     */
    List<Map<String, Object>> findContractOrderDetail(@Param("createTimeFrom") String createTimeFrom,@Param("createTimeTo") String createTimeTo);
}
