package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductMapper mapper;


    public Product queryByProNo(String proNo) {
        return mapper.queryByProNo(proNo);
    }

    public List<Product> queryByProName(String proName) {
        return mapper.queryByProName(proName);
    }

    public List<Product> queryByProType(String proType) {
        return mapper.queryByProType(proType);
    }

    public List<Product> queryAllPro() {
        return mapper.queryAllPro();
    }

    public boolean insertPro(Product product) {
        return mapper.insertPro(product);
    }

    public boolean OnShelf(String proNo) {
        return mapper.OnShelf(proNo);
    }

    public boolean OffShelf(String proNo) {
        return mapper.OffShelf(proNo);
    }
}
