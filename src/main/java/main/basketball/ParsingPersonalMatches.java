package main.basketball;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingPersonalMatches {
    public static List <String> parsingPersonalMatches(String url, int count)
    {
        List <String> general = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36"; // User-Agent
        try {
            // 1. Подключение к сайту и получение HTML
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent) // Установка User-Agent
                    .timeout(5000) // Установка таймаута (5 секунд)
                    .get();
            Elements table = doc.select(".table-item__count");
            if (table == null) {
                System.err.println("Table not found. Check the selector!");
            }

            for (Element td : table) {
                if (count==0) break;
                Elements a = td.select("a");  // В каждом td находим первый элемент <a>
                String matches = a.attr("title");
                String score = a.text().replace("ОТ", "");
//                System.out.println(matches);
//                System.out.println(score);
                general.add(matches);
                general.add(score);
                count--;
            }
            return general;
            }
             catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
