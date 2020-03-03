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
@TableName("crm_cashback_record")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmCashbackRecord extends Model<CrmCashbackRecord> implements Serializable {

    private static final long serialVersionUID = -4841638350864777217L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer hkId;

    /**
     * 对应客户
     */
    private String hkCustomerid;

    /**
     * 合同/订单 ID
     */
    private Integer hkHtid;

    /**
     * 款项日期
     */
    private String hkDate;

    /**
     * 回款金额
     */
    private BigDecimal hkMoney;

    /**
     * 冲消金额
     */
    private BigDecimal hkMoneycx;

    /**
     * 开具发票
     */
    private String hkInvoice;

    /**
     * 所有者
     */
    private String hkPreside;

    /**
     * 备注
     */
    private String hkRemark;


}
