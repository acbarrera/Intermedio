package Clase2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.util.List;

public class airbnbTest {
    WebDriver driver;

    public void levantarNavegador(String url){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",chromeDriverUrl);
        driver = new ChromeDriver();
        driver.get(url);
    }
    @Test
    public void reservaAirbnb() throws InterruptedException{
        levantarNavegador("https://www.airbnb.com/");

        Thread.sleep(2000);
        WebElement lugar = driver.findElement(By.xpath("//*[@placeholder='Where are you going?']"));
        lugar.sendKeys("Budapest");

        Thread.sleep(2000);
        WebElement calen = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']"));
        calen.click();

        Thread.sleep(2000);
        WebElement fechaInicio = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-04-10']"));
        fechaInicio.click();

        Thread.sleep(2000);
        WebElement fechaFin = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-04-25']"));
        fechaFin.click();

        Thread.sleep(2000);
        WebElement guestCant = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']"));
        guestCant.click();

        Thread.sleep(2000);
        WebElement cantAdultos = driver.findElement(By.xpath("//*[@data-testid='stepper-adults-increase-button']"));
        cantAdultos.click();
        cantAdultos.click();

        Thread.sleep(3000);
        WebElement cantNinos = driver.findElement(By.xpath("//*[@data-testid='stepper-children-increase-button']"));
        cantNinos.click();

        Thread.sleep(2000);
        WebElement cantInfante = driver.findElement(By.xpath("//*[@data-testid='stepper-infants-increase-button']"));
        cantInfante.click();

        Thread.sleep(1000);
        WebElement botonBuscar = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']"));
        botonBuscar.click();

        Thread.sleep(3000);
        List<WebElement> verifCantPersonas = driver.findElements(By.xpath("//*[contains(text(),'Mar 10 - 25 · 3 guests')]"));

        Assert.assertTrue(driver.getCurrentUrl().contains("Budapest"));
        Assert.assertNotNull(verifCantPersonas);
    }
  
}
