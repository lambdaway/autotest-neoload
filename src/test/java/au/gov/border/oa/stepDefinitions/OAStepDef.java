package au.gov.border.oa.stepDefinitions;

import au.gov.border.oa.steps.LoginSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OAStepDef
{
    private Scenario scenario;

    @Before
    public void before(Scenario scenario)
    {
        this.scenario = scenario;
    }

    @After
    public void after()
    {
    }

    @Steps
    LoginSteps loginSteps;

    @Given("^(?:.*) opens? Visa Finder page$")
    public void openOAHomePage()
    {
        loginSteps.openVisaFinder();
    }

    @And("^(?:.*) selects? Study visa option$")
    public void selectStudyVisaOption() throws Exception
    {
        loginSteps.selectStudyVisaOption();
    }

    @When("^(?:.*) selects? Study Full Time$")
    public void selectStudyFullTime() throws Exception
    {
        loginSteps.selectStudyFullTime();
    }

    @Then("^(?:.*) could see visa details$")
    public void seeVisaDetails() throws Exception
    {
        loginSteps.viewVisaDetails();
    }

}
