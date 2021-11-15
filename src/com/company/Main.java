package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static String[][] information = new String[10][2];
    public static void main(String[] args) {
        int i = 0;
        while(true) {
            System.out.println("DO YOU  WANT TO BUY OR CHECK A RAFFLE TICKET:");
            String answer = bufferReader();
            if (answer.equalsIgnoreCase("buy")) {
                if(i<10) {
                    System.out.println("What is your name:");
                    information[i][0] = bufferReader();
                    i++;
                }else{
                    System.out.println("The spaces are full");
                }
            }else if(answer.equalsIgnoreCase("check")){
                System.out.println("What is your name?");
                String temp = bufferReader();
                check(temp);

            }
            //System.out.println(Arrays.deepToString(information));
        }

    }

    private static void check(String temp) {
        boolean check = false;
        Random random= new Random();
        int tempNum = 0;
        A:for (int j = 0; j <10; j++) {
            if(information[j][0] == null){
                continue;
            }else if (information[j][0].equalsIgnoreCase(temp)) {
                System.out.println("You are in our list");
                check = true;
                tempNum = j;
                break A;
            }
        }
        if(check == true){
            if(information[tempNum][1] == null){
                int raffleNum = random.nextInt(10)+1;
                information[tempNum][1] = Integer.toString(raffleNum);
                System.out.println("Your number is " + raffleNum);
            }else{
                System.out.println("Your number is " + information[tempNum][1]);
            }
        }else{
            System.out.println("There is no ticket under that name, please buy a ticket");
        }
    }

    private static String bufferReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = " ";
        try {
            answer = reader.readLine();
        }catch(Exception e){
            System.out.println(e);
        }
        return answer;
    }
}
