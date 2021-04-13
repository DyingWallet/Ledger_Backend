package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.mapper.StorageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageServiceImp implements stu.xuronghao.ledger.service.StorageService {
    @Resource
    StorageMapper mapper;


    @Override
    public Product queryOneItem(String proNo, String userNo) {
        return mapper.queryOneItem(proNo, userNo);
    }

    @Override
    public List<Product> queryByItem(String proNo) {
        return mapper.queryByItem(proNo);
    }

    @Override
    public List<Product> queryByUser(String userNo) {
        return mapper.queryByUser(userNo);
    }

    @Override
    public List<Product> queryStock() {
        return mapper.queryStock();
    }

    @Override
    public boolean buyItem(Product product) {
        return mapper.insertItem(product);
    }
}
