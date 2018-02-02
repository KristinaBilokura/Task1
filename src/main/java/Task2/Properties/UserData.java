package Task2.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserData {
    private final static String PATH = "src\\main\\resources\\data.properties";
    private Properties properties = new Properties();
    public UserData() throws FileNotFoundException {
    }
    public String getData(String userdata) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PATH);
        properties.load(fileInputStream);
        switch (userdata) {
            case "url":
                String Url = properties.getProperty("URL");
                return Url;
            case "email":
                String email = properties.getProperty("EMAIL");
                return email;
            case "password":
                String password = properties.getProperty("PASSWORD");
                return password;
        }
        return userdata;
    }
}

