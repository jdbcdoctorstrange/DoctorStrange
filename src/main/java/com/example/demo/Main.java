
package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Closet> closets = new ArrayList<>();
        Closet tripOne = new Closet();
        Closet tripTwo = new Closet();
        Closet tripThree = new Closet();


	    Jacket cottonJacket = new Jacket("Blue", "Cotton", "M");
	    Jacket leatherJacket = new Jacket("Green", "Leather", "XL");
	    Jacket suitJacket = new Jacket("Red", "Cotton", "S");
	    Shirt poloShirt = new Shirt("Red", "Cotton", "M");
	    Shirt tShirt = new Shirt("Sky Blue", "Cotton", "L");
	    Shirt silkShirt = new Shirt("Purple", "Silk", "M");
	    Pants jeans = new Pants("Blue", "Denim","32");
	    Pants leggings = new Pants("Tye Dye", "Spandex", "XS");
	    Pants skirt = new Pants("Pink", "Leather", "XXL");
	    Footwear sneakers = new Footwear("black", "leather", "12");
	    Footwear stilettos = new Footwear("Black", "Leather", "2");
	    Footwear clown = new Footwear("Yellow", "Rubber", "15");

	    tripOne.setJackets(cottonJacket);
	    tripOne.setShirts(poloShirt);
	    tripOne.setPants(skirt);
	    tripOne.setFootwear(clown);


        tripTwo.setJackets(cottonJacket);
        tripTwo.setShirts(silkShirt);
        tripTwo.setPants(jeans);
        tripTwo.setFootwear(clown);


        tripThree.setJackets(cottonJacket);
        tripThree.setShirts(silkShirt);
        tripThree.setPants(jeans);
        tripThree.setFootwear(clown);

        closets.add(tripOne);
        closets.add(tripTwo);
        closets.add(tripThree);

        String quitInput = "n";
        boolean quit = false;
        while(true) {



            if (quitInput.equalsIgnoreCase("n")){
                    System.out.println("Choose your closet: ");
                String closet1 = input.nextLine();
                if (closet1.equalsIgnoreCase("tripOne")) {
                    System.out.println(tripOne.randomOutfit());
                } else if (closet1.equalsIgnoreCase("tripTwo")) {
                    System.out.println(tripTwo.randomOutfit());
                } else if (closet1.equalsIgnoreCase("tripThree")) {
                    System.out.println(tripThree.randomOutfit());
                }
                System.out.println("quit(y/n)");
                quitInput = input.nextLine();
            }
        }
//        for(Closet c: closets){
//            System.out.println(c.randomOutfit());
//        }



//        System.out.println(tripThree.randomOutfit());
//        System.out.println("Jacket "+tripOne.getJacket(0).toString());
//        System.out.println("Shirt "+tripOne.getShirts(0).toString());
    }
}
