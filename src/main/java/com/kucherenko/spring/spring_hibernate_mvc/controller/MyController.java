package com.kucherenko.spring.spring_hibernate_mvc.controller;

import com.kucherenko.spring.spring_hibernate_mvc.dao.UserDAO;
import com.kucherenko.spring.spring_hibernate_mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.UserDataHandler;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userDAO.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "all-users";
    }

    @RequestMapping("/search")
    public String searchUsers(@RequestParam("searchName")String keyword, Model model){
        List<User> users = userDAO.search(keyword);
        model.addAttribute("allUsers",users);
        return "all-users";
    }

    @RequestMapping("/updateUser")
    public String updateEmployee(@RequestParam("usrId")int id, Model model){
        User user = userDAO.getUserById(id);
        model.addAttribute("user",user);
       return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user")User user){
        userDAO.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/addUser")
    public String saveUser(Model model){
        User user = new User();
        user.setCreatedDate(new Timestamp(new Date().getTime()));
        model.addAttribute("user",user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String saveUser(@RequestParam("usrId")int id, Model mode){
        userDAO.deleteUser(id);
        return "redirect:/";
    }


}
