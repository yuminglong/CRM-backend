package com.jiebao.platfrom.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiebao.platfrom.crm.domain.CrmPurchase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Sinliz
 */

public interface CrmPurchaseMapper extends BaseMapper<CrmPurchase> {
    @Select({"<script> " +
            "SELECT *,(g.`采购支出`+g.`收支流水`+g.`费用报销`) as '总计' FROM \n" +
            "(\n" +
            "SELECT * FROM \n" +
            "(\n" +
            "SELECT * FROM \n" +
            "(\n" +
            "SELECT * FROM \n" +
            "(\n" +
            "SELECT DATE_FORMAT(#{date}, '%Y-%m') AS `month1`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 1 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 2 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 3 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 4 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 5 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 6 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 7 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 8 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 9 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 10 MONTH), '%Y-%m') AS `month`\n" +
            "UNION SELECT DATE_FORMAT((#{date} - INTERVAL 11 MONTH), '%Y-%m') AS `month`\n" +
            ") AS a\n" +
            "left join\n" +
            "(\n" +
            "select DATE_FORMAT(cgdate, '%Y-%m') as `month2`,sum(summoney) as '采购支出'\n" +
            "from crm_purchase\n" +
            " group by year(cgdate),month(cgdate)\n" +
            ") AS b\n" +
            "on\n" +
            "a.month1=b.month2\n" +
            ")as c\n" +
            "left join\n" +
            "(\n" +
            "select DATE_FORMAT(mdate, '%Y-%m') as `month3`,sum(moneyout) as '收支流水'\n" +
            "from crm_revenue_expenditure \n" +
            " group by year(mdate),month(mdate)\n" +
            ") as d\n" +
            "on\n" +
            "c.month1 = d.month3\n" +
            ") as e\n" +
            "left join\n" +
            "(\n" +
            "select DATE_FORMAT(fy_askdate, '%Y-%m') as `month4`,sum(fy_summoney) as '费用报销'\n" +
            "from crm_reimburse\n" +
            " group by year(fy_askdate),month(fy_askdate)\n" +
            ") as f\n" +
            "on\n" +
            "e.month3 = f.month4\n" +
            ") as g\n" ,

            "</script>",
    })
    List<Map<String, Object>> getcrmPay(@Param("date") String date);
}
