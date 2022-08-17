// To launch the driver and take screenshots

package StepDefnitions;

import com.qa.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ApplicationHooks extends TestBase {

	@Before
	public void setUP() throws IOException {
		initialization();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		try {

		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			// Take a screenshot...
//			final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
//			scenario.(sourcePath, "image/png"); // ... and embed it in the report.
			ConsoleLogs(scenario.getName()); //... to get selenium action -- java console logs
			logBrowserConsoleLogs(scenario.getName()); //... get browser console logs in logs folder
			closeBrowser();
//			driver.quit();
		} else
		{
		closeBrowser();
//			driver.quit();
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			driver.quit();
		}
	}
}
