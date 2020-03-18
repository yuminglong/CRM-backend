package com.jiebao.platfrom.crm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiebao.platfrom.common.converter.TimeConverter;
import com.jiebao.platfrom.common.domain.RegexpConstant;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Excel("用户信息表")
public class CrmPay implements Serializable {


    @ExcelField(value = "支出时间")
    private String month1;

    @ExcelField(value = "采购支出")
    private String 采购支出;

    @ExcelField(value = "收支流水")
    private String 收支流水;

    @ExcelField(value = "费用报销")
    private String 费用报销;

    @ExcelField(value = "总计")
    private String 总计;

}
