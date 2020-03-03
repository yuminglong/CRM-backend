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
 * 金智CRM-客户资料
 * @author Sinliz
 */
@Data
@TableName("crm_customer")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CrmCustomer extends Model<CrmCustomer> implements Serializable {

    private static final long serialVersionUID = 4843352354443936763L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private Integer khId;

    private String khName;

    private String khShortname;

    private String khCountry;

    private String khProvince;

    private String khCity;

    private String khCoaddress;

    private String khType;

    private String khHandset;

    private String khWorktel;

    private String khRemark;


}
