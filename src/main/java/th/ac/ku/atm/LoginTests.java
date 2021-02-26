package th.ac.ku.atm;

import org.junit.Test;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTests {
    @LocalServerPort
    private Integer port;
    private static WebDriver driver;
    private static WebDriverWait wait;


    @FindBy(id = "inputId")
    private WebElement idField;

    @FindBy(id = "inputPin")
    private WebElement pinField;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        PageFactory.initElements(driver, this);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/login");
        idField = wait.until(webDriver ->
                webDriver.findElement(By.id("inputId")));
        pinField = driver.findElement(By.id("inputPin"));
        submitButton = driver.findElement(By.id("submitButton"));

    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }


    @Test
    void testLoginCorrectIdPin() {
        WebElement idField = wait.until(webDriver ->
                webDriver.findElement(By.id("inputId")));
        WebElement pinField = driver.findElement(By.id("inputPin"));
        WebElement submitButton = driver.findElement(By.id("submitButton"));

        idField.sendKeys("1");
        pinField.sendKeys("99");
        submitButton.click();

        WebElement resultHeader = wait.until(webDriver ->
                webDriver.findElement(By.tagName("h1")));
        assertEquals("Can't find customer", resultHeader.getText());

    }


}
