package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    TopRepository topRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @GetMapping("/addtop")
    public String topForm(Model model) {

        User user = userService.getCurrentUser();
        Top top = new Top();
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("top", top);
        model.addAttribute("file", top.getImgUrl());
        return "topform";
    }

    @PostMapping("/processtop")
    public String processForm(@Valid Top top, BindingResult result, Model model,
                              @RequestParam("file")MultipartFile file) {
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "topform";
        }
        if(!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                top.setImgUrl(uploadResult.get("imgUrl").toString());
            }catch (IOException e) {
                e.printStackTrace();
                return "topform";
            }
        }
        //top.setUid(userService.getCurrentUser().getId());
        top.getCloset().setUser(userService.getCurrentUser());
        
        topRepository.save(top);
        return "redirect:/";
    }
}
