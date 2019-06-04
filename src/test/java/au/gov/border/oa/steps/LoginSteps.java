package au.gov.border.oa.steps;

import com.github.tamnguyenbbt.dom.DomUtil;
import com.neotys.selenium.proxies.NLWebDriver;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps
{
    private NLWebDriver driver;
    private CommonSteps commonSteps = new CommonSteps();
    private DomUtil domUtil = new DomUtil();

    public void setDriver(NLWebDriver driver) {
        this.driver = driver;
        commonSteps.setDriver(driver);
    }

    @Step
    public void openVisaFinder()
    {
        driver.get("https://immi.homeaffairs.gov.au/visas/getting-a-visa/visa-finder");
        commonSteps.verifyTextInPage("Explore visa options", true);
    }

    @Step
    public void selectStudyVisaOption() throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "h3", "Study", "a").click();
        commonSteps.verifyTextInPage("study full time", true);
    }

    @Step
    public void selectStudyFullTime() throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "label", "study full time", "input").click();
        domUtil.getWebElementBestEffort(driver, "button", "Continue", "button").click();
        commonSteps.verifyTextInPage("Subclass 500", true);
    }

    @Step
    public void viewVisaDetails() throws Exception
    {
        domUtil.getWebElementBestEffort(driver, "button", "Details", "button").click();
        commonSteps.verifyTextInPage("With this visa you can", true);
    }

}
