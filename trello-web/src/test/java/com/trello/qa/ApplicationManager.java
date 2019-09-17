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
  TeamHelper teamHelper;
  BoardHelper boardHelper;
  SessionHelper sessionHelper;

  public void init() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    teamHelper = new TeamHelper(driver);
    boardHelper = new BoardHelper(driver);
    sessionHelper = new SessionHelper(driver);

    sessionHelper.openSite("https://trello.com");
    sessionHelper.login("elena.telran@yahoo.com", "12345.com");
  }

  public void stop() {
    driver.quit();
  }

  public TeamHelper getTeamHelper() {
    return teamHelper;
  }

  public BoardHelper getBoardHelper() {
    return boardHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
