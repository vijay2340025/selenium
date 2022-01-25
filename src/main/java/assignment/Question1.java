package assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Question1 {
    public static void main(String[] args) throws InterruptedException {
        // web driver setup
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");

        // search all elements of type input by xpath - relative xpath
        List<WebElement> fields =
                driver.findElements(By.xpath("//input[@type='text']"));

        for(WebElement element : fields) {
            System.out.println("Element Name: "+element.getAttribute("name")+" and Type: "+element.getAttribute("type"));
        }

        // wait for 5 seconds using Duration class
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
    }
}
