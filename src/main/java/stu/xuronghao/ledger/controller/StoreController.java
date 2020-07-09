package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    public String queryByProNo(@RequestParam(value = "proNo")String proNo){
        log.info("Ready to query pro by No:" + proNo);
        Product product = productService.queryByProNo(proNo);
        return JSON.toJSONString(product, SerializerFeature.WriteClassName);
    }

    //按名模糊查找
    @GetMapping("/queryByProName")
    public String queryByProName(@RequestParam(value = "proName")String proName){
        log.info("Ready to query pro by Name:" + proName);
        List<Product> products = productService.queryByProName(proName);
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //按类型查找
    @GetMapping("/queryByProType")
    public String queryByProType(@RequestParam(value = "proType")String proType){
        log.info("Ready to query pro by Type: " + proType);
        List<Product> products = productService.queryByProType(proType);
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryAllPro")
    public String queryAllPro(){
        log.info("Ready to query all Pro!");
        List<Product> products = productService.queryAllPro();
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //新增商品
    @PostMapping(value = "/insertPro", produces = "application/json;charset=UTF-8")
    public boolean insertPro(@RequestBody String proJson){
        Product product = JSON.parseObject(proJson,Product.class);
        log.info("Ready to insert a new Pro: " + product.toString());
        return productService.insertPro(product);
    }

    //上架商品
    @PostMapping(value = "/OnShelf", produces = "application/json;charset=UTF-8")
    public boolean OnShelf(@RequestBody String proNo){
        log.info("Ready to On-Shelf Pro: " + proNo);
        return productService.OnShelf(proNo);
    }

    //下架商品
    @PostMapping(value = "/OffShelf", produces = "application/json;charset=UTF-8")
    public boolean OffShelf(@RequestBody String proNo){
        log.info("Ready to Off-Shelf Pro: " + proNo);
        return productService.OffShelf(proNo);
    }

}
