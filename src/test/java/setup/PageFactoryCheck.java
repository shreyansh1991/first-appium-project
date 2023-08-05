package setup;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class PageFactoryCheck {


    @AndroidFindBy(accessibility = "Views")
    private WebElement element;
    public static void main(String[] args) throws MalformedURLException {
        new PageFactoryCheck().check();
    }

    public void check() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andriod");

        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        caps.setCapability(MobileCapabilityType.APP, appUrl);

        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        AppiumDriver driver = new AndroidDriver(url, caps);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

//        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));
        System.out.println(element);
        element.click();
        System.out.println(driver.getSessionId());

    }
}