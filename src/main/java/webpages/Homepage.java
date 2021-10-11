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

    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/div[3]/div/p")
    private WebElement githubLoginHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login_field\"]")
    private WebElement githubUsername;

    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
    private WebElement githubPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/div[3]/form/div/input[12]")
    private WebElement githubLogin;

    @FindBy(how = How.XPATH, using = "//*[@id=\"page_react_container\"]/div/div[2]/div[3]")
    private WebElement questionPageTag;

    @FindBy(how = How.XPATH, using = "//*[@id=\"AceEditorTask107\"]/div[2]/div/div[3]/div[1]")
    private WebElement questionTitle;

    @FindBy(how = How.XPATH, using = "//*[@id=\"page_react_container\"]/div/p")
    private WebElement questionText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"AceEditorTask107\"]/div[2]/div/div[3]")
    private WebElement questionExample;

    @FindBy(how = How.XPATH, using = "//*[@id=\"page_react_container\"]/div/div[3]/div[3]/a[2]")
    private WebElement skipQuestionBtn;


    public boolean isHomePage() {
        return homePageHeader.getText().contains("The 2021 Toptal JavaScript Speed Coding Challenge");
    }

    public boolean modalPopsUp() {
        return getStartedModal.getText().contains("Get Started");
    }

    public boolean needsLogin() {
        return modalH2.getText().contains("Please log in to start:");
    }

    public boolean isGithubLoginPage() {
        return githubLoginHeader.getText().contains("Sign in to GitHub");
    }

    public boolean isQuestionPage() {
        return questionPageTag.getText().contains("Total Score");
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

    public void clickOnGithubLoginBtn() {
        githubLogin.click();
    }

    public void setGithubUsername(String email){
        githubUsername.clear();
        githubUsername.sendKeys(email);
    }

    public void setGithubPassword(String password){
        githubPassword.clear();
        githubPassword.sendKeys(password);
    }

    public String getQuestionTitle() {
        return questionTitle.getText().split(" = ")[0];
    }

    public String getQuestion() {
        return questionText.getText();
    }

    public String getQuestionExample() {
        return questionExample.getText();
    }

    public void clickSkipQuestionBtn() {
        skipQuestionBtn.click();
    }

}
