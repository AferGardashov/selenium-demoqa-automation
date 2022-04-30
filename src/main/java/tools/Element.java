package tools;

import base.BaseTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Element extends BaseTest {

    public void upload() {
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement uploadButton = driver.findElement(By.id("uploadFile"));
        String filePath = "C://Users/user/Downloads/sampleFile.jpeg";
        uploadButton.sendKeys(filePath);

    }

    public void download() {
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String path = "C://Users/user/Downloads"; // path to .jpeg file.
        String fileName = "sampleFile.jpeg";
        boolean isDownload = isDownloaded(path, fileName);
        System.out.println(isDownload);

    }

    private boolean isDownloaded(String path, String fileName) { // written for download() method to check if the file downloaded.
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                files[i].delete();
                return true;
            }
        }
        return false;
    }


    public void broken() {
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//div/img[1] "));
        String url = element.getAttribute("src");
        System.out.println(url);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

    }

    public void dynamicButtons() {
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement txt = driver.findElement(By.xpath("//div/p"));
        String s = txt.getText();
        System.out.println(s);
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));

        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.elementToBeClickable(enableAfter));
        enableAfter.click();

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        String className = colorChange.getAttribute("class");
        System.out.println(className);

        WebDriverWait wait2 = new WebDriverWait(driver, 6);
        wait2.until(ExpectedConditions.attributeToBe(colorChange, "class", "mt-4 text-danger btn btn-primary"));
        className = colorChange.getAttribute("class");
        System.out.println(className);


        WebDriverWait wait3 = new WebDriverWait(driver, 5);
        wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("visibleAfter")));

        WebElement visibleAfter = driver.findElement(By.id("visibleAfter"));
        visibleAfter.click();
        String afterText = visibleAfter.getText();
        System.out.println(afterText);
    }

    public void buttons() {
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(doubleClickBtn).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String s = doubleClickMessage.getText();
        System.out.println(s);

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickBtn).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String rmsg = rightClickMessage.getText();
        System.out.println(rmsg);

//These are the xpath's of two buttons we need.
//div/button[starts-with(text() , 'Click Me')]
//div[last()]/button
        WebElement clickBtn = driver.findElement(By.xpath("//div[last()]/button"));
        clickBtn.click();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));

        String dmsg = dynamicClickMessage.getText();
        System.out.println(dmsg);

    }

    public void radioButton() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
        if (element.isEnabled()) {
            element.click();
        }
        WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
        String s = output.getText();
        System.out.println(s);

    }

    public void checkBox() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(new By.ByCssSelector("input[id='hobbies-checkbox-1']"));
        WebElement element2 = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div[1]/label"));

        try {
            element2.click();
        } catch (ElementClickInterceptedException ex) {
            element.click();
        }

    }

    public void textBox() {
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("Name Surname");

        WebElement email = driver.findElement(new By.ByCssSelector(".mr-sm-2[type='email']"));
        email.click();
        email.sendKeys("name.surname@gmail.com");

        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        currentAdress.click();
        currentAdress.sendKeys("Baku");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("Baku");

        WebElement button = driver.findElement(new By.ByCssSelector("button.btn[type='button']"));
        button.click();

    }


}
