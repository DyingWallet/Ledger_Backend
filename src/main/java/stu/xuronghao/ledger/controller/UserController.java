package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.User;
import stu.xuronghao.ledger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import stu.xuronghao.ledger.utils.ConstantVariable;
import stu.xuronghao.ledger.utils.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    //按编号精确查找
    @GetMapping("/queryByUserNo")
    public String queryByUserNo(@RequestParam(value = "userNo") String userNo) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_BY_NO_NAME_TYPE, ConstantVariable.USER, userNo));
        User user = userService.queryByUserNo(userNo);
        return JSON.toJSONString(user, SerializerFeature.WriteClassName);
    }

    //按用户名模糊查找
    @GetMapping("/queryByUserName")
    public String queryByUserName(@RequestParam(value = "userName") String userName) {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_USER_NAME, userName));
        List<User> users = userService.queryByUserName(userName);
        return JSON.toJSONString(users, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryAllUser")
    //方法默认返回ArrayList，不用特意设置
    public String queryAllUser() {
        log.info(StringUtils.format(ConstantVariable.LOG_QUERY_ALL,ConstantVariable.USER));
        List<User> users = userService.queryAllUser();
        return JSON.toJSONString(users, SerializerFeature.WriteClassName);
    }

    //用户注册
    @PostMapping(value = "/SignUp", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean userSignUp(@RequestBody String userJson) {
        log.info(StringUtils.format(ConstantVariable.LOG_SIGN_IN_USER, userJson));
        User user = JSON.parseObject(userJson,User.class);
        return userService.insertUser(user);
    }

    //用户登录
    @PostMapping(value = "/Login", produces = ConstantVariable.REQUEST_PRODUCE)
    public String userLogin(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson,User.class);
        user = userService.UserLogin(user);
        log.info(StringUtils.format(ConstantVariable.LOG_CURRENT_USER, user.toString()));
        return JSON.toJSONString(user, SerializerFeature.WriteClassName);
    }

    //获取用户信息
    @PostMapping(value = "/getUserInfo",produces = ConstantVariable.REQUEST_PRODUCE)
    public String getUserInfo(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson,User.class);
        log.info(StringUtils.format(ConstantVariable.LOG_GET_USER_INFO,user.toString()));
        return JSON.toJSONString(userService.getUserInfo(user), SerializerFeature.WriteClassName);
    }

    //更新用户信息
    @PostMapping(value = "/updateUserInfo",produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean updateUserInfo(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson,User.class);
        log.info(StringUtils.format(ConstantVariable.LOG_UPDATE_USER_INFO, ConstantVariable.LOG_USER_INFO, user.getUserNo()));
        return userService.updateUserInfo(user);
    }

    //更改密码
    @PostMapping(value = "/changeUserPasswd", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean changeUserPasswd(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson, User.class);
        log.info(StringUtils.format(ConstantVariable.LOG_UPDATE_USER_INFO,ConstantVariable.LOG_PASSWD , user.getUserNo()));
        return userService.changeUserPasswd(user);
    }

    //更改预算
    @PostMapping(value = "/changeUserBudget",produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean changeUserBudget(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson, User.class);
        log.info(StringUtils.format(ConstantVariable.LOG_UPDATE_USER_INFO, ConstantVariable.LOG_BUDGET, user.getUserNo()));
        return userService.changeUserBudget(user);
    }

    //用户删除
    @PostMapping(value = "/deleteUser", produces = ConstantVariable.REQUEST_PRODUCE)
    public boolean deleteUser(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson, User.class);
        log.warn(StringUtils.format(ConstantVariable.LOG_FROZE_USER, user.toString()));
        if (userService.deleteUser(user.getUserNo())) {
            log.warn(StringUtils.format(ConstantVariable.LOG_USER_HAS_BEEN_FROZEN, user.getUserNo()));
        } else {
            log.error(StringUtils.format(ConstantVariable.LOG_FROZE_USER_FAILED, user.toString()));
            return false;
        }
        return true;
    }
}