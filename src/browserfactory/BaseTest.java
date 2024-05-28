package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {
    // variable
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        // launch browser
        driver = new ChromeDriver();
        // open url
        driver.get(baseUrl);
        // Maximise the browser window
        driver.manage().window().maximize();

        // We give Implicit wait to driver // error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
