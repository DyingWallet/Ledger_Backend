package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.Cost;

import java.util.List;

@Mapper
public interface CostMapper {
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
}
