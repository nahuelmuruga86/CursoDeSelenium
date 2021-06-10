import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class PrimerTest {

    public WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }


    @Test
    public void primerTest(){
        String url = "www.netflix.com";
        WebDriver driver = getDriver(url);
        driver.manage().window().maximize();

        System.out.println("El titulo de la pagina es " + driver.getTitle());
        System.out.println("la url de la pagina es: "+ driver.getCurrentUrl());

        WebElement elementH1 = driver.findElement(By.tagName("h1"));
        System.out.println("El elemento es :" + elementH1.getText() );
        List<WebElement> listasH1 = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de h1 que hay en la pagina son: " + listasH1.size());
        for (WebElement h1: listasH1){
            System.out.println( "h1 es " + h1.getText());
        }

        System.out.println("******* ********* *********");

        WebElement elementA = driver.findElement(By.tagName("a"));
        System.out.println( "el elemento es: " + elementA.getText());
        List<WebElement> listaA = driver.findElements(By.tagName("a"));
        System.out.println("la cantidad de a son " + listaA.size());
        for(WebElement a: listaA){
            System.out.println("a es " + a.getText());
        }
        driver.close();

    }

    @Test
    public void segudotest(){
        String url = "www.spotify.com";
    WebDriver driver = getDriver(url);
    driver.manage().window().maximize();
    System.out.println(driver.getTitle());
    if (driver.getTitle().equals("Escuchar es todo - Spotify")){
        System.out.println("Test Passed");
    } else {
        System.out.println("No paso el test");
    }


}


}
