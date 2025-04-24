package main.parserDota.OldCode;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class HtmlUnit {
    public static void main(String[] args) {

        String url = "https://hawk.live/matches/156044";

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true); // Включаем JavaScript
        webClient.getOptions().setCssEnabled(false); // Отключаем CSS для скорости
        webClient.getOptions().setThrowExceptionOnScriptError(false); // Игнорируем ошибки JavaScript
        webClient.waitForBackgroundJavaScript(5000); // Ждем до 5 секунд, пока выполнится JavaScript

        try {
            HtmlPage page = webClient.getPage(url);

            // Находим все элементы <img>
            List<DomElement> imageElements = (List<DomElement>)(List<?>) page.getByXPath("//img");

            System.out.println("Найдено " + imageElements.size() + " изображений:");

            for (DomElement imageElement : imageElements) {
                if (imageElement instanceof HtmlImage) {
                    HtmlImage image = (HtmlImage) imageElement;
                    String src = image.getSrcAttribute();
                    System.out.println("  src: " + src);
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            webClient.close();
        }
    }
}

/*
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jm.task.core.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {
    private static final String TABLE_NAME = "users";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS users(id SERIAL PRIMARY KEY, name VARCHAR(50), lastname VARCHAR(50), age SMALLINT)";
    private static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS users";
    private static final String SAVE_USER_SQL = "INSERT INTO users(name, lastname, age) VALUES(?,?,?)";
    private static final String REMOVE_USER_SQL = "DELETE FROM users WHERE id = ?";
    private static final String TRUNCATE_TABLE_SQL = "TRUNCATE TABLE users";
    private static final String SELECT_USER_SQL = "SELECT id, name, lastName, age FROM users";

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try {
            try (
                Connection connection = Util.getConnection();
                Statement statement = connection.createStatement();
            ) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS users(id SERIAL PRIMARY KEY, name VARCHAR(50), lastname VARCHAR(50), age SMALLINT)");
                System.out.println("Таблица создана");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            try (
                Connection connection = Util.getConnection();
                Statement statement = connection.createStatement();
            ) {
                statement.executeUpdate("DROP TABLE IF EXISTS users");
                System.out.println("Таблица удалена");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            try (
                Connection connection = Util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, lastname, age) VALUES(?,?,?)");
            ) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);
                preparedStatement.executeUpdate();
                System.out.println("User с именем – " + name + " добавлен в базу данных");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            try (
                Connection connection = Util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            ) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                System.out.println("User удален");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> allUser = new ArrayList();

        try {
            try (
                Connection connection = Util.getConnection();
                Statement statement = connection.createStatement();
            ) {
                ResultSet resultSet = statement.executeQuery("SELECT id, name, lastName, age FROM users");

                while(resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setAge(resultSet.getByte("age"));
                    allUser.add(user);
                }
            }

            return allUser;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("TRUNCATE TABLE users");
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось очистить");
        }

    }
}
 */
