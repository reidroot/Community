package com.wxy.community.dao;

import com.wxy.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketMapper {

    // 新增登录凭证
    @Insert({
            "insert into login_ticket(user_id, ticket, status, expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    // 根据ticket查询登录凭证
    @Select("select * from login_ticket where ticket = #{ticket}")
    LoginTicket selectByTicket(String ticket);

    // 更改登录凭证状态
    @Update("update login_ticket set status = #{status} where ticket = #{ticket}")
    int updateStatus(String ticket, int status);
}
