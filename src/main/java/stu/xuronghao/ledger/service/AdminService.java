package stu.xuronghao.ledger.service;


import stu.xuronghao.ledger.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<User> queryAllUser();

    List<User> queryByKey(String Key);

    List<Anno> queryAnnounce(String key);

    List<Feedback> queryAllFeedback();

    List<Product> queryProduct(String key);

    void updateUserStatus(String id);

    void processedFeedback(String id);

    void revocationAnnounce(String id);

     void deleteAnnounce(String id);

    Admin login(String id, String password);

    void adminUpdatePasswd(String newPasswd, String adminNo);

    void postAnnounce(String title, String type, String content, String date, String adminNo);
}
