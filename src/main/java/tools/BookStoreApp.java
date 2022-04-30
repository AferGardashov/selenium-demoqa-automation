package tools;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreApp extends BaseTest {

    public void bookStore() {
        BaseTest.driver.get("https://demoqa.com/books");
        BaseTest.driver.manage().window().maximize();

        WebElement searchBox = BaseTest.driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("Java");

        WebElement firstBook = BaseTest.driver.findElement(By.xpath("//*[@id='see-book-Learning JavaScript Design Patterns']/a"));
        firstBook.click();

        WebElement description = BaseTest.driver.findElement(By.xpath("//div[@id='description-wrapper']/div[2]/label"));
        System.out.println(description.getText());
    }

    public void login() {
        BaseTest.driver.get("https://demoqa.com/login");
        BaseTest.driver.manage().window().maximize();

        BaseTest.driver.findElement(By.id("newUser")).click();

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/register"));
        new BookStoreApp().register();

        WebElement userName = BaseTest.driver.findElement(By.id("userName"));
        WebElement password = BaseTest.driver.findElement(By.id("password"));
        WebElement login = BaseTest.driver.findElement(By.id("login"));
        userName.sendKeys("name.surname");
        password.sendKeys("Password123.");
        login.click();

    }

    private void register() {
        WebElement firstName = BaseTest.driver.findElement(By.id("firstname"));
        WebElement lastName = BaseTest.driver.findElement(By.id("lastname"));
        WebElement userName = BaseTest.driver.findElement(By.id("userName"));
        WebElement password = BaseTest.driver.findElement(By.id("password"));
        firstName.sendKeys("Name");
        lastName.sendKeys("Surname");
        userName.sendKeys("name.surname");
        password.sendKeys("Password123.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//Waiting for reCaptcha to appear.

        BaseTest.driver.switchTo().frame(BaseTest.driver.findElement(By.xpath("//*[@id='g-recaptcha']/div/div/iframe")));
        //Switch to reCaptcha frame.

        WebElement reCaptchaButton = BaseTest.driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[1]"));
        reCaptchaButton.click();

        WebElement clickedBtn = BaseTest.driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));

        WebDriverWait isClicked = new WebDriverWait(BaseTest.driver, 20);
        isClicked.until(ExpectedConditions.attributeToBe(clickedBtn, "aria-checked", "true"));

        BaseTest.driver.switchTo().parentFrame();
        //Switch to main(parent) frame.

        WebElement registerButton = BaseTest.driver.findElement(By.id("register"));
        registerButton.click();
//Register process does not work, because the site is demo.

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement gotologin = BaseTest.driver.findElement(By.xpath("//*[@id='userForm']/div[7]/div[2]/button"));
        gotologin.click();

    }
}
