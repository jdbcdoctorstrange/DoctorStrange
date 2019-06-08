package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
/*
// Add user/role data into the database before the application runs
@Component
public class DataLoader implements CommandLineRunner{
    // Instantiate both the user and role repository to invoke constructor methods
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
        Run method will be executed after the application context is
        loaded and right before the Spring Application run method is
        completed.
     */
/*
    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role userRole = roleRepository.findByRole("USER");
        Role adminRole = roleRepository.findByRole("ADMIN");

        User user = new User("bob@bob.com",passwordEncoder.encode("password"),"Bob","Bobberson",true,"bob");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

//        user = new User("admin@adm.com",passwordEncoder.encode("password"),"Admin","User",true,"admin");
//        user.setRoles(Arrays.asList(adminRole));
//        userRepository.save(user);

        Closet bobCloset = new Closet();
        bobCloset.setClosetName("Bob's Closet");
        bobCloset.setUid(user.getId());
        bobCloset.setUser(user);
        closetRepository.save(bobCloset);

        Top whiteShirt = new Top();
        whiteShirt.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559929110/c0a3b76610b1c63ab7e19e57e5d6a309.jpg");
        whiteShirt.setColor("white");
        whiteShirt.setSize("small");
        whiteShirt.setMaterial("cotton");
        whiteShirt.setCategory("informal");
        whiteShirt.setSeason("spring");
        whiteShirt.setSleeves("long");
        whiteShirt.setType("Botton down");
        whiteShirt.setCloset(bobCloset);
        topRepository.save(whiteShirt);



        Bottom blueBottom = new Bottom();
        blueBottom.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559929488/15752506_349_main.jpg");
        blueBottom.setColor("blue");
        blueBottom.setSize("small");
        blueBottom.setMaterial("denim");
        blueBottom.setCategory("informal");
        blueBottom.setSeason("spring");
        blueBottom.setType("pants");
        blueBottom.setCloset(bobCloset);
        bottomRepository.save(blueBottom);

        Jacket blackJacket = new Jacket();
        blackJacket.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559929830/rBVaJFjU0dyAf9vyAAEfjj0Qa_A786.jpg");
        blackJacket.setColor("black");
        blackJacket.setSize("small");
        blackJacket.setMaterial("leather");
        blackJacket.setCategory("informal");
        blackJacket.setSeason("spring");
        blackJacket.setCloset(bobCloset);
        jacketRepository.save(blackJacket);

        Footwear blackFootwear = new Footwear();
        blackFootwear.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559930120/9244051_fpx.jpg");
        blackFootwear.setColor("black");
        blackFootwear.setSize("small");
        blackFootwear.setMaterial("leather");
        blackFootwear.setCategory("informal");
        blackFootwear.setSeason("spring");
        blackFootwear.setCloset(bobCloset);
        footwearRepository.save(blackFootwear);

        Accessories bobAccessories = new Accessories();
        bobAccessories.setImgUrl("https://res.cloudinary.com/drd5k7s5s/image/upload/v1559930371/oMQc_xqN_400x400.png");
        bobAccessories.setColor("red");
        bobAccessories.setSize("small");
        bobAccessories.setMaterial("felt");
        bobAccessories.setCategory("informal");
        bobAccessories.setSeason("spring");
        bobAccessories.setCloset(bobCloset);
        accessoriesRepository.save(bobAccessories);

    }
}
*/