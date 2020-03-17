package com.jiebao.platfrom.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmBillRecord;

/**
 * @author Sinliz
 */
public interface ICrmBillRecordService extends IService<CrmBillRecord> {
    /**
     * 查询开票信息
     * @param crmBillRecord
     * @param queryRequest
     * @return
     */
    IPage<CrmBillRecord> findBillDetail(CrmBillRecord crmBillRecord, QueryRequest queryRequest);
}
