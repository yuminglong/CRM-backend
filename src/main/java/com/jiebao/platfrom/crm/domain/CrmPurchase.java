package com.jiebao.platfrom.crm.domain;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author Sinliz
 */
@Data
@TableName("crm_purchase")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Excel("开支情况汇总表")
public class CrmPurchase extends Model<CrmPurchase> implements Serializable {

    private static final long serialVersionUID = 2725520526379860823L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer cgid;

    /**
     * 供应商
     */
    private String gysid;

    /**
     * 采购主题
     */
    private String cgname;

    /**
     * 采购单号
     */
    private String cgno;

    /**
     * 采购日期
     */
    private String cgdate;

    /**
     * 供应商代表
     */
    private String gysjingban;

    /**
     * 我方代表
     */
    private String empid;

    /**
     * 采购金额
     */
    private BigDecimal summoney;

    /**
     * 优惠折扣率
     */
    private BigDecimal cgMoneyzhekou;

    /**
     * 优惠抹零金额
     */
    private BigDecimal cgKjmoney;

    /**
     * 附加费用分类
     */
    private String cgFjmoneylx;

    /**
     * 附加费用金额
     */
    private BigDecimal cgFjmoney;

    /**
     * 采购摘要
     */
    private String cgremark;

    /**
     * 执行状态
     */
    private String cgZxstate;


}
