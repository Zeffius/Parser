package main.basketball;

import java.text.DecimalFormat;
import java.util.List;

import static main.basketball.Teams.*;

/*
Поставить названия команд
Ссылку на общие матчи
Количество общих матчей
 */

public class CompareTeams {




    public static String team1 = denverNaggets;
    public static String team2 = minessotaTimberwolfs;
    public static String url = "https://www.championat.com/basketball/_nba/tournament/6174/match/1213922/#preview";
    public static int countPersonalMatches = 20;






/*
    public static String team1 = ;
    public static String team2 = ;
    public static String url = "";
    public static int countPersonalMatches = ;

 */

    public static void compareTeams()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Матч команд: " + team1 +" против " +team2 + "\n" + url);
        List <String> tempScore1 = ParsingComand.parsingTeam(team1);
        List <String> tempScore2 =ParsingComand.parsingTeam(team2);
        double averageTeam1 = CalculateStep1.calculate (tempScore1, team1);
        System.out.println("\n____\n");
        double averageTeam2 = CalculateStep1.calculate (tempScore2, team2);
        System.out.println("\n____\n");
        List <String> personalMatches = ParsingPersonalMatches.parsingPersonalMatches //нужно передавать url и количество матчей за последние 3 года
                (url, countPersonalMatches);
        List <Double> averageStep2 = CalculateStep2.calculate(personalMatches, team1, team2);
        System.out.println("Команда 1: " + team1 +"\nКоманда 2: " + team2 +
                             "\nИтоговый счёт: " + "\nШаг 1 для команды 1: " + df.format(averageTeam1)
                            + "\nШаг 1 для команды 2: " + df.format(averageTeam2)
//                            + "\nШаг 2 для обеих команд: " + averageStep2
                            + "\nШаг 2 для команды 1: " + df.format(averageStep2.get(0))
                            + "\nШаг 2 для команды 2: " + df.format(averageStep2.get(1))
                            + "\nИтог = " + df.format((averageTeam1+averageStep2.get(0))/2) + " : " + df.format((averageTeam2+averageStep2.get(1))/2)
                            + "\nТотал общий: " + df.format((((averageTeam1+averageStep2.get(0))/2) + ((averageTeam2+averageStep2.get(1))/2))));
    }
}
