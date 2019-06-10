package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;


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


//    @PostConstruct
//    public void fillTable() {
//
//        System.out.println("Loading data...");
//
//        roleRepository.save(new Role("USER"));
//        roleRepository.save(new Role("ADMIN"));
//
//        Role userRole = roleRepository.findByRole("USER");
//        Role adminRole = roleRepository.findByRole("ADMIN");
//
//        User user = new User("bob@bob.com",passwordEncoder.encode("password"),"Bob","Bobberson",true,"bob");
//        user.setRoles(Arrays.asList(userRole));
//        userRepository.save(user);
//
////        user = new User("admin@adm.com",passwordEncoder.encode("password"),"Admin","User",true,"admin");
////        user.setRoles(Arrays.asList(adminRole));
////        userRepository.save(user);
//
//        Closet bobCloset = new Closet();
//        bobCloset.setClosetName("Bob's Closet");
//        bobCloset.setUid(user.getId());
//        bobCloset.setUser(user);
//        closetRepository.save(bobCloset);
//
//        Top whiteShirt = new Top();
//        whiteShirt.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559929110/c0a3b76610b1c63ab7e19e57e5d6a309.jpg");
//        whiteShirt.setColor("white");
//        whiteShirt.setSize("small");
//        whiteShirt.setMaterial("cotton");
//        whiteShirt.setCategory("informal");
//        whiteShirt.setSeason("spring");
//        whiteShirt.setSleeves("long");
//        whiteShirt.setType("Botton down");
//        whiteShirt.setCloset(bobCloset);
//        topRepository.save(whiteShirt);
//
//
//
//        Bottom blueBottom = new Bottom();
//        blueBottom.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559929488/15752506_349_main.jpg");
//        blueBottom.setColor("blue");
//        blueBottom.setSize("small");
//        blueBottom.setMaterial("denim");
//        blueBottom.setCategory("informal");
//        blueBottom.setSeason("spring");
//        blueBottom.setType("pants");
//        blueBottom.setCloset(bobCloset);
//        bottomRepository.save(blueBottom);
//
//        Jacket blackJacket = new Jacket();
//        blackJacket.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559929830/rBVaJFjU0dyAf9vyAAEfjj0Qa_A786.jpg");
//        blackJacket.setColor("black");
//        blackJacket.setSize("small");
//        blackJacket.setMaterial("leather");
//        blackJacket.setCategory("informal");
//        blackJacket.setSeason("spring");
//        blackJacket.setCloset(bobCloset);
//        jacketRepository.save(blackJacket);
//
//        Footwear blackFootwear = new Footwear();
//        blackFootwear.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559930120/9244051_fpx.jpg");
//        blackFootwear.setColor("black");
//        blackFootwear.setSize("small");
//        blackFootwear.setMaterial("leather");
//        blackFootwear.setCategory("informal");
//        blackFootwear.setSeason("spring");
//        blackFootwear.setCloset(bobCloset);
//        footwearRepository.save(blackFootwear);
//
//        Accessories bobAccessories = new Accessories();
//        bobAccessories.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559930371/oMQc_xqN_400x400.png");
//        bobAccessories.setColor("red");
//        bobAccessories.setSize("small");
//        bobAccessories.setMaterial("felt");
//        bobAccessories.setCategory("informal");
//        bobAccessories.setSeason("spring");
//        bobAccessories.setCloset(bobCloset);
//        accessoriesRepository.save(bobAccessories);
//
//    }

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


    @RequestMapping("/updatetop/{id}")
    public String updateTop(@PathVariable("id") long id, Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("closets", topRepository.findById(id).get().getCloset());
        topRepository.findById(id).ifPresent(o -> model.addAttribute("top", o));


        return "topform";
    }

    @RequestMapping("/updatejacket/{id}")
    public String updateJack(@PathVariable("id") long id, Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("closets", jacketRepository.findById(id).get().getCloset());
        jacketRepository.findById(id).ifPresent(o -> model.addAttribute("jacket", o));

        return "jacketform";
    }

    @RequestMapping("/updatefootwear/{id}")
    public String updateFoot(@PathVariable("id") long id, Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("closets", footwearRepository.findById(id).get().getCloset());
        footwearRepository.findById(id).ifPresent(o -> model.addAttribute("footwear", o));


        return "footwearform";
    }

    @RequestMapping("/updateaccesory/{id}")
    public String updateAcc(@PathVariable("id") long id, Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("closets", accessoriesRepository.findById(id).get().getCloset());
        accessoriesRepository.findById(id).ifPresent(o -> model.addAttribute("accessory", o));


        return "accessoryform";
    }

}



