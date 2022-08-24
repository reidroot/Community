package com.wxy.community;

import com.wxy.community.dao.DiscussPostMapper;
import com.wxy.community.dao.UserMapper;
import com.wxy.community.entity.DiscussPost;
import com.wxy.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        User user1 = userMapper.selectByName("zhangfei");
        System.out.println(user1);

        User user2 = userMapper.selectByEmail("nowcoder103@sina.com");
        System.out.println(user2);
    }

    @Test
    public void testInsertUser(){

        User user = new User();
        user.setUsername("reidroot");
        user.setPassword("123456");
        user.setSalt("49f10");
        user.setEmail("1835149573@qq.com");
        user.setStatus(1);
        user.setType(0);
        user.setActivationCode("69dcd69f4c0145058df820e90820ba1e");
        user.setHeaderUrl("http://images.nowcoder.com/head/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){

        int rows = userMapper.updateHeader(150, "https://1101");
        System.out.println(rows);

        rows = userMapper.updatePassWord(150, "654321");
        System.out.println(rows);

        rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){

        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }
}
