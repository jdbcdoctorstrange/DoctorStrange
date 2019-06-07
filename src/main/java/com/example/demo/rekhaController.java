package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

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


        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("top", top);
        model.addAttribute("closets", closetRepository.findAll());
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
                topRepository.save(top);
            }catch (IOException e) {
                e.printStackTrace();
                return "topform";
            }
        }
        System.out.println("Debug 3>>>>>>>>>>>");
        //top.setUid(userService.getCurrentUser().getId());
       // top.getCloset().setUser(userService.getCurrentUser());

        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }

    @GetMapping("/addbottom")
    public String bottomForm(Model model) {

        User user = userService.getCurrentUser();
        Bottom bottom = new Bottom();


        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("bottom", bottom);
        model.addAttribute("closets", closetRepository.findAll());
        model.addAttribute("file", bottom.getImgUrl());
        return "bottomform";
    }

    @PostMapping("/processbottom")
    public String processbottom(@Valid Bottom bottom, BindingResult result, Model model,
                             @RequestParam("file")MultipartFile file) {

        System.out.println("Debug 1>>>>>>>>>>>");
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "bottomform";
        }
        System.out.println("Debug 2>>>>>>>>>>>");
        if(!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                bottom.setImgUrl(uploadResult.get("url").toString());
            }catch (IOException e) {
                e.printStackTrace();
                return "bottomform";
            }
        }
        System.out.println("Debug 3>>>>>>>>>>>");
        //top.setUid(userService.getCurrentUser().getId());
        // top.getCloset().setUser(userService.getCurrentUser());

        bottomRepository.save(bottom);
        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }

    @GetMapping("/addjacket")
    public String jacketForm(Model model) {

        User user = userService.getCurrentUser();
        Jacket jacket = new Jacket();


        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("jacket", jacket);
        model.addAttribute("closets", closetRepository.findAll());
        model.addAttribute("file", jacket.getImgUrl());
        return "jacketform";
    }

    @PostMapping("/processjacket")
    public String processjacket(@Valid Jacket jacket, BindingResult result, Model model,
                                @RequestParam("file")MultipartFile file) {

        System.out.println("Debug 1>>>>>>>>>>>");
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "jacketform";
        }
        System.out.println("Debug 2>>>>>>>>>>>");
        if(!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                jacket.setImgUrl(uploadResult.get("url").toString());
            }catch (IOException e) {
                e.printStackTrace();
                return "jacketform";
            }
        }
        System.out.println("Debug 3>>>>>>>>>>>");
        //top.setUid(userService.getCurrentUser().getId());
        // top.getCloset().setUser(userService.getCurrentUser());

        jacketRepository.save(jacket);
        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/addfootwear")
    public String footwearForm(Model model) {

        User user = userService.getCurrentUser();
        Footwear footwear = new Footwear();


        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("footwear", footwear);
        model.addAttribute("closets", closetRepository.findAll());
        model.addAttribute("file", footwear.getImgUrl());
        return "footwearform";
    }

    @PostMapping("/processfootwear")
    public String processFootwear(@Valid Footwear footwear, BindingResult result, Model model,
                                @RequestParam("file")MultipartFile file) {

        System.out.println("Debug 1>>>>>>>>>>>");
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "footwearform";
        }
        System.out.println("Debug 2>>>>>>>>>>>");
        if(!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                footwear.setImgUrl(uploadResult.get("url").toString());
            }catch (IOException e) {
                e.printStackTrace();
                return "footwearform";
            }
        }
        System.out.println("Debug 3>>>>>>>>>>>");
        //top.setUid(userService.getCurrentUser().getId());
        // top.getCloset().setUser(userService.getCurrentUser());

        footwearRepository.save(footwear);
        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }
    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/addaccessory")
    public String accessoryForm(Model model) {

        User user = userService.getCurrentUser();
        Accessories accessory = new Accessories();


        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        model.addAttribute("accessory", accessory);
        model.addAttribute("closets", closetRepository.findAll());
        model.addAttribute("file", accessory.getImgUrl());
        return "accessoryform";
    }

    @PostMapping("/processaccessory")
    public String processAccessory(@Valid Accessories accessory, BindingResult result, Model model,
                                  @RequestParam("file")MultipartFile file) {

        System.out.println("Debug 1>>>>>>>>>>>");
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "accessoryform";
        }
        System.out.println("Debug 2>>>>>>>>>>>");
        if(!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(),
                        ObjectUtils.asMap("resourcetype", "auto"));
                accessory.setImgUrl(uploadResult.get("url").toString());
            }catch (IOException e) {
                e.printStackTrace();
                return "accessoryform";
            }
        }
        System.out.println("Debug 3>>>>>>>>>>>");
        //top.setUid(userService.getCurrentUser().getId());
        // top.getCloset().setUser(userService.getCurrentUser());

        accessoriesRepository.save(accessory);
        System.out.println("Debug 4>>>>>>>>>>>");
        return "redirect:/";
    }



    @RequestMapping("/detail/{id}")
    public String showCloset(@PathVariable("id") long id, Model model) {
        User user = userService.getCurrentUser();
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );
        closetRepository.findById(id).ifPresent(o -> model.addAttribute("closet", o));
        // model.addAttribute("message", messageRepository.findById(id));
        Optional <Closet> closet = closetRepository.findById(id);
        model.addAttribute("tops", closetRepository.findById(id).get().getTops());
        model.addAttribute("jackets", closetRepository.findById(id).get().getJackets());
        model.addAttribute("bottoms", closetRepository.findById(id).get().getPants());
        model.addAttribute("footwears", closetRepository.findById(id).get().getFootwears());
        model.addAttribute("accessories", closetRepository.findById(id).get().getAccessories());

        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCloset(@PathVariable("id") long id, Model model) {
        User user = userService.getCurrentUser();
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user);
        //model.addAttribute("message", messageRepository.findById(id));
        closetRepository.findById(id).ifPresent(o -> model.addAttribute("closet", o));
        Closet cls = closetRepository.findByIdAndUid(id, userService.getCurrentUser().getId());
        if (cls != null) {
            System.out.println("Found closet\n");
            cls.setUid(userService.getCurrentUser().getId());
            closetRepository.save(cls);
            return "closetform";
        } else {
            return "redirect:/listclosets";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delCloset(@PathVariable("id") long id) {
        User user = userService.getCurrentUser();
        Closet cls = closetRepository.findByIdAndUid(id,userService.getCurrentUser().getId());
        if(cls != null || (roleRepository.findByRoleAndUsersId("ADMIN", user.getId()) != null)) {
            closetRepository.deleteById(id);
            System.out.println("Found closet\n");
        }
        return "redirect:/";
    }

    @GetMapping("/addpackinglist")
    public String packingForm(Model model) {
        User user = userService.getCurrentUser();
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", user );




        // model.addAttribute("message", messageRepository.findById(id));
//        model.addAttribute("tops", pcloset.getTops());
//        model.addAttribute("jackets", pcloset.getJackets());
//        model.addAttribute("bottoms", pcloset.getPants());
//        model.addAttribute("footwears", pcloset.getFootwears());
//        model.addAttribute("accessories", pcloset.getAccessories());
        Closet closet = closetRepository.findByUidAndClosetName(user.getId(), "Packing closet");

        if(closet == null) {
            model.addAttribute("pcloset", new Closet());
        } else {
            System.out.println("Closet found id"+closet.getId()+closet.getClosetName());
            model.addAttribute("pcloset", closet);
        }

        model.addAttribute("closets", closetRepository.findAllClosetsByUid(user.getId()));

        return "packinglist";
    }

    @PostMapping("/processpackinglist")
    public String processPacking(@Valid @RequestParam("selectedcloset") Closet closet,
                                 @ModelAttribute("pcloset") Closet pcloset,
                                 Model model) {
        User user = userService.getCurrentUser();
        //top.setUid(userService.getCurrentUser().getId());
        // top.getCloset().setUser(userService.getCurrentUser());

        //Loop through all tops and check if selected
        System.out.println("The selected closet id "+closet.getId());
        pcloset.setClosetName("Packing closet");
        pcloset.setUid(user.getId());
        pcloset.setUser(user);
        user.setCloset(pcloset);
        userRepository.save(user);
       // closetRepository.save(pcloset);
        System.out.println("Debug 4>>>>>>>>>>>");
        model.addAttribute("user", user);
        model.addAttribute("pcloset", pcloset);
        model.addAttribute("selectedcloset", closet);
        return "packingitem";
    }

    @PostMapping("/processpackingitem")
    public String processPackingItem(@Valid Closet pcloset, Model model) {
        User user = userService.getCurrentUser();
//        pcloset.set
        //closetRepository.save(pcloset);
        //userRepository.save(user);
        // closetRepository.save(pcloset);
        System.out.println("Debug 4>>>>>>>>>>>");
        model.addAttribute("user", user);
        model.addAttribute("pcloset", pcloset);
      //  model.addAttribute("selectedcloset", closet);
        return "redirect:/";
    }
}
