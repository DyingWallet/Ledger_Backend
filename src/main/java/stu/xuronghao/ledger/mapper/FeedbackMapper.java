package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.Feedback;

import java.util.Date;
import java.util.List;

@Mapper
public interface FeedbackMapper {
    Feedback queryByNo(String fbNo);

    List<Feedback> queryByTitle(String fbTitle);

    List<Feedback> queryByType(String fbType);

    List<Feedback> queryByAdmin(String adminNo);

    List<Feedback> queryByUser(String userNo);

    List<Feedback> queryByDate(Date beginDate, Date endDate);

    List<Feedback> queryAllFb();

    boolean insertFb(Feedback fb);

    boolean deleteFb(String fb);

    List<Feedback> queryByDateOfUser(String userNo, Date beginDate, Date endDate);
}
