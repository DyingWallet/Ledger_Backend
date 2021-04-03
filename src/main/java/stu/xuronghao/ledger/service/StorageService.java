package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.mapper.StorageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageService {
    @Resource
    StorageMapper mapper;


    public Product queryOneItem(String proNo, String userNo) {
        return mapper.queryOneItem(proNo, userNo);
    }

    public List<Product> queryByItem(String proNo) {
        return mapper.queryByItem(proNo);
    }

    public List<Product> queryByUser(String userNo) {
        return mapper.queryByUser(userNo);
    }

    public List<Product> queryStock() {
        return mapper.queryStock();
    }

    public boolean buyItem(Product product) {
        return mapper.insertItem(product);
    }
}
