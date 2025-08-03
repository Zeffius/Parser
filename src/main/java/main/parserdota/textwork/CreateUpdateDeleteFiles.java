package main.parserdota.textwork;

import main.parserdota.heroes.Heroes;

import java.nio.file.*;
import java.util.Map;
import java.util.Set;

public class CreateUpdateDeleteFiles {
    public static void createfiles() {

        Map <String, String> heroes = Heroes.toHeroes();
        Set <String> set = heroes.keySet();

        Path dir = Paths.get("src/main/java/main/parserdota/textwork/savedheroes");
        Path logFile = Paths.get("src/main/java/main/parserdota/textwork/Created_heroes"); //ПУТЬ ПОКА ТАКОЙ, НЕ СОВПАДАЕТ С ГЕРОЯМИ
        try {
            // Создаём директории, если их нет
            Files.createDirectories(dir);

            // Создаём файл в этой директории
            for (String setTemp: set) {
                String safeName = setTemp.replace(" ", "_");
                Path filePath = dir.resolve(safeName + ".txt");

                // создаём пустой файл (если уже был — перезапишем)
                Files.write(filePath, new byte[0], StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

                // добавляем имя файла в лог
                Files.writeString(logFile, filePath.getFileName() + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
            System.out.println("Все файлы созданы и записаны в лог: " + logFile.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatefiles()
    {

    }

    public static void deletefiles()
    {

    }
}
