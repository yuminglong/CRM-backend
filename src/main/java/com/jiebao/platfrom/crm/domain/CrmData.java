package com.jiebao.platfrom.crm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 金智CRM-基础数据接口
 *
 * @author Sinliz
 */
@Data
@TableName("crm_data")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmData extends Model<CrmData> implements Serializable {

    private static final long serialVersionUID = -321703910495522559L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 数据接口类型ID
     */
    @TableField("dataTypeId")
    private String dataTypeId;

    /**
     * 数据接口类型名称
     */
    @TableField("dataName")
    private String dataName;

    /**
     * 数据接口对应实体类
     */
    private String bean;

    /**
     * 此数据接口是否需要更新
     */
    @TableField("isUpdate")
    private Boolean isUpdate;

    /**
     * 数据最后更新时间
     */
    @TableField("updateTime")
    private String updateTime;

    /**
     * 此数据接口是否自动更新
     */
    @TableField("autoUpdate")
    private Boolean autoUpdate;


}
