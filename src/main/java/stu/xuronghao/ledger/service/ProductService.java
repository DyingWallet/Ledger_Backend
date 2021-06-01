package stu.xuronghao.ledger.service;

import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.entity.Product;

import java.util.List;

@Service
public interface ProductService {
    Product queryByProNo(String proNo);

    List<Product> queryByProName(String proName);

    List<Product> queryByProType(String proType);

    List<Product> queryAllPro();

    boolean insertPro(Product product);

    boolean OnShelf(String proNo);

    boolean OffShelf(String proNo);
}
