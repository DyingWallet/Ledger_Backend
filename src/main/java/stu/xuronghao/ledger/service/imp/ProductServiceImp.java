package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.ProductService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Resource
    ProductMapper mapper;


    @Override
    public Product queryByProNo(String proNo) {
        return mapper.queryByProNo(proNo);
    }

    @Override
    public List<Product> queryByProName(String proName) {
        return mapper.queryByProName(proName);
    }

    @Override
    public List<Product> queryByProType(String proType) {
        return mapper.queryByProType(proType);
    }

    @Override
    public List<Product> queryAllPro() {
        return mapper.queryAllPro();
    }

    @Override
    public boolean insertPro(Product product) {
        return mapper.insertPro(product);
    }

    @Override
    public boolean OnShelf(String proNo) {
        return mapper.OnShelf(proNo);
    }

    @Override
    public boolean OffShelf(String proNo) {
        return mapper.OffShelf(proNo);
    }
}
