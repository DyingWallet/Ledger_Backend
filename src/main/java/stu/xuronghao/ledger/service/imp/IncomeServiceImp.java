package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.Income;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import stu.xuronghao.ledger.mapper.IncomeMapper;
import stu.xuronghao.ledger.mapper.UserMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.IncomeService;
import stu.xuronghao.ledger.utils.DateTimeHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncomeServiceImp implements IncomeService {
    @Resource
    IncomeMapper mapper;
    @Resource
    UserMapper userMapper;
    @Resource
    HistoryMapper historyMapper;
    @Resource
    SentServiceImp sentService;


    @Override
    public Income queryByIncNo(String incomeNo) {
        return mapper.queryByIncNo(incomeNo);
    }

    @Override
    public List<Income> queryByIncEvent(String incomeEvent) {
        return mapper.queryByIncEvent(incomeEvent);
    }

    @Override
    public List<Income> queryByIncType(String incomeType) {
        return mapper.queryByIncType(incomeType);
    }

    @Override
    public List<Income> queryByIncUser(String userNo) {
        return mapper.queryByIncUser(userNo);
    }

    @Override
    public List<Income> queryByIncDate(String beginDate, String endDate) {
        return mapper.queryByIncDate(beginDate, endDate);
    }

    @Override
    public List<Income> queryAllInc() {
        return mapper.queryAllInc();
    }

    @Override
    public boolean insertInc(Income income) {
        return mapper.insertInc(income);
    }

    @Override
    public boolean updateInc(Income income) {
        return mapper.updateInc(income);
    }

    @Override
    public boolean deleteInc(Income income) {
        return mapper.deleteInc(income);
    }

    @Override
    public List<Income> queryByIncDateOfUser(String userNo, String beginDate, String endDate) {
        return mapper.queryByIncDateOfUser(userNo, beginDate, endDate);
    }

    @Override
    public ChatInfo incomeChat(Income income, ChatInfo chat) {
        if (insertInc(income) && historyMapper.insertByUser(chat)) {
            chat.setUserNo(income.getUserNo());
            chat.setContent(sentService.getReply());
            chat.setIsMeSend(0);
            chat.setDatetime(DateTimeHandler.getCurrentDatetime());
            if (historyMapper.insertByUser(chat))
                return chat;
        }
        return null;
    }
}
