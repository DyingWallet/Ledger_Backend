package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.ChatInfo;
import stu.xuronghao.ledger.entity.User;
import stu.xuronghao.ledger.mapper.HistoryMapper;
import stu.xuronghao.ledger.mapper.UserMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.UserService;
import stu.xuronghao.ledger.utils.ConstantVariable;
import stu.xuronghao.ledger.utils.DateTimeHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Resource
    UserMapper mapper;
    @Resource
    HistoryMapper historyMapper;

    //精确查找
    @Override
    public User queryByUserNo(String userNo) {
        return mapper.queryByUserNo(userNo);
    }

    //模糊查找
    @Override
    public List<User> queryByUserName(String userName) {
        return mapper.queryByUserName(userName);
    }

    //查找所有
    @Override
    public List<User> queryAllUser() {
        return mapper.queryAllUser();
    }

    //修改密码
    @Override
    public boolean changeUserPasswd(User user) {
        return mapper.changeUserPasswd(user);
    }

    //删除用户
    @Override
    public boolean deleteUser(String userNo) {
        return mapper.deleteUser(userNo);
    }

    //登录
    @Override
    public User UserLogin(User user) {
        //从数据库中拉取数据
        User res = mapper.queryByUserNo(user.getUserNo());

        //用户存在
        if (res != null) {
            //用户密码正确
            if (user.getUserPasswd().equals(res.getUserPasswd())) {
                if (ConstantVariable.ACTIVE == res.getUserStatus()) {
                    //改变登录状态
                    res.setUserStatus(ConstantVariable.LOGGED_IN);
                    return res;
                } else if (ConstantVariable.FROZEN_USER == res.getUserStatus()) {
                    //用户被冻结
                    user.setUserPasswd(null);
                    user.setUserStatus(ConstantVariable.FROZEN_USER);
                }
            } else {
                //密码错误
                user.setUserStatus(ConstantVariable.WRONG_PASSWD);
            }
        } else {
            //未注册
            user.setUserStatus(ConstantVariable.NO_USER);
        }
        return user;
    }

    //新增用户
    @Override
    public boolean insertUser(User user) {
        if (mapper.queryByUserNo(user.getUserNo()) == null) {
            ChatInfo chat = new ChatInfo();
            user.setUserStatus(ConstantVariable.ACTIVE);
            chat.setUserNo(user.getUserNo());
            chat.setContent(ConstantVariable.DEFAULT_CONTENT);
            chat.setIsMeSend(0);
            chat.setDatetime(DateTimeHandler.getCurrentDatetime());
            return mapper.insertUser(user) && historyMapper.insertByUser(chat);
        } else
            return false;
    }

    //更新预算
    @Override
    public boolean changeUserBudget(User user){
        return mapper.changeUserBudget(user);
    }

    @Override
    public boolean updateUserInfo(User user) {
        return mapper.updateUserInfo(user);
    }

    @Override
    public User getUserInfo(User user) {
        return mapper.queryByUserNo(user.getUserNo());
    }
}
