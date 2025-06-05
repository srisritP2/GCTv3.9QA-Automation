package com.qa.base;

// Import required dependencies
import com.qa.util.CustomWebDriverListener;
import org.openqa.selenium.*; // Importing Selenium WebDriver
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.*; // For capturing browser logs
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.*; // For explicit waits

import java.awt.*; // For Robot class (keyboard and mouse events)
import java.awt.event.KeyEvent;
import java.io.*; // File handling (logs, config files)
import java.time.Duration; // New Selenium 4 time management
import java.util.*; // For Maps and Properties
import java.util.function.Function;
import java.util.logging.Level;

/**
 * - TestBase class: Manages WebDriver initialization, browser settings, logging, and utilities.
 * - Loads browser properties
 * - Sets up WebDriver based on config file
 * - Manages browser alerts, scrolling, and logging
 * - Closes browser after execution
 */
public class TestBase {
    public static final By yesButton = By.xpath("//span[contains(text(),'Yes')]");

    //  Global WebDriver instance (used across all test cases)
    public static WebDriver driver;

    //  Properties object to load configuration settings from the config file
    public static Properties prop;

    //  BufferedWriter for writing logs to a file
    public static BufferedWriter bwcc;

    /**
     *  Constructor: Loads the `config.properties` file for configurations
     */
    public TestBase() {
        try {
            //  Initialize Properties object
            prop = new Properties();

            //  Load configuration file
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace(); // Handle file not found or reading errors
        }
    }

    /**
     * - Initializes WebDriver based on the browser specified in `config.properties`
     * - Registers a Custom WebDriver Event Listener for logging
     * - Configures browser settings and timeouts
     */
    public static void initialization() {
        //  Read the browser name from the properties file
        String browserName = prop.getProperty("browser").toLowerCase();

        //  Switch-case to handle different browsers
        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();

                //  Configure Chrome browser options
                chromeOptions.addArguments("--start-maximized"); // Start browser maximized
                chromeOptions.addArguments("--disable-notifications"); // Disable notifications
                chromeOptions.addArguments("--disable-popup-blocking"); // Block popups

                //  Set Chrome preferences
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 1);
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Framework_Downloads");
                chromeOptions.setExperimentalOption("prefs", prefs);

        // Set window size (width x height)
//                options.addArguments("--window-size=800,600"); // Adjust the values as needed
//                chromeOptions.addArguments("--window-size=1920,1080");

        // Set browser zoom to 80% To Execute scenarios in Laptop resolution
//                chromeOptions.addArguments("--force-device-scale-factor=0.8");// Adjust the value as needed
//                chromeOptions.addArguments("--high-dpi-support=0.8");// Adjust the value as needed
//			      chromeOptions.addArguments("--headless");   //To run the scripts on headless Chrome browser

                //  Initialize ChromeDriver with options
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                // Configure Firefox settings (disable cache)
                firefoxOptions.addPreference("browser.cache.disk.enable", false);
                firefoxOptions.addPreference("browser.cache.memory.enable", false);
                firefoxOptions.addPreference("network.http.use-cache", false);

                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "safari":
                //  Initialize SafariDriver and maximize window
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();

                //  Configure Edge browser options
                edgeOptions.addArguments("--disable-cache");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--incognito");

                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new RuntimeException("Invalid browser name: " + browserName);
        }

        //  Register Custom WebDriver Listener for logging browser events
        CustomWebDriverListener listener = new CustomWebDriverListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        //  Delete all cookies
        driver.manage().deleteAllCookies();

        //  Set page load timeout (60 seconds max)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        //  Set implicit wait timeout (10 seconds for elements to be found)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Open the application URL specified in `config.properties`
        driver.get(prop.getProperty("url"));
    }

    /**
     *  Waits for an element to be visible on the page
     * @param locator  - The By locator of the element
     * @param timeout  - The maximum duration to wait
     */
    public static void waitForElement(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementWithRetry(By locator, Function<By, ExpectedCondition<WebElement>> condition) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                return wait.until(condition.apply(locator));
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new StaleElementReferenceException("Element still stale after retries: " + locator.toString());
    }
    public static void clickWithRetryAfterRefresh(By locator) throws InterruptedException {
        try {
            WebElement element = waitForElementWithRetry(locator, ExpectedConditions::elementToBeClickable);
            element.click();
        } catch (Exception e) {
            refreshPageWithF5();
            Thread.sleep(3000);
            WebElement element = waitForElementWithRetry(locator, ExpectedConditions::elementToBeClickable);
            element.click();
        }
    }
    /**
     * Scrolls down using the Robot class (simulating PAGE_DOWN key)
     */
    public static void scrollDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        System.out.println("🔽 Scrolled Down");
    }

    /**
     *  Scrolls up using the Robot class (simulating PAGE_UP key)
     */
    public static void scrollUp() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        System.out.println("🔼 Scrolled Up");
    }

    /**
     *  Accepts browser alerts if present
     */
    public static void acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("✅ Alert accepted.");
        } catch (Exception e) {
            System.out.println("⚠️ No alert present.");
        }
    }
    public static void yesAlertHandle() {
        if (driver.findElement(yesButton).isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement yesButtonElement = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
            yesButtonElement.click();
        } else {
            System.out.println("Alert Not found");
        }
    }
    public static void refreshPageWithF5() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.F5).perform(); // Presses F5 to refresh
        System.out.println("Page refreshed!");
    }
    /**
     *  Captures and saves WebDriver console logs to a file
     */
    public static void ConsoleLogs(String met_name) throws IOException {
        String logPath = System.getProperty("user.dir") + "\\logs\\" + "Consolelogs_" + met_name + ".txt";
        BufferedWriter bwcc = new BufferedWriter(new FileWriter(logPath, true));

        // Extract and filter logs
        LogEntries logEntries = driver.manage().logs().get(LogType.DRIVER);
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains("Exception") || entry.getLevel().equals(Level.SEVERE)) {
                bwcc.write(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + System.lineSeparator());
            }
        }

        bwcc.close();
        System.out.println("Filtered console logs logged to: " + logPath);
    }

    /**
     *  Captures browser console logs (JavaScript errors) and saves to a file
     */
    public static void logBrowserConsoleLogs(String met_name) throws IOException {
        String logPath = System.getProperty("user.dir") + "\\logs\\" + met_name + "_BrowserLogs.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(logPath, true));

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getLevel().equals(Level.SEVERE)) {  // Only capture severe errors
                bw.write(met_name + " --> " + new Date(entry.getTimestamp()) + " " + entry.getMessage() + System.lineSeparator());
            }
        }

        bw.close();
        System.out.println("Filtered browser logs logged to: " + logPath);
    }

    /**
     *  Closes the browser and quits WebDriver session
     */
    public void closeBrowser() {
        try {
            Thread.sleep(5000); // Wait before closing (optional)
            driver.quit();
            System.out.println("✅ Browser closed successfully.");
        } catch (InterruptedException e) {
            System.err.println("⚠️ Error closing browser: " + e.getMessage());
        }
    }
}

