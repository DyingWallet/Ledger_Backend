package stu.xuronghao.ledger.utils;

public class ConstantVariable {
    //公用
    public static final String FORMAT_REGEX_PATTERN = "\\{\\d\\}";
    public static final String ADMIN = "Admin";
    public static final String ANNOUNCEMENT = "Announcement";
    public static final String COST = "Cost";
    public static final String FEEDBACK = "Feedback";
    public static final String INCOME = "Income";
    public static final String SENTENCE = "Sentence";
    public static final String STORAGE = "Storage";
    public static final String STORE = "Store";
    public static final String PRODUCT = "Product";
    public static final String USER = "User";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_ZONE = "GMT+8:00";
    public static final String REQUEST_PRODUCE = "application/json;charset=UTF-8";

    //日志
    public static final String DEFAULT_CONTENT = "欢迎使用治账！快记点什么吧！";
    public static final String LOG_QUERY_BY_NO_NAME_TYPE = "Ready to query {0}: {1}";
    public static final String LOG_QUERY_USER_NAME = "Ready to query related user: {0}";
    public static final String LOG_QUERY_ALL = "Ready to query all {0}!";
    public static final String LOG_INSERT = "Ready to insert {0}: {1}";
    public static final String LOG_UPDATE = "Ready to update {0}: {1}";
    public static final String LOG_DELETE = "Ready to delete {0}: {1}";
    public static final String LOG_CHANGE_STATE = "Ready to change state {0}: {1}";

    //管理员相关
    //登录
    public static final String LOGIN_PAGE = "login";
    //主页
    public static final String HOME_PAGE = "home";
    //反馈
    public static final String FEEDBACK_PAGE = "feedback";
    //管理员
    public static final String ADMIN_PAGE = "admin";
    //空
    public static final String BLANK_PAGE = "";
    //列表
    public static final String LIST = "list";
    //查询
    public static final String QUERY = "query";
    //公告
    public static final String ANNOUNCE = "announce";
    //重定向
    public static final String REDIRECT = "redirect:";
    //发布公告
    public static final String SEND_ANNOUNCE = "/" + ADMIN + "/" + ANNOUNCE;
    //id,passwd信息
    public static final String LOG_ID_PASSWD = "id = {0}; passwd = {1}";
    //公告信息
    public static final String LOG_ANNO_INFO = "{0} + \n + {1} + \n + {2} + \n + {3}";

    //用户相关
    public static final int LOGGED_IN = 2;
    public static final int ACTIVE = 1;
    public static final int FROZEN_USER = 0;
    public static final int NO_USER = -1;
    public static final int WRONG_PASSWD = -2;

    public static final String LOG_SIGN_IN_USER = "Ready to SignUp user: {0}";
    public static final String LOG_CURRENT_USER = "{0} logged in";
    public static final String LOG_CHANGE_PASSWD = "Ready to update passwd: {0}";
    public static final String LOG_FROZE_USER = "Ready to froze user: {0}";
    public static final String LOG_USER_HAS_BEEN_FROZEN = "User: {0} has been deleted";
    public static final String LOG_FROZE_USER_FAILED = "Failed to delete user: {0}";

    //公告/反馈相关
    public static final String LOG_QUERY_BY_DATE_RANGE = "Ready to query {0} between {1} and {2}";
    public static final String LOG_QUERY_BY_TITLE = "Ready to query {0}: {1}";
    public static final String LOG_QUERY_BY_TYPE = "Ready to query {0}: {1}";

    //支出/收入相关
    public static final String SPLIT_STR = "<<->>";


    private ConstantVariable(){}
}