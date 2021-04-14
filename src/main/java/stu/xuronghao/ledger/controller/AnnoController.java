package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Anno;
import stu.xuronghao.ledger.service.AnnoService;
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
@RequestMapping("/Anno")
public class AnnoController {
    private static final Logger log = LoggerFactory.getLogger(AnnoController.class);
    @Resource
    private AnnoService annoService;

    //精确查询
    @GetMapping("/queryByAnnoNo")
    public String queryByAnnoNo(@RequestParam(value = "annoNo") String annoNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.ANNOUNCEMENT, annoNo));
        Anno anno = annoService.queryByAnnoNo(annoNo);

        return JSON.toJSONString(anno, SerializerFeature.WriteClassName);
    }

    //按标题模糊查询
    @GetMapping("/queryByAnnoName")
    public String queryByAnnoName(@RequestParam(value = "annoTitle") String annoTitle) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.ANNOUNCEMENT, annoTitle));
        List<Anno> annos = annoService.queryByTitle(annoTitle);
        return JSON.toJSONString(annos, SerializerFeature.WriteClassName);
    }

    //按类型查询
    @GetMapping("/queryByTypes")
    public String queryByAnnoType(@RequestParam(value = "annoType") String annoType) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.ANNOUNCEMENT, annoType));
        List<Anno> annos = annoService.queryByAnnoType(annoType);
        return JSON.toJSONString(annos, SerializerFeature.WriteClassName);
    }

    //按管理员编号查询
    @GetMapping("/queryByAdmin")
    public String queryByAnnoAdmin(@RequestParam(value = "adminNo") String adminNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.ANNOUNCEMENT, adminNo));
        List<Anno> annos = annoService.queryByAnnoAdmin(adminNo);
        return JSON.toJSONString(annos, SerializerFeature.WriteClassName);
    }

    //按日期范围查询
    @GetMapping("/queryByDate")
    public String queryByAnnoDate(@RequestParam(value = "beginDate") Date beginDate,
                                  @RequestParam(value = "endDate") Date endDate) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_DATE_RANGE,ConstantVariable.ANNOUNCEMENT,
                DateTimeHandler.getDate(beginDate), DateTimeHandler.getDate(endDate)));

        List<Anno> annos = annoService.queryByAnnoDate(beginDate, endDate);
        return JSON.toJSONString(annos, SerializerFeature.WriteClassName);
    }

    //查询所有

    @GetMapping("/queryAllAnno")
    public String queryAllAnno() {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_ALL, ConstantVariable.ANNOUNCEMENT));
        List<Anno> annos = annoService.queryAllAnno();
        return JSON.toJSONString(annos, SerializerFeature.WriteClassName);
    }

    //插入新公告
    @PostMapping(value = "/insertAnno", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean insertAnno(@RequestBody String annoJson) {
        Anno anno = JSON.parseObject(annoJson, Anno.class);
        log.info(StringUtils.format(ConstantVariable.LOG_INSERT, ConstantVariable.ANNOUNCEMENT, anno.toString()));
        return annoService.insertAnno(anno);
    }

    //更新公告
    @PostMapping(value = "/updateAnno", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean updateAnno(@RequestBody String annoJson) {
        Anno anno = JSON.parseObject(annoJson, Anno.class);
        log.info(StringUtils.format(ConstantVariable.LOG_UPDATE, ConstantVariable.ANNOUNCEMENT, anno.toString()));
        return annoService.updateAnno(anno);
    }

    //删除公告
    @PostMapping(value = "/deleteAnno", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean deleteAnno(@RequestBody String annoNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_DELETE, ConstantVariable.ANNOUNCEMENT, annoNo));
        return annoService.deleteAnno(annoNo);
    }
}