package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HistoryService {
    @Resource
    HistoryMapper mapper;

    public List<ChatInfo> queryByUser(String userNo) {
        return mapper.queryByUser(userNo);
    }

}
