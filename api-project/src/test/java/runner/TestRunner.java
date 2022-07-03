package runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.restassured.RestAssured;
import utils.GenericUtils;

@RunWith(Cucumber.class)  // Ctrl+Shift+o to import  import io.cucumber.junit.CucumberOptions;
@CucumberOptions(
			//features ="src/test/resources/features/GithubListOrgRepos.feature",
			features ="src/test/resources/features/", // Execute scenarios with tags instead of specific ones
			glue = "stepdefinitions",
			snippets = SnippetType.CAMELCASE,
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			dryRun = false
			//tags="not (@p3 or @p2 or @smoke)"
			//tags="@important"
			//tags="@smoke"
		)

public class TestRunner {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("================== This is before class ====================");
		String env = GenericUtils.getPropertyValue("global","env");
		String url = GenericUtils.getPropertyValue(env,"url");
		System.out.println("Global Properties Environment : "+ env);
		System.out.println("Env Properties url : "+ url);
		RestAssured.baseURI=url; //"https://api.github.com";
	}
	
}
