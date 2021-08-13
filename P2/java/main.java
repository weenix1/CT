import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Diogo\\Desktop\\Uni\\CT\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestingFunctions testingFunctions = new TestingFunctions(driver);
        Tests tests = new Tests(testingFunctions);
        tests.runAllTests();
    }
}
