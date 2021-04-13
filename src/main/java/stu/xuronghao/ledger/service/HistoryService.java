package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.ChatInfo;

import java.util.List;

public interface HistoryService {

    List<ChatInfo> queryByUser(String userNo);
}
