package com.automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EbayScenario {
    static AppiumDriver driver;

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "393d1f1a3b25");
        capabilities.setCapability("app", "C:\\Users\\291504\\Downloads\\Mobile APK's\\Ebay.apk");

        //to unlock device
//        capabilities.setCapability("unlockType", "pattern");
//        capabilities.setCapability("unlockKey", "");
        //to set the location
//        AndroidDriver driver1 = new AndroidDriver(capabilities);
//        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver1.setLocation(new Location("","",""));


        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement closeBtn = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Close']"));
        closeBtn.click();

        WebElement searchInput = driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,'Search on eBay')]"));
        searchInput.click();

        WebElement searchInputInside = driver.findElement(By.xpath("//android.widget.AutoCompleteTextView[contains(@text,'Search on eBay')]"));
        searchInputInside.sendKeys("Laptop");

        WebElement laptopBtn = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/search_suggestion_text' and @text='laptop']"));
        laptopBtn.click();

        WebElement favTab = driver.findElement(By.id("com.ebay.mobile:id/text_slot_1"));
        favTab.click();

        List<WebElement> laptopNames = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'textview_header_0')]"));
        List<WebElement> laptopCards = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@resource-id,'cell_collection_item')]"));

        int x1 = laptopCards.getFirst().getLocation().getX();
        int y1 = laptopCards.getFirst().getLocation().getY();

        int h1 = laptopCards.getFirst().getSize().getHeight();
        int w1 = laptopCards.getFirst().getSize().getWidth();

        boolean temp = true;
        while (true) {
            for (WebElement laptopName : laptopNames) {
                if (laptopName.getText().contains("HP")) {
                    laptopName.click();
                    temp = false;
                    break;
                }
            }

            if (!temp) {
                break;
            }


//            System.out.println(x1 + (w1 / 2));
//            System.out.println(y1 + h1 * 2);
//            System.out.println(x1 + (w1 / 2));
//            System.out.println(y1);
//
//            System.out.println("before scroll");
            scroll(x1 + (w1 / 2), y1 + h1 * 2, x1 + (w1 / 2), y1);
//            System.out.println("scroll done");

            laptopNames = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'textview_header_0')]"));
//            laptopCards = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@resource-id,'cell_collection_item')]"));

        }

        WebElement productImage = driver.findElement(By.id("com.ebay.mobile:id/imageview_image"));
        productImage.click();

        WebElement fullImage = driver.findElement(By.xpath("(//android.widget.ImageView[contains(@resource-id,'photo_gallery_item')])[1]"));

        int x2 = fullImage.getLocation().getX();
        int y2 = fullImage.getLocation().getY();

        int w2 = fullImage.getSize().getWidth();
        int h2 = fullImage.getSize().getHeight();

        zoom(w2 / 2 + x2, h2 / 2 + y2);

        driver.navigate().back();

        productImage = driver.findElement(By.id("com.ebay.mobile:id/imageview_image"));

        int x3 = productImage.getLocation().getX();
        int y3 = productImage.getLocation().getY();

        int w3 = productImage.getSize().getWidth();
        int h3 = productImage.getSize().getHeight();


        //Scroll till about this item is not available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        while (true) {

            try {
                WebElement aboutThisItemText = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'textview_header_title') and @text='About this item']"));
                if (aboutThisItemText.isDisplayed()) {
                    break;
                }
            } catch (Exception ignored) {
            }

            scroll(x3 + (w3 / 2), y3 + h3, x3 + (w3 / 2), y3);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        List<WebElement> aboutItemKeys = driver.findElements(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'stat_layout')]/android.widget.TextView[contains(@resource-id,'stat_key')]"));
        List<WebElement> aboutItemValues = driver.findElements(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'stat_layout')]//android.widget.TextView[contains(@resource-id,'stat_value') or contains(@resource-id,'stat_timer')]"));

        System.out.println("------------About this item-----------");
        for (int i = 0; i < aboutItemKeys.size(); i++) {
            System.out.print(aboutItemKeys.get(i).getAttribute("content-desc") + ": ");
            System.out.println(aboutItemValues.get(i).getAttribute("content-desc"));
        }

        driver.quit();


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

    public static void zoom(int startX, int startY) {

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");


        // Sequence for the first finger (finger1)
        Sequence sequence1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX - 100, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX - 500, startY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Sequence for the second finger (finger2)
        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX + 100, startY))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX + 500, startY))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform both finger actions
        driver.perform(Arrays.asList(sequence1, sequence2));

    }


}
