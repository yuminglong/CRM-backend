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
@TableName("crm_reimburse")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmReimburse extends Model<CrmReimburse> implements Serializable {

    private static final long serialVersionUID = -3322051759409354747L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer fyId;

    /**
     * 对应客户
     */
    private String fyCustomerid;

    /**
     * 报销主题
     */
    private String fyTitle;

    /**
     * 报销单号
     */
    private String fyOrderno;

    /**
     * 单据类型
     */
    private String fyDatatype;

    /**
     * 关联单据
     */
    private String fyDataid;

    /**
     * 申请日期
     */
    private String fyAskdate;

    /**
     * 申请人
     */
    private String fyEmpid;

    /**
     * 报销金额
     */
    private BigDecimal fySummoney;

    /**
     * 备注
     */
    private String fyRemark;


}
