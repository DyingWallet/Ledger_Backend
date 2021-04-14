package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Feedback;
import stu.xuronghao.ledger.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import stu.xuronghao.ledger.utils.ConstantVariable;
import stu.xuronghao.ledger.utils.DateTimeHandler;
import stu.xuronghao.ledger.utils.StringUtils;

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
    public String queryByNo(@RequestParam(value = "fbNo") String fbNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.FEEDBACK, fbNo));
        Feedback feedback = feedbackService.queryByNo(fbNo);
        return JSON.toJSONString(feedback, SerializerFeature.WriteClassName);
    }

    //模糊查找
    @GetMapping("/queryByTitle")
    public String queryByTitle(@RequestParam(value = "fbTitle") String fbTitle) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_TITLE, ConstantVariable.FEEDBACK, fbTitle));
        List<Feedback> feedbacks = feedbackService.queryByTitle(fbTitle);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //类型查找
    @GetMapping("/queryByType")
    public String queryByType(@RequestParam(value = "fbType") String fbType) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_TYPE, ConstantVariable.FEEDBACK, fbType));
        List<Feedback> feedbacks = feedbackService.queryByType(fbType);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //按管理员查找
    @GetMapping("/queryByAdmin")
    public String queryByAdmin(@RequestParam(value = "adminNo") String adminNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.FEEDBACK, adminNo));
        List<Feedback> feedbacks = feedbackService.queryByAdmin(adminNo);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //按用户查找
    @GetMapping("/queryByUser")
    public String queryByUser(@RequestParam(value = "userNo") String userNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.COST, userNo));
        List<Feedback> feedbacks = feedbackService.queryByUser(userNo);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //时间段查找
    @GetMapping("/queryByDate")
    public String queryByDate(@RequestParam(value = "beginDate") Date beginDate,
                              @RequestParam(value = "endDate") Date endDate) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_DATE_RANGE,ConstantVariable.FEEDBACK,
                DateTimeHandler.getDate(beginDate), DateTimeHandler.getDate(endDate)));

        List<Feedback> feedbacks = feedbackService.queryByDate(beginDate, endDate);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //按用户时间段查找
    @GetMapping("/queryByDateOfUser")
    public String queryByDateOfUser(@RequestParam(value = "userNo") String userNo,
                                    @RequestParam(value = "beginDate") Date beginDate,
                                    @RequestParam(value = "endDate") Date endDate) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_DATE_RANGE,ConstantVariable.FEEDBACK,
                DateTimeHandler.getDate(beginDate), DateTimeHandler.getDate(endDate)));

        List<Feedback> feedbacks = feedbackService.queryByDateOfUser(userNo, beginDate, endDate);
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryAllFb")
    public String queryAllFb() {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_ALL,ConstantVariable.FEEDBACK));

        List<Feedback> feedbacks = feedbackService.queryAllFb();
        return JSON.toJSONString(feedbacks, SerializerFeature.WriteClassName);
    }

    //插入
    @PostMapping(value = "/insertFb", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean insertFb(@RequestBody String fbJson) {
        Feedback feedback = JSON.parseObject(fbJson, Feedback.class);
        log.info(StringUtils.format(ConstantVariable.LOG_INSERT, ConstantVariable.FEEDBACK, feedback.toString()));

        return feedbackService.insertFb(feedback);
    }

    //删除
    @PostMapping(value = "/deleteFb", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean deleteFb(@RequestBody String fbJson) {
        Feedback feedback = JSON.parseObject(fbJson, Feedback.class);
        log.info(StringUtils.format(ConstantVariable.LOG_DELETE, ConstantVariable.FEEDBACK, feedback.toString()));

        return feedbackService.deleteFb(feedback.getFbNo());
    }
}
