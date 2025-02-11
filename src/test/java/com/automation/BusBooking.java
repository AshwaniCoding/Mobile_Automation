package com.automation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class BusBooking {

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","393d1f1a3b25");
        capabilities.setCapability("app","C:\\Users\\291504\\Downloads\\MobileAutomationAPKs-master\\EaseMyTrip.apk");
        capabilities.setCapability("appPackage","com.easemytrip.android");
        capabilities.setCapability("appActivity","com.easemytrip.android.SplashScreenActivity");

        AppiumDriver driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement doNotAllowBtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
        doNotAllowBtn.click();

        WebElement busTab = driver.findElement(By.xpath("//android.widget.TextView[@text='Bus']"));
        busTab.click();

        WebElement originInput = driver.findElement(By.xpath("//android.widget.TextView[@text='Enter origin']"));
        originInput.click();

        WebElement sourceCity = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Source City']"));
        sourceCity.sendKeys("Satna");

        WebElement firstCity = driver.findElement(By.xpath("(//android.widget.TextView[contains(@resource-id,'search_airport_list_item_name')])[1]"));
        firstCity.click();

        WebElement destinationCity = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Destination City']"));
        destinationCity.sendKeys("Nagpur");

        firstCity.click();

        WebElement travelDate = driver.findElement(By.xpath("//android.widget.TextView[@text='Travel Date']"));
        travelDate.click();

    }

}
