package setup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class ClickUsingCoordinates {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("1");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "io.appium.android.apis");

        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        caps.setCapability(MobileCapabilityType.APP, appUrl);

        URL url = new URL("http://0.0.0.0:4723/");

        AppiumDriver driver = new AndroidDriver(url, caps);
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));
        int width = element.getRect().getWidth()/2;
        int height = element.getLocation().getY();

        action_clickOnPosition(driver, width, height);
    }

    public static void action_clickOnPosition(AppiumDriver driver, int pointA_X, int pointA_Y) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger, 1);
        clickPosition.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), pointA_X, pointA_Y)).addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(clickPosition));
    }
}
