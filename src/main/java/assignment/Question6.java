package assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Question6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/login");

        System.out.println(driver.getTitle());
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("user@phptravels.com");

        WebElement psw = driver.findElement(By.xpath("//input[@type='password']"));
        psw.sendKeys("demouser");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("author__meta")));
        WebElement nameElement = driver.findElement(By.className("author__title"));
        String name = nameElement.findElement(By.tagName("strong")).getText();

        System.out.println("Welcome " +name);
    }
}
