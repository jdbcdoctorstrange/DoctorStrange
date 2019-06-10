package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        System.out.println(new File(".").getAbsoluteFile());

//        ScriptEngineManager factory = new ScriptEngineManager();
//        ScriptEngine engine = factory.getEngineByName("JavaScript");
//        try {
//            engine.eval(new FileReader("js/weather.js"));
//            engine.eval("weatherBalloon("+"'beltsville'"+")");
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException fe) {
//            fe.printStackTrace();
//        }
        return "userclosetform";
    }


    @RequestMapping("/process")
    public String processUserForm(@RequestParam("occasion") String occasion, @RequestParam("temperature") String temp,
                                  Model model) {
        long uid = userService.getCurrentUser().getId();
        String season ="";
        ArrayList<Top> tops = new ArrayList<>();
        ArrayList<Jacket> jackets = new ArrayList<>();
        ArrayList<Bottom> bottoms = new ArrayList<>();
        ArrayList<Footwear> footwears = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>();
        model.addAttribute("user", userService.getCurrentUser());

        if (Integer.parseInt(temp) <= 32){
            season = "winter";
        }else if(Integer.parseInt(temp) >= 45 || Integer.parseInt(temp) <= 75){
            //generating a random because these temperatures range in either fall or spring
            Random random = new Random();
            //For 50% chance of true
            boolean fallOrSpring = (random.nextInt(2) == 0) ? true : false;
            if(fallOrSpring){
                season = "fall";
            }else{
                season = "spring";
            }
        }else if(Integer.parseInt(temp) >= 76){
            season = "summer";
        }

        System.out.println(season);//testing output
        season = "spring"; //hard coded for lack of outfits.
        model.addAttribute("closets", closetRepository.findAllClosetsByUid(uid));
        for(Closet closet: closetRepository.findAllClosetsByUid(uid)){
            for(Top top : closet.getTops()){
                if(top.getCategory().equals(occasion) && top.getSeason().equalsIgnoreCase(season)){
                    tops.add(top);
                }
            }
            for(Bottom bottom : closet.getBottoms()){
                if(bottom.getCategory().equals(occasion) && bottom.getSeason().equalsIgnoreCase(season)){
                    bottoms.add(bottom);
                }
            }
            for(Jacket jacket: closet.getJackets()){
                if(jacket.getCategory().equals(occasion) && jacket.getSeason().equalsIgnoreCase(season)){
                    jackets.add(jacket);
                }
            }
            for(Footwear footwear: closet.getFootwears()){
                if(footwear.getCategory().equals(occasion) && footwear.getSeason().equalsIgnoreCase(season)){
                    footwears.add(footwear);
                }
            }
            for(Accessories accessory : closet.getAccessories()){
                if(accessory.getCategory().equals(occasion) && accessory.getSeason().equalsIgnoreCase(season)){
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
