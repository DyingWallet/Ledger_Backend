package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.ChatInfo;

import java.util.List;

@Mapper
public interface HistoryMapper {

    boolean insertByUser(ChatInfo chatInfo);

    List<ChatInfo> queryByUser(String userNo);
}
