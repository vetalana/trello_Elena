package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase {
  @Test
  public void testBoardCreation(){
    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm("qa21", "descr qa 21");
    confirmBoardCreation();
  }

}
