package Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        logger=Logger.getLogger("BaseClass");
        PropertyConfigurator.configure("log4j.properties");

        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();

        driver.findElement(By.id("consent_prompt_submit")).click();

    }


    public void tearDown()
    {
        driver.quit();
    }

    public int randomNumber(int totalElements)
    {
        Random random=new Random();
        int randomNumber=random.nextInt(totalElements-1);
        return randomNumber;

    }

}
