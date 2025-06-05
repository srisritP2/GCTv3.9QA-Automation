package com.qa.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import com.qa.base.TestBase;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomWebDriverListener implements WebDriverListener {

	private static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\screenshots\\";
	private static final String LOG_FILE = System.getProperty("user.dir") + "\\logs\\test_log.txt";

	public static String toText = "Start of Program"; // Capturing console logs

	/**
	 * Logs navigation events
	 */
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("🌐 Navigating to: " + url);
		logToFile("Navigating to: " + url);
		appendConsoleLog("Navigating to: " + url);
	}

	/**
	 * Logs before switching windows
	 */
	public void beforeSwitchToWindow(WebDriver driver, String windowHandle) {
		System.out.println("🪟 Switching to window: " + windowHandle);
		logToFile("Switching to window: " + windowHandle);
		appendConsoleLog("Switching to window: " + windowHandle);
	}

	/**
	 * Captures logs when an exception occurs
	 */
	public void onError(Object target, Method method, Object[] args, Throwable throwable) {
		String errorMsg = "❌ Exception in method: " + method.getName() + " - " + throwable.getMessage();
		System.err.println(errorMsg);
		appendConsoleLog(errorMsg);

		if (target instanceof WebDriver) {
			WebDriver driver = (WebDriver) target;
			takeScreenshot(driver);
		}

		logToFile(errorMsg);
	}

	/**
	 * Takes a screenshot when an exception occurs
	 */
	private void takeScreenshot(WebDriver driver) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String fileName = SCREENSHOT_PATH + "error_" + getCurrentTimestamp() + ".png";
			Files.createDirectories(Paths.get(SCREENSHOT_PATH));
			Files.copy(srcFile.toPath(), new File(fileName).toPath());
			System.out.println("📸 Screenshot saved: " + fileName);
			logToFile("Screenshot taken: " + fileName);
		} catch (IOException e) {
			System.err.println("⚠️ Failed to take screenshot: " + e.getMessage());
		}
	}

	/**
	 * Logs messages to a file
	 */
	private void logToFile(String message) {
		try (FileOutputStream fos = new FileOutputStream(LOG_FILE, true)) {
			String logEntry = getCurrentTimestamp() + " - " + message + System.lineSeparator();
			fos.write(logEntry.getBytes());
		} catch (IOException e) {
			System.err.println("⚠️ Failed to write to log file: " + e.getMessage());
		}
	}

	/**
	 * Appends logs to ConsoleLogs for saving in TestBase
	 */
	private void appendConsoleLog(String message) {
		toText += System.lineSeparator() + message;
	}

	/**
	 * Returns the current timestamp for log and screenshot naming
	 */
	private String getCurrentTimestamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	}
}
