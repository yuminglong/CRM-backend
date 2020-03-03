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
@TableName("crm_payment_bill")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmPaymentBill extends Model<CrmPaymentBill> implements Serializable {

    private static final long serialVersionUID = 8964944551497817843L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer billId;

    /**
     * 供应商(客户)
     */
    private String billCustomerid;

    /**
     * 采购单ID
     */
    private Integer billParentid;

    /**
     * 付款记录
     */
    private String billHkid;

    /**
     * 发票内容
     */
    private String billContent;

    /**
     * 收票日期
     */
    private String billDate;

    /**
     * 票据类型
     */
    private String billType;

    /**
     * 发票号码
     */
    private String billNo;

    /**
     * 票据金额
     */
    private BigDecimal billMoney;

    /**
     * 计算进项税
     */
    private String billHanshui;

    /**
     * 税率
     */
    private BigDecimal billShuilv;

    /**
     * 经手人
     */
    private String billWho;

    /**
     * 是否付款
     */
    private String billHkstate;

    /**
     * 备注
     */
    private String billRemark;


}
