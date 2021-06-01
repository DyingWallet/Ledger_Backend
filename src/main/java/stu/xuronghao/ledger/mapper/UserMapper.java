package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    //按用户编号查询
    User queryByUserNo(String userNo);

    //按用户名模糊查询
    List<User> queryByUserName(String userName);

    //查询所有用户
    List<User> queryAllUser();

    //查询记录条数
    int countAll();

    //积分变动
    boolean creditsChanges(String userNo, int changes);

    //新增用户
    boolean insertUser(User user);

    //修改密码
    boolean changeUserPasswd(User user);

    //更新预算
    boolean changeUserBudget(User user);

    //注销用户
    boolean setUserStatus(String userNo, int userStatus);

    //删除用户
    boolean deleteUser(String userNo);

    boolean updateUserInfo(User user);
}
