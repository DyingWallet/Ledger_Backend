package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Cost;
import stu.xuronghao.ledger.mapper.CostMapper;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import stu.xuronghao.ledger.mapper.UserMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.CostService;
import stu.xuronghao.ledger.utils.DateTimeHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CostServiceImp implements CostService {
    @Resource
    CostMapper mapper;
    @Resource
    UserMapper userMapper;
    @Resource
    HistoryMapper historyMapper;
    @Resource
    SentServiceImp sentService;

    @Override
    public Cost queryByCostNo(String costNo) {
        return mapper.queryByCostNo(costNo);
    }

    @Override
    public List<Cost> queryByCostEvent(String costEvent) {
        return mapper.queryByCostEvent(costEvent);
    }

    @Override
    public List<Cost> queryByCostType(String costType) {
        return mapper.queryByCostType(costType);
    }

    @Override
    public List<Cost> queryByCostUser(String userNo) {
        return mapper.queryByCostUser(userNo);
    }

    @Override
    public List<Cost> queryByCostDate(String beginDate, String endDate) {
        return mapper.queryByCostDate(beginDate, endDate);
    }

    @Override
    public List<Cost> queryAllCost() {
        return mapper.queryAllCost();
    }

    @Override
    public boolean insertCost(Cost cost) {
        return mapper.insertCost(cost);
    }

    @Override
    public boolean updateCost(Cost cost) {
        return mapper.updateCost(cost);
    }

    @Override
    public boolean deleteCost(Cost cost) {
        return mapper.deleteCost(cost);
    }

    @Override
    public List<Cost> queryByCostDateOfUser(String userNo, String beginDate, String endDate) {
        return mapper.queryByCostDateOfUser(userNo, beginDate, endDate);
    }

    @Override
    public ChatInfo costChat(Cost cost, ChatInfo chat) {
        if (insertCost(cost) && historyMapper.insertByUser(chat)) {
            chat.setUserNo(cost.getUserNo());
            chat.setContent(sentService.getReply());
            chat.setIsMeSend(0);
            chat.setDatetime(DateTimeHandler.getCurrentDatetime());
            if (historyMapper.insertByUser(chat))
                return chat;
        }
        return null;
    }
}