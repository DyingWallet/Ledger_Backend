package stu.xuronghao.ledger.mapper;


import stu.xuronghao.ledger.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminDao {


    /**
     * query all user
     */
    @Select("select * from User_T")
    List<User> findAllUser();

    /**
     * query user by key
     */
    @Select("select * from User_T where userName like concat('%',#{key},'%') or userNo like concat('%',#{key},'%')")
    List<User> findUserByKey(@Param("key") String Key);

    /**
     * change user status
     */
    @Update("update User_T set userStatus = userStatus^1 where userNo = #{userNo}")
    void updateUserStatus(@Param("userNo") String id);

    /**
     * post an announce
     */
    @Insert("insert into Announce_T values(#{annoNo},#{annoTitle},#{annoType},#{annoContent},#{annoDate},#{adminNo})")
    void insertAnnounce(@Param("annoNo") String annoNo, @Param("annoTitle") String annoTitle, @Param("annoType") String annoType, @Param("annoContent") String annoContent,
                        @Param("annoDate") String annoDate, @Param("adminNo") String adminNo);


    /**
     * delete an announce
     */
    @Delete("delete from Announce_T where annoNo = #{annoNo}")
    void deleteAnnounce(@Param("annoNo") String annoNo);

    /**
     * query announce
     */
    @Select("select * from Announce_T where annoContent like concat('%',#{key},'%') order by annoDate desc")
    List<Anno> queryAnnounce(@Param("key") String key);

    /**
     * query all feedback
     */
    @Select("select * from Feedback_T order by fbDate desc ")
    List<Feedback> findAllFeedback();

    /**
     * Processed feedback
     */
    @Update("update Feedback_T set fbRead = fbRead ^ true where fbno = #{fbno}")
    void processedFeedback(@Param("fbno") String fbno);

    /**
     * admin login
     */
    @Select("select * from  Admin_T where adminNo = #{adminNo} and adminPasswd = #{adminPasswd}")
    Admin adminLogin(@Param("adminNo") String adminNo, @Param("adminPasswd") String adminPasswd);

    /**
     * admin_UpdatePassword
     */
    @Update("update Admin_T set adminPasswd = #{newPasswd} where adminNo = #{adminNo}")
    void adminUpdatePasswd(@Param("newPasswd") String newPasswd, @Param("adminNo") String adminNo);

    /**
     * revocationAnnounce
     */
    @Update("update Announce_T set annoType = 0 where annoNo = #{annoNo}")
    void revocationAnnounce(@Param("annoNo") String id);


    /**
     * updateProduct
     */
    @Update("update Products_T set proName = #{proName} , proNumber = #{proNumber} , proType = #{proType} , proPrice = #{proPrice}, proDiscount = #{proDiscount}, proStatus= #{proStatus} where proNo = #{proNo}")
    void updateProduct(@Param("proNo") String proNo, @Param("proName") String proName, @Param("proType") String proType, @Param("proPrice") String proPrice, @Param("proDiscount") String proDiscount, @Param("proStatus") String proStatus);

    /**
     *  putOnSale 。。。
     */

}
