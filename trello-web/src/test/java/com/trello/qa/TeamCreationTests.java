package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends  TestBase{
  @Test
  public void testTeamCreationFromPlusButtonOnHeader(){
    clickOnPlusButtonOnHeader();
    selectCreateTeamFromDropDown();
    fillTeamCreationForm("qa21", "descr qa 21");
    clickContinueButton();
    //Assert


    Assert.assertTrue(isUserLoggedIn());
  }

  @Test(enabled=false)
  public void testTeamCuncellCreationFromPlusButtonOnHeader(){
    clickOnPlusButtonOnHeader();
    selectCreateTeamFromDropDown();
    fillTeamCreationForm("qa21", "descr qa 21");
    clickXButton();
    //Assert


    Assert.assertTrue(isUserLoggedIn());
  }

  public void clickXButton() {

  }


}
