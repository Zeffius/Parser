package main.parserdota.textwork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.parserdota.CompareTeamsDotaManual.heroesTeamManual1;
import static main.parserdota.CompareTeamsDotaManual.heroesTeamManual2;
import static main.parserdota.CompareTeamsDotaURL.heroesTeamUrl1;
import static main.parserdota.CompareTeamsDotaURL.heroesTeamUrl2;
import static main.parserdota.CompareTeamsDotaURLOld.heroesTeamUrl3;
import static main.parserdota.CompareTeamsDotaURLOld.heroesTeamUrl4;

public class TextParsingTeam1 {
    public static void parsingText(byte identifier){

    List<String> heroesTeam1 = new ArrayList<>();
    List<String> heroesTeam2 = new ArrayList<>();
    double disAdvantage = 0.0;
    double winrate = 0;


        if(identifier==0)
    {
        heroesTeam1 = heroesTeamManual1;
        heroesTeam2 = heroesTeamManual2;
    }
        else if(identifier==1)
    {
        heroesTeam1 = heroesTeamUrl1;
        heroesTeam2 = heroesTeamUrl2;
    }
        else if(identifier==2)
    {
        heroesTeam1 = heroesTeamUrl3;
        heroesTeam2 = heroesTeamUrl4;
    }




        for(String hero1 : heroesTeam1) {
            String safeFileName = hero1.replace(" ", "_") + ".txt";
            Path filePath = Paths.get("src/main/java/main/parserdota/textwork/savedheroes", safeFileName);
            List<Map<String, String>> counterPicks = new ArrayList<>();
            try {
                List<String> linesHero1 = Files.readAllLines(filePath);
                for (String hero2 : heroesTeam2) {
                    for (String lines : linesHero1) {
                        if (lines.startsWith(hero2))
                        {
                            Map<String, String> counterPick = new HashMap<>(); // Map для хранения данных о герое
                            String [] parts = lines.split("\\|");
                            if(parts.length == 3) {
                                String disadvantage = parts[1].trim();
                                String winRate = parts[2].trim();
                                counterPick.put("hero", hero2);
                                counterPick.put("disadvantage", disadvantage);
                                counterPick.put("winRate", winRate);
                                disAdvantage += Double.parseDouble(disadvantage.replace("%", ""));
                                winrate += Double.parseDouble(winRate.replace("%", ""));
                                counterPicks.add(counterPick);
                            }
                        }
                    }
                }
                counterPicks.sort((a, b) -> {
                    double d1 = Double.parseDouble(a.get("disadvantage").replace("%", "").trim());
                    double d2 = Double.parseDouble(b.get("disadvantage").replace("%", "").trim());
                    return Double.compare(d2, d1); // убывание
                });
                System.out.println("СТАТА ПО ГЕРОЮ: " + hero1);
                // 4. Вывод результатов
                for (Map<String, String> counterpick : counterPicks) {
                    System.out.println ("DisAdv: " + counterpick.get("disadvantage") +
                            ",\t WR: " + counterpick.get("winRate") +
                            " \tПротив героя: " + counterpick.get("hero"));
                }
                System.out.println("_____________________________________________________________");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("ОБЩАЯ СТАТИСТИКА");
        System.out.println("Предположительный винрейт команды 1 по отношению ко второй: " + winrate/25);
        System.out.println("Disadvantage (положительное - плохо, отрицательное - хорошо): " + disAdvantage);
    }
}
