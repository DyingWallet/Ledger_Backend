package stu.xuronghao.ledger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stu.xuronghao.ledger.entity.*;
import stu.xuronghao.ledger.service.AdminService;
import stu.xuronghao.ledger.utils.ConstantVariable;
import stu.xuronghao.ledger.utils.DateTimeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stu.xuronghao.ledger.utils.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    public static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService service;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/home")
    public String home() {
        return ConstantVariable.HOME_PAGE;
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
        model.addAttribute(ConstantVariable.LIST, list);
        return ConstantVariable.QUERY;
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
        log.info(id);
        List<User> list = service.queryByKey(id);
        model.addAttribute(ConstantVariable.LIST, list);
        return ConstantVariable.QUERY;
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
        model.addAttribute(ConstantVariable.LIST, list);
        return ConstantVariable.QUERY;
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
        model.addAttribute(ConstantVariable.LIST, list);
        return ConstantVariable.ANNOUNCE;
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
        model.addAttribute(ConstantVariable.LIST, list);
        return ConstantVariable.FEEDBACK_PAGE;
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
        //"redirect:feedback"
        return ConstantVariable.REDIRECT+ConstantVariable.FEEDBACK_PAGE;
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
        return ConstantVariable.ANNOUNCE;
    }

    /**
     * 登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {

        return ConstantVariable.LOGIN_PAGE;
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
        log.info(StringUtils.format(ConstantVariable.LOG_ID_PASSWD,id,password));
        Admin admin = service.login(id, password);
        session.setAttribute(ConstantVariable.ADMIN_PAGE, admin);
        //"redirect:home"
        return ConstantVariable.REDIRECT+ConstantVariable.HOME_PAGE;
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
        session.removeAttribute(ConstantVariable.ADMIN_PAGE);
        //"redirect:login"
        return ConstantVariable.REDIRECT+ConstantVariable.LOGIN_PAGE;
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
        Admin admin = (Admin) session.getAttribute(ConstantVariable.ADMIN_PAGE);
        log.info(admin.toString());
        String adminNo = admin.getAdminNo();
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        if (admin.getAdminPasswd().equals(oldPassword)) {
            service.adminUpdatePasswd(newPassword, adminNo);
            admin = service.login(adminNo, newPassword);
            session.setAttribute(ConstantVariable.ADMIN_PAGE, admin);
            return "1";
        } else {
            return "0";
        }
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
        Admin admin = (Admin) session.getAttribute(ConstantVariable.ADMIN_PAGE);
        String title = request.getParameter("title");
        String type = "1";
        String content = request.getParameter("content");
        String date = DateTimeHandler.getCurrentDatetime();
        log.info(StringUtils.format(ConstantVariable.LOG_ANNO_INFO,title,type,content,date));
        service.postAnnounce(title, type, content, date, admin.getAdminNo());
        //"redirect:/admin/announce"
        return ConstantVariable.REDIRECT+ConstantVariable.SEND_ANNOUNCE;
    }

    /**
     * 商城部分（待完成）
     */
//    @RequestMapping("/products")
//    public String products(Model model, HttpServletRequest request){
//        String key = request.getParameter("key");
//        if(key == null) key = "";
//        List<Product> list = service.queryProduct(key);
//        model.addAttribute(ConstantVariable.LIST,list);
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
