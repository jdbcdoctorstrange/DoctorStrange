//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    UserService userService;
//    @Autowired
//    ClosetRepository closetRepository;
//    @Autowired
//    TopRepository topRepository;
//
//    @Autowired
//    BottomRepository bottomRepository;
//
//    @Autowired
//    JacketRepository jacketRepository;
//
//    @Autowired
//    FootwearRepository footwearRepository;
//
//    @Autowired
//    AccessoriesRepository accessoriesRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    CloudinaryConfig cloudc;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public void run(String... strings) throws Exception {
//
//        System.out.println("Loading data...");
//
//        roleRepository.save(new Role("USER"));
//        roleRepository.save(new Role("ADMIN"));
//
//        Role userRole = roleRepository.findByRole("USER");
//        Role adminRole = roleRepository.findByRole("ADMIN");
//
//        User user = new User("katy@email.com",passwordEncoder.encode("password"),"Katy","Bobberson",true,"katy");
//        user.setRoles(Arrays.asList(userRole));
//        userRepository.save(user);
//
////        user = new User("admin@adm.com",passwordEncoder.encode("password"),"Admin","User",true,"admin");
////        user.setRoles(Arrays.asList(adminRole));
////        userRepository.save(user);
//
//        Closet bobCloset = new Closet();
//        bobCloset.setClosetName("Katy's Closet");
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
//        Top forShirt = new Top();
//        forShirt.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560175086/formal-ladies-shirts-250x250.png");
//        forShirt.setColor("white");
//        forShirt.setSize("small");
//        forShirt.setMaterial("cotton");
//        forShirt.setCategory("formal");
//        forShirt.setSeason("spring");
//        forShirt.setSleeves("long");
//        forShirt.setType("Botton down");
//        forShirt.setCloset(bobCloset);
//        topRepository.save(forShirt);
//
//        Top redSweater = new Top();
//        redSweater.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560116246/611pcKkQCqL._UX522_.jpg");
//        redSweater.setColor("blue");
//        redSweater.setSize("small");
//        redSweater.setMaterial("linen");
//        redSweater.setCategory("formal");
//        redSweater.setSeason("fall");
//        redSweater.setSleeves("short");
//        redSweater.setType("Botton down");
//        redSweater.setCloset(bobCloset);
//        topRepository.save(redSweater);
//
//        Top sumShirt = new Top();
//        sumShirt.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560118645/1568b9a5bdd1b3b3bb8753f45d4458b3_xlarge.jpg");
//        sumShirt.setColor("orange");
//        sumShirt.setSize("small");
//        sumShirt.setMaterial("cotton");
//        sumShirt.setCategory("informal");
//        sumShirt.setSeason("summer");
//        sumShirt.setSleeves("short");
//        sumShirt.setType("cold shoulder");
//        sumShirt.setCloset(bobCloset);
//        topRepository.save(sumShirt);
//
//
//        Top fShirt = new Top();
//        fShirt.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560119464/c483e26b1e45f5825271e75605331c35.jpg");
//        fShirt.setColor("green");
//        fShirt.setSize("small");
//        fShirt.setMaterial("wool");
//        fShirt.setCategory("formal");
//        fShirt.setSeason("fall");
//        fShirt.setSleeves("long");
//        fShirt.setType("sweater");
//        fShirt.setCloset(bobCloset);
//        topRepository.save(fShirt);
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
//        Bottom bBottom = new Bottom();
//        bBottom.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560119169/81X9cZaOZ-L._UX522_.jpg");
//        bBottom.setColor("blue");
//        bBottom.setSize("small");
//        bBottom.setMaterial("denim");
//        bBottom.setCategory("informal");
//        bBottom.setSeason("summer");
//        bBottom.setType("shorts");
//        bBottom.setCloset(bobCloset);
//        bottomRepository.save(bBottom);
//
//
//        Bottom blackBottom = new Bottom();
//        blackBottom.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560115067/LX94_015_Black_W_StormLineStretchRainPants_Front.jpg");
//        blackBottom.setColor("black");
//        blackBottom.setSize("small");
//        blackBottom.setMaterial("wool");
//        blackBottom.setCategory("formal");
//        blackBottom.setSeason("spring");
//        blackBottom.setType("pants");
//        blackBottom.setCloset(bobCloset);
//        bottomRepository.save(blackBottom);
//
//
//        Bottom fBottom = new Bottom();
//        fBottom.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560119955/women-s-high-waist-maxi-chiffon-pleated-skirt.jpg");
//        fBottom.setColor("brown");
//        fBottom.setSize("small");
//        fBottom.setMaterial("wool");
//        fBottom.setCategory("formal");
//        fBottom.setSeason("fall");
//        fBottom.setType("skirt");
//        fBottom.setCloset(bobCloset);
//        bottomRepository.save(fBottom);
//
//        Bottom forBottom = new Bottom();
//        forBottom.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560175342/Edgy-gaastra-dark-blue-skirt-abele-women-4D2O.jpg");
//        forBottom.setColor("blue");
//        forBottom.setSize("small");
//        forBottom.setMaterial("wool");
//        forBottom.setCategory("formal");
//        forBottom.setSeason("spring");
//        forBottom.setType("skirt");
//        forBottom.setCloset(bobCloset);
//        bottomRepository.save(forBottom);
//
//
//        Jacket sJacket = new Jacket();
//        sJacket.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560118870/zu8968882_main_tm1396037478.jpg");
//        sJacket.setColor("white");
//        sJacket.setSize("small");
//        sJacket.setMaterial("cotton");
//        sJacket.setCategory("informal");
//        sJacket.setSeason("summer");
//        sJacket.setCloset(bobCloset);
//        jacketRepository.save(sJacket);
//
//        Jacket forJacket = new Jacket();
//        forJacket.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560175505/71P12NZ75DL._UX342_.jpg");
//        forJacket.setColor("blue");
//        forJacket.setSize("small");
//        forJacket.setMaterial("cotton");
//        forJacket.setCategory("formal");
//        forJacket.setSeason("spring");
//        forJacket.setCloset(bobCloset);
//        jacketRepository.save(forJacket);
//
//
//
//        Jacket fJacket = new Jacket();
//        fJacket.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560119640/1543837506_917M80A3332_X1700_E01_ZHC.jpg");
//        fJacket.setColor("beige");
//        fJacket.setSize("small");
//        fJacket.setMaterial("cotton");
//        fJacket.setCategory("formal");
//        fJacket.setSeason("fall");
//        fJacket.setCloset(bobCloset);
//        jacketRepository.save(fJacket);
//
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
//
//        Jacket blJacket = new Jacket();
//        blJacket.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560115348/Coats_L0BA210F_4291_674F.jpg");
//        blJacket.setColor("peach");
//        blJacket.setSize("small");
//        blJacket.setMaterial("cashmere");
//        blJacket.setCategory("formal");
//        blJacket.setSeason("winter");
//        blJacket.setCloset(bobCloset);
//        jacketRepository.save(blJacket);
//
//
//        Footwear sFootwear = new Footwear();
//        sFootwear.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560117088/e418ca8a-0972-41b5-afdc-f04767652e06.jpg");
//        sFootwear.setColor("white");
//        sFootwear.setSize("small");
//        sFootwear.setMaterial("leather");
//        sFootwear.setCategory("informal");
//        sFootwear.setSeason("summer");
//        sFootwear.setCloset(bobCloset);
//        footwearRepository.save(sFootwear);
//
//        Footwear forFootwear = new Footwear();
//        forFootwear.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560175743/Nubuck-Leather-High-heeled-Shoes-Pointed-Toe-Thin-Heels-Pointed-Toe-Formal-Women-s-Shoes-Black.jpg");
//        forFootwear.setColor("black");
//        forFootwear.setSize("small");
//        forFootwear.setMaterial("leather");
//        forFootwear.setCategory("formal");
//        forFootwear.setSeason("spring");
//        forFootwear.setCloset(bobCloset);
//        footwearRepository.save(forFootwear);
//
//
//
//
//        Footwear fFootwear = new Footwear();
//        fFootwear.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560120184/04.w710.h473.2x.jpg");
//        fFootwear.setColor("brown");
//        fFootwear.setSize("small");
//        fFootwear.setMaterial("rubber");
//        fFootwear.setCategory("formal");
//        fFootwear.setSeason("fall");
//        fFootwear.setCloset(bobCloset);
//        footwearRepository.save(fFootwear);
//
//
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
//        Footwear blFootwear = new Footwear();
//        blFootwear.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560120514/cole-haan-womens-galina-boot-tall-boots_2XMjj2D.jpg");
//        blFootwear.setColor("black");
//        blFootwear.setSize("small");
//        blFootwear.setMaterial("leather");
//        blFootwear.setCategory("formal");
//        blFootwear.setSeason("winter");
//        blFootwear.setCloset(bobCloset);
//        footwearRepository.save(blFootwear);
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
//
//        Accessories forAccessories = new Accessories();
//        forAccessories.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560175979/61B4B3RBq7L._UX522_.jpg");
//        forAccessories.setColor("blue");
//        forAccessories.setSize("small");
//        forAccessories.setMaterial("silk");
//        forAccessories.setCategory("formal");
//        forAccessories.setSeason("spring");
//        forAccessories.setCloset(bobCloset);
//        accessoriesRepository.save(forAccessories);
//
//
//
//        Accessories bozAccessories = new Accessories();
//        bozAccessories.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560115706/61S_2B6qp9EiL._UL1161_.jpg");
//        bozAccessories.setColor("black");
//        bozAccessories.setSize("medium");
//        bozAccessories.setMaterial("leather");
//        bozAccessories.setCategory("formal");
//        bozAccessories.setSeason("winter");
//        bozAccessories.setCloset(bobCloset);
//        accessoriesRepository.save(bozAccessories);
//
//
//        Accessories sAccessories = new Accessories();
//        sAccessories.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560117218/sunglasses-rose-theater-1_grande.jpg");
//        sAccessories.setColor("rainbow");
//        sAccessories.setSize("small");
//        sAccessories.setMaterial("metal");
//        sAccessories.setCategory("informal");
//        sAccessories.setSeason("summer");
//        sAccessories.setCloset(bobCloset);
//        accessoriesRepository.save(sAccessories);
//
//
//
//        Accessories fAccessories = new Accessories();
//        fAccessories.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1560120359/71vbDyl3VTL._SX466_.jpg");
//        fAccessories.setColor("rainbow");
//        fAccessories.setSize("big");
//        fAccessories.setMaterial("metal");
//        fAccessories.setCategory("formal");
//        fAccessories.setSeason("fall");
//        fAccessories.setCloset(bobCloset);
//        accessoriesRepository.save(fAccessories);
//
//
//
//    }
//}
