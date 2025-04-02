package basketball;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static basketball.Teams.teams;

public final class ParsingComand {
    public static List <String> parsingTeam(String team) {
        List <String> matches = new ArrayList<>(); //запись всех матчей
        List <String> scores = new ArrayList<>(); //запись всех счетов
        List <String> general = new ArrayList<>(); //запись в порядке: матч - счет - матч - счет
        String url = teams.get(team);
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36"; // User-Agent
        int countOfMatches = 0; // отвечает за количество отслеживаемых последних матчей
        int indexArrays = 0;
        String regex = "(\\d+) : (\\d+)";



        try {
            // 1. Подключение к сайту и получение HTML
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent) // Установка User-Agent
                    .timeout(5000) // Установка таймаута (5 секунд)
                    .get();
            Elements table = doc.select(".stat-results__count");
            if (table == null) {
                System.err.println("Table not found. Check the selector!");
            }

            for (Element td: table) {
                Elements a = td.select("a");  // В каждом td находим первый элемент <a>
                String title = a.attr("title"); // Получаем значение атрибута title
                // Получаем только "Денвер Наггетс - Оклахома-Сити Тандер" (без даты и лиги)
                String[] parts = title.split(", ");  // Разделяем строку по ", "
                String matchTitle = parts[0];//  Берем первую часть
                if (matchTitle.length()>1) { //там есть пустая строка, поэтому проверка на больше 1 элемента
                   matches.add(matchTitle);
                }
//                countOfMatches++;
            }
            Pattern pattern = Pattern.compile(regex);

            Elements scoreSpan = (Elements) table.select("span");
            countOfMatches = 0;
            indexArrays = 1;
            for (Element scoreSp: scoreSpan) {
                String score = scoreSp.text().trim(); // Получаем текст из span и удаляем лишние пробелы
                Matcher matcher = pattern.matcher(score);
                if (score.matches(regex)) {
                    scores.add(score);
                }
//                System.out.println(score);
//                countOfMatches++;
//                scores.set(indexArrays, score);
//                indexArrays+=2;
            }

//            System.out.println(matches.size());
//            System.out.println(scores.size());
            while (countOfMatches<scores.size())
            {
                if (countOfMatches<matches.size()) {
                    general.add(matches.get(countOfMatches));
                }
                if(countOfMatches< scores.size())
                {
                    general.add(scores.get(countOfMatches));
                }
                countOfMatches++;
            }
//            System.out.println(general.size());
            return general;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
