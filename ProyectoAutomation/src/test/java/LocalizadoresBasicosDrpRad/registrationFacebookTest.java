package LocalizadoresBasicosDrpRad;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class registrationFacebookTest {
    public WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        String url = "https://www.facebook.com";
        WebDriver driver = getDriver(url);
        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.id("password_step_input")).sendKeys("123456789");
        Thread.sleep(2000);

        WebElement DiaNacimiento = driver.findElement(By.name("birthday_day"));
        WebElement MesNacimiento = driver.findElement(By.name("birthday_month"));
        WebElement AñoNacimiento = driver.findElement(By.name("birthday_year"));
        WebElement Sexo = driver.findElement(By.name("sex"));

        Select dia = new Select(DiaNacimiento);
        dia.selectByValue("31");

        Select mes = new Select(MesNacimiento);
        mes.selectByValue("5");

        Select año = new Select(AñoNacimiento);
        año.selectByValue("1986");

        Sexo.click();
/*
        Select genero = new Select(Sexo);
        genero.selectByVisibleText("Hombre");
*/

        //driver.findElement(By.name("websubmit"));

    }
}
