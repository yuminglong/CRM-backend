package com.jiebao.platfrom.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiebao.platfrom.common.domain.JiebaoConstant;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.dao.CrmDataMapper;
import com.jiebao.platfrom.crm.domain.CrmData;
import com.jiebao.platfrom.crm.service.ICrmDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */

@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CrmDataServiceImpl extends ServiceImpl<CrmDataMapper, CrmData> implements ICrmDataService {


    @Override
    public List<CrmData> listByUpdate() {
        LambdaQueryWrapper<CrmData> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CrmData::getIsUpdate, true);
        return this.baseMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public IPage<CrmData> getCrmDataList(QueryRequest request, CrmData crmData) {
        LambdaQueryWrapper<CrmData> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<CrmData> page = new Page<>(request.getPageNum(), request.getPageSize());
        lambdaQueryWrapper.orderByDesc(CrmData::getUpdateTime);
        return this.page(page, lambdaQueryWrapper);
    }

}
