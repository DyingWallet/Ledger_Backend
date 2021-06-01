package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.Income;

import java.util.List;

@Mapper
public interface IncomeMapper {
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
}
