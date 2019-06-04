package au.gov.border.oa.runjunit.features.student;

import au.gov.border.oa.steps.LoginSteps;
import com.neotys.selenium.proxies.NLWebDriver;
import com.neotys.selenium.proxies.NLWebDriverFactory;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.neotys.selenium.proxies.NLWebDriverFactory.addProxyCapabilitiesIfNecessary;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentNL {

    @Managed
    WebDriver driver;

    @Rule
    public TestName name = new TestName();


    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void viewStudyVisaDetails() throws Exception {
        String projectPath = null;
//        String CHROME_DRIVER_PATH = "D:\\Neoloadsupport\\selenium\\chromedriver_win32\\chromedriver.exe";
        String CHROME_DRIVER_PATH = "C:\\Temp\\WebDrivers\\chromedriver.exe";
        final File file = new File(CHROME_DRIVER_PATH);

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        @SuppressWarnings("deprecation")
        ChromeDriver webDriver = new ChromeDriver(addProxyCapabilitiesIfNecessary(new DesiredCapabilities()));
        NLWebDriver nlDriver = NLWebDriverFactory.newNLWebDriver(webDriver, "Homeaffaiars", projectPath);

        LoginSteps loginSteps = new LoginSteps();
        loginSteps.setDriver(nlDriver);

        nlDriver.startTransaction("home page");
        loginSteps.openVisaFinder();
        nlDriver.stopTransaction();

        nlDriver.startTransaction("Select Visa");
        loginSteps.selectStudyVisaOption();
        nlDriver.stopTransaction();

        nlDriver.startTransaction("Select study full time");
        loginSteps.selectStudyFullTime();
        nlDriver.stopTransaction();

        nlDriver.startTransaction("View VISA deatils");
        loginSteps.viewVisaDetails();
        nlDriver.stopTransaction();

        nlDriver.quit();
    }
}
