package stu.xuronghao.ledger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import stu.xuronghao.ledger.entity.User;
import stu.xuronghao.ledger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    private final int LoggedIn = 1,
            LoggedOut = 0,
            NoUser = -1,
            WrongPasswd = -2,
            FrozenUser=-3;
    //按编号精确查找
    @GetMapping("/queryByUserNo")
    public String queryByUserNo(@RequestParam(value = "userNo") String userNo) {
        log.info("Ready to query user: " + userNo);
        User user = userService.queryByUserNo(userNo);
        return JSON.toJSONString(user, SerializerFeature.WriteClassName);
    }

    //按用户名模糊查找
    @GetMapping("/queryByUserName")
    public String queryByUserName(@RequestParam(value = "userName") String userName) {
        log.info("Ready to query related user: " + userName);
        List<User> users = userService.queryByUserName(userName);
        return JSON.toJSONString(users, SerializerFeature.WriteClassName);
    }

    //查找所有
    @GetMapping("/queryAllUser")
    //方法默认返回ArrayList，不用特意设置
    public String queryAllUser() {
        log.info("Ready to query all users!");
        /*List<User> li = userService.queryAllUser();
        User temp;
        for(int i = 0; i< li.size();i++){
            temp = li.get(i);
            log.warn("the user " + i + " is: " + temp.toString());
        }
        return li;*/
        List<User> users = userService.queryAllUser();
        return JSON.toJSONString(users, SerializerFeature.WriteClassName);
    }

    //用户注册
    @PostMapping(value = "/SignUp", produces = "application/json;charset=UTF-8")
    public boolean UserSignUp(@RequestBody User user) {
        log.info("Ready to SignUp user: " + user.toString());
        return userService.insertUser(user);
    }

    //用户登录
    @PostMapping(value = "/Login",produces = "application/json;charset-UTF-8")
    public User UserLogin(@RequestBody User user){

        userService.UserLogin(user);
        log.info(user.toString());
        return user;
    }

    //用户登出
/*    @PostMapping(value = "Logout",produces = "application/json;charset-UTF-8")
    public boolean UserLogout(@RequestBody User user){
        log.info(user.toString());
        return userService.UserLogout(user);
    }*/

    //更改密码
    @PostMapping(value = "/changeUserPasswd", produces = "application/json;charset=UTF-8")
    public boolean changeUserPasswd(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson,User.class);
        log.info("Ready to update passwd: " + user.getUserNo());
        return userService.changeUserPasswd(user);
    }

/*
    //用户状态变化
    @PostMapping(value = "/frozeUser", produces = "application/json;charset:UTF-8")
    public boolean setUserStatus(@RequestBody User user) {
        log.warn("Ready to froze user: " + user.getUserNo());
        return userService.setUserStatus(user.getUserStatus(),user.getUserNo());
    }*/

    //用户删除
    @PostMapping(value = "/deleteUser", produces = "application/json;charset:UTF-8")
    public boolean deleteUser(@RequestBody String userJson) {
        User user = JSON.parseObject(userJson,User.class);
        log.warn("Ready to delete user: " + user);
        if (userService.deleteUser(user.getUserNo())) {
            log.warn("User: " + user.getUserNo() + " has been deleted");
        } else {
            log.error("Failed to delete user: " + user);
            return false;
        }
        return true;
    }

/*    @Resource
    SentService sentService;

    @GetMapping("/test")
    public String getReply(){
        return sentService.getReply();
    }*/

}
