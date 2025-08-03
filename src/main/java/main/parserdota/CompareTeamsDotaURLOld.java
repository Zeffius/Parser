package main.parserdota;

import main.parserdota.dltvmatches.ParsingOldDLTVMatches;
import main.parserdota.dotabuffParsing.ParsingDotabuffTeam1;
import main.parserdota.dotabuffParsing.ParsingDotabuffTeam2;
import main.parserdota.heroes.Heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareTeamsDotaURLOld {
    public static List<String> heroesTeamUrl3 = new ArrayList<>();
    public static List <String> heroesTeamUrl4 = new ArrayList <> ();
//    public static List <String> heroesTeam = new ArrayList <> ();

    private CompareTeamsDotaURLOld() {
    }


    public static void compareTeams () {

        //сюда ссылку на матч



        String url = "https://ru.dltv.org/matches/421508/tundra-esports-vs-team-tidebound-clavision-masters-2025-snow-ruyi";






        int columnWidth = 40;

        Map<String, String> heroes = Heroes.toHeroes();
        List <String> heroesTeam = ParsingOldDLTVMatches.parseDLTVMatches(url); //через DLTV;
        System.out.printf("%-" + columnWidth + "s%s%n", "Команда 1:", "Команда 2:");
        for(int i = 0; i<5;i++)
        {
            if (heroesTeam.get(i).equals("Outworld Devourer")) heroesTeamUrl3.add("Outworld Destroyer");
            else heroesTeamUrl3.add(heroesTeam.get(i));

            if (heroesTeam.get(i+5).equals("Outworld Devourer")) heroesTeamUrl4.add("Outworld Destroyer");
            else heroesTeamUrl4.add(heroesTeam.get(i+5));
            System.out.printf("%-" + columnWidth + "s%s%n", heroesTeamUrl3.get(i), heroesTeamUrl4.get(i));
        }
        System.out.println("");
        ParsingDotabuffTeam1.parsingDotabuff(heroes, (byte)2);
        System.out.println("________");
        ParsingDotabuffTeam2.parsingDotabuff(heroes, (byte)2);

        if (heroesTeam.size()/10==3|heroesTeam.size()/10==2) {
            heroesTeamUrl3.clear();
            heroesTeamUrl4.clear();
            System.out.println("\n\n\n\n\n КАРТА 3\n");
            for (int i = 10; i < 15; i++) {
                if (heroesTeam.get(i).equals("Outworld Devourer")) heroesTeamUrl3.add("Outworld Destroyer");
                else heroesTeamUrl3.add(heroesTeam.get(i));

                if (heroesTeam.get(i + 5).equals("Outworld Devourer")) heroesTeamUrl4.add("Outworld Destroyer");
                else heroesTeamUrl4.add(heroesTeam.get(i + 5));
            }
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-" + columnWidth + "s%s%n", heroesTeamUrl3.get(j), heroesTeamUrl4.get(j));
            }
            System.out.println("");
            ParsingDotabuffTeam1.parsingDotabuff(heroes, (byte) 2);
            System.out.println("________");
            ParsingDotabuffTeam2.parsingDotabuff(heroes, (byte) 2);
        }


        if (heroesTeam.size()/10==3) {
            heroesTeamUrl3.clear();
            heroesTeamUrl4.clear();
            System.out.println("\n\n\n\n\n КАРТА 3\n");
            for (int i = 20; i < 25; i++) {
                if (heroesTeam.get(i).equals("Outworld Devourer")) heroesTeamUrl3.add("Outworld Destroyer");
                else heroesTeamUrl3.add(heroesTeam.get(i));

                if (heroesTeam.get(i + 5).equals("Outworld Devourer")) heroesTeamUrl4.add("Outworld Destroyer");
                else heroesTeamUrl4.add(heroesTeam.get(i + 5));
            }
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-" + columnWidth + "s%s%n", heroesTeamUrl3.get(j), heroesTeamUrl4.get(j));
            }
            System.out.println("");
            ParsingDotabuffTeam1.parsingDotabuff(heroes, (byte) 2);
            System.out.println("________");
            ParsingDotabuffTeam2.parsingDotabuff(heroes, (byte) 2);
        }
    }
}
