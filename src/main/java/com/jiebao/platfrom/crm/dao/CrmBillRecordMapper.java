package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiebao.platfrom.crm.domain.CrmBillRecord;
import com.jiebao.platfrom.system.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Sinliz
 */
public interface CrmBillRecordMapper extends BaseMapper<CrmBillRecord> {
    /**
     * 查询开票信息
     * @param page 分页
     * @param crmBillRecord 实体
     * @return
     */
    IPage<CrmBillRecord> findBillDetail(Page page, @Param("crmBillRecord") CrmBillRecord crmBillRecord);
}
