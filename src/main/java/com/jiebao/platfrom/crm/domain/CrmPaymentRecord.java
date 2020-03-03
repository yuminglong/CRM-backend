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
@TableName("crm_payment_record")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmPaymentRecord extends Model<CrmPaymentRecord> implements Serializable {

    private static final long serialVersionUID = 1946139890313870717L;

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
     * 付款日期
     */
    private String fkDate;

    /**
     * 付款金额
     */
    private BigDecimal fkMoney;

    /**
     * 所有者
     */
    private String fkPreside;

    /**
     * 采购单ID
     */
    private Integer fkBuyid;

    /**
     * 冲消金额
     */
    private BigDecimal fkMoneycx;

    /**
     * 负责人
     */
    private String fkPrincipal;

    /**
     * 备注
     */
    private String fkRemark;

    /**
     * 付款方式
     */
    private String fkPaymode;

    /**
     * 是否收票
     */
    private String fkInvoice;


}
