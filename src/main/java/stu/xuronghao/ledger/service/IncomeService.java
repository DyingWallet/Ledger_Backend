package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Income;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import stu.xuronghao.ledger.mapper.IncomeMapper;
import stu.xuronghao.ledger.mapper.UserMapper;
import stu.xuronghao.ledger.utils.DateHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncomeService {
    @Resource
    IncomeMapper mapper;
    @Resource
    UserMapper userMapper;
    @Resource
    HistoryMapper historyMapper;
    @Resource
    SentService sentService;


    public Income queryByIncNo(String incomeNo) {
        return mapper.queryByIncNo(incomeNo);
    }


    public List<Income> queryByIncEvent(String incomeEvent) {
        return mapper.queryByIncEvent(incomeEvent);
    }

    public List<Income> queryByIncType(String incomeType) {
        return mapper.queryByIncType(incomeType);
    }

    public List<Income> queryByIncUser(String userNo) {
        return mapper.queryByIncUser(userNo);
    }

    public List<Income> queryByIncDate(String beginDate, String endDate) {
        return mapper.queryByIncDate(beginDate, endDate);
    }

    public List<Income> queryAllInc() {
        return mapper.queryAllInc();
    }

    public boolean insertInc(Income income) {
        return mapper.insertInc(income);
    }

    public boolean updateInc(Income income) {
        return mapper.updateInc(income);
    }

    public boolean deleteInc(Income income) {
        return mapper.deleteInc(income);
    }

    public List<Income> queryByIncDateOfUser(String userNo, String beginDate, String endDate) {
        return mapper.queryByIncDateOfUser(userNo,beginDate,endDate);
    }
    public ChatInfo incomeChat(Income income, ChatInfo chat) {
        if(insertInc(income) && historyMapper.insertByUser(chat)){
            chat.setUserNo(income.getUserNo());
            chat.setContent(sentService.getReply());
            chat.setIsMeSend(0);
            chat.setDatetime(DateHandler.getCurrentDatetime());
            if(historyMapper.insertByUser(chat))
                return chat;
        }
        return null;
    }
}
