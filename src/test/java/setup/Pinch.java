package setup;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class Pinch {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        System.out.println("1");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("appPackage", "com.google.android.apps.maps");
        caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        caps.setCapability("autoGrantPermissions", "true");
        URL url = new URL("http://0.0.0.0:4723/");
        AppiumDriver driver = new AndroidDriver(url, caps);
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("explore_tab_home_bottom_sheet"));

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75
        ));


    }
}
