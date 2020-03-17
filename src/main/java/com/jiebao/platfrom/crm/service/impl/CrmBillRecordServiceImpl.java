package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.common.domain.JiebaoConstant;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.common.utils.SortUtil;
import com.jiebao.platfrom.crm.dao.CrmBillRecordMapper;
import com.jiebao.platfrom.crm.domain.CrmBillRecord;
import com.jiebao.platfrom.crm.service.ICrmBillRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Sinliz
 */
@Slf4j
@Service("crmBillRecordService")
public class CrmBillRecordServiceImpl extends ServiceImpl<CrmBillRecordMapper, CrmBillRecord> implements ICrmBillRecordService {

    @Override
    public IPage<CrmBillRecord> findBillDetail(CrmBillRecord crmBillRecord, QueryRequest queryRequest) {
        try {
            Page<CrmBillRecord> page = new Page<>();
            SortUtil.handlePageSort(queryRequest, page, "bill_parentid", JiebaoConstant.ORDER_ASC, false);
            return this.baseMapper.findBillDetail(page, crmBillRecord);
        } catch (Exception e) {
            log.error("查询用户异常", e);
            return null;
        }
    }
}
