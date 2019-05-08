package com.company;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static HashMap<Integer, String> draw(HashMap<Integer, String> spaces){


        System.out.println(" " + spaces.get(1) +" | " + spaces.get(2) + " | " + spaces.get(3));
        System.out.println("-----------");
        System.out.println(" " + spaces.get(4) +" | " + spaces.get(5) + " | " + spaces.get(6));
        System.out.println("-----------");
        System.out.println(" " + spaces.get(7) +" | " + spaces.get(8) + " | " + spaces.get(9));

        return spaces;
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

        opponent(spaces);
        return spaces;

    }


    public static HashMap<Integer, String> opponent(HashMap<Integer, String> spaces) {
        Random random = new Random();

        ArrayList<Integer> open = new ArrayList<>();

        for (HashMap.Entry<Integer, String> space : spaces.entrySet()) {
            if (!space.getValue().equalsIgnoreCase("x") || !space.getValue().equalsIgnoreCase("o")) {
                open.add(space.getKey());
            }
        }


        if (spaces.containsValue("5")) {
            spaces.replace(5, "5", "O");
        } else if (spaces.containsValue("1")) {
            spaces.replace(1, "1", "O");
        } else if (spaces.containsValue("3")) {
            spaces.replace(3, "3", "O");
        } else if (spaces.containsValue("7")) {
            spaces.replace(7, "7", "O");
        } else if (spaces.containsValue("9")) {
            spaces.replace(9, "9", "O");
        } else if (spaces.containsValue("2")) {
            spaces.replace(2, "2", "O");
        } else if (spaces.containsValue("4")) {
            spaces.replace(4, "4", "O");
        } else if (spaces.containsValue("6")) {
            spaces.replace(6, "6", "O");
        } else if (spaces.containsValue("8")) {
            spaces.replace(8, "8", "O");
        }


        return spaces;
    }

    public static HashMap<Integer, String> opponentBeta(HashMap<Integer, String> spaces) {
        if (spaces.containsValue("5")) {
            spaces.replace(5, "5", "O");
        }

        return spaces;
    }

    public static String gameState(HashMap<Integer, String> spaces) {
        String win = "ongoing";

        //horizontal wins
        if (spaces.get(1).equalsIgnoreCase("x") && spaces.get(2).equalsIgnoreCase("x") && spaces.get(3).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(1).equalsIgnoreCase("o") && spaces.get(2).equalsIgnoreCase("o") && spaces.get(3).equalsIgnoreCase("o")) {
            win = "o";
        }
        if (spaces.get(4).equalsIgnoreCase("x") && spaces.get(5).equalsIgnoreCase("x") && spaces.get(6).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(4).equalsIgnoreCase("o") && spaces.get(5).equalsIgnoreCase("o") && spaces.get(6).equalsIgnoreCase("o")) {
            win = "o";
        }
        if (spaces.get(7).equalsIgnoreCase("x") && spaces.get(8).equalsIgnoreCase("x") && spaces.get(9).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(7).equalsIgnoreCase("o") && spaces.get(8).equalsIgnoreCase("o") && spaces.get(9).equalsIgnoreCase("o")) {
            win = "o";
        }

        //diagonal wins
        if (spaces.get(1).equalsIgnoreCase("x") && spaces.get(5).equalsIgnoreCase("x") && spaces.get(9).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(1).equalsIgnoreCase("o") && spaces.get(5).equalsIgnoreCase("o") && spaces.get(9).equalsIgnoreCase("o")) {
            win = "o";
        }
        if (spaces.get(7).equalsIgnoreCase("x") && spaces.get(5).equalsIgnoreCase("x") && spaces.get(3).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(7).equalsIgnoreCase("o") && spaces.get(5).equalsIgnoreCase("o") && spaces.get(3).equalsIgnoreCase("o")) {
            win = "o";
        }

        //vertical wins
        if (spaces.get(1).equalsIgnoreCase("x") && spaces.get(4).equalsIgnoreCase("x") && spaces.get(7).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(1).equalsIgnoreCase("o") && spaces.get(4).equalsIgnoreCase("o") && spaces.get(7).equalsIgnoreCase("o")) {
            win = "o";
        }
        if (spaces.get(2).equalsIgnoreCase("x") && spaces.get(5).equalsIgnoreCase("x") && spaces.get(8).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(2).equalsIgnoreCase("o") && spaces.get(5).equalsIgnoreCase("o") && spaces.get(8).equalsIgnoreCase("o")) {
            win = "o";
        }
        if (spaces.get(3).equalsIgnoreCase("x") && spaces.get(6).equalsIgnoreCase("x") && spaces.get(9).equalsIgnoreCase("x")) {
            win = "x";
        } else if (spaces.get(3).equalsIgnoreCase("o") && spaces.get(6).equalsIgnoreCase("o") && spaces.get(9).equalsIgnoreCase("o")) {
            win = "o";
        }



        return win;
    }


    public static void main(String[] args) {




        Scanner scanner = new Scanner(System.in);

        String win;
        String playAgain = "";

        while(!playAgain.equalsIgnoreCase("n")) {
            HashMap<Integer, String> spaces = new HashMap<>();

            spaces.put(1, "1");
            spaces.put(2, "2");
            spaces.put(3, "3");
            spaces.put(4, "4");
            spaces.put(5, "5");
            spaces.put(6, "6");
            spaces.put(7, "7");
            spaces.put(8, "8");
            spaces.put(9, "9");
            win = "ongoing";
            draw(spaces);
            while (win.equalsIgnoreCase("ongoing")) {
                win = gameState(draw(input(spaces)));

                if (win.equalsIgnoreCase("x")) {
                    System.out.println("\nYOU WIN!");
                } else if (win.equalsIgnoreCase("o")) {
                    System.out.println("\nYou lose.");
                }
            }
            System.out.println("Play Again? (y/n)");
            playAgain = scanner.nextLine();
            System.out.println();
        }

    }
}
