package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/GetReply")
public class SentController {
    @Resource
    HistoryService historyService;

    @GetMapping("/getHistoryByUser")
    public String getHistoryByUser(@RequestParam(value = "userNo") String userNo){
        List<ChatInfo> temp = historyService.queryByUser(userNo);
        return JSON.toJSONString(temp, SerializerFeature.WriteClassName);

    }
}
