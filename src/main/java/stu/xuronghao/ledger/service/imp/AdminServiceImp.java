package stu.xuronghao.ledger.service.imp;


import stu.xuronghao.ledger.entity.*;
import stu.xuronghao.ledger.mapper.AdminDao;
import stu.xuronghao.ledger.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Resource
    private AdminDao dao;

    @Override
    public List<User> queryAllUser() {
        return dao.findAllUser();
    }

    @Override
    public List<User> queryByKey(String key) {
        return dao.findUserByKey(key);
    }

    @Override
    public List<Anno> queryAnnounce(String key) {
        return dao.queryAnnounce(key);
    }

    @Override
    public List<Feedback> queryAllFeedback() {
        return dao.findAllFeedback();
    }

    @Override
    public List<Product> queryProduct(String key) {
        return null;
    }

    @Override
    public void updateUserStatus(String id) {
        dao.updateUserStatus(id);
        return;
    }

    @Override
    public void processedFeedback(String id) {
        dao.processedFeedback(id);
        return;
    }

    @Override
    public void revocationAnnounce(String id) {
        dao.revocationAnnounce(id);
        return;
    }

    @Override
    public Admin login(String id, String password) {
        Admin admin = dao.adminLogin(id, password);
        return admin;
    }

    @Override
    public void adminUpdatePasswd(String newPasswd, String adminNo) {
        dao.adminUpdatePasswd(newPasswd, adminNo);
        return;
    }

    @Override
    public void postAnnounce(String title, String type, String content, String date, String adminNo) {
        dao.insertAnnounce("123", title, type, content, date, adminNo);
    }
}
