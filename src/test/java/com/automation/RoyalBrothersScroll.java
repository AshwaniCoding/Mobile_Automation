package com.automation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class RoyalBrothersScroll {
    static AppiumDriver driver;

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "393d1f1a3b25");
        capabilities.setCapability("app", "C:\\Users\\291504\\Downloads\\Mobile APK's\\RoyalBrothers.apk");


        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement mayBeLaterBtn = driver.findElement(By.xpath("//android.widget.Button[@text='MAYBE LATER']"));
        mayBeLaterBtn.click();

        WebElement mayBeLaterBtn2 = driver.findElement(By.xpath("//android.widget.Button[@text='MAYBE LATER']"));
        mayBeLaterBtn2.click();

        WebElement skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='SKIP']"));
        skipBtn.click();

        WebElement selectCityInput = driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Select city')]"));
        selectCityInput.sendKeys("Trivandrum");

        WebElement firstCity = driver.findElement(By.xpath("//android.widget.ScrollView//android.widget.TextView"));
        firstCity.click();

        WebElement pickUpDate = driver.findElement(By.xpath("(//android.widget.TextView[@text=' Date '])[1]"));
        pickUpDate.click();
        WebElement date30 = driver.findElement(By.xpath("//android.widget.TextView[@text='30']"));
        date30.click();

//        WebElement scrollView = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup"));
//
//        int x1 = scrollView.getLocation().getX();
//        int y1 = scrollView.getLocation().getY();
//
//        int h1 = scrollView.getSize().getWidth();
//        int w1 = scrollView.getSize().getHeight();
//
//        while (true) {
//            try {
//                WebElement pickUpTime = driver.findElement(By.xpath("//android.widget.TextView[@text='03:00 PM']"));
//                if (pickUpTime.isDisplayed()) {
//                    break;
//                }
//            } catch (Exception ignored) {
//            }
//            scroll(x1 + (w1 / 2), y1 + h1 - 50, x1 + (w1 / 2), y1);
//        }


//        WebElement pickUpTime = driver.findElement(By.xpath("//android.widget.TextView[@text='03:00 PM']"));
//        pickUpTime.click();

//        WebElement dropOffDate = driver.findElement(By.xpath("(//android.widget.TextView[@text=' Date '])[2]"));

        WebElement time6Am = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='06:00 AM']"));
        time6Am.click();
        WebElement date31 = driver.findElement(By.xpath("//android.widget.TextView[@text='31']"));
        date31.click();
        time6Am = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='06:00 AM']"));
        time6Am.click();


//        scrollView = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup"));
//
//        int x2 = scrollView.getLocation().getX();
//        int y2 = scrollView.getLocation().getY();
//
//        int h2 = scrollView.getSize().getWidth();
//        int w2 = scrollView.getSize().getHeight();
//
//        while (true) {
//            try {
//                pickUpTime = driver.findElement(By.xpath("//android.widget.TextView[@text='03:00 PM']"));
//                if (pickUpTime.isDisplayed()) {
//                    break;
//                }
//            } catch (Exception ignored) {
//            }
//            scroll(x2 + (w2 / 2), y2 + h2 - 50, x2 + (w2 / 2), y2);
//        }

        WebElement searchBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='SEARCH']"));
        searchBtn.click();

        List<WebElement> card = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'BOOK NOW')]/.."));


        //First Scroll
        int x4 = card.getFirst().getLocation().getX();
        int y4 = card.getFirst().getLocation().getY();

        int h4 = card.getFirst().getSize().getHeight();
        int w4 = card.getFirst().getSize().getWidth();

        List<WebElement> vehicleNameAndLimit = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'BOOK NOW')]/../android.widget.TextView"));
        List<WebElement> vehiclePrice = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'BOOK NOW')]"));

        int length = vehicleNameAndLimit.size();

        System.out.println("------------ Details " + (1) + "-------------");
        System.out.println("Vehicle Name: " + vehicleNameAndLimit.get(length-3).getText());
        System.out.println("Vehicle Limit: " + vehicleNameAndLimit.get(length-1).getText());
        System.out.println("Vehicle Price: " + vehiclePrice.getLast().getAttribute("content-desc"));

        scroll(x4+w4/2,y4+(h4-100),x4+w4/2,y4-100);

        //For Rest Scrolls
        card = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'BOOK NOW')]/.."));
        int size = card.size()-1;
        int x5 = card.get(size).getLocation().getX();
        int y5 = card.get(size).getLocation().getY();

        int h5 = card.get(size).getSize().getHeight();
        int w5 = card.get(size).getSize().getWidth();


        int k=2;
//        String previous="", current;
        while (true) {

//            try {
//                List<WebElement> soldOut = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'SOLD OUT')]"));
//                if (soldOut.getFirst().isDisplayed()) {
//                    break;
//                }
//            } catch (Exception ignored) {
//            }

            vehiclePrice = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'BOOK NOW')]"));
            vehicleNameAndLimit = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,'BOOK NOW')]/../android.widget.TextView"));
            length = vehicleNameAndLimit.size();

            if(vehiclePrice.isEmpty() && length < 2 ){
                break;
            }


            System.out.println("------------ Details " + (k++) + "-------------");
            System.out.println("Vehicle Name: " + vehicleNameAndLimit.get(length-3).getText());
            System.out.println("Vehicle Limit: " + vehicleNameAndLimit.get(length-1).getText());
            System.out.println("Vehicle Price: " + vehiclePrice.getLast().getAttribute("content-desc"));

//            current = vehiclePrice.getLast().getText().contains("SOLD OUT");

            scroll(x5 + (w5/2), y5 + h5, x5 + (w5/2), y5+12);
//            previous = current;

        }


    }

    public static void scroll(int startX, int startY, int endX, int endY) {

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(2500), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }
}
