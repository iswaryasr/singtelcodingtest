package com.singtel.todo.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.singtel.todo.utils.WebDriverUtils;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "src/test/resources/features" }
, glue = { "com/singtel/todo/steps" }
, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
, tags = "@TodoMVC")

public class CucumberTestRunner {

	private TestNGCucumberRunner cucumberRunner;

	@BeforeSuite
	public void setupEnvironment() {
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		cucumberRunner = new TestNGCucumberRunner(CucumberTestRunner.class);
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		cucumberRunner.runScenario(pickle.getPickle());
	}

	@AfterTest
	public void tearDown() {
		WebDriverUtils.closeWebDriver();
	}

	@DataProvider
	public Object[][] scenarios() {
		return cucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		cucumberRunner.finish();
	}

}