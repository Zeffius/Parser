package main.parserdota;

import main.parserdota.dltvmatches.ParsingDLTVMatches;
import main.parserdota.dotabuffParsing.ParsingDotabuffTeam1;
import main.parserdota.dotabuffParsing.ParsingDotabuffTeam2;
import main.parserdota.heroes.Heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareTeamsURLNew implements CompareTeams {
    private final List <String> heroesTeamUrl1 = new ArrayList <> ();
    private final List <String> heroesTeamUrl2 = new ArrayList <> ();
//    public static List <String> heroesTeam = new ArrayList <> ();


    @Override
    public void compareTeamsDotabuff () {

        //сюда ссылку на матч

        String url = "https://ru.dltv.org/matches/421568/lvlup-vs-zero-tenacity-cis-battle";



        int columnWidth = 40;
        Map<String, String> heroes = Heroes.toHeroes();
        List <String> heroesTeam = ParsingDLTVMatches.parseDLTVMatches(url); //через DLTV
        System.out.printf("%-" + columnWidth + "s%s%n", "Команда 1:", "Команда 2:");
        for(int i = 0; i<heroesTeam.size()-5;i++)
        {
            if (heroesTeam.get(i).equals("Outworld Devourer")) heroesTeamUrl1.add("Outworld Destroyer");
            else heroesTeamUrl1.add(heroesTeam.get(i));

            if (heroesTeam.get(i+5).equals("Outworld Devourer")) heroesTeamUrl2.add("Outworld Destroyer");
            else heroesTeamUrl2.add(heroesTeam.get(i+5));
            System.out.printf("%-" + columnWidth + "s%s%n", heroesTeamUrl1.get(i), heroesTeamUrl2.get(i));
        }
        System.out.println("");
        ParsingDotabuffTeam1.parsingDotabuff(heroes, (byte)1);
        System.out.println("________");
        ParsingDotabuffTeam2.parsingDotabuff(heroes, (byte)1);
    }

    @Override
    public void compareTeamsText() {

        //сюда ссылку на матч

        String url = "https://ru.dltv.org/matches/421568/lvlup-vs-zero-tenacity-cis-battle";



        int columnWidth = 40;
        Map<String, String> heroes = Heroes.toHeroes();
        List <String> heroesTeam = ParsingDLTVMatches.parseDLTVMatches(url); //через DLTV
        System.out.printf("%-" + columnWidth + "s%s%n", "Команда 1:", "Команда 2:");
        for(int i = 0; i<heroesTeam.size()-5;i++)
        {
            if (heroesTeam.get(i).equals("Outworld Devourer")) heroesTeamUrl1.add("Outworld Destroyer");
            else heroesTeamUrl1.add(heroesTeam.get(i));

            if (heroesTeam.get(i+5).equals("Outworld Devourer")) heroesTeamUrl2.add("Outworld Destroyer");
            else heroesTeamUrl2.add(heroesTeam.get(i+5));
            System.out.printf("%-" + columnWidth + "s%s%n", heroesTeamUrl1.get(i), heroesTeamUrl2.get(i));
        }
        System.out.println("");
        ParsingDotabuffTeam1.parsingDotabuff(heroes, (byte)1);
        System.out.println("________");
        ParsingDotabuffTeam2.parsingDotabuff(heroes, (byte)1);
    }
}
