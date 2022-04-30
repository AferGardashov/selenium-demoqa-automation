package tools;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Form extends BaseTest {

    public void fillForm() {

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        setPersonalInfo();
        dateSet();
        setSubject();
        selectHobby();
        uploadPicture();
        stateAndCity();

    }

    private void dateSet() {
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        WebElement yearButton =
                driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
        Select select = new Select(yearButton);
        select.selectByValue("2000");
        WebElement monthButton =
                driver.findElement(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
        select = new Select(monthButton);
        select.selectByIndex(2);
        WebElement dayButton = driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div[4]/div[6]"));
        dayButton.click();
    }

    private void uploadPicture() {
        WebElement picture = driver.findElement(By.id("uploadPicture"));
        String picturePath = "C://Users/user/Downloads/sampleFile.jpeg";
        picture.sendKeys(picturePath);
    }

    private void setSubject(){
        WebElement subjectBox = driver.findElement(By.id("subjectsInput"));
        subjectBox.sendKeys("Com");
        subjectBox.sendKeys(Keys.ENTER);
        subjectBox.sendKeys("Eng");
        subjectBox.sendKeys(Keys.ENTER);

    }
    private void selectHobby() {
        WebElement musicHobby = driver.findElement(By.cssSelector("label.custom-control-label[for='hobbies-checkbox-3']"));
        WebElement musicHobbyy = driver.findElement(By.id("hobbies-checkbox-3"));
        try{
            musicHobby.click();
        }catch (ElementClickInterceptedException ex){
            musicHobbyy.click();
        }
    }

    private void setPersonalInfo(){
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Name");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Surname");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("name123@gmail.com");

        WebElement gender = driver.findElement(By.cssSelector("label.custom-control-label[for='gender-radio-1']"));
        gender.click();

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("My Location");

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("123456789");
    }
    private void stateAndCity(){
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Noi");
        city.sendKeys(Keys.ENTER);

    }

    private void submit(){  //This button sometimes is not available because of ads.
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }
}


