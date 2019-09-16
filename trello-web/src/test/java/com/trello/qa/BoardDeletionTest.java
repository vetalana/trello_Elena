package com.trello.qa;

import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
  @Test
  public void deletionBoardTest() throws InterruptedException {
    int before = app.getPersnalBoardsCount();
    app.clickOnFirstPrivateBoard();
    Thread.sleep(10000);
    app.clickOnMoreButtonInBoardMenu();
    app.initBoardDeletion();
    app.confirmBoardDeletion();//.js-delete
    app.confirmFinishBoardDeletion();//.js-confirm.full
    app.returnToHomePage();


    int after = app.getPersnalBoardsCount();
  }


}
