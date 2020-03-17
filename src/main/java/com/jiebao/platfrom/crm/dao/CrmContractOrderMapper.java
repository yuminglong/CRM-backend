package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jiebao.platfrom.crm.domain.CrmContractOrder;
import com.jiebao.platfrom.crm.domain.CrmOrderMonth;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.sql.DataSourceDefinitions;
import java.util.List;

/**
 * @author Sinliz
 */
@Repository
public interface CrmContractOrderMapper extends BaseMapper<CrmContractOrder> {
    @Select("<script>select ht_id as id,ht_customerid as htName,IFNULL(ht_summoney,0) as htSumMoney,ht_date " +
            "as htDate,ht_preside as htPerson,(select IFNULL(sum(bill_money),0) from crm_bill_record where bill_parentid=c.ht_id) " +
            "as htKpMoney,(select IFNULL(avg(bill_shuilv),0) from crm_bill_record  where bill_parentid=c.ht_id) as htSjMoney," +
            " c.ht_summoney-(select IFNULL(sum(hk_money),0) from crm_cashback_record where hk_htid=c.ht_id ) as htYqMoney " +
            "from crm_contract_order c    where c.ht_date like '${year}/${month}%' ORDER BY c.ht_date DESC  </script>")
    List<CrmOrderMonth> crmContractOrderList( String year, String month);  //
}
// and c.ht_date like '#{year}'+'/#{month}%'