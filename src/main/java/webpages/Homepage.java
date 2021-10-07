package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Ridwan Mustapha
 */
public class Homepage {
    private final WebDriver driver;
    private static final String PAGE_URL = "https://speedcoding.toptal.com/challenge?ch=toptal-js-2021";

    @FindBy(how = How.XPATH, using = "//*[@id=\"page_react_container\"]/div[1]/section/h2")
    private WebElement homePageHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal-host\"]/div/div/div[1]")
    private WebElement getStartedModal;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal-host\"]/div/div/div[2]")
    private WebElement modalH2;

    @FindBy(how = How.XPATH, using = "//*[@id=\"page_react_container\"]/div[1]/section/div[3]/div[1]/button")
    private WebElement startChallengeBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal-host\"]/div/div/div[6]/button")
    private WebElement modalStartChallengeBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal-host\"]/div/div/div[3]/div/button[2]")
    private WebElement loginWithGithubBtn;

    public boolean isHomePage() {
        return homePageHeader.getText().contains("The 2021 Toptal JavaScript Speed Coding Challenge");
    }

    public boolean modalPopsUp() {
        return getStartedModal.getText().contains("Get Started");
    }

    public boolean needsLogin() {
        return modalH2.getText().contains("Please log in to start:");
    }

    //Constructor
    public Homepage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnStartChallengeButton() {
        startChallengeBtn.click();
    }

    public void clickOnModalStartChallengeButton() {
        modalStartChallengeBtn.click();
    }

    public void clickOnLoginBtn() {
        loginWithGithubBtn.click();
    }
}
