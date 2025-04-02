package basketball;

import java.util.List;

public class CalculateStep1 {
    public static double calculate (List <String> tempScore, String team)
    {
//        for (String h: tempScore)
//        {
//            System.out.println(h);
//        }
////        System.out.println("\n\n\n____\n\n\n");

        int count = 0;
        int countOfMatches = tempScore.size()/2;
        double plusResult = 0.0;
        double minusResult = 0.0;
        System.out.println("Команда " + team);
        System.out.println("Порядок от последнего матча к более ранним");
        for (int i = tempScore.size()-1; i > 0; i-=2) {
            if (countOfMatches==(tempScore.size()/2)-10) break;
            System.out.print(tempScore.get(i-1));
//            System.out.println();
            String[] parts = tempScore.get(i-1).split(" - ");
            String[] score = tempScore.get(i).split(" : ");

            if (parts[0].trim().equals(team))
            {
                int a = Integer.parseInt(score[0].trim()); //Счёт самой команды
                count+=a;
                if (Integer.parseInt(score[0].trim())>Integer.parseInt(score[1].trim()))
                {
                    plusResult+=1.0;
                    System.out.println(" (Победа) ");
                }
                else if(Integer.parseInt(score[1].trim())>Integer.parseInt(score[0].trim()))
                {
                    plusResult-=1.5;
                    System.out.println(" (Поражение) ");
                }
                else System.out.println("Что-то не то");
            }
            else if(parts[1].trim().equals(team))
            {
                int a = Integer.parseInt(score[1].trim());
                count+=a;
                if (Integer.parseInt(score[1].trim())>Integer.parseInt(score[0].trim()))
                {
                    plusResult+=1.0;
                    System.out.println(" (Победа) ");
                }
                else if(Integer.parseInt(score[0].trim())>Integer.parseInt(score[1].trim()))
                {
                    plusResult-=1.5;
                    System.out.println(" (Поражение) ");
                }
                else System.out.println("Что-то не то");
            }
            else System.out.println("Хуйня какая-то");
            countOfMatches--;

            System.out.print(tempScore.get(i));
            int total = Integer.parseInt(score[0].trim()) + Integer.parseInt(score[1].trim());
            System.out.println(" -> " + total);
        }
        double reverseCountOfMatches = tempScore.size()/2-countOfMatches;
        double plusMinusResult = plusResult+minusResult;
        double itog2 = (double)count/reverseCountOfMatches+3+plusMinusResult;
        System.out.println("Тестовый итог без плюсов и минусов: " + itog2);
        double itog = (double)count/reverseCountOfMatches; //тест
        System.out.println("Общий счёт " + count + " Количество матчей при этом: " + reverseCountOfMatches);
        System.out.println("Расчёт первого этапа для команды: " + team + "\n" + itog);
        return itog;
//        System.out.println(plusMinusResult);


    }
}
