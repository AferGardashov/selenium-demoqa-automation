package tools;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Interaction extends BaseTest {

    public void resizable() {
        driver.get("https://demoqa.com/resizable");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        WebElement resizableBoxWithRestriction = driver.findElement(By.id("resizableBoxWithRestriction"));
        String restrictedBoxSize = resizableBoxWithRestriction.getAttribute("style");
        System.out.println(restrictedBoxSize);

        WebElement dragElementRestricted = driver.findElement(By.cssSelector("div[id='resizableBoxWithRestriction'] span"));
        action.dragAndDropBy(dragElementRestricted, 300, 100).perform();

        restrictedBoxSize = resizableBoxWithRestriction.getAttribute("style");
        System.out.println(restrictedBoxSize);


    }

    public void sortable() {
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

//List
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='demo-tabpane-list']/div/div"));

        for (int i = 1; i < list.size(); i++) {

            WebElement element = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[" + i + "]"));

            WebElement destination1 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[6]"));
            WebElement destination2 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[5]"));
            WebElement destination3 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[4]"));
            WebElement destination4 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[3]"));
            WebElement destination5 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[2]"));
            WebElement destination6 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[1]"));

            action.dragAndDrop(element, destination1).perform();
            action.dragAndDrop(element, destination2).perform();
            action.dragAndDrop(element, destination3).perform();
            action.dragAndDrop(element, destination4).perform();
            action.dragAndDrop(element, destination5).perform();
            action.dragAndDrop(element, destination6).perform();
            break;
        }
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//Grid
        WebElement grid = driver.findElement(By.id("demo-tab-grid"));
        grid.click();
        List<WebElement> listGrid = driver.findElements(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div"));

        for (int i = 1; i <= listGrid.size(); i++) {

            WebElement boxElement = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[" + i + "]"));

            WebElement destination_1 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[9]"));
            WebElement destination_2 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[8]"));
            WebElement destination_3 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[7]"));
            WebElement destination_4 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[6]"));
            WebElement destination_5 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[5]"));
            WebElement destination_6 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[4]"));
            WebElement destination_7 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[3]"));
            WebElement destination_8 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[2]"));
            WebElement destination_9 = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[1]"));

            action.dragAndDrop(boxElement, destination_1).perform();
            action.dragAndDrop(boxElement, destination_2).perform();
            action.dragAndDrop(boxElement, destination_3).perform();
            action.dragAndDrop(boxElement, destination_4).perform();
            action.dragAndDrop(boxElement, destination_5).perform();
            action.dragAndDrop(boxElement, destination_6).perform();
            action.dragAndDrop(boxElement, destination_7).perform();
            action.dragAndDrop(boxElement, destination_8).perform();
            action.dragAndDrop(boxElement, destination_9).perform();
            break;
        }
    }

    public void selectable() {
        driver.get("https://demoqa.com/selectable");
        driver.manage().window().maximize();

        WebElement firstButton = driver.findElement(By.xpath("//*[@id='verticalListContainer']/li[1]"));
        WebElement secondButton = driver.findElement(By.xpath("//*[@id='verticalListContainer']/li[2]"));
        WebElement thirdButton = driver.findElement(By.xpath("//*[@id='verticalListContainer']/li[3]"));
        WebElement fourthButton = driver.findElement(By.xpath("//*[@id='verticalListContainer']/li[4]"));
        firstButton.click();
        secondButton.click();
        thirdButton.click();
        fourthButton.click();

        WebElement gridButton = driver.findElement(By.id("demo-tab-grid"));
        gridButton.click();

        WebElement buttonOne = driver.findElement(By.xpath("//div/div[1]/div[1]/li[1]"));
        WebElement buttonTwo = driver.findElement(By.xpath("//div/div[1]/div[1]/li[2]"));
        WebElement buttonThree = driver.findElement(By.xpath("//div/div[1]/div[1]/li[3]"));
        WebElement buttonFour = driver.findElement(By.xpath("//div/div[1]/div[2]/li[1]"));
        WebElement buttonFive = driver.findElement(By.xpath("//div/div[1]/div[2]/li[2]"));
        WebElement buttonSix = driver.findElement(By.xpath("//div/div[1]/div[2]/li[3]"));
        WebElement buttonSeven = driver.findElement(By.xpath("//div/div[1]/div[3]/li[1]"));
        WebElement buttonEight = driver.findElement(By.xpath("//div/div[1]/div[3]/li[2]"));
        WebElement buttonNine = driver.findElement(By.xpath("//div/div[1]/div[3]/li[3]"));
        buttonOne.click();
        buttonTwo.click();
        buttonThree.click();
        buttonFour.click();
        buttonFive.click();
        buttonSix.click();
        buttonSeven.click();
        buttonEight.click();
        buttonNine.click();

    }

    public void draggable() {
        driver.get("https://demoqa.com/dragabble");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        WebElement dragBox = driver.findElement(By.id("dragBox"));
        action.dragAndDropBy(dragBox, 100, 100).perform();

        driver.findElement(By.id("draggableExample-tab-axisRestriction")).click();

        WebElement xOnlyBox = driver.findElement(By.id("restrictedX"));
        WebElement yOnlyBox = driver.findElement(By.id("restrictedY"));
        action.dragAndDropBy(xOnlyBox, 150, 150).perform();
        action.dragAndDropBy(yOnlyBox, 150, 150).perform();

        driver.findElement(By.id("draggableExample-tab-containerRestriction")).click();

        WebElement dragBoxInBox = driver.findElement(By.cssSelector("div[id='containmentWrapper'] div"));
        action.dragAndDropBy(dragBoxInBox, 50, 50).perform();
        WebElement dragItemInBox = driver.findElement(By.cssSelector("div.draggable span"));
        action.dragAndDropBy(dragItemInBox, 50, 50).perform();

        driver.findElement(By.id("draggableExample-tab-cursorStyle")).click();

        WebElement cursorTopLeft = driver.findElement(By.id("cursorTopLeft"));
        WebElement cursorCenter = driver.findElement(By.id("cursorCenter"));
        WebElement cursorBottom = driver.findElement(By.id("cursorBottom"));
        action.dragAndDropBy(cursorTopLeft, 20, 20).perform();
        action.dragAndDropBy(cursorCenter, 20, 20).perform();
        action.dragAndDropBy(cursorBottom, 20, 20).perform();


    }

    public void droppable() {
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();
        WebElement source = driver.findElement(By.id("dragBox"));
        WebElement target = driver.findElement(By.id("notGreedyDropBox"));

        action.dragAndDrop(source, target).perform();


    }
}
