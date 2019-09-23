package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardModificationTests extends  TestBase {
  @BeforeMethod
  public void preconditions(){
    if(!app.getBoardHelper().isTherePersonalBoards()){
      app.getBoardHelper().createBoard();
    };
  }
  @Test
  public void changeBoardName(){
    app.getBoardHelper().clickOnFirstPrivateBoard();
    String bName = "BB";
    app.getBoardHelper().changeBoardName(bName);
 //   String newName = app.getBoardHelper().getNameAfterChange();

    //Assert.assertEquals();
    Assert.assertTrue(app.getBoardHelper().findBoardByName(bName));

  }


}
