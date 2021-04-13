package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.Product;

import java.util.List;

public interface StorageService {
    Product queryOneItem(String proNo, String userNo);

    List<Product> queryByItem(String proNo);

    List<Product> queryByUser(String userNo);

    List<Product> queryStock();

    boolean buyItem(Product product);
}
