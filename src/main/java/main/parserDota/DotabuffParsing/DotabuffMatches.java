package main.parserDota.DotabuffParsing;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DotabuffMatches {
    public static List<String> parseDotabuffMatches(String url) {
        List<String> pickHeroes = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wwwze\\IdeaProjects\\Parser\\chromedriver-win64\\chromedriver.exe"); //хром драйвер

        // Настройка Chrome (без GUI — headless, можно убрать если хочешь видеть браузер)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // если хочешь видеть браузер — закомментируй
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");

        // Указываем путь к chromedriver, если не в PATH
        // System.setProperty("webdriver.chrome.driver", "/путь/к/chromedriver");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(url);
            Thread.sleep(3000); // дать странице время прогрузиться (можно заменить на WebDriverWait)

            // Вывод HTML (для отладки)
            System.out.println(driver.getPageSource());

            // Пример: найти div'ы с героями
            List<WebElement> picks = driver.findElements(By.cssSelector("div.pick[data-tippy-content]"));
            for (WebElement pick : picks) {
                String hero = pick.getAttribute("data-tippy-content");
                pickHeroes.add(hero);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка при работе с Selenium");
        } finally {
            driver.quit(); // Обязательно закрываем браузер
        }

        return pickHeroes;
    }
}