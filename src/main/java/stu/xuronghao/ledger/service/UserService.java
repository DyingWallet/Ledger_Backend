package stu.xuronghao.ledger.service;

import stu.xuronghao.ledger.entity.User;

import java.util.List;

public interface UserService {
    //精确查找
    User queryByUserNo(String userNo);

    //模糊查找
    List<User> queryByUserName(String userName);

    //查找所有
    List<User> queryAllUser();

    //修改密码
    boolean changeUserPasswd(User user);

    //删除用户
    boolean deleteUser(String userNo);

    //登录
    User UserLogin(User user);

    //新增用户
    boolean insertUser(User user);

    //更新预算
    boolean changeUserBudget(User user);

    //更新用户信息
    boolean updateUserInfo(User user);

    //获取用户信息
    User getUserInfo(User user);
}
