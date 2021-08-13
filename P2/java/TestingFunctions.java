import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

public class TestingFunctions {

    /*
    Driver for testing
     */
    private final WebDriver driver;

    public TestingFunctions(WebDriver driver){
        this.driver = driver;
    }

    public void pressCell(int pos){

        driver.findElement(By.id("cell-" + pos)).findElement(By.className("button")).click();

    }

    public void endGame(){
        driver.findElement(By.id("gameend")).findElement(By.id("close")).findElement(By.className("gwt-Button")).click();
    }

    public boolean cellHasSymbol(int pos){

        try {
            driver.findElement(By.id("cell-" + pos)).findElement(By.className("button")).findElement(By.tagName("img"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void chooseSymbolPlayer1(String symbol){

        Select newSymbol = new Select(driver.findElement(By.id("player1-icon")).findElement(By.className("gwt-ListBox")));
        newSymbol.selectByValue(symbol);

    }

    public void chooseSymbolPlayer2(String symbol){

        Select newSymbol = new Select(driver.findElement(By.id("player2-icon")).findElement(By.className("gwt-ListBox")));
        newSymbol.selectByValue(symbol);

    }

}
