package stu.xuronghao.ledger.mapper;

import stu.xuronghao.ledger.entity.ChatInfo;

import java.util.List;

public interface HistoryMapper {

    boolean insertByUser(ChatInfo chatInfo);

    List<ChatInfo> queryByUser(String userNo);
}
