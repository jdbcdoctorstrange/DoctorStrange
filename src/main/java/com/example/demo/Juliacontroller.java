package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class Juliacontroller {
    @Autowired
    UserService userService;
    @Autowired
    ClosetRepository closetRepository;
    @Autowired
    TopRepository topRepository;

    @Autowired
    BottomRepository bottomRepository;

    @Autowired
    JacketRepository jacketRepository;

    @Autowired
    FootwearRepository footwearRepository;

    @Autowired
    AccessoriesRepository accessoriesRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CloudinaryConfig cloudc;

    //    @RequestMapping("/suggestedform")
//    public String getUserForm(Model model) {
//        model.addAttribute("user", userService.getCurrentUser());
//        return "userclosetform";
//    }
//
//
//    @RequestMapping("/process")
//    public String processUserForm(@RequestParam("occasion") String occasion, Model model) {
//        model.addAttribute("user", userService.getCurrentUser());
//        return "suggestedclothes";
//    }
    @RequestMapping("/deletetop/{id}")
    public String delTop(@PathVariable("id") long id) {
        User user = userService.getCurrentUser();
        Top top = topRepository.findById(id).get();
        if (top != null || (roleRepository.findByRoleAndUsersId("ADMIN", user.getId()) != null)) {
            topRepository.deleteById(id);
            System.out.println("Found closet\n");
        }
        return "redirect:/";
    }

    @RequestMapping("/deletejacket/{id}")
    public String delJack(@PathVariable("id") long id) {
        User user = userService.getCurrentUser();
        Jacket jacket = jacketRepository.findById(id).get();
        if (jacket != null || (roleRepository.findByRoleAndUsersId("ADMIN", user.getId()) != null)) {
            jacketRepository.deleteById(id);
            System.out.println("Found closet\n");
        }
        return "redirect:/";
    }

    @RequestMapping("/deletebottom/{id}")
    public String delBot(@PathVariable("id") long id) {
        User user = userService.getCurrentUser();
        Bottom bottom = bottomRepository.findById(id).get();
        if (bottom != null || (roleRepository.findByRoleAndUsersId("ADMIN", user.getId()) != null)) {
            bottomRepository.deleteById(id);
            System.out.println("Found closet\n");
        }
        return "redirect:/";
    }

    @RequestMapping("/deletefootwear/{id}")
    public String delFot(@PathVariable("id") long id) {
        User user = userService.getCurrentUser();
        Footwear footwear = footwearRepository.findById(id).get();
        if (footwear != null || (roleRepository.findByRoleAndUsersId("ADMIN", user.getId()) != null)) {
            footwearRepository.deleteById(id);
            System.out.println("Found closet\n");
        }
        return "redirect:/";
    }

    @RequestMapping("/deleteaccessory/{id}")
    public String delAcc(@PathVariable("id") long id) {
        User user = userService.getCurrentUser();
        Accessories accessories = accessoriesRepository.findById(id).get();
        if (accessories != null || (roleRepository.findByRoleAndUsersId("ADMIN", user.getId()) != null)) {
            accessoriesRepository.deleteById(id);
            System.out.println("Found closet\n");
        }
        return "redirect:/";
    }
}
