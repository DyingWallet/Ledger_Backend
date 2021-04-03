package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Cost;
import stu.xuronghao.ledger.mapper.CostMapper;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import stu.xuronghao.ledger.mapper.UserMapper;
import stu.xuronghao.ledger.utils.DateHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CostService {
    @Resource
    CostMapper mapper;
    @Resource
    UserMapper userMapper;
    @Resource
    HistoryMapper historyMapper;
    @Resource
    SentService sentService;

    public Cost queryByCostNo(String costNo) {
        return mapper.queryByCostNo(costNo);
    }


    public List<Cost> queryByCostEvent(String costEvent) {
        return mapper.queryByCostEvent(costEvent);
    }

    public List<Cost> queryByCostType(String costType) {
        return mapper.queryByCostType(costType);
    }

    public List<Cost> queryByCostUser(String userNo) {
        return mapper.queryByCostUser(userNo);
    }

    public List<Cost> queryByCostDate(String beginDate, String endDate) {
        return mapper.queryByCostDate(beginDate, endDate);
    }

    public List<Cost> queryAllCost() {
        return mapper.queryAllCost();
    }

    public boolean insertCost(Cost cost) {
        return mapper.insertCost(cost);
    }

    public boolean updateCost(Cost cost) {
        return mapper.updateCost(cost);
    }

    public boolean deleteCost(Cost cost) {
        return mapper.deleteCost(cost);
    }

    public List<Cost> queryByCostDateOfUser(String userNo, String beginDate, String endDate) {
        return mapper.queryByCostDateOfUser(userNo, beginDate, endDate);
    }

    public ChatInfo costChat(Cost cost, ChatInfo chat) {
        if (insertCost(cost) && historyMapper.insertByUser(chat)) {
            chat.setUserNo(cost.getUserNo());
            chat.setContent(sentService.getReply());
            chat.setIsMeSend(0);
            chat.setDatetime(DateHandler.getCurrentDatetime());
            if (historyMapper.insertByUser(chat))
                return chat;
        }
        return null;
    }
}
