package Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.*;

import java.util.List;

public class Recordando_selenium {

    WebDriver driver ;


    public void levantarNavegador(String url){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(url);
    }
    @Test
    public void ejercicio1(){
        levantarNavegador("https://www.facebook.com/");
        List<WebElement> listH112 = driver.findElements(By.tagName("h112"));
        Assert.assertTrue(listH112.isEmpty());
    }
    @Test /*no entiendo lo que hay que hacer*/
    public void ejercicio2(){
        levantarNavegador("https://www.facebook.com/");
        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));
        Assert.assertFalse(!listH1.isEmpty());
    }
    @Test
    public void ejercicio3(){
        levantarNavegador("https://www.booking.com/");
        List<WebElement> listH2 = driver.findElements(By.tagName("h2"));
        boolean linkh2Presente = false;
        /*for (WebElement e: listH2) {
            System.out.println(e.getText());
            }*/

       for (WebElement e: listH2) {
            if (e.getText().equals("Connect with other travelers") || e.getAttribute("href").contains("https")){
                linkh2Presente = true;
            }
        }
        Assert.assertTrue(linkh2Presente);
    }
   // @Test //no puedo usar xpath
    /*public void ejercicio4(){
        levantarNavegador("https://www.booking.com/");
        WebElement botonInicioC;// = new getBtnByText();
        List<WebElement> listBotn = driver.findElement(By.className("bui-button bui-button--secondary js-header-login-link");

        for (WebElement e: listBotn){
            if (e.getText().equals("Sign in")){
                botonInicioC = e;
            }
        }
        botonInicioC.click();
    }*/
    @Test
    //Crear un método estático que reciba el driver y una clase como String,
    // y retorne la lista de WebElement que utilizan esa clase.
    public static List<WebElement> ejercicio5(WebElement d, String c){
      List<WebElement> listClase = d.findElements(By.className(c));
      return listClase;
    }
    @Test
    public void ejercicio6(){
        levantarNavegador("https://www.netflix.com/");
        List<WebElement> listForm = driver.findElements(By.tagName("form"));
        System.out.println("Cantidad de forms: "+ listForm.size());
        for (WebElement e1: listForm){
            List<WebElement> h3 = e1.findElements(By.tagName("h3"));
            for (WebElement e2: h3){
                System.out.println(e2.getText());
            }

        }
    }

    @AfterMethod
    public void cerrar(){
        driver.close();
    }
}
