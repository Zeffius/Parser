package org.example;

import main.parserDota.CompareTeamsDotaManual;
import main.parserDota.CompareTeamsDotaURL;
import main.parserDota.CompareTeamsDotaURLOld;

public class Main {

    public static void main(String[] args) {
        int i = 0;
//        ParsingDLTVMatches.parseDLTVMatches();
        if (i==0) {
            CompareTeamsDotaURL.compareTeams(); //по ссылке
        }
        else if (i==1) {
            CompareTeamsDotaManual.compareTeams(); //ручное
        }
        else if (i==2) {
            CompareTeamsDotaURLOld.compareTeams(); //старые игры
        }
        else System.out.println("Нихуя");

//        CompareTeams.compareTeams(); //баскетболл


    }

}