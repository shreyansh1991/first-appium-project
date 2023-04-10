package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingAppPackage {
    public static void main(String[] args) throws MalformedURLException {
        // command to get the app activity and app package.
//        adb shell "dumpsys window | grep -E mCurrentFocus"
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options options=new UiAutomator2Options()
                .setAppPackage("io.appium.android.apis")

                .setAppActivity("io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");
        URL url = new URL("http://0.0.0.0:4723/");

        AppiumDriver driver = new AndroidDriver(url, options);
        System.out.println("!!!!!!!!.....................");


    }
}
