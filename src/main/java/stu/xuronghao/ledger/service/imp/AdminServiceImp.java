package stu.xuronghao.ledger.service.imp;


import stu.xuronghao.ledger.entity.*;
import stu.xuronghao.ledger.mapper.AdminMapper;
import stu.xuronghao.ledger.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Resource
    private AdminMapper mapper;

    @Override
    public List<User> queryAllUser() {
        return mapper.findAllUser();
    }

    @Override
    public List<User> queryByKey(String key) {
        return mapper.findUserByKey(key);
    }

    @Override
    public List<Anno> queryAnnounce(String key) {
        return mapper.queryAnnounce(key);
    }

    @Override
    public List<Feedback> queryAllFeedback() {
        return mapper.findAllFeedback();
    }

    @Override
    public List<Product> queryProduct(String key) {
        return null;
    }

    @Override
    public void updateUserStatus(String id) {
        mapper.updateUserStatus(id);
        return;
    }

    @Override
    public void processedFeedback(String id) {
        mapper.processedFeedback(id);
        return;
    }

    @Override
    public void revocationAnnounce(String id) {
        mapper.revocationAnnounce(id);
        return;
    }

    @Override
    public void deleteAnnounce(String id){
        mapper.deleteAnnounce(id);
    }

    @Override
    public Admin login(String id, String password) {
        Admin admin = mapper.adminLogin(id, password);
        return admin;
    }

    @Override
    public void adminUpdatePasswd(String newPasswd, String adminNo) {
        mapper.adminUpdatePasswd(newPasswd, adminNo);
        return;
    }

    @Override
    public void postAnnounce(String title, String type, String content, String date, String adminNo) {
        mapper.insertAnnounce("123", title, type, content, date, adminNo);
    }
}
