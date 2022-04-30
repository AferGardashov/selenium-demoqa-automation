package tools;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Widget extends BaseTest {

    public void selectMenu() {
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

//Select Value.
        WebElement withOptGroup = driver.findElement(By.id("withOptGroup"));
        withOptGroup.click();
        WebElement secondOption = driver.findElement(By.id("react-select-2-option-0-1"));
        secondOption.click();

//Select One.
        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();
        WebElement drButton = driver.findElement(By.id("react-select-3-option-0-0"));
        drButton.click();

//Old Select Menu.
        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldSelectMenu);
        select.selectByValue("7");

//Multi select drop down.
        WebElement input = driver.findElement(By.xpath("//*[@id='selectMenuContainer']/div[7]/div/div"));
        input.click();
        WebElement selected = driver.findElement(By.id("react-select-4-option-0"));
        selected.click();

//Standard multi select.
        WebElement cars = driver.findElement(By.id("cars"));
        select = new Select(cars);
        select.selectByVisibleText("Volvo");
        select.selectByVisibleText("Opel");

    }


    public void tooltip() {
        driver.get("https://demoqa.com/tool-tips");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("toolTipButton"))).perform();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));

        WebElement element = driver.findElement(By.className("tooltip-inner"));
        String text = element.getText();
        System.out.println(text);


    }

    public void progressBar() {
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();

        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebElement progressBar = driver.findElement(By.cssSelector("div[role='progressbar']"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "31"));
        startStopButton.click();

    }

    public void slider() {
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();

        WebElement defaultValue = driver.findElement(By.id("sliderValue"));
        String defaultText = defaultValue.getAttribute("value");
        System.out.println("Default value: " + defaultText);

        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 0, 0).perform();

        WebElement currentValue = driver.findElement(By.id("sliderValue"));
        String currentText = currentValue.getAttribute("value");
        System.out.println("Current value: " + currentText);


    }

    public void datePicker() {
        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();

        WebElement dateButton = driver.findElement(By.id("datePickerMonthYearInput"));
        dateButton.click();

        WebElement monthButton = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(monthButton);
        selectMonth.selectByValue("2");

        WebElement yearButton = driver.findElement(By.className("react-datepicker__year-select"));
        selectMonth = new Select(yearButton);
        selectMonth.selectByValue("2000");

        WebElement dayButton =
                driver.findElement(By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[6]"));
        dayButton.click();

    }

    public void autoComplete() {
        driver.get("https://demoqa.com/auto-complete");
        driver.manage().window().maximize();

        WebElement autoCompleteSingleInput = driver.findElement(By.id("autoCompleteSingleInput"));
        autoCompleteSingleInput.sendKeys("R");
        autoCompleteSingleInput.sendKeys(Keys.ENTER);

        WebElement autoCompleteMultipleInput = driver.findElement(By.id("autoCompleteMultipleInput"));

        autoCompleteMultipleInput.sendKeys("R");
        autoCompleteMultipleInput.sendKeys(Keys.ARROW_DOWN);
        autoCompleteMultipleInput.sendKeys(Keys.ARROW_DOWN);
        autoCompleteMultipleInput.sendKeys(Keys.ENTER);

        autoCompleteMultipleInput.sendKeys("W");
        autoCompleteMultipleInput.sendKeys(Keys.ENTER);

    }

    public void accordian() {
        driver.get("https://demoqa.com/accordian");
        driver.manage().window().maximize();

        WebElement firstCard = driver.findElement(By.xpath("//div[@class='card'][1]/div[2]"));
        String className = firstCard.getAttribute("class");
        System.out.println(className);

        driver.findElement(By.id("section1Heading")).click();

        className = firstCard.getAttribute("class");
        System.out.println(className);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        className = firstCard.getAttribute("class");
        System.out.println(className);


    }
}
