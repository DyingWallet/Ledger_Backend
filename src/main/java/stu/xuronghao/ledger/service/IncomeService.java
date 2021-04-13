package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Income;

import java.util.List;

public interface IncomeService {
    Income queryByIncNo(String incomeNo);

    List<Income> queryByIncEvent(String incomeEvent);

    List<Income> queryByIncType(String incomeType);

    List<Income> queryByIncUser(String userNo);

    List<Income> queryByIncDate(String beginDate, String endDate);

    List<Income> queryAllInc();

    boolean insertInc(Income income);

    boolean updateInc(Income income);

    boolean deleteInc(Income income);

    List<Income> queryByIncDateOfUser(String userNo, String beginDate, String endDate);

    ChatInfo incomeChat(Income income, ChatInfo chat);
}
