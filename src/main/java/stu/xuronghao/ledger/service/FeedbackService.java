package stu.xuronghao.ledger.service;

import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.entity.Feedback;

import java.util.Date;
import java.util.List;

@Service
public interface FeedbackService {

    //精确查找
    Feedback queryByNo(String fbNo);

    //按标题查询-模糊匹配
    List<Feedback> queryByTitle(String fbTitle);

    //按类型查找
    List<Feedback> queryByType(String fbType);

    //按管理员编号查询
    List<Feedback> queryByAdmin(String adminNo);

    //按用户编号查询
    List<Feedback> queryByUser(String userNo);

    //按日期范围查询
    List<Feedback> queryByDate(Date beginDate, Date endDate);

    //查询所有
    List<Feedback> queryAllFb();

    //插入新公告
    boolean insertFb(Feedback fb);

    //删除公告
    boolean deleteFb(String fb);

    List<Feedback> queryByDateOfUser(String userNo, Date beginDate, Date endDate);
}