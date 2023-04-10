package setup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebView {
    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
                .setChromedriverExecutable(System.getProperty("user.dir")+ File.separator+"browser_exe"+File.separator+"chromedriver.exe");
        URL url = new URL("http://0.0.0.0:4723/");

        AppiumDriver driver = new AndroidDriver(url, uiAutomator2Options);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scrolling
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"WebView\")")).click();

        Set<String> contextHandles = ((AndroidDriver) driver).getContextHandles();
        for (String contextHandle : contextHandles) {
            System.out.println(contextHandle);
        }
        ((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.xpath("//h1[text()='This page is a Selenium sandbox']")).getText());
        System.out.println(driver.findElement(By.id("i am a link")).getText());

    }
}
