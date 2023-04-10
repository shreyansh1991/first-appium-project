package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LockDevice {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
                .setChromedriverExecutable(System.getProperty("user.dir")+ File.separator+"browser_exe"+File.separator+"chromedriver.exe");
        URL url = new URL("http://0.0.0.0:4723/");

        AppiumDriver driver = new AndroidDriver(url, uiAutomator2Options);
//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        ((AndroidDriver) driver).lockDevice();                                              //To lock the device if provided duration then unlocked after that time

        System.out.println(((AndroidDriver) driver).isDeviceLocked());
    Thread.sleep(5000);
        ((AndroidDriver) driver).unlockDevice();                                            //To unlock the device
    }
}
