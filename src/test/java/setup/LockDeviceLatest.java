package setup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
 
public class LockDeviceLatest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("unlockType", "pin");
        caps.setCapability("unlockKey", "1111");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        caps.setCapability(MobileCapabilityType.APP, appUrl);
 
        URL url = new URL("http://0.0.0.0:4723/");
 
        AppiumDriver driver = new AndroidDriver(url, caps);
 
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        ((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
        Thread.sleep(10000);
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
 
    }
}