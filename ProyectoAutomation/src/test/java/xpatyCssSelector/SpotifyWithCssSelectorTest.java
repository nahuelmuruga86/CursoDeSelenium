package xpatyCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {

    public WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    @Test
    public void spotifyByPlaceHoldertest(){
        String url = "https://www.spotify.com/uy/signup/";
        WebDriver driver = getDriver(url);
        driver.findElement(By.cssSelector("input#email")).sendKeys("nm.test@mail.com");
        driver.findElement(By.cssSelector("input#confirm")).sendKeys("nm.test@mail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input#displayname")).sendKeys("nmtest01");
        driver.findElement(By.cssSelector("input#day")).sendKeys("31");
        WebElement elementoMes = driver.findElement(By.cssSelector("select#month"));
        Select meses = new Select(elementoMes);
        meses.selectByValue("05");
        driver.findElement(By.cssSelector("input#year")).sendKeys("1986");
        driver.findElement(By.cssSelector("label[for='gender_option_female']")).click();
        driver.findElement(By.cssSelector("button")).click();

        driver.close();
    }

}
