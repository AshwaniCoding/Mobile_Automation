package com.automation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FlightDetails {

    static AppiumDriver driver;

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","393d1f1a3b25");
        capabilities.setCapability("app","C:\\Users\\291504\\Downloads\\MobileAutomationAPKs-master\\EaseMyTrip.apk");
        capabilities.setCapability("appPackage","com.easemytrip.android");
        capabilities.setCapability("appActivity","com.easemytrip.android.SplashScreenActivity");


        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement dontAllowBtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
//        System.out.println(dontAllowBtn.isDisplayed());
        dontAllowBtn.click();
//        WebElement maybeLaterBtn = driver.findElement(By.id("com.easemytrip.android:id/btn_update_later"));
//        System.out.println(maybeLaterBtn.isDisplayed());
//        maybeLaterBtn.click();
        WebElement flightsTab = driver.findElement(By.xpath("(//android.widget.TextView[@text='Flights'])[1]"));
//        System.out.println(flightsTab.isDisplayed());
        flightsTab.click();

//        WebElement fromTab = driver.findElement(By.xpath("//android.widget.TextView[@text='FROM']"));
//        fromTab.click();
//
//        WebElement fromCityInput = driver.findElement(By.xpath("//android.widget.TextView[@text='From']/following-sibling::android.widget.AutoCompleteTextView"));
//        fromCityInput.sendKeys("Mumbai");
//
//        WebElement fromFirstCity = driver.findElement(By.xpath("(//android.widget.TextView[contains(@resource-id,'search_airport_list')])[1]"));
//        fromFirstCity.click();
//
//        WebElement toTab = driver.findElement(By.xpath("//android.widget.TextView[@text='TO']"));
//        toTab.click();
//
//        WebElement toCityInput = driver.findElement(By.xpath("//android.widget.TextView[@text='To']/following-sibling::android.widget.AutoCompleteTextView"));
//        toCityInput.sendKeys("Delhi");
//
//        WebElement toFirstCity = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout"));
//        toFirstCity.click();
//
//        WebElement departureDate = driver.findElement(By.xpath("//android.widget.TextView[@text='DEPARTURE DATE']"));
//        departureDate.click();
//
//        WebElement date4Feb = driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,'04 Feb')]"));
//        date4Feb.click();
//
//        WebElement travellersTab = driver.findElement(By.xpath("//android.widget.TextView[@text='TRAVELLERS']"));
//        travellersTab.click();
//
//        WebElement adultsTwo = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'adult_two')]"));
//        adultsTwo.click();
//
//        WebElement childrenTwo = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'child_two')]"));
//        childrenTwo.click();
//
//        WebElement infantOne = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'infant_one')]"));
//        infantOne.click();
//
//        WebElement doneBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Done']"));
//        doneBtn.click();

        WebElement searchBtn = driver.findElement(By.xpath("//android.widget.Button[@text='SEARCH']"));
        searchBtn.click();

//        List<WebElement> flightNames = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_name')]"));
//        List<WebElement> flightPrices = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_rate_discounted')]"));
//        List<WebElement> flightTravellingDuration = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'travelling_duration')]"));
//        List<WebElement> flightTimings = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_timing')]"));

        List<WebElement> flightCard = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'onewayrecyclerview')]/android.widget.RelativeLayout"));
//        List<WebElement> flightCard;

        int l=0;
        while (l<20){

//            flightCard = driver.findElements(By.xpath("//android.widget.RelativeLayout[@resource-id='com.easemytrip.android:id/top_id']"));
//            for(int i=0;i<flightCard.size();i++){

                List<WebElement> flightNames = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_name')]"));
                List<WebElement> flightPrices = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_rate_discounted')]"));
                List<WebElement> flightTravellingDuration = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'travelling_duration')]"));
                List<WebElement> flightTimings = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'flight_timing')]"));

                System.out.println("------------ Flight Details " + (l+1) + "------------");
                System.out.println("Flight Name: " + flightNames.getFirst().getText());
                System.out.println("Flight Price: " + flightPrices.getFirst().getText());
                System.out.println("Flight Duration: " + flightTravellingDuration.getFirst().getText());
                System.out.print("Departure Time: " + flightTimings.get(0).getText() + " | ");
                System.out.println("Arrival Time: " + flightTimings.get(1).getText());

                int x = flightCard.getFirst().getLocation().getX();
                int y = flightCard.getFirst().getLocation().getY();
                int width = flightCard.getFirst().getSize().getWidth();
                int height = flightCard.getFirst().getSize().getHeight();
                int updatedX = x + (width/2);


                scroll(updatedX, y+height+30, updatedX, y);

//            }
            flightCard = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'onewayrecyclerview')]/android.widget.RelativeLayout"));
            l++;
        }

//        int j=0;
//        for (int i = 0; i < 3; i++){
//            System.out.println("------------ Flight Details " + (i+1) + "------------");
//            System.out.println("Flight Name: " + flightNames.get(i).getText());
//            System.out.println("Flight Price: " + flightPrices.get(i).getText());
//            System.out.println("Flight Duration: " + flightTravellingDuration.get(i).getText());
//            System.out.print("Departure Time: " + flightTimings.get(j++).getText() + " | ");
//            System.out.println("Arrival Time: " + flightTimings.get(j++).getText());
//        }

    }

    public static void scroll(int startX, int startY, int endX, int endY){

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }
}
