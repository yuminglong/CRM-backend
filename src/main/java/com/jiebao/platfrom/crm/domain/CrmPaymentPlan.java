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
@TableName("crm_payment_plan")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmPaymentPlan extends Model<CrmPaymentPlan> implements Serializable {

    private static final long serialVersionUID = 430276279722695072L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer fkId;

    /**
     * 供应商
     */
    private String fkCustomerid;

    /**
     * 采购单ID
     */
    private Integer fkBuyid;

    /**
     * 计划日期
     */
    private String fkDate;

    /**
     * 付款金额
     */
    private BigDecimal fkMoney;

    /**
     * 冲消金额
     */
    private BigDecimal fkMoneycx;

    /**
     * 负责人
     */
    private String fkPrincipal;

    /**
     * 所有者
     */
    private String fkPreside;

    /**
     * 备注
     */
    private String fkRemark;

    /**
     * 是否付款
     */
    private String fkStatus;

    /**
     * 是否收票
     */
    private String fkInvoice;

    /**
     * 付款方式
     */
    private String fkPaymode;


}
