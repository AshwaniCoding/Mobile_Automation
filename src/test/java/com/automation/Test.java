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

public class Test {

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement doNotAllowBtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
        doNotAllowBtn.click();
        WebElement flightsTab = driver.findElement(By.xpath("(//android.widget.TextView[@text='Flights'])[1]"));
        flightsTab.click();

        WebElement searchBtn = driver.findElement(By.xpath("//android.widget.Button[@text='SEARCH']"));
        searchBtn.click();

        List<WebElement> flightCard = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'onewayrecyclerview')]/android.widget.RelativeLayout"));

        int l = 0;
        while (l < 20) {


            List<WebElement> flightNames = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_name')]"));
            List<WebElement> flightPrices = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_rate_discounted')]"));
            List<WebElement> flightTravellingDuration = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'travelling_duration')]"));
            List<WebElement> flightTimings = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_timing')]"));



            int x = flightCard.getFirst().getLocation().getX();
            int y = flightCard.getFirst().getLocation().getY();
            int width = flightCard.getFirst().getSize().getWidth();
            int height = flightCard.getFirst().getSize().getHeight();
            int updatedX = x + (width / 2);

            System.out.println("------------ Flight Details " + (l + 1) + "------------");
            System.out.println("Flight Name: " + flightNames.getFirst().getText());
            System.out.println("Flight Price: " + flightPrices.getFirst().getText());
            System.out.println("Flight Duration: " + flightTravellingDuration.getFirst().getText());
            System.out.print("Departure Time: " + flightTimings.get(0).getText() + " | ");
            System.out.println("Arrival Time: " + flightTimings.get(1).getText());


            scroll(updatedX, y + height + 28, updatedX, y);

            l++;
            flightCard = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'onewayrecyclerview')]/android.widget.RelativeLayout"));
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
