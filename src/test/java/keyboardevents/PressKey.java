package keyboardevents;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class PressKey {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos");
        URL url = new URL("http://0.0.0.0:4723/");

        AppiumDriver driver = new AndroidDriver(url, uiAutomator2Options);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //scrolling
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"TextFields\")")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((d) -> {
            System.out.println(((AndroidDriver) driver).isKeyboardShown());
            return ((AndroidDriver) driver).isKeyboardShown();
        });
        System.out.println("is keyboard shown ?" + ((AndroidDriver) driver).isKeyboardShown());

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.S));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.H));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.R));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.E));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.Y));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.N));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.S));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.H));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME)); // this will put the application to backgorund.

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CONTACTS));

        ((AndroidDriver) driver).hideKeyboard();

    }
}
