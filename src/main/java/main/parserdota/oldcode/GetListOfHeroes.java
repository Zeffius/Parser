package main.parserdota.oldcode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/*
ЭТОТ КОД ДЛЯ ПОЛУЧЕНИЯ КАКИХ-ТО МАССОВЫХ ДАННЫХ, ЧТОБЫ ОФОРМИТЬ КАКУЮ-ТО БАЗУ ОБЪЕКТОВ
ТУТ СВОЙ main

 */

public class GetListOfHeroes {
    public static void main(String[] args) {
        String url = "https://www.dotabuff.com/heroes";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36"; // User-Agent
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent) // Установка User-Agent
                    .timeout(5000) // Установка таймаута (5 секунд)
                    .get();

            // 1. Выбор таблицы
            Element table = doc.select("table.sortable").first();

            if (table != null) {
                // 2. Выбор строк таблицы (исключаем строку заголовка)
                Elements rows = table.select("tbody > tr");

                // Создаем Map для хранения данных о герое
                Map<String, String> counterPick = new TreeMap<>();
                // 3. Перебор строк и извлечение данных
                for (Element row : rows) {
                    Elements cells = row.select("td");

                    // Проверка, что в строке достаточно ячеек
                    if (cells.size() >= 5) { // Нужно как минимум 5 столбцов (Hero, Disadvantage, Win Rate, и другие)
                        String hero = cells.get(1).text();       // 0 - это картинка, 1 - имя героя
                        String disadvantage = cells.get(2).text(); // 2 - Disadvantage
                        String winRate = cells.get(3).text();      // 3 - Win Rate

                        counterPick.put(hero, "https://www.dotabuff.com/heroes/"+ hero +"/counters");
                    }
                }

                // 4. Вывод результатов
                for (Map.Entry<String, String> entry : counterPick.entrySet()) {
                    System.out.println("static String "+entry.getKey() + " = " + "\"" + entry.getKey() + "\"");
                }
            } else {
                System.out.println("Table not found!");
            }

        } catch (IOException e) {
            System.err.println("Error connecting to the website: " + e.getMessage());
        }
    }
}
