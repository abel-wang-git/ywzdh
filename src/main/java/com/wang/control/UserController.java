package com.wang.control;

import com.wang.entity.User;
import com.wang.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/7.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/save")
    @ResponseBody
    public User save(){
        User user = new User();
        user.setName("123");
        user.setPassWord("123");
        userService.save(user);
        return user;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
            userService.delete(1L);
        return "susses";
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<User> find(){
            return  userService.findAll();
    }
    @RequestMapping("/findO")
    @ResponseBody
    public List<User> findO(){
            return  userService.findOne(1L);
    }

    @GetMapping(value = "/home")
    public String index(){
        return "home";
    }
}
