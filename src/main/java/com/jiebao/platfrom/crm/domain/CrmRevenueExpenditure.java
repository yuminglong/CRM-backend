package com.jiebao.platfrom.crm.domain;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author Sinliz
 */
@Data
@TableName("crm_revenue_expenditure")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmRevenueExpenditure extends Model<CrmRevenueExpenditure> implements Serializable {

    private static final long serialVersionUID = -1421872256637686027L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer mid;

    /**
     * 对应客户
     */
    private String customerid;

    /**
     * 单据编号
     */
    private String billno;

    /**
     * 款项日期
     */
    private String mdate;

    /**
     * 账户
     */
    private String acid;

    /**
     * 转入账户
     */
    private String toacid;

    /**
     * 经办人
     */
    private String jingban;

    /**
     * 摘要
     */
    private String mremark;

    /**
     * 收入金额
     */
    private BigDecimal moneyin;

    /**
     * 支出金额
     */
    private BigDecimal moneyout;

    /**
     * 分类1
     */
    private String mtype1;

    /**
     * 分类2
     */
    private String mtype2;

    /**
     * 分类3
     */
    private String mtype3;


}
