package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.HistoryService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HistoryServiceImp implements HistoryService {
    @Resource
    HistoryMapper mapper;

    @Override
    public List<ChatInfo> queryByUser(String userNo) {
        return mapper.queryByUser(userNo);
    }

}
