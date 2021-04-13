package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.Feedback;
import stu.xuronghao.ledger.mapper.FeedbackMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.FeedbackService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImp implements FeedbackService {
    @Resource
    FeedbackMapper mapper;

    //精确查找
    @Override
    public Feedback queryByNo(String fbNo) {
        return mapper.queryByNo(fbNo);
    }

    //按标题查询-模糊匹配
    @Override
    public List<Feedback> queryByTitle(String fbTitle) {
        return mapper.queryByTitle(fbTitle);
    }

    //按类型查找
    @Override
    public List<Feedback> queryByType(String fbType) {
        return mapper.queryByType(fbType);
    }

    //按管理员编号查询
    @Override
    public List<Feedback> queryByAdmin(String adminNo) {
        return mapper.queryByAdmin(adminNo);
    }

    //按用户编号查询
    @Override
    public List<Feedback> queryByUser(String userNo) {
        return mapper.queryByUser(userNo);
    }

    //按日期范围查询
    @Override
    public List<Feedback> queryByDate(Date beginDate, Date endDate) {
        return mapper.queryByDate(beginDate, endDate);
    }

    //查询所有
    @Override
    public List<Feedback> queryAllFb() {
        return mapper.queryAllFb();
    }

    //插入新公告
    @Override
    public boolean insertFb(Feedback fb) {
        return mapper.insertFb(fb);
    }

    //删除公告
    @Override
    public boolean deleteFb(String fb) {
        return mapper.deleteFb(fb);
    }

    @Override
    public List<Feedback> queryByDateOfUser(String userNo, Date beginDate, Date endDate) {
        return mapper.queryByDateOfUser(userNo, beginDate, endDate);
    }
}
