package stu.xuronghao.ledger.mapper;

import stu.xuronghao.ledger.entity.Admin;

import java.util.List;

public interface AdminMapper {

    //按管理员编号查询
    Admin queryByAdminNo(String adminNo);

    //模糊查询
    List<Admin> queryByAdminName(String adminName);

    //查询所有管理员
    List<Admin> queryAllAdmin();

    //新增管理员
    boolean insertAdmin(Admin admin);

    //修改密码
    boolean changeAdminPasswd(Admin admin);

    //注销管理员
    boolean frozeAdmin(String adminNo);

    //删除管理员
    boolean deleteAdmin(String adminNo);
}
