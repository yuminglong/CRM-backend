package com.jiebao.platfrom.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiebao.platfrom.common.domain.QueryRequest;
import com.jiebao.platfrom.crm.domain.CrmData;

import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */
public interface ICrmDataService extends IService<CrmData> {

    /**
     * 查询需要更新的数据接口列表
     * @return
     */
    List<CrmData> listByUpdate();

    IPage<CrmData> getCrmDataList(QueryRequest request, CrmData crmData);
}
