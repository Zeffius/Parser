package main.parserDota.DLTVMatches;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsingDLTVMatches {
    public static List<String> parseDLTVMatches(String url){
//        String url = "https://ru.dltv.org/matches/419890";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, как Gecko) Chrome/132.0.0.0 YaBrowser/25.2.0.0 Safari/537.36"; // User-Agent
//        int count = 0;
        List <String> pickHeroes = new ArrayList<>();
        try {
            // 1. Подключение к сайту и получение HTML
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent) // Установка User-Agent
                    .timeout(15000) // Установка таймаута (10 секунд)
                    .get();
            Elements pickPlayers = doc.select("div.pick.player");
            Elements pickPlayerss = doc.select("div.pick.player");
            for (org.jsoup.nodes.Element pickPlayer : pickPlayers) {

//                String tippyContent = pickPlayer.attr("data-tippy-content");
                pickHeroes.add(pickPlayer.attr("data-tippy-content"));
//                System.out.println(tippyContent);
            }
//            for (String g: pickHeroes)
//            {
//                System.out.println(g);
//            }
//            System.out.println(pickPlayerss);
            if (pickPlayerss.isEmpty()) System.out.println("Нихуя нет героев");
//            System.out.println("_________________");
//            System.out.println(pickHeroes.size());
            return pickHeroes;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения к сайту");
            return null;

        }
    }
}
