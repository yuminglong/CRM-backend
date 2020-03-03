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
@TableName("crm_project")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmProject extends Model<CrmProject> implements Serializable {

    private static final long serialVersionUID = -2172556198727212213L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * ID
     */
    private Integer xmId;

    /**
     * 主客户
     */
    private String xmCustomerid;

    /**
     * 立项日期
     */
    private String xmDate;

    /**
     * 负责人
     */
    private String xmPrincipal;

    /**
     * 项目阶段
     */
    private String xmPhase;

    /**
     * 项目状态
     */
    private String xmState;

    /**
     * 预计签单日
     */
    private String xmExpdate;

    /**
     * 可能性
     */
    private String xmExpknx;

    /**
     * 项目主题
     */
    private String xmTitle;

    /**
     * 项目成员
     */
    private String xmMemberemp;

    /**
     * 项目概要
     */
    private String xmContent;

    /**
     * 阶段备注
     */
    private String xmPhasenote;

    /**
     * 售前阶段
     */
    private String xmSalephase;

    /**
     * 预期金额
     */
    private BigDecimal xmExpmoney;


}
