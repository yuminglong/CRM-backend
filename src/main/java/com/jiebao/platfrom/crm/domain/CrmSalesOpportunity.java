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
 * 金智CRM-销售机会
 * @author Sinliz
 */
@Data
@TableName("crm_sales_opportunity")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmSalesOpportunity extends Model<CrmSalesOpportunity> implements Serializable {

    private static final long serialVersionUID = -7216966213869891326L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private Integer xshId;

    private String xshCustomerid;

    private String xshTitle;

    private String xshLxrid;

    private String xshLianxi;

    private String xshDate;

    private String xshPreside;

    private String xshRequire;

    private String xshExpdate;

    private BigDecimal xshExpmoney;

    private String xshPhase;

    private String xshKnx;

    private String xshState;

    private String xshPhasenote;


}
