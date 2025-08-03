package org.example;

import main.TestCode;
import main.basketball.CompareTeams;
import main.parserdota.CompareTeamsDotaManual;
import main.parserdota.CompareTeamsDotaURL;
import main.parserdota.CompareTeamsDotaURLOld;
import main.parserdota.oldcode.CompareTeamsDotabuff;
import main.parserdota.dotabuffParsing.DotaduffWriterFiles;
import main.parserdota.textwork.CreateUpdateDeleteFiles;

public class Main {

    public static void main(String[] args) {
        int i = 5;

        switch (i){
            case 0 -> CompareTeamsDotaURL.compareTeamsDotabuff(); //по ссылке
            case 1 -> CompareTeamsDotaManual.compareTeams(); //ручное
            case 2 -> CompareTeamsDotaURLOld.compareTeams(); //старые игры
            case 3 -> CompareTeamsDotabuff.compareTeams(); //обычные игры дота

            case 4 -> CompareTeamsDotaManual.compareTeamsText(); //ручное текст
            case 5 -> CompareTeamsDotaURL.compareTeamsText(); //по ссылке текст


            case 15 -> CreateUpdateDeleteFiles.createfiles();
            case 16 -> DotaduffWriterFiles.writtingfiles();



            case 9 -> CompareTeams.compareTeams(); //баскетболл
            case 10 -> TestCode.test();
            default -> System.out.println("ничего");

            //в будущем можно подумать над Map <Integer, Runnable>
        }



    }

}