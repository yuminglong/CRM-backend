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
 * 金智CRM-开票记录
 *
 * @author Sinliz
 */
@Data
@TableName("crm_bill_record")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmBillRecord extends Model<CrmBillRecord> implements Serializable {

    private static final long serialVersionUID = -8445158093077559692L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer billId;

    /**
     * 客户
     */
    private String billCustomerid;

    /**
     * 票据金额
     */
    private BigDecimal billMoney;

    /**
     * 开票日期
     */
    private String billDate;

    /**
     * 经手人
     */
    private String billWho;

    /**
     * 合同/订单 ID
     */
    private Integer billParentid;

    /**
     * 回款记录
     */
    private String billHkid;

    /**
     * 开票内容
     */
    private String billContent;

    /**
     * 票据类型
     */
    private String billType;

    /**
     * 发票号码
     */
    private String billNo;

    /**
     * 是否含税
     */
    private String billHanshui;

    /**
     * 税率
     */
    private BigDecimal billShuilv;

    /**
     * 是否回款
     */
    private String billHkstate;

    /**
     * 备注
     */
    private String billRemark;


}
