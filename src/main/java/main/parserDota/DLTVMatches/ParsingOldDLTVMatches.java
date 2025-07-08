package main.parserDota.DLTVMatches;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParsingOldDLTVMatches {
    public static List<String> parseDLTVMatches(String url){
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, как Gecko) Chrome/132.0.0.0 YaBrowser/25.2.0.0 Safari/537.36"; // User-Agent
        List <String> pickHeroes = new ArrayList<>();
        try {
            // 1. Подключение к сайту и получение HTML
            Document doc = Jsoup.connect(url)
                    .userAgent(userAgent) // Установка User-Agent
                    .timeout(15000) // Установка таймаута (15 секунд)
                    .get();
            Elements pickPlayers = doc.select("div.map__finished-v2__pick div.pick");
            for (org.jsoup.nodes.Element pickPlayer : pickPlayers) {
                pickHeroes.add(pickPlayer.attr("data-tippy-content"));
            }
            return pickHeroes;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения к сайту");
            return null;
        }
    }
}