package stu.xuronghao.ledger.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.Product;
import stu.xuronghao.ledger.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Stock")
public class StorageController {
    private static final Logger log = LoggerFactory.getLogger(StorageController.class);

    @Resource
    StorageService storageService;


    //查找单件
    @GetMapping("/queryOneItem")
    public String queryOneItem(@RequestParam(value = "proNo") String proNo,
                               @RequestParam(value = "userNo") String userNo) {
        log.info("Ready to query the Item: " + proNo + ", " + userNo);
        Product product = storageService.queryOneItem(proNo, userNo);
        return JSON.toJSONString(product, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryStock")
    public String queryStock() {
        log.info("Ready to query the whole Stock!");
        List<Product> products = storageService.queryStock();
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //按物品查找
    @GetMapping("/queryByItem")
    public String queryByItem(@RequestParam(value = "proNo") String proNo) {
        log.info("Ready to query the Item: " + proNo);
        List<Product> products = storageService.queryByItem(proNo);
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //按用户查找
    @GetMapping("/queryByUser")
    public String queryByUser(@RequestParam(value = "userNo") String userNo) {
        log.info("Ready to query the Item: " + userNo);
        List<Product> products = storageService.queryByUser(userNo);
        return JSON.toJSONString(products, SerializerFeature.WriteClassName);
    }

    //购买物品
    @PostMapping(value = "Purchase", produces = "application/json;charset=UTF-8")
    public boolean buyItem(@RequestBody String proJson) {
        Product product = JSON.parseObject(proJson, Product.class);
        log.info("Ready to buy Item: " + product.toString());
        return storageService.buyItem(product);
    }

}
