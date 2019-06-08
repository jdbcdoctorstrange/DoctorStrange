package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

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
    public String processUserForm(@RequestParam("occasion") String occasion, @RequestParam("temp") String temp, Model model) {
        long uid = userService.getCurrentUser().getId();
        ArrayList<Top> tops = new ArrayList<>();
        ArrayList<Jacket> jackets = new ArrayList<>();
        ArrayList<Bottom> bottoms = new ArrayList<>();
        ArrayList<Footwear> footwears = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>();
        model.addAttribute("user", userService.getCurrentUser());
        System.out.println(temp);
//        model.addAttribute("closets", closetRepository.findAllClosetsByUid(uid));
        for(Closet closet: closetRepository.findAllClosetsByUid(uid)){
            for(Top top : closet.getTops()){
                if(top.getCategory().equals(occasion)){
                    tops.add(top);
                }
            }
            for(Bottom bottom : closet.getBottoms()){
                if(bottom.getCategory().equals(occasion)){
                    bottoms.add(bottom);
                }
            }
            for(Jacket jacket: closet.getJackets()){
                if(jacket.getCategory().equals(occasion)){
                    jackets.add(jacket);
                }
            }
            for(Footwear footwear: closet.getFootwears()){
                if(footwear.getCategory().equals(occasion)){
                    footwears.add(footwear);
                }
            }
            for(Accessories accessory : closet.getAccessories()){
                if(accessory.getCategory().equals(occasion)){
                    accessories.add(accessory);
                }
            }

            Collections.shuffle(tops);
            Collections.shuffle(bottoms);
            Collections.shuffle(jackets);
            Collections.shuffle(footwears);
            Collections.shuffle(accessories);

            model.addAttribute("top", tops.get(0));
            model.addAttribute("bottom", bottoms.get(0));
            model.addAttribute("jacket", jackets.get(0));
            model.addAttribute("footwear", footwears.get(0));
            model.addAttribute("accessory", accessories.get(0));
        }
        return "suggestedclothes";
    }

    @RequestMapping("/currentweather")
    public String showWeather(Model model){
        model.addAttribute("user", userService.getCurrentUser());
        return "currentWeather";
    }

}
