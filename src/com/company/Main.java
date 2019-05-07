package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void draw(HashMap<Integer, String> spaces){


        System.out.println(" " + spaces.get(1) +" | " + spaces.get(2) + " | " + spaces.get(3));
        System.out.println("-----------");
        System.out.println(" " + spaces.get(4) +" | " + spaces.get(5) + " | " + spaces.get(6));
        System.out.println("-----------");
        System.out.println(" " + spaces.get(7) +" | " + spaces.get(8) + " | " + spaces.get(9));
    }


    public static HashMap<Integer, String> input(HashMap<Integer, String> spaces) {
        Scanner scanner = new Scanner(System.in);
        boolean free = true;
        String input;

        //prompt for user input space, keep looping if space is already taken
        do {

            System.out.println("Which space do you want claim?");
            System.out.print("Enter number of the space: ");
            input = scanner.nextLine();


            //for each of the spaces on the board
            for (HashMap.Entry<Integer, String> space : spaces.entrySet()) {

                //only look at the space if it equals to input
                if (input.equalsIgnoreCase(space.getKey().toString())) {
                    //if the space already has (X) or (O), request user to choose different space
                    if (space.getValue().equalsIgnoreCase("x") || space.getValue().equalsIgnoreCase("o")) {
                        System.out.println("Space " + space.getKey() + " already taken");
                        //set bool to false to loop back to input another space
                        free = false;
                    } else {
                        //if space doesn't have (X) or (O), then change space value to (X)
                        free = true;
                    }
                }

            }
        } while (!free);



        for (HashMap.Entry<Integer, String> space : spaces.entrySet()) {
            if (input.equalsIgnoreCase(space.getValue())) {
                space.setValue("X");
            }
        }

        return spaces;

    }

    public static void main(String[] args) {

        HashMap<Integer, String> spaces = new HashMap<>();
        spaces.put(1, "X");
        spaces.put(2, "2");
        spaces.put(3, "3");
        spaces.put(4, "4");
        spaces.put(5, "5");
        spaces.put(6, "6");
        spaces.put(7, "7");
        spaces.put(8, "8");
        spaces.put(9, "9");
        draw(spaces);


        draw(input(spaces));


    }
}
