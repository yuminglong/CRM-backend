package com.jiebao.platfrom.crm.domain;

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
@TableName("crm_purchase_apply")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmPurchaseApply extends Model<CrmPurchaseApply> implements Serializable {

    private static final long serialVersionUID = -6645364519762697438L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer qhId;

    /**
     * 申请单号
     */
    private String qhOrderno;

    /**
     * 对应客户
     */
    private String qhCustomerid;

    /**
     * 使用日期
     */
    private String qhDate;

    /**
     * 状态
     */
    private String qhState;

    /**
     * 标题
     */
    private String qhTitle;

    /**
     * 对应单据
     */
    private String qhDataid;

    /**
     * 备注
     */
    private String qhRemark;


}
