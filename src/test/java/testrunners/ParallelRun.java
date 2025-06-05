//This file is to define the before, after class

package testrunners;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//plugin is for reports
//monochrome is to print console without special characters.
//glue is for step definitions declaration
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        },
        monochrome = true,
        tags = "@QuickTestSuite and not @Skip_Scenario",
//        tags = "@RunNow",
//        tags = "@QuickTestSuite and @EndToEndTestSuite",
//        tags = "not @Skip_Scenario",
//        tags = "not @ignore",
//        tags = "@Run_Scenario",
        glue = { "StepDefinitions" },
        features = {"src/test/resources/features"}
)
public class ParallelRun extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }
    @DataProvider(parallel = false)
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();

    }
}