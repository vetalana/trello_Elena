package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditionsLogin() {
    if (!app.isUserLoggedIn()) {
      app.login("elena.telran@yahoo.com", "12345.com");
    }
  }

  @Test
  public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
    int before = app.getTeamsCount();
    app.clickOnPlusButtonOnHeader();
    app.selectCreateTeamFromDropDown();
    String teamName = "qa21-" + System.currentTimeMillis();
    app.fillTeamCreationForm(teamName, "descr qa 21");
    app.clickContinueButton();
    //  String createdTeamName = getTeamNameFromTeamPage();
    app.returnToHomePage();
    int after = app.getTeamsCount();
    Assert.assertEquals(after, before + 1);
    //  Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
  }

  @Test
  public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
    int before = app.getTeamsCount();
    app.clickOnPlusButtonOnLeftNavMenu();
    app.fillTeamCreationForm("h", "g");
    app.clickContinueButton();
    String createdTeamName = app.getTeamNameFromTeamPage();
    app.returnToHomePage();
    //  refreshPage();
    int after = app.getTeamsCount();

    Assert.assertEquals(after, before + 1);
    Assert.assertEquals(createdTeamName, "h");
  }

  @Test(enabled = false)
  public void testTeamCuncellCreationFromPlusButtonOnHeader() {
    app.clickOnPlusButtonOnHeader();
    app.selectCreateTeamFromDropDown();
    app.fillTeamCreationForm("qa21", "descr qa 21");
    app.clickXButton();
    //Assert


    Assert.assertTrue(app.isUserLoggedIn());
  }

  @AfterClass
  public void postActions() throws InterruptedException {
    app.cleanTeams();
  }

}
