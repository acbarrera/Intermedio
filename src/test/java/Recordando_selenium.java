import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.*;

public class Recordando_selenium {

    @Test
    public void primertest(){
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",chromeDriverUrl);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        System.out.println(driver.getTitle());
        driver.close();
    }
}
