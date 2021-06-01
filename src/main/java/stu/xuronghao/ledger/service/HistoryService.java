package stu.xuronghao.ledger.service;

import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.entity.ChatInfo;

import java.util.List;

@Service
public interface HistoryService {

    List<ChatInfo> queryByUser(String userNo);
}
