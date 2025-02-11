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

public class HolidayPackage {
    static AppiumDriver driver;

    public static void main(String[] args) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "393d1f1a3b25");
        capabilities.setCapability("app", "C:\\Users\\291504\\Downloads\\Mobile APK's\\EaseMyTrip.apk");
        capabilities.setCapability("appPackage", "com.easemytrip.android");
        capabilities.setCapability("appActivity", "com.easemytrip.android.SplashScreenActivity");


        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement doNotAllowBtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
        doNotAllowBtn.click();

        WebElement referAndEarnCard = driver.findElement(By.xpath("//android.widget.TextView[@text='Refer & Earn']/.."));
        WebElement flightsCard = driver.findElement(By.xpath("(//android.widget.TextView[@text='Flights'])[1]//.."));


        int x1 = referAndEarnCard.getLocation().getX();
        int y1 = referAndEarnCard.getLocation().getY();

        int x2 = flightsCard.getSize().getWidth();
        int y2 = flightsCard.getLocation().getY();

        while (true) {
            try {
                WebElement bestHolidayPackage = driver.findElement(By.xpath("//android.widget.TextView[@text='Best Holidays Packages']"));
                if (bestHolidayPackage.isDisplayed()) {
                    break;
                }
            } catch (Exception ignored) {
            }
            scroll(x1, y1, x2, y2);
        }

        WebElement swipeCard = driver.findElement(By.xpath("(//android.widget.TextView[@text='Best Holidays Packages']/following-sibling::android.view.View)[2]/android.view.View"));

        int x3 = swipeCard.getSize().getWidth() + swipeCard.getLocation().getX();
        int y3 = swipeCard.getLocation().getY();

        int x4 = swipeCard.getLocation().getX();
        int y4 = swipeCard.getLocation().getY();


        List<WebElement> placeName = driver.findElements(By.xpath("(//android.widget.TextView[@text=\"Best Holidays Packages\"]/following-sibling::android.view.View)[2]/android.view.View/android.view.View/android.widget.TextView"));
        List<WebElement> otherDetails = driver.findElements(By.xpath("(//android.widget.TextView[@text=\"Best Holidays Packages\"]/following-sibling::android.view.View)[2]/android.view.View/android.widget.TextView"));

        System.out.println("-------------- Details " + (1) + "-------------");
        System.out.println("Place Name: " + placeName.getFirst().getText());
        System.out.println("Price: " + otherDetails.get(0).getText());
        System.out.println("Time Period: " + otherDetails.get(1).getText());

        int k = 0;
        while (k < 4) {

            placeName = driver.findElements(By.xpath("(//android.widget.TextView[@text=\"Best Holidays Packages\"]/following-sibling::android.view.View)[2]/android.view.View/android.view.View/android.widget.TextView"));
            otherDetails = driver.findElements(By.xpath("(//android.widget.TextView[@text=\"Best Holidays Packages\"]/following-sibling::android.view.View)[2]/android.view.View/android.widget.TextView"));

            int i = 3;
            System.out.println("-------------- Details " + (k + 2) + "-------------");
            System.out.println("Place Name: " + placeName.get(1).getText());
            System.out.println("Price: " + otherDetails.get(i++).getText());
            System.out.println("Time Period: " + otherDetails.get(i).getText());

            scroll(x3 + 40, y3, x4, y4);
            k++;

        }

    }


    public static void scroll(int startX, int startY, int endX, int endY) {

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }
}
