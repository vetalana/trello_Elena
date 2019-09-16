package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;

  public void init() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    openSite("https://trello.com");
    login("elena.telran@yahoo.com", "12345.com");
  }

  public void login(String email, String password) {
    new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/login']")));
    click(By.cssSelector("[href='/login']"));
    type(By.cssSelector("[type=email]"), email);
    type(By.cssSelector("[type=password]"), password);
    click(By.id("login"));
  }

  public void waitForElementAndClick(By locator, int time) {
    new WebDriverWait(driver, time)
            .until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void openSite(String url) {
    driver.get(url);
  }

  public void stop() {
    driver.quit();
  }

  public boolean isUserLoggedIn() {
    return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public void clickContinueButton() {
    click(By.cssSelector("[type=submit]"));
  }

  public void fillTeamCreationForm(String teamName, String description) {
    type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
    type(By.cssSelector("textarea"), description);
  }

  public void selectCreateTeamFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-team-button']"));
  }

  public void clickOnPlusButtonOnHeader() {
    waitForElementAndClick(By.
            cssSelector("[data-test-id='header-create-menu-button']"), 15);
  }

  public void fillBoardCreationForm(String boardName, String s) {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);

    if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
      click(By.cssSelector(".W6rMLOx8U0MrPx"));
      click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
    }

  }

  public void selectCreateBoardFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-board-button']"));
  }

  public void confirmBoardCreation() {
    waitForElementAndClick(By.cssSelector("[data-test-id='header-create-board-submit-button']"), 20);
  }

  protected String getTeamNameFromTeamPage() {
    new WebDriverWait(driver, 20)
            .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
    return driver.findElement(By.cssSelector("h1")).getText();
  }

  public void returnToHomePage() {
    if (isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))) {
      new WebDriverWait(driver, 20)
              .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
      click(By.cssSelector("a[href='/']"));
      click(By.cssSelector("a[href='/']"));
    } else
      waitForElementAndClick(By.cssSelector("a[href='/']"), 15);
  }

  public int getTeamsCount() {
    new WebDriverWait(driver, 5)
            .until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
    return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
  }

  public void clickXButton() {

  }

  public int getPersnalBoardsCount() {
    return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
  }

  @BeforeMethod
  public void isOnHomePage() {
    if (!isTherePersonalBoards()) {
      returnToHomePage();
    }
  }

  public boolean isTherePersonalBoards() {
    return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
  }

  public void refreshPage() {
    driver.navigate().refresh();
  }

  public void clickOnPlusButtonOnLeftNavMenu() {
    click(By.cssSelector(".icon-add.icon-sm"));
  }

  public void clickOnMoreButtonInBoardMenu() {
    WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
    System.out.println(menuButton.getCssValue("visibility"));
    if (menuButton.getCssValue("visibility").equals("visible")) {
      click(By.cssSelector(".mod-show-menu"));
      click(By.cssSelector(".js-open-more"));
    } else {
      click(By.cssSelector(".js-open-more"));
    }

  }

  public void clickOnFirstPrivateBoard() {
    click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
  }

  public void openSettings() throws InterruptedException {
    //waitForElementAndClick(By.xpath("//*[@class='icon-gear icon-sm OiX3P2i2J92Xat']/../../.."), 20);
    Thread.sleep(5000);
    click(By.xpath("//*[@class='icon-gear icon-sm OiX3P2i2J92Xat']/../../.."));
    //   click(By.cssSelector("[href$=account]"));
    //waitForElementAndClick(By.cssSelector("li .icon-gear.icon-sm.OiX3P2i2J92Xat"), 30);
  }

  public void deleteTeam() throws InterruptedException {
//    new WebDriverWait(driver, 10)
//            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
    Thread.sleep(10000);
    click(By.cssSelector(".quiet-button"));
    click(By.cssSelector(".js-confirm"));
  }


  public void clickOnFirstTeam() {
//waitForElementAndClick(By.cssSelector("[data-test-id^='home-team-tab-section-']"), 20);
    //click(By.xpath("//*[@data-test-id='home-team-tab-name']"));
    click(By.cssSelector("[data-test-id^='home-team-tab-section-']"));
  }

  public void initBoardDeletion() {
    clickCloseBoardButton();
    confirmCloseButton();
  }

  private void confirmCloseButton() {
    click(By.cssSelector(".js-confirm.full.negate"));
  }

  private void clickCloseBoardButton() {
    click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));

  }

  public void confirmBoardDeletion() {
    new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-delete")));
    click(By.cssSelector(".js-delete"));
  }

  public void confirmFinishBoardDeletion() {
    click(By.cssSelector(".js-confirm.full"));
  }

  public void cleanTeams() throws InterruptedException {
    int count = getTeamsCount();
    while (count > 5) {
      clickOnFirstTeam();
      openSettings();
      deleteTeam();
     // returnToHomePage();
      refreshPage();
      count = getTeamsCount();
      System.out.println(count);
    }
  }
}
