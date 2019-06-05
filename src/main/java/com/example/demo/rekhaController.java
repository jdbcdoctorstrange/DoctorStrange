package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@SuppressWarnings("ALL")
@Controller
public class rekhaController {

    @Autowired
    UserService userService;
    @Autowired
    ClosetRepository closetRepository;
    @Autowired
    TopRepository topRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/listclosets")
    public String listClosets(Model model) {
        User user = userService.getCurrentUser();
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("closets", closetRepository.findAllClosetsByUid(user.getId()));
        return "closetlist";
    }

    @GetMapping("/addcloset")
    public String closetForm(Model model) {

        User user = userService.getCurrentUser();
        Closet closet = new Closet();

        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("closet", closet);
        return "closetform";
    }

    @PostMapping("/processcloset")
    public String processcloset(@Valid Closet closet, BindingResult result, Model model) {

        System.out.println("Debug 1>>>>>>>>>>>");
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "closetform";
        }

        closet.setUser(userService.getCurrentUser());
        closet.setUid(userService.getCurrentUser().getId());
        userService.getCurrentUser().setCloset(closet);

        closetRepository.save(closet);
        userRepository.save(userService.getCurrentUser());
        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }
    @GetMapping("/addtop")
    public String topForm(Model model) {

        User user = userService.getCurrentUser();
        Top top = new Top();
        Closet closet = new Closet();
        top.setCloset(closet);
        User tuser = new User();
        top.getCloset().setUser(tuser);
        top.getCloset().setUser(user);
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("top", top);
        model.addAttribute("file", top.getImgUrl());
        return "topform";
    }

    @PostMapping("/processtop")
    public String processtop(@Valid Top top, BindingResult result, Model model,
                              @RequestParam("file")MultipartFile file) {

        System.out.println("Debug 1>>>>>>>>>>>");
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "topform";
        }
        System.out.println("Debug 2>>>>>>>>>>>");
        if(!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                top.setImgUrl(uploadResult.get("url").toString());
            }catch (IOException e) {
                e.printStackTrace();
                return "topform";
            }
        }
        System.out.println("Debug 3>>>>>>>>>>>");
        //top.setUid(userService.getCurrentUser().getId());
        top.getCloset().setUser(userService.getCurrentUser());
        
        topRepository.save(top);
        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }
}
