package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Cost;
import stu.xuronghao.ledger.service.CostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Cost")
public class CostController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    CostService costService;

    //精确查找
    @GetMapping("/queryByCostNo")
    public String queryByCostNo(@RequestParam(value = "costNo") String costNo) {
        log.info("Ready to query cost: " + costNo);
        Cost cost = costService.queryByCostNo(costNo);
        return JSON.toJSONString(cost, SerializerFeature.WriteClassName);
    }

    //模糊查找
    @GetMapping("/queryByCostEvent")
    public String queryByCostEvent(@RequestParam(value = "costEvent") String costEvent) {
        log.info("Ready to query cost by: " + costEvent);
        List<Cost> costs = costService.queryByCostEvent(costEvent);
        return JSON.toJSONString(costs, SerializerFeature.WriteClassName);
    }

    //类型查找
    @GetMapping("/queryByCostType")
    public String queryByCostType(@RequestParam(value = "costType") String costType) {
        log.info("Ready to query cost by: " + costType);
        List<Cost> costs = costService.queryByCostType(costType);
        return JSON.toJSONString(costs, SerializerFeature.WriteClassName);
    }

    //按用户查找
    @GetMapping("/queryByCostUser")
    public String queryByCostUser(@RequestParam(value = "userNo") String userNo) {
        log.info("Ready to query cost by: " + userNo);
        List<Cost> costs = costService.queryByCostUser(userNo);
        return JSON.toJSONString(costs, SerializerFeature.WriteClassName);
    }

    //时间段查找
    @GetMapping("/queryByCostDate")
    public String queryByCostDate(@RequestParam(value = "beginDate") String beginDate,
                                      @RequestParam(value = "endDate") String endDate) {
        //注意！日期应只包含年月日，而不包含具体时间
        log.info("Ready to query cost between + " + beginDate + " and " + endDate);
        List<Cost> costs = costService.queryByCostDate(beginDate, endDate);
        return JSON.toJSONString(costs, SerializerFeature.WriteClassName);
    }

    //用户时间段查找
    @GetMapping("/queryByCostDateOfUser")
    public String queryByCostDateOfUser(@RequestParam(value = "userNo") String userNo,
                                        @RequestParam(value = "beginDate") String beginDate,
                                        @RequestParam(value = "endDate") String endDate) {
        //注意！日期应只包含年月日，而不包含具体时间
        log.info("Ready to query cost between + " + beginDate + " and " + endDate + " Of " + userNo);
        List<Cost> costs = costService.queryByCostDateOfUser(userNo,beginDate, endDate);
        return JSON.toJSONString(costs, SerializerFeature.WriteClassName);
    }

    //全部查找
    @GetMapping("/queryAllCost")
    public String queryAllCost() {
        log.info("Ready to query all cost!");
        List<Cost> costs = costService.queryAllCost();
        return JSON.toJSONString(costs);
    }

    //插入
    @PostMapping(value = "/insertCost", produces = "application/json;charset=UTF-8")
    public boolean insertCost(@RequestBody String costJson) {
        Cost cost = JSON.parseObject(costJson,Cost.class);
        log.info("Ready to insert cost: " + cost.toString());
        return costService.insertCost(cost);
    }

    //交互插入
    @PostMapping(value = "/costChat",produces = "application/json;charset=UTF-8")
    public String costChat(@RequestBody String infoJson){
        String costJson = infoJson.split("<<->>")[0];
        String chatJson = infoJson.split("<<->>")[1];
        Cost cost = JSON.parseObject(costJson,Cost.class);
        ChatInfo chat = JSON.parseObject(chatJson,ChatInfo.class);
        return JSON.toJSONString(costService.costChat(cost,chat),SerializerFeature.WriteClassName);
    }

    //更新
    @PostMapping(value = "/updateCost", produces = "application/json;charset=UTF-8")
    public boolean updateCost(@RequestBody String costJson) {
        Cost cost = JSON.parseObject(costJson,Cost.class);
        log.info("Ready to update cost: " + cost.toString());
        return costService.updateCost(cost);
    }

    //删除
    @PostMapping(value = "/deleteCost", produces = "application/json;charset=UTF-8")
    public boolean deleteCost(@RequestBody String costJson) {
        Cost cost = JSON.parseObject(costJson,Cost.class);
        log.warn("Ready to delete cost: " + cost.toString());
        return costService.deleteCost(cost);
    }

}
