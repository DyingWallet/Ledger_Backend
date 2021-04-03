package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.Feedback;
import stu.xuronghao.ledger.mapper.FeedbackMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackService {
    @Resource
    FeedbackMapper mapper;

    //精确查找
    public Feedback queryByNo(String fbNo) {
        return mapper.queryByNo(fbNo);
    }

    //按标题查询-模糊匹配
    public List<Feedback> queryByTitle(String fbTitle) {
        return mapper.queryByTitle(fbTitle);
    }

    //按类型查找
    public List<Feedback> queryByType(String fbType) {
        return mapper.queryByType(fbType);
    }

    //按管理员编号查询
    public List<Feedback> queryByAdmin(String adminNo) {
        return mapper.queryByAdmin(adminNo);
    }

    //按用户编号查询
    public List<Feedback> queryByUser(String userNo) {
        return mapper.queryByUser(userNo);
    }

    //按日期范围查询
    public List<Feedback> queryByDate(Date beginDate, Date endDate) {
        return mapper.queryByDate(beginDate, endDate);
    }

    //查询所有
    public List<Feedback> queryAllFb() {
        return mapper.queryAllFb();
    }

    //插入新公告
    public boolean insertFb(Feedback fb) {
        return mapper.insertFb(fb);
    }

    //删除公告
    public boolean deleteFb(String fb) {
        return mapper.deleteFb(fb);
    }


    public List<Feedback> queryByDateOfUser(String userNo, Date beginDate, Date endDate) {
        return mapper.queryByDateOfUser(userNo, beginDate, endDate);
    }
}
