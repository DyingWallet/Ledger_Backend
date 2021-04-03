package stu.xuronghao.ledger.controller;

import stu.xuronghao.ledger.entity.*;
import stu.xuronghao.ledger.service.AdminService;
import stu.xuronghao.ledger.utils.DatetimeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService service;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * 查询所有用户信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/query")
    public String query(Model model) {
        List<User> list = service.queryAllUser();
        model.addAttribute("list", list);
        return "query";
    }

    /**
     * 根据 key 值对用户进行模糊查询 userNo, userName
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/queryByKey")
    public String queryById(Model model, HttpServletRequest request) {
        String id = request.getParameter("key");
//        System.out.println(id);
        List<User> list = service.queryByKey(id);
        model.addAttribute("list", list);
        return "query";
    }

    /**
     * 冻结 / 解冻 用户
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/changeUserStatus")
    public String changeUserStatus(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        service.updateUserStatus(id);
        List<User> list = service.queryAllUser();
        model.addAttribute("list", list);
        return "query";
    }

    /**
     * 查询所有的公告
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/announce")
    public String announce(Model model, HttpServletRequest request) {
        String key = request.getParameter("key");
        if (key == null) key = "";
        List<Anno> list = service.queryAnnounce(key);
        model.addAttribute("list", list);
        return "announce";
    }

    /**
     * 查询所有的反馈
     *
     * @param model
     * @return
     */
    @RequestMapping("/feedback")
    public String feedback(Model model) {
        List<Feedback> list = service.queryAllFeedback();
        model.addAttribute("list", list);
        return "feedback";
    }

    /**
     * 处理反馈
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/processedFeedback")
    public String processedFeedback(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        service.processedFeedback(id);
        return "redirect:feedback";
    }

    /**
     * 撤销公告
     *
     * @param request
     * @return
     */
    @RequestMapping("/revocationAnnounce")
    public String revocationAnnounce(HttpServletRequest request) {
        String id = request.getParameter("id");
        service.revocationAnnounce(id);
        return "announce";
    }

    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    /**
     * 管理员登录请求
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/adminlogin")
    public String adminLogin(HttpServletRequest request, HttpSession session) {
        String id = request.getParameter("adminId");
        String password = request.getParameter("password");
//        System.out.println("id = " + id + "; pd = " + password);
        Admin admin = service.login(id, password);
        session.setAttribute("admin", admin);
        return "redirect:home";
    }
//    sudo apt install docker-ce=<focal 5:19.03.9~3-0~ubuntu-focal amd64> docker-ce-cli=<focal 5:19.03.9~3-0~ubuntu-focal amd64> containerd.io

    /**
     * 管理员注销
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:login";
    }

    /**
     * 管理员更改密码
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(HttpServletRequest request, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        System.out.println(admin);
        String adminNo = admin.getAdminNo();
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        if (admin.getAdminPasswd().equals(oldPassword)) {
            System.out.println("!!!!");
            service.adminUpdatePasswd(newPassword, adminNo);
            admin = service.login(adminNo, newPassword);
//            session.removeAttribute("admin");
            session.setAttribute("admin", admin);
            return "1";
        } else {
            return "0";
        }
//        return "";
    }

    /**
     * 发布公告
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/postAnnounce")
    public String postAnnounce(HttpServletRequest request, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        String title = request.getParameter("title");
        String type = "1";
        String content = request.getParameter("content");
        String date = DatetimeHandler.getCurrentDatetime();
        System.out.println(title + "\n" + type + "\n" + content + "\n" + date);
        service.postAnnounce(title, type, content, date, admin.getAdminNo());
        return "redirect:/admin/announce";
    }

    /**
     * 商城部分（待完成）
     */
//    @RequestMapping("/products")
//    public String products(Model model, HttpServletRequest request){
//        String key = request.getParameter("key");
//        if(key == null) key = "";
//        List<Product> list = service.queryProduct(key);
//        model.addAttribute("list",list);
//        return "/products";
//    }
//
//    @RequestMapping("/updateProduct")
//    public String updateProduct(HttpServletRequest request){
//        String proNo = request.getParameter("proNo");
//        String proName = request.getParameter("proName");
//        String proType = request.getParameter("proType");
//        String proPrice = request.getParameter("proPrice");
//        String proDiscount = request.getParameter("proDiscount");
//        String proStatus = request.getParameter("proStatus");
//
//        return "redirect:products";
//    }

}
