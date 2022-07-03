package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class BaseClass {
	//@Before(value= "@p1")
		@Before
		public void beforeScenarioP1() {
			
			System.out.println("---------------------------------------");
			System.out.println("This is before P1 scenario");
		}
		@Before(value= "@p2")
		public void beforeScenarioP2() {
			System.out.println("---------------------------------------");
			System.out.println("This is before P2 scenario");
		}
		
		@BeforeStep
		public void beforeStep() {
			System.out.println("---------------------------------------");
			System.out.println("This is before step");
		}

		@AfterStep
		public void afterStep() {
			System.out.println("---------------------------------------");
			System.out.println("This is after step");
		}
		
		@After(value= "@p1")
		public void afterScenarioP1() {
			System.out.println("---------------------------------------");
			System.out.println("This is after P1 scenario");
		}
		@After(value= "@p2")
		public void afterScenarioP2() {
			System.out.println("---------------------------------------");
			System.out.println("This is after P2 scenario");
		}
}
