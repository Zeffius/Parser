package main.parserDota.DotabuffParsing;

import main.parserDota.Heroes.Heroes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static main.parserDota.CompareTeamsDotaManual.heroesTeamManual1;
import static main.parserDota.CompareTeamsDotaManual.heroesTeamManual2;
import static main.parserDota.CompareTeamsDotaURL.heroesTeamUrl1;
import static main.parserDota.CompareTeamsDotaURL.heroesTeamUrl2;
import static main.parserDota.CompareTeamsDotaURLOld.heroesTeamUrl3;
import static main.parserDota.CompareTeamsDotaURLOld.heroesTeamUrl4;
import static main.parserDota.CompareTeamsDotabuff.heroesTeamUrl5;
import static main.parserDota.CompareTeamsDotabuff.heroesTeamUrl6;

public class ParsingDotabuffTeam1 {

    public static void parsingDotabuff(Map <String, String> heroes1, byte identifier) {
        List<String> heroesTeam1 = new ArrayList<>();
        List<String> heroesTeam2 = new ArrayList<>();
        if (identifier==0) {
            heroesTeam1 = heroesTeamManual1;
            heroesTeam2 = heroesTeamManual2;
        }
        else if (identifier==1)
        {
           heroesTeam1 = heroesTeamUrl1;
           heroesTeam2 = heroesTeamUrl2;
        }
        else if (identifier==2)
        {
            heroesTeam1 = heroesTeamUrl3;
            heroesTeam2 = heroesTeamUrl4;
        }
        else if (identifier==3)
        {
            heroesTeam1 = heroesTeamUrl5;
            heroesTeam2 = heroesTeamUrl6;
        }
      else System.out.println("Хуета в дотатабафф парсинг тим 1");


            double disAdvantage = 0.0;
            double winrate = 0;
            for(String hero : heroesTeam1) {
                String url = heroes1.get(hero);
                String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:127.0) Gecko/20100101 Firefox/127.0"; // User-Agent
                // 1. Подключение к сайту и получение HTML
                try {
                    // 1. Подключение к сайту и получение HTML
                    Document doc = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:127.0) Gecko/20100101 Firefox/127.0")
                            .referrer("https://www.google.com/")
                            .header("Accept-Language", "en-US,en;q=0.9")
                            .header("Accept-Encoding", "gzip, deflate")
                            .header("Connection", "keep-alive")
                            .timeout(10000)
                            .get();

                    // 1. Выбор таблицы
                    Element table = doc.select("table.sortable").first();
                    if (table != null) {
                        // 2. Выбор строк таблицы (исключаем строку заголовка)
                        Elements rows = table.select("tbody > tr");

                        // Список для хранения данных о контр-пиках
                        List<Map<String, String>> counterPicks = new ArrayList<>();

                        // 3. Перебор строк и извлечение данных
                        for (Element row : rows) {
                            Elements cells = row.select("td");

                            Map<String, String> counterPick = new HashMap<>(); // Map для хранения данных о герое

                            for (String hero1 : heroesTeam2) {
                                if (hero1.equals(cells.get(1).text())) { // Нужно как минимум 5 столбцов (Hero, Disadvantage, Win Rate, и другие)
                                    String disadvantage = cells.get(2).text(); // 2 - Disadvantage
                                    String winRate = cells.get(3).text();      // 3 - Win Rate

                                    counterPick.put("hero", hero1);
                                    counterPick.put("disadvantage", disadvantage);
                                    counterPick.put("winRate", winRate);
                                    disAdvantage += Double.parseDouble(cells.get(2).text().replace("%", ""));
                                    winrate += Double.parseDouble(cells.get(3).text().replace("%", ""));

                                    counterPicks.add(counterPick);
                                }
                            }
                        }

                        System.out.println("СТАТА ПО ГЕРОЮ: " + hero);
                        // 4. Вывод результатов
                        for (Map<String, String> counterPick : counterPicks) {
                            System.out.println ("DisAdv: " + counterPick.get("disadvantage") +
                                    ",\t WR: " + counterPick.get("winRate") +
                                    " \tПротив героя: " + counterPick.get("hero"));
                        }
                        System.out.println("_____________________________________________________________");

                    } else {
                        System.out.println("Table not found!");
                    }

                } catch (IOException e) {
                    System.err.println("Error connecting to the website: " + e.getMessage());
                }
            }

            if (disAdvantage>10.0||disAdvantage<10.0) System.out.println("МАТЧ");

            System.out.println("ОБЩАЯ СТАТИСТИКА");
            System.out.println("Предположительный винрейт команды 1 по отношению ко второй: " + winrate/25);
            System.out.println("Disadvantage (положительное - плохо, отрицательное - хорошо): " + disAdvantage);
        }
    }

