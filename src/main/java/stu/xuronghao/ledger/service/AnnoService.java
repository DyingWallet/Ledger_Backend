package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.Anno;

import java.util.Date;
import java.util.List;

public interface AnnoService {

    //精确查找
    Anno queryByAnnoNo(String annoNo);

    //按标题查询-模糊匹配
    List<Anno> queryByTitle(String annoTitle);

    //按类型查找
    List<Anno> queryByAnnoType(String annoType);

    //按管理员编号查询
    List<Anno> queryByAnnoAdmin(String adminNo);

    //按日期范围查询
    List<Anno> queryByAnnoDate(Date beginDate, Date endDate);

    //查询所有
    List<Anno> queryAllAnno();

    //插入新公告
    boolean insertAnno(Anno anno);

    //更新公告
    boolean updateAnno(Anno anno);

    //删除公告
    boolean deleteAnno(String anno);

}
