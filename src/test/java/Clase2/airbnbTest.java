package Clase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GetProperties;

public class airbnbTest {
    private String url = "https://www.airbnb.com/";

    @Test
    public void primertest(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",chromeDriverUrl);

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        System.out.println(driver.getTitle());
        driver.close();
    }
}
