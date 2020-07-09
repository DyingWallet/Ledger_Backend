package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Feedback;
import stu.xuronghao.ledger.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Feedback")
public class FeedbackController {
    private static final Logger log = LoggerFactory.getLogger(FeedbackController.class);

    @Resource
    FeedbackService feedbackService;

    //精确查找
    @GetMapping("/queryByNo")
    public String queryByNo(@RequestParam(value = "fbNo")String fbNo){
        log.info("Ready to query feedback: " + fbNo);
        Feedback feedback = feedbackService.queryByNo(fbNo);
        return JSON.toJSONString(feedback, SerializerFeature.WriteClassName);
    }

    //模糊查找
    @GetMapping("/queryByTitle")
    public String queryByTitle(@RequestParam(value = "fbTitle")String fbTitle){
        log.info("Ready to query feedback: " + fbTitle);
        List<Feedback> feedbacks = feedbackService.queryByTitle(fbTitle);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //类型查找
    @GetMapping("/queryByType")
    public String queryByType(@RequestParam(value = "fbType")String fbType){
        log.info("Ready to query feedback: " + fbType);
        List<Feedback> feedbacks = feedbackService.queryByType(fbType);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //按管理员查找
    @GetMapping("/queryByAdmin")
    public String queryByAdmin(@RequestParam(value = "adminNo")String adminNo){
        log.info("Ready to query feedback by admin: " + adminNo);
        List<Feedback> feedbacks = feedbackService.queryByAdmin(adminNo);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //按用户查找
    @GetMapping("/queryByUser")
    public String queryByUser(@RequestParam(value = "userNo")String userNo){
        log.info("Ready to query feedback by user: " + userNo);
        List<Feedback> feedbacks = feedbackService.queryByUser(userNo);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //时间段查找
    @GetMapping("/queryByDate")
    public String queryByDate(@RequestParam(value = "beginDate")Date beginDate,
                                        @RequestParam(value = "endDate")Date endDate){
        log.info("Ready to query feedback between: " + beginDate.toString() + " and " + endDate.toString());

        List<Feedback> feedbacks = feedbackService.queryByDate(beginDate,endDate);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //按用户时间段查找
    @GetMapping("/queryByDateOfUser")
    public String queryByDateOfUser(@RequestParam(value = "userNo")String userNo,
                                    @RequestParam(value = "beginDate")Date beginDate,
                                    @RequestParam(value = "endDate")Date endDate){
        log.info("Ready to query feedback between: "
                + beginDate.toString() + " and " + endDate.toString() + " Of " + userNo);

        List<Feedback> feedbacks = feedbackService.queryByDateOfUser(userNo,beginDate,endDate);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryAllFb")
    public String queryAllFb(){
        log.info("Ready to query all feedback");

        List<Feedback> feedbacks = feedbackService.queryAllFb();
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //插入
    @PostMapping(value = "/insertFb",produces = "application/json;charset=UTF-8")
    public boolean insertFb(@RequestBody String fbJson){
        Feedback feedback = JSON.parseObject(fbJson,Feedback.class);
        log.info("Ready to insert feedback: " + feedback.toString());

        return feedbackService.insertFb(feedback);
    }

    //删除
    @PostMapping(value = "/deleteFb",produces = "application/json;charset=UTF-8")
    public boolean deleteFb(@RequestBody String fbJson){
        Feedback feedback = JSON.parseObject(fbJson,Feedback.class);
        log.warn("Ready to delete feedback: " + feedback.getFbNo());

        return feedbackService.deleteFb(feedback.getFbNo());
    }
}
