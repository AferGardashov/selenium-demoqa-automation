package tools;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AlertFrameWindow extends BaseTest {

    public void modal() {
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();

        WebElement smallButton = driver.findElement(By.id("showLargeModal"));
        smallButton.click();

        WebElement info = driver.findElement(By.cssSelector("div.modal-body p"));
        String s = info.getText();
        System.out.println(s);

        WebElement closeSmallModal = driver.findElement(By.id("closeLargeModal"));
        closeSmallModal.click();

    }

    public void nestedFrames() {
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();

        driver.switchTo().frame("frame1");
        WebElement text1 = driver.findElement(By.cssSelector("body"));
        String s1 = text1.getText();
        System.out.println(s1);

        driver.switchTo().frame(0);

        WebElement text2 = driver.findElement(By.cssSelector("p"));
        String s2 = text2.getText();

        System.out.println(s2);

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        String s = driver.findElement(By.cssSelector("div[id='framesWrapper']")).getText();
        System.out.println(s);


    }

    public void frames() {
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        driver.switchTo().frame(1);
        WebElement element = driver.findElement(By.id("sampleHeading"));
        String text = element.getText();
        System.out.println(text);

        driver.switchTo().parentFrame();
        WebElement element1 = driver.findElement(By.xpath("//*[@id='framesWrapper']/div"));
        System.out.println(element1.getText());

        driver.switchTo().frame("frame2");
        WebElement element2 = driver.findElement(By.id("sampleHeading"));
        String text2 = element2.getText();
        System.out.println(text2);


    }

    public void alerts() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("test message");
        alert.accept();

    }

    public void windows() {
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        WebElement tabButton = driver.findElement(By.id("windowButton"));
        tabButton.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());

        WebElement text = driver.findElement(By.id("sampleHeading"));
        String s = text.getText();
        System.out.println("Text:" + s);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
