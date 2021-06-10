import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {


    public WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    @Test
    public void netflixUruguayTest() throws InterruptedException {
        String url = "https://www.netflix.com/uy/";

        //Acceder a Netflix: https://www.netflix.com/uy/ NOTA: como estoy en argentina se redirecciona automaticamente a la url: "https://www.netflix.com/ar/";
        WebDriver driver = getDriver(url);

        List<WebElement> elementosh1 = driver.findElements(By.tagName("h1"));
        List<WebElement> elementosh2 = driver.findElements(By.tagName("h2"));
        WebElement botonIniciarSesion = driver.findElement(By.className("redButton"));
        List<WebElement> botones = driver.findElements(By.tagName("button"));
        List<WebElement> elementosDiv = driver.findElements(By.tagName("div"));
        List<WebElement> elementosLink = driver.findElements(By.tagName("a"));
        String titulo = driver.getTitle();


        //Mostrar los elementos h1 y h2 que hay en el sitio
        for (WebElement eh1: elementosh1){
            System.out.println("elemento h1: " + eh1.getText());
        }
        for (WebElement eh2: elementosh2){
            System.out.println("elemento h2: " + eh2.getText());
        }


        //Refrescar la página
        //driver.navigate().refresh();

        //Mostrar el texto de los botones que se encuentran en la página. Nota: el boton de inicio de sesion es rojo pero no esta como un boton en el DOM
        System.out.println("elemento botones Rojos: " + botonIniciarSesion.getText());
        for (WebElement bot: botones){
            System.out.println("elemento botones Rojos: " + bot.getText());
        }


        //Mostrar la cantidad de elementos div que contiene el sitio
        for (WebElement div: elementosDiv){
            System.out.println("elemento div: " + div.getText());
        }

        //Obtener y mostrar el título de la página
        System.out.println(titulo);

        //Mostrar la cantidad de elementos de tipos link
        for (WebElement link: elementosLink){
            System.out.println("elemento link: " + link.getText());
        }

        driver.close();


    }
}
