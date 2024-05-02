package pages;

import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPage {

    By button_login = By.id("login2");
    By input_username = By.id("loginusername");
    By input_password = By.xpath("//*[@id=\"loginpassword\"]");
    By button_login_new = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By productTitle = By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a");
    By button_logout = By.id("logout2");
    By carousel_next = By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[1]/span[1]");


    public void isOnLoginPage(){
        Utility.driver.get("https://www.demoblaze.com/");
    }
    public void clickButtonLogin(){
        Utility.driver.findElement(button_login).click();
    }
    public void inputUserName(String username){
        Utility.driver.findElement(input_username).sendKeys(username);
    }
    public void inputPassword(String password){
        Utility.driver.findElement(input_password).sendKeys(password);
    }
    public void clickButtonLoginNew(){
        Utility.driver.findElement(button_login_new).click();
    }
    public void isOnHomepage(){
        Utility.driver.findElement(productTitle);
        WebElement productElement = Utility.driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Samsung galaxy s6", productElement.getText());
    }
    public void clickButtonLogout(){
        WebDriverWait wait = new WebDriverWait(Utility.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button_logout));
        Utility.driver.findElement(button_logout).click();

    }

}
