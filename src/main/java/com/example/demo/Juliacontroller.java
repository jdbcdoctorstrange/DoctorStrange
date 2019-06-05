package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class Juliacontroller {
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClosetRepository closetRepository;

    @RequestMapping("/form")
    public String getUserForm(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "userclosetform";
    }

    @PostMapping("/process")
    public String processUserForm(@RequestParam("category") String category, Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "index";
    }

}