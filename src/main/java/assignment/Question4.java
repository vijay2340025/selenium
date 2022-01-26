package assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("chrome://downloads/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String js = "return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
        WebElement input = (WebElement) jse.executeScript(js);
        jse.executeScript("arguments[0].setAttribute('value', 'vijay');", input);

        String val = (jse.executeScript("return arguments[0].getAttribute('value');", input)).toString();
        System.out.println(val);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();
    }
}
