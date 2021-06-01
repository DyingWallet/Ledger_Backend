package stu.xuronghao.ledger.service;

import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Cost;
import stu.xuronghao.ledger.utils.DateTimeHandler;

import java.util.List;

@Service
public interface CostService {

    Cost queryByCostNo(String costNo);

    List<Cost> queryByCostEvent(String costEvent);

    List<Cost> queryByCostType(String costType);

    List<Cost> queryByCostUser(String userNo);

    List<Cost> queryByCostDate(String beginDate, String endDate);

    List<Cost> queryAllCost();

    boolean insertCost(Cost cost);

    boolean updateCost(Cost cost);

    boolean deleteCost(Cost cost);

    List<Cost> queryByCostDateOfUser(String userNo, String beginDate, String endDate);

    ChatInfo costChat(Cost cost, ChatInfo chat);
}