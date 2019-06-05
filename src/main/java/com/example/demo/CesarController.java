package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class CesarController {
    @Autowired
    CloudinaryConfig cloudc;

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

    @RequestMapping("/clothes")
    public String showAllClothes(Model model){
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("closets", closetRepository.findAllClosetsByUid(user.getId()));
        return "tops";
    }

    @RequestMapping("/addtopces")
    public String addTop(Model model){
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("closets", closetRepository.findAll());
        model.addAttribute("top", new Top());
        return "addtop";
    }

    @PostMapping("/processtopces")
    public String processTop(@RequestParam("file") MultipartFile file, @Valid Top top,
                             BindingResult result){
        if(result.hasErrors()){
            return "addtop";
        }
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
        topRepository.save(top);
        return "redirect:/clothes";
    }
}
