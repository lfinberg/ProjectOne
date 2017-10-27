
package nsolutions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * PageHeader //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 * 
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 *
 */
public class LoadPage
{
  // define header message that you want to verify
  final String HEADER_MESSAGE_1 = "Accenture Makes Minority Investment in and Forms Strategic Alliance with Nomis";
  // locate the first item on the header menu
  final String MENU_NAME1 = "Solutions & Products";
  // when you click on the faster image, it brings the Faster panel with its
  // context that has 3 paragraphs
  final Integer FAST_SUB_MENUS = 3;
  // define expected Started URL
  final String GET_STARTED_URL = "https://info.nomissolutions.com/get-started";
  // define expected Solutions URL
  final String EXP_SOLUTIONS_URL = "https://www.nomissolutions.com/solutions";
  // define expected Resources URL
  final String EXP_RESORCES_URL = "https://blog.nomissolutions.com/resources";

  // define output URLs
  String output_GetStarted_URL;
  String output_Resources_URL;
  String output_Solutions_URL;

  // define menus element with the @FindBy annotation: how = How.CSS, using =
  // ".hs-menu-item.hs-menu-depth-1.hs-item-has-children>a")
  @FindBy(css = ".hs-menu-item.hs-menu-depth-1.hs-item-has-children>a")
  private List<WebElement> menus;

  // define list of header messages
  @FindBy(css = ".span12>h1")
  private List<WebElement> headers;
  // locate Resources Menu on the header
  @FindBy(css = ".hs-menu-item.hs-menu-depth-1>a[href^=\"//blog.\"]")
  private WebElement resources;
  // locate the get started button
  @FindBy(css = ".hs-menu-item.hs-menu-depth-1>a>span")
  private WebElement getStarted;
  // locate the next button
  @FindBy(css = ".slick-next.slick-arrow")
  private WebElement nextButton;
  // locate the previous button
  @FindBy(css = ".slick-prev.slick-arrow")
  private WebElement previousButton;
  // locate the faster image
  @FindBy(css = "#hs_cos_wrapper_module_1442093937821889>h4>a>img")
  private WebElement fasterImg;
  // locate the context of the faster panel
  @FindBy(css = "#hs_cos_wrapper_module_14411536034686877>ul>li")
  private List<WebElement> fasterContexts;
  // locate the smarter image
  @FindBy(css = "#hs_cos_wrapper_module_14420939526991132>h4>a>img")
  private WebElement smarterImg;
  // locate the better image
  @FindBy(css = "#hs_cos_wrapper_module_14420939609181412>h4>a>img")
  private WebElement betterImg;
  // locate the video button
  @FindBy(css = ".btn3.margin-top2")
  WebElement videoButton;
  // define a variable for a number of paragraphs for the faster panel
  Integer numberofParts;

  private WebDriver driver;
  private WebDriverWait wait;

  public LoadPage(WebDriver driver)
  {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public LoadPage clickOnNextBtn()
  {
    waitTillElementIsVisible(nextButton);
    // click on "Next" button
    nextButton.click();
    return this;
  }

  public LoadPage clickOnPreviousBtn()
  {
    waitTillElementIsVisible(previousButton);
    // click on Previous button
    previousButton.click();
    return this;
  }

  public String getTextFromFirstMenu()
  {
    return menus.get(0).getText();
  }

  public String getFirstHeaderMessage()
  {
    return headers.get(1).getText();
  }

  public LoadPage clickOnGetStarted()
  {
    getStarted.click();
    output_GetStarted_URL = driver.getCurrentUrl();
    driver.navigate().back();
    return this;
  }

  public SolutionsPage clickOnSolutions()
  {
    waitTillElementIsVisible(menus.get(0));
    menus.get(0).click();
    output_Solutions_URL = driver.getCurrentUrl();
    return PageFactory.initElements(this.driver, SolutionsPage.class);
  }

  public LoadPage clickOnResources()
  {
    resources.click();
    output_Resources_URL = driver.getCurrentUrl();
    driver.navigate().back();
    return this;
  }

  public LoadPage clickOnFasterImg()
  {
    fasterImg.click();
    numberofParts = fasterContexts.size();
    return this;
  }

  public LoadPage clickOnSmarterImg()
  {
    smarterImg.click();
    return this;
  }

  public LoadPage clickOnBetterImg()
  {
    betterImg.click();
    return this;
  }

  private void waitTillElementIsVisible(WebElement element)
  {
    wait = new WebDriverWait(this.driver, 10);
    wait.until(ExpectedConditions.visibilityOf(element));
  }
}
