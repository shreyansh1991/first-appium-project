package browsersession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class BrowserEmulatorTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public AppiumDriverLocalService getAppiumServerCustom() {
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\win\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.ALLOW_INSECURE,"chromedriver_autodownload")
                .withTimeout(Duration.ofSeconds(90))
                .withLogFile(new File("ServerLogs/server.log")));
    }

    public static void main(String[] args) {
//        appium --allow-insecure chromedriver_autodownload
        BrowserEmulatorTest test = new BrowserEmulatorTest();
        test.getAppiumServerCustom().start();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "provide_udid");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("autoGrantPermissions",true);

        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        AppiumDriver driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(((AndroidDriver) driver).getContext());
        driver.get("https://tesla.com/");
        System.out.println("driver.getTitle() "+driver.getTitle());
        test.getAppiumServerCustom().close();

    }
}

//https://www.youtube.com/watch?v=c2Ns75xpEGA