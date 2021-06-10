import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.channels.WritableByteChannel;
import java.util.List;

public class Ejercicios {

    public WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }


    @Test
    public  void mostrarTituloTest(){
        String url = "https://www.netflix.com";
        WebDriver driver = getDriver(url);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test
    public void bbcMundoTest(){

        String url = "https://www.bbc.com/mundo";
        WebDriver driver = getDriver(url);
        driver.manage().window().maximize();
        List<WebElement> listasH1 = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de H1 es " + listasH1.size());
        for (WebElement h1: listasH1){
            System.out.println( "h1 es " + h1.getText());
        }
        List<WebElement> listH2 = driver.findElements(By.tagName("h2"));
        System.out.println("la cantidad de H2 es: " + listH2.size());
        for (WebElement h2: listH2){
            System.out.println("h2 es " + h2.getText());
        }
        driver.close();
    }

    @Test
    public void bbcmundoLink(){
        String url ="https://www.bbc.com/mundo";
        WebDriver driver = getDriver(url);
        driver.manage().window().maximize();
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("la cantidad de links es: " + listaLinks.size());
        for (WebElement link: listaLinks){
            System.out.println("los links son :" + link.getText());
        }
        driver.close();
    }
    @Test
    public void bbMundoListas(){
        String url ="https://www.bbc.com/mundo";
        WebDriver driver = getDriver(url);
        driver.manage().window().maximize();
        List<WebElement> listaLis = driver.findElements(By.tagName("li"));
        System.out.println("La cantidad de elementos li: " + listaLis.size());
        for (WebElement li:listaLis){
            System.out.println("los elementos li son: "+li.getText());
        }
        driver.close();
    }
    //Ejercicio 6
    @Test
    public void spotifyTitleTest(){
        String url = "https://www.spotify.com";
        WebDriver driver = getDriver(url);
        driver.manage().window().maximize();
        if (driver.getTitle().equals("Escuchar es todo - Spotify") ){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }
    //Ejercicio 7
    @Test
    public void getWindowsSizeTest(){
        String url = "https://www.google.com";
        WebDriver driver = getDriver(url);
        Dimension d = new Dimension(1024, 768);
        System.out.println(driver.manage().window().getSize());
        driver.manage().window().setSize(d);
        System.out.println(driver.manage().window().getSize());

    }

    //Ejercicio 10
    @Test
    public void searchInGoogle() {
        String url = "https://www.google.com";
        WebDriver driver = getDriver(url);
        WebElement buscador = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        buscador.sendKeys("WebElement");
        buscador.submit();
    }

    //Ejercicio 11
    @Test
    public void searchInGoogleAndGoBack(){
        String url = "https://www.google.com";
        WebDriver driver = getDriver(url);
        WebElement buscador = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        buscador.sendKeys("WebElement");
        buscador.submit();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }

    //Ejercicio 12
    @Test
    public void facebookPageTest(){
        String url = "https://www.facebook.com";
        WebDriver driver = getDriver(url);
        List <WebElement> div = driver.findElements(By.tagName("div"));
        System.out.println("cantidad de div es "+  div.size());
        for (WebElement di:div){
            System.out.println("div es" + di.getText());
        }
        List <WebElement> archor = driver.findElements(By.tagName("a"));
        System.out.println("cantidad de archor es "+  archor.size());
        for (WebElement a:archor){
            System.out.println("archor es" + a.getText());
        }
        List <WebElement> button = driver.findElements(By.tagName("button"));
        System.out.println("cantidad de button es "+  button.size());
        for (WebElement b:button){
            System.out.println("archor es" + b.getText());
        }
    }
    //Ejercicio 13
    @Test
    public void sendKeyTofacebook(){
        String url = "https://www.facebook.com";
        WebDriver driver = getDriver(url);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        WebElement iniciarSecionBoton = driver.findElement(By.tagName("button"));
        username.sendKeys("test@test.com");
        password.sendKeys("holamundo");
        iniciarSecionBoton.click();

    }



}

