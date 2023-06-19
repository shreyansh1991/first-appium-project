package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AutomateChrome_Tesla {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = null;
//DesiredCapabilities caps = new DesiredCapabilities();
//        try{
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability(MobileCapabilityType.UDID, "KRZDUOJV757DU84H");
//        options.setChromedriverExecutable("C:\\Users\\shreyansh.jain\\Desktop\\appium\\exe\\chromedriver.exe");
//            options.setAppPackage("com.android.chrome")
//                    .setAppActivity("com.google.android.apps.chrome.Main");
        options.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        URL url = new URL("http://0.0.0.0:4723");

        driver = new AndroidDriver(url, options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        driver.get("https://www.tesla.com/");
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));

        driver.findElement(By.cssSelector(".tds-site-header > ol >li > button > span")).click();

        driver.findElement(AppiumBy.xpath("//section[@class='tds-modal-content']//ol//li//a//span[text()='Model X']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        Actions actions = new Actions(driver);

        JavascriptExecutor jse = ((JavascriptExecutor) driver);

        WebElement orderNow_model_x = driver.findElement(By.xpath("//div[@class='tcl-order__buttons']//section/a[@title='Order Now']"));

        scrollToElement_Y_Position(driver, orderNow_model_x);

//        orderNow_model_x.click();
        clickUsingJs(driver,orderNow_model_x);


        System.out.println("Order now button clicked!");

        WebElement paint_container = driver.findElement(By.

                xpath("//fieldset[@class='tds-form-fieldset tds-fieldset tds--vertical_margin--fieldset option-widget--container']"));

// WebElement model_x_Ultra_Red_Selection = driver.findElement(By.cssSelector("#Model_X_Ultra_Red"));

        WebElement model_x_Ultra_Red_Selection = driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='image'])[7]"));

        scrollToElement_Y_Position(driver, paint_container);

//model_x_Ultra_Red_Selection.click();

        wait.until(ExpectedConditions.elementToBeClickable(model_x_Ultra_Red_Selection));

        actions.moveToElement(model_x_Ultra_Red_Selection).click().build().perform();

// Thread.sleep(40000);

        WebElement model_x_wheels_section = driver.findElement(By.

                xpath("//div[@data-group-id='WHEELS']//fieldset[@class='tds-form-fieldset tds-fieldset tds--vertical_margin--fieldset option-widget--container']"));

        shouldScrollFromElementByGivenAmountWithOffset(driver, model_x_wheels_section, 200);

        WebElement model_x_Turbine_Wheels = driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='image'])[10]"));

        wait.until(ExpectedConditions.elementToBeClickable(model_x_Turbine_Wheels));

        actions.moveToElement(model_x_Turbine_Wheels).click().build().perform();

        System.out.println("Turbine wheel svg img clicked!");

//...............ok................

// Thread.sleep(6000);

        WebElement model_x_package = driver.findElement

                (By.xpath("//div[@data-group-id='PACKAGES']//div[contains(@class,'option-widget--container')]"));

        shouldScrollFromElementByGivenAmountWithOffset(driver, model_x_package, 700);

        WebElement model_x_cream_color = driver.findElement(

                By.xpath("(//*[name()='svg']//*[local-name()='image'])[15]"));

        wait.until(ExpectedConditions.elementToBeClickable(model_x_cream_color));

        actions.moveToElement(model_x_cream_color).click().build().perform();

        System.out.println("Cream Color selected as clicked!");

        shouldScrollFromElementByGivenAmountWithOffset(driver, model_x_package, 1000);

        WebElement model_x_seat_count_7 = driver.findElement

                (By.xpath("//label//div[text()='7']"));

        wait.until(ExpectedConditions.elementToBeClickable(model_x_seat_count_7));

        actions.moveToElement(model_x_seat_count_7).click().build().perform();

        WebElement Model_X_Yoke_Steering = driver.findElement(

                By.xpath("(//*[name()='svg']//*[local-name()='image'])[17]"));

        wait.until(ExpectedConditions.elementToBeClickable(Model_X_Yoke_Steering));

        actions.moveToElement(Model_X_Yoke_Steering).click().build().perform();

        System.out.println("York Steering svg img clicked!");

        WebElement model_X_ACCESSORIES = driver.findElement

                (By.xpath("//div[@data-group-id='ACCESSORIES']"));

        Thread.sleep(6000);

        shouldScrollFromElementByGivenAmountWithOffset(driver, model_X_ACCESSORIES, 4700);

        WebElement model_x_charging_wall_connector = driver.findElement

                (By.xpath("(//div[@class='tds-form-input']//input)[1]"));

        wait.until(ExpectedConditions.elementToBeClickable(model_x_charging_wall_connector));

        actions.moveToElement(model_x_charging_wall_connector).click().build().perform();

        System.out.println("Wall charger clicked");

        WebElement model_x_charging_mobile_connector = driver.findElement

                (By.xpath("(//div[@class='tds-form-input']//input)[1]"));

        wait.until(ExpectedConditions.elementToBeClickable(model_x_charging_mobile_connector));

        actions.moveToElement(model_x_charging_mobile_connector).click().build().perform();

        System.out.println("Mobile charger clicked");

        WebElement button_continue_to_payment = driver.findElement(

                By.xpath("//button//span[text() = 'Continue to Payment']"));

        wait.until(ExpectedConditions.elementToBeClickable(model_x_charging_mobile_connector));

        actions.moveToElement(model_x_charging_mobile_connector).click().build().perform();

        System.out.println("Continue to payment button clicked");

        Thread.sleep(5000);


//        }
//catch (Exception e)
//{
//    System.out.println(e.getMessage());
//}
//        finally {
//        driver.quit();
//        }}
    }

    public static void scrollToElement(AppiumDriver driver, WebElement ele) {

        new Actions(driver)

                .scrollToElement(ele)

                .perform();

    }

    public static void scrollToElement_Y_Position(AppiumDriver driver, WebElement ele) {

        int deltaY = ele.getRect().y;

        System.out.println("deltaY: " + deltaY);

        new Actions(driver)

                .scrollByAmount(0, deltaY)

                .perform();

    }
    public static void clickUsingJs(AppiumDriver driver,WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void shouldScrollFromElementByGivenAmountWithOffset(AppiumDriver driver, WebElement ele, int position_y) {

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(ele);

        new Actions(driver)

                .scrollFromOrigin(scrollOrigin, 0, position_y)

                .perform();

        System.out.println("Position Y: " + position_y);

    }

}
