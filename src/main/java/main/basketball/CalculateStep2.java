package main.basketball;

import java.util.ArrayList;
import java.util.List;

public class CalculateStep2 {
    public static List <Integer> mediana = new ArrayList<>();
    public static List <Double> calculate (List<String> personalMatches, String team1, String team2)
    {
        List <Double> countTeamsLeftRight = new ArrayList<>();
//        double countTeams = 0;
        double countLeft = 0;
        double countRight = 0;
        int count = 0;
        int minTotal = 999;
        int maxTotal = 0;
        int tempAB = 0;
        System.out.println("Шаг 2 (третья строчка в каждом матче сложение и проверка условия на порядок расположения команды - левая или правая)");
        for (int i = 0; i < personalMatches.size(); i+=2) {
            System.out.println(personalMatches.get(i));
            System.out.print(personalMatches.get(i+1));
//            System.out.println();
            String[] parts = personalMatches.get(i).split(" - ");
            String[] score = personalMatches.get(i+1).split(" : ");
            if (parts[0].trim().equals(team1)&&parts[1].equals(team2))
            {
                int a = Integer.parseInt(score[0].trim()); //Счёт левой команды
                int b = Integer.parseInt(score[1].trim()); //Счёт правой команды
                tempAB = a+b;
                
                countLeft = countLeft+a;
                countRight = countRight+b;

                System.out.println(" -> " + tempAB);

                if(minTotal >tempAB) minTotal =tempAB;
                if(maxTotal <tempAB) maxTotal =tempAB;




//                countTeams=countTeams+a+b;
//                System.out.println("1 : "+countTeams);
                count+=2;
            }
            else if(parts[1].trim().equals(team1)&&parts[0].trim().equals(team2))
            {
                int a = Integer.parseInt(score[0].trim()); //Счёт левой команды
                int b = Integer.parseInt(score[1].trim()); //Счёт правой команды
                tempAB = a+b;
                countLeft = countLeft+b;
                countRight = countRight+a;
                System.out.println(" -> " + tempAB);
                if(minTotal >tempAB) minTotal =tempAB;
                if(maxTotal <tempAB) maxTotal =tempAB;
//                countTeams=countTeams+a+b;
//                System.out.println("2 : "+countTeams);
                count+=2;
            }
            else System.out.println("Хуйня какая-то");
        }
        countLeft=countLeft/(count/2);
        countRight=countRight/(count/2);
        System.out.println("Минимальный тотал: " + minTotal);
        System.out.println("Максимальный тотал: " + maxTotal);
        System.out.println(" ");
        countTeamsLeftRight.add(countLeft);
        countTeamsLeftRight.add(countRight);
//        System.out.println(countTeams/count);
//        return countTeams/count;

        return countTeamsLeftRight;
    }
}
