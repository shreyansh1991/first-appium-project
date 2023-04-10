package browsersession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateBrowserSession {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_5");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
//        caps.setCapability("chromedriverExecutable",System.getProperty("user.dir")+ File.separator+"browser_exe"+File.separator+"chromedriver.exe");

//        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
//        uiAutomator2Options.setAppPackage("com.android.chrome")
//                .setAppActivity("com.google.android.apps.chrome.Main")
//                .setChromedriverExecutable(System.getProperty("user.dir")+ File.separator+"browser_exe"+File.separator+"chromedriver.exe");
        URL url = new URL("http://0.0.0.0:4723/");

        AppiumDriver driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tesla.com/");
        System.out.println("driver.getTitle() "+driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    wait.until((d)->{
        System.out.println(driver.findElements(By.xpath("//button[@title='Menu']")).size());
        return driver.findElements(By.xpath("//button[@title='Menu']")).size()>0;
    });
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@title='Menu']")).click();
        driver.findElement(By.xpath("//a[@title='Model X']")).click();
//        driver.findElement(By.cssSelector
//                ("#tesla-hero-3455 > div.tcl-hero__content.tds-animate_small--reveal > div > section > div > a")).click();



    }
}
