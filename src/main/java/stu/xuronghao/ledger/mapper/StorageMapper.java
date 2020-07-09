package stu.xuronghao.ledger.mapper;

import stu.xuronghao.ledger.entity.Product;

import java.util.List;

public interface StorageMapper {
    Product queryOneItem(String proNo, String userNo);

    List<Product> queryByItem(String proNo);

    List<Product> queryByUser(String userNo);

    List<Product> queryStock();

    boolean insertItem(Product product);
}
