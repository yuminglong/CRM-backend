package com.jiebao.platfrom.crm.domain;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("crm_contract_order")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmContractOrder extends Model<CrmContractOrder> implements Serializable {

    private static final long serialVersionUID = -1194470929595161323L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer htId;

    /**
     * 对应客户
     */
    private String htCustomerid;

    /**
     * 签单日期
     */
    private String htDate;

    /**
     * 所有者
     */
    private String htPreside;

    /**
     * 状态
     */
    private String htState;

    /**
     * 总金额
     */
    private BigDecimal htSummoney;

    /**
     * 主题
     */
    private String htTitle;

    /**
     * 合同单号
     */
    private String htNumber;

    /**
     * 对应联系人
     */
    private String htLxrid;

    /**
     * 联系方式
     */
    private String htLxrinfo;

    /**
     * 开始日期
     */
    private String htBegindate;

    /**
     * 优惠折扣率
     */
    private BigDecimal htMoneyzhekou;

    /**
     * 优惠抹零金额
     */
    private BigDecimal htKjmoney;

    /**
     * 附加费用分类
     */
    private String htFjmoneylx;

    /**
     * 附加费用金额
     */
    private BigDecimal htFjmoney;

    /**
     * 最晚发货/结束日期
     */
    private String htEnddate;

    /**
     * 发货方式
     */
    private String htWuliutype;

    /**
     * 收货地址
     */
    private String fahuoaddressid;

    /**
     * 合同正文
     */
    private String htContract;

    /**
     * 备注
     */
    private String htRemark;

    /**
     * 已收款金额
     */
    @TableField(exist = false)
    private BigDecimal afterMoney;

    /**
     * 待收款金额
     */
    @TableField(exist = false)
    private Integer waitMoney;

    @TableField(exist = false)
    private transient String createTimeFrom;
    @TableField(exist = false)
    private transient String createTimeTo;
}
