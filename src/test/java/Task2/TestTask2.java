package Task2;
import Task2.Properties.Constants;
import Task2.Properties.UserData;
import Task2.Properties.WebDriverData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;


public class TestTask2 {
    private static WebDriver driver;
    private static UserData userData;
    public static Constants constants;
    @BeforeClass
    public static void open() throws IOException {
        WebDriverData webDriverData = new WebDriverData();
        userData = new UserData();
        System.setProperty(webDriverData.getDriver("driver"),webDriverData.getDriver("path"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void GmailTest() throws InterruptedException, IOException {
        driver.get(userData.getData("url"));
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        MainPage mainPage = new MainPage(driver);
        loginPage.typeLogin(userData.getData("email"));
        loginPage.getPassword();
        loginPage.typePassword(userData.getData("password"));
        mainPage.clickmessage();
        mainPage.typeMessage(constants.ADDRESSE,constants.SUBJECT,constants.MESSAGE);
        mainPage.clicklinkSentMessage();
        Assert.assertNotNull(mainPage.correct(constants.ADDRESSE,driver));
        Thread.sleep(1000);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(mainPage.getcheckboxVisible()));
        mainPage.clickchechbox();
        mainPage.clickDelete();
        try {
            mainPage.correct(constants.ADDRESSE,driver);
            fail("FAIL");
        } catch (Exception ex) {
        }
    }
    @AfterClass
    public static void quit(){
        driver.quit();
    }
}