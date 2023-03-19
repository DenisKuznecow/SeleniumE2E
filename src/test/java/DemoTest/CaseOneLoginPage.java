package DemoTest;
import com.saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CaseOneLoginPage {

    private WebDriver driver;
    protected BasePage basePage;

    private final String AUT_URL = "https://www.saucedemo.com/";


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com");

    }

@AfterMethod
    public void SignInPage() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);

    }


    @Test
    public void login() {

        WebElement username = driver.findElement(By.id("//*[@id=\"user-name\"]"));
        WebElement password = driver.findElement(By.id("//*[@id=\\\"password\\\"]\""));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();

    }

@AfterMethod
public void ActualUrl () {
    String actualUrl = "https://www.saucedemo.com/inventory.html";
    String expectedUrl = driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, actualUrl);
}
    @AfterClass
    public void tearDown () {
        driver.quit();
    }
}