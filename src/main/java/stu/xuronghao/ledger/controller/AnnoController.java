package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Anno;
import stu.xuronghao.ledger.service.AnnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
        log.info("Ready to query anno: " + annoNo);
        Anno anno = annoService.queryByAnnoNo(annoNo);

        return JSON.toJSONString(anno, SerializerFeature.WriteClassName);
    }

    //按标题模糊查询
    @GetMapping("/queryByAnnoName")
    public String queryByAnnoName(@RequestParam(value = "annoTitle") String annoTitle) {
        log.info("Ready to query anno: " + annoTitle);
        List<Anno> annos = annoService.queryByTitle(annoTitle);
        return JSON.toJSONString(annos,SerializerFeature.WriteClassName);
    }

    //按类型查询
    @GetMapping("/queryByTypes")
    public String queryByAnnoType(@RequestParam(value = "annoType") String annoType) {
        log.info("Ready to query anno: " + annoType);
        List<Anno> annos = annoService.queryByAnnoType(annoType);
        return JSON.toJSONString(annos,SerializerFeature.WriteClassName);
    }

    //按管理员编号查询
    @GetMapping("/queryByAdmin")
    public String queryByAnnoAdmin(@RequestParam(value = "adminNo") String adminNo) {
        log.info("Ready to query anno: " + adminNo);
        List<Anno> annos = annoService.queryByAnnoAdmin(adminNo);
        return JSON.toJSONString(annos,SerializerFeature.WriteClassName);
    }

    //按日期范围查询
    @GetMapping("/queryByDate")
    public String queryByAnnoDate(@RequestParam(value = "beginDate") Date beginDate,
                                      @RequestParam(value = "endDate") Date endDate) {
        log.info("Ready to query anno between + " + beginDate + " and " + endDate);

        List<Anno> annos = annoService.queryByAnnoDate(beginDate, endDate);
        return JSON.toJSONString(annos,SerializerFeature.WriteClassName);
    }

    //查询所有

    @GetMapping("/queryAllAnno")
    public String queryAllAnno() {
        log.info("Ready to query all anno!");
        List<Anno> annos = annoService.queryAllAnno();
        return JSON.toJSONString(annos,SerializerFeature.WriteClassName);
    }

    //插入新公告
    @PostMapping(value = "/insertAnno", produces = "application/json;charset=UTF-8")
    public boolean insertAnno(@RequestBody String annoJson) {
        Anno anno = JSON.parseObject(annoJson,Anno.class);
        log.info("Ready to insert anno: " + anno.toString());
        return annoService.insertAnno(anno);
    }

    //更新公告
    @PostMapping(value = "/updateAnno", produces = "application/json;charset=UTF-8")
    public boolean updateAnno(@RequestBody String annoJson) {
        Anno anno = JSON.parseObject(annoJson,Anno.class);
        log.info("Ready to update anno: " + anno.toString());
        return annoService.updateAnno(anno);
    }

    //删除公告
    @PostMapping(value = "/deleteAnno", produces = "application/json;charset=UTF-8")
    public boolean deleteAnno(@RequestBody String annoNo) {
        log.info("Ready to delete anno: " + annoNo);
        return annoService.deleteAnno(annoNo);
    }
}
