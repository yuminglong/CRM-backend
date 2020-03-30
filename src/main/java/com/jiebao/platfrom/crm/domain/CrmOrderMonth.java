package com.jiebao.platfrom.crm.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@Excel("月销售表")
public class CrmOrderMonth implements Serializable {
    @ExcelField(value = "合同id")
    private String id;     //合同id
    @ExcelField(value = "合同名字")
    private String htName;     //合同名字
    @ExcelField(value = "合同金额")
    private String htSumMoney;  //合同金额
    @ExcelField(value = "合同时间")
    private String htDate;  //合同时间
    @ExcelField(value = "采购费用")
    private String cgMoney;//采购费用
    @ExcelField(value = "报销金额")
    private String bxMoney;//报销金额
    @ExcelField(value = "合同相关人员")
    private String htPerson;//合同相关人员  内部
    @ExcelField(value = "合同开票金额")
    private String htKpMoney;//合同开票金额
    @ExcelField(value = "税金")
    private double htSjMoney;//税金
    @ExcelField(value = "费用合计")
    private double htFyMoney;//费用合计
    @ExcelField(value = "应收账款")
    private String htYsMoney;//应收账款
    @ExcelField(value = "逾期应收账款")
    private String htYqMoney;//逾期应收账款

    public String getId() {
        return id;
    }

    public String getHtName() {
        return htName;
    }

    public String getHtSumMoney() {
        return htSumMoney+".00";
    }

    public String getHtDate() {
        return htDate;
    }

    public String getCgMoney() {
        return "0"+".00";
    }

    public String getBxMoney() {
        return  "0"+".00";
    }

    public String getHtSjMoney() {
        return htSjMoney+".00";
    }

    public String getHtFyMoney() {
        return htFyMoney+".00";
    }

    public String getHtPerson() {
        return htPerson;
    }

    public String getHtKpMoney() {
        return htKpMoney+".00";
    }



    public String getHtYsMoney() {
        return htYsMoney+".00";
    }

    public String getHtYqMoney() {
        return htYqMoney+".00";
    }
}
