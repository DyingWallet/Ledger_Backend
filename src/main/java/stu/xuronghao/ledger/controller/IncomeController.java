package stu.xuronghao.ledger.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Income;
import stu.xuronghao.ledger.service.IncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import stu.xuronghao.ledger.utils.ConstantVariable;
import stu.xuronghao.ledger.utils.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Income")
public class IncomeController {
    private static final Logger log = LoggerFactory.getLogger(IncomeController.class);

    @Resource
    IncomeService incomeService;

    //精确查找
    @GetMapping("/queryIncomeByNo")
    public String queryByIncomeNo(@RequestParam(value = "incomeNo") String incomeNo) {
        Income income;
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.INCOME, incomeNo));
        income = incomeService.queryByIncNo(incomeNo);
        return JSON.toJSONString(income, SerializerFeature.WriteClassName);
    }

    //模糊查找
    @GetMapping("/queryIncomeByEvent")
    public String queryByIncomeEvent(@RequestParam(value = "incomeEvent") String incomeEvent) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.INCOME, incomeEvent));
        List<Income> incomes = incomeService.queryByIncEvent(incomeEvent);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //类型查找
    @GetMapping("/queryIncomeByType")
    public String queryByIncomeType(@RequestParam(value = "incomeType") String incomeType) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.INCOME, incomeType));
        List<Income> incomes = incomeService.queryByIncType(incomeType);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //按用户查找
    @GetMapping("/queryByIncomeUser")
    public String queryByIncomeUser(@RequestParam(value = "userNo") String userNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.INCOME, userNo));
        List<Income> incomes = incomeService.queryByIncUser(userNo);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //时间段查找
    @GetMapping("/queryByIncomeDate")
    public String queryByIncomeDate(@RequestParam(value = "beginDate") String beginDate,
                                    @RequestParam(value = "endDate") String endDate) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_DATE_RANGE, ConstantVariable.INCOME,
                beginDate, endDate));
        List<Income> incomes = incomeService.queryByIncDate(beginDate, endDate);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //按用户时间段查找
    @GetMapping("/queryByIncomeDateOfUser")
    public String queryByIncomeDateOfUser(@RequestParam(value = "userNo") String userNo,
                                          @RequestParam(value = "beginDate") String beginDate,
                                          @RequestParam(value = "endDate") String endDate) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_DATE_RANGE, ConstantVariable.INCOME,
                beginDate, endDate));
        List<Income> incomes = incomeService.queryByIncDateOfUser(userNo, beginDate, endDate);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //全部查找
    @GetMapping("/queryAllIncome")
    public String queryAllIncome() {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_ALL, ConstantVariable.INCOME));
        List<Income> incomes = incomeService.queryAllInc();
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //插入
    @PostMapping(value = "/insertIncome", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean insertIncome(@RequestBody String incomeJson) {
        Income income = JSON.parseObject(incomeJson, Income.class);
        log.info(StringUtils.format(ConstantVariable.LOG_INSERT, ConstantVariable.INCOME, income.toString()));
        return incomeService.insertInc(income);
    }

    //交互插入
    @PostMapping(value = "/incomeChat", produces = ConstantVariable.REQUEST_PRODUCE)
    public String incomeChat(@RequestBody String infoJson) {
        String[] temp = infoJson.split(ConstantVariable.SPLIT_STR);
        String incomeJson = temp[0];
        String chatJson = temp[1];
        Income income = JSON.parseObject(incomeJson, Income.class);
        ChatInfo chat = JSON.parseObject(chatJson, ChatInfo.class);
        return JSON.toJSONString(incomeService.incomeChat(income, chat), SerializerFeature.WriteClassName);
    }

    //更新
    @PostMapping(value = "/updateIncome", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean updateIncome(@RequestBody String incomeJson) {
        Income income = JSON.parseObject(incomeJson, Income.class);
        log.info(StringUtils.format(ConstantVariable.LOG_UPDATE, ConstantVariable.INCOME, income.toString()));
        return incomeService.updateInc(income);
    }

    //删除
    @PostMapping(value = "/deleteIncome", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean deleteIncome(@RequestBody String incomeJson) {
        Income income = JSON.parseObject(incomeJson, Income.class);
        log.warn(StringUtils.format(ConstantVariable.LOG_DELETE, ConstantVariable.INCOME, income.toString()));
        return incomeService.deleteInc(income);
    }

}
