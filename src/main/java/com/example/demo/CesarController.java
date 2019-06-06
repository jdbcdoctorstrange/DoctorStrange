package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class CesarController {
    @Autowired
    UserService userService;

    @Autowired
    ClosetRepository closetRepository;

    @Autowired
    TopRepository topRepository;

    @Autowired
    JacketRepository jacketRepository;

    @Autowired
    BottomRepository bottomRepository;

    @Autowired
    FootwearRepository footwearRepository;

    @Autowired
    AccessoriesRepository accessoriesRepository;

    @RequestMapping("/suggestedform")
    public String getUserForm(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "userclosetform";
    }


    @RequestMapping("/process")
    public String processUserForm(@RequestParam("occasion") String occasion, Model model) {
        model.addAttribute("user", userService.getCurrentUser());

        return "suggestedclothes";
    }

}
