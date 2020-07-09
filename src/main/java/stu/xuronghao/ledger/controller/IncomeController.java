package stu.xuronghao.ledger.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Income;
import stu.xuronghao.ledger.service.IncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Income")
public class IncomeController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    IncomeService incomeService;

    //精确查找
    @GetMapping("/queryIncomeByNo")
    public String queryByIncomeNo(@RequestParam(value = "incomeNo") String incomeNo) {
        Income income;
        log.info("Ready to query income: " + incomeNo);
        income = incomeService.queryByIncNo(incomeNo);
        return JSON.toJSONString(income, SerializerFeature.WriteClassName);
    }

    //模糊查找
    @GetMapping("/queryIncomeByEvent")
    public String queryByIncomeEvent(@RequestParam(value = "incomeEvent") String incomeEvent) {
        log.info("Ready to query income by: " + incomeEvent);
        List<Income> incomes = incomeService.queryByIncEvent(incomeEvent);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //类型查找
    @GetMapping("/queryIncomeByType")
    public String queryByIncomeType(@RequestParam(value = "incomeType") String incomeType) {
        log.info("Ready to query income by: " + incomeType);
        List<Income> incomes = incomeService.queryByIncType(incomeType);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //按用户查找
    @GetMapping("/queryByIncomeUser")
    public String queryByIncomeUser(@RequestParam(value = "userNo") String userNo) {
        log.info("Ready to query income by: " + userNo);
        List<Income> incomes = incomeService.queryByIncUser(userNo);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //时间段查找
    @GetMapping("/queryByIncomeDate")
    public String queryByIncomeDate(@RequestParam(value = "beginDate") String beginDate,
                                    @RequestParam(value = "endDate") String endDate) {
        log.info("Ready to query income between + " + beginDate + " and " + endDate);
        List<Income> incomes =  incomeService.queryByIncDate(beginDate, endDate);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //按用户时间段查找
    @GetMapping("/queryByIncomeDateOfUser")
    public String queryByIncomeDateOfUser(@RequestParam(value = "userNo") String userNo,
                                          @RequestParam(value = "beginDate") String beginDate,
                                          @RequestParam(value = "endDate") String endDate) {
        log.info("Ready to query income between + " + beginDate + " and " + endDate + " Of " + userNo);
        List<Income> incomes = incomeService.queryByIncDateOfUser(userNo, beginDate, endDate);
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //全部查找
    @GetMapping("/queryAllIncome")
    public String queryAllIncome() {
        log.info("Ready to query all income!");
        List<Income> incomes =  incomeService.queryAllInc();
        return JSON.toJSONString(incomes, SerializerFeature.WriteClassName);
    }

    //插入
    @PostMapping(value = "/insertIncome", produces = "application/json;charset=UTF-8")
    public boolean insertIncome(@RequestBody String incomeJson) {
        Income income = JSON.parseObject(incomeJson,Income.class);
        log.info("Ready to insert income: " + income.toString());
        return incomeService.insertInc(income);
    }

    //交互插入
    @PostMapping(value = "/incomeChat", produces = "application/json;charset=UTF-8")
    public String incomeChat(@RequestBody String infoJson){
        String incomeJson = infoJson.split("<<->>")[0];
        String chatJson = infoJson.split("<<->>")[1];
        Income income = JSON.parseObject(incomeJson,Income.class);
        ChatInfo chat = JSON.parseObject(chatJson,ChatInfo.class);
        return JSON.toJSONString(incomeService.incomeChat(income,chat),SerializerFeature.WriteClassName);
    }

    //更新
    @PostMapping(value = "/updateIncome", produces = "application/json;charset=UTF-8")
    public boolean updateIncome(@RequestBody String incomeJson) {
        Income income = JSON.parseObject(incomeJson,Income.class);
        log.info("Ready to update income: " + income.toString());
        return incomeService.updateInc(income);
    }

    //删除
    @PostMapping(value = "/deleteIncome", produces = "application/json;charset=UTF-8")
    public boolean deleteIncome(@RequestBody String incomeJson) {
        Income income = JSON.parseObject(incomeJson,Income.class);
        log.warn("Ready to delete income: " + income.toString());
        return incomeService.deleteInc(income);
    }

}
