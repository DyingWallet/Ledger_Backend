package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.Anno;
import stu.xuronghao.ledger.mapper.AnnoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AnnoService {
    @Resource
    AnnoMapper mapper;

    //精确查找
    public Anno queryByAnnoNo(String annoNo) {
        return mapper.queryByAnnoNo(annoNo);
    }

    //按标题查询-模糊匹配
    public List<Anno> queryByTitle(String annoTitle) {
        return mapper.queryByAnnoTitle(annoTitle);
    }

    //按类型查找
    public List<Anno> queryByAnnoType(String annoType) {
        return mapper.queryByAnnoType(annoType);
    }

    //按管理员编号查询
    public List<Anno> queryByAnnoAdmin(String adminNo) {
        return mapper.queryByAnnoAdmin(adminNo);
    }

    //按日期范围查询
    public List<Anno> queryByAnnoDate(Date beginDate, Date endDate) {
        return mapper.queryByAnnoDate(beginDate, endDate);
    }

    //查询所有
    public List<Anno> queryAllAnno() {
        return mapper.queryAllAnno();
    }

    //插入新公告
    public boolean insertAnno(Anno anno) {
        return mapper.insertAnno(anno);
    }

    //更新公告
    public boolean updateAnno(Anno anno) {
        return updateAnno(anno);
    }

    //删除公告
    public boolean deleteAnno(String anno) {
        return mapper.deleteAnno(anno);
    }

}
