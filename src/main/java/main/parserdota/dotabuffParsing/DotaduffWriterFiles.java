package main.parserdota.dotabuffParsing;

import main.parserdota.heroes.Heroes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DotaduffWriterFiles {
    public static void writtingfiles ()
    {   Map <String, String> heroes = Heroes.toHeroes();
//        Map <String, String> heroesS = heroes.entrySet().stream().limit(2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:127.0) Gecko/20100101 Firefox/127.0"; // User-Agent
//        Set<String> setNames = heroes.keySet();
        int count = 0;
        for(Map.Entry <String, String> entryHeroes : heroes.entrySet()) {
            String url = entryHeroes.getValue();
            System.out.println(url);
            String safeFileName = entryHeroes.getKey().replace(" ", "_") + ".txt";
            Path filePath = Paths.get("src/main/java/main/parserdota/textwork/savedheroes", safeFileName);
            if (Files.exists(filePath)) {
                try {
                    Files.write(filePath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
                    String tempHero = entryHeroes.getKey();
                    // Список для хранения данных о контр-пиках
//                    List<Map<String, String>> counterPicks = new ArrayList<>();

                    // 3. Перебор строк и извлечение данных
                    for (Element row : rows) {
                        Elements cells = row.select("td");
                        for (String hero1 : heroes.keySet()) {
                            if (hero1.equals(cells.get(1).text())) {
                                String name = cells.get(1).text();
                                String disadvantage = cells.get(2).text(); // 2 - Disadvantage
                                String winRate = cells.get(3).text();      // 3 - Win Rate
//                                System.out.println(name + " " + disadvantage + " " + winRate);
                                String content = name + " | " + disadvantage + " | " + winRate + System.lineSeparator();
                                try {
                                    if (Files.exists(filePath)) {
                                        Files.writeString(filePath, content, StandardOpenOption.APPEND);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace(); // или лог
                                }

                            }


                            //Пока логика записи пусть будет тут же, а этот код потом можно сделать так, что сюда будет собираться мапа, а в writter-е записываться
//                    Map<String, String> counterPick = new HashMap<>(); // Map для хранения данных о герое

//                    for (String hero1 : heroesTeam2) {
//                        if (hero1.equals(cells.get(1).text())) { // Нужно как минимум 5 столбцов (Hero, Disadvantage, Win Rate, и другие)
//                            String disadvantage = cells.get(2).text(); // 2 - Disadvantage
//                            String winRate = cells.get(3).text();      // 3 - Win Rate
//
//                            counterPick.put("hero", hero1);
//                            counterPick.put("disadvantage", disadvantage);
//                            counterPick.put("winRate", winRate);
//                            disAdvantage += Double.parseDouble(cells.get(2).text().replace("%", ""));
//                            winrate += Double.parseDouble(cells.get(3).text().replace("%", ""));
//
//                            counterPicks.add(counterPick);
                        }
                    }
                    System.out.println("Запись закончена для героя: " + tempHero + " " + ++count);
                }
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
