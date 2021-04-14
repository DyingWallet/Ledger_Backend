package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import stu.xuronghao.ledger.utils.ConstantVariable;
import stu.xuronghao.ledger.utils.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Store")
public class StoreController {
    private static final Logger log = LoggerFactory.getLogger(StoreController.class);

    @Resource
    ProductService productService;

    //精确查找
    @GetMapping("/queryByProNo")
    public String queryByProNo(@RequestParam(value = "proNo") String proNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.PRODUCT, proNo));
        Product product = productService.queryByProNo(proNo);
        return JSON.toJSONString(product, SerializerFeature.WriteClassName);
    }

    //按名模糊查找
    @GetMapping("/queryByProName")
    public String queryByProName(@RequestParam(value = "proName") String proName) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.PRODUCT, proName));
        List<Product> products = productService.queryByProName(proName);
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //按类型查找
    @GetMapping("/queryByProType")
    public String queryByProType(@RequestParam(value = "proType") String proType) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.PRODUCT,  proType));
        List<Product> products = productService.queryByProType(proType);
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryAllPro")
    public String queryAllPro() {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_ALL, ConstantVariable.PRODUCT));
        List<Product> products = productService.queryAllPro();
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //新增商品
    @PostMapping(value = "/insertPro", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean insertPro(@RequestBody String proJson) {
        Product product = JSON.parseObject(proJson, Product.class);
        log.info(StringUtils.format(ConstantVariable.LOG_INSERT, ConstantVariable.PRODUCT, product.toString()));
        return productService.insertPro(product);
    }

    //上架商品
    @PostMapping(value = "/OnShelf", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean onShelf(@RequestBody String proNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_CHANGE_STATE, ConstantVariable.PRODUCT, proNo));
        return productService.OnShelf(proNo);
    }

    //下架商品
    @PostMapping(value = "/OffShelf", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean offShelf(@RequestBody String proNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_CHANGE_STATE, ConstantVariable.PRODUCT, proNo));
        return productService.OffShelf(proNo);
    }

}
