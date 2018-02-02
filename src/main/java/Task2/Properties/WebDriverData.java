package Task2.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class WebDriverData {
    private final static String PATH = "src\\main\\resources\\driverData.properties";
    private Properties properties = new Properties();
    public WebDriverData() throws FileNotFoundException {}
    public String getDriver(String driver) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PATH);
        properties.load(fileInputStream);
        switch (driver) {
            case "driver":
                String drivername = properties.getProperty("WEBDRIVER");
                return drivername;
            case "path":
                String path = properties.getProperty("PATH");
                return path;
        }
        return driver;
    }
}
