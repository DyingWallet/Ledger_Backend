package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {


    Product queryByProNo(String proNo);

    List<Product> queryByProName(String proName);

    List<Product> queryByProType(String proType);

    List<Product> queryAllPro();

    boolean insertPro(Product product);

    boolean OnShelf(String proNo);

    boolean OffShelf(String proNo);
}
