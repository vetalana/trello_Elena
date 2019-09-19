package com.trello.qa.tests;

import com.trello.qa.manager.ApplicationManager;
import org.testng.annotations.*;


public class TestBase {

  protected static ApplicationManager app = new ApplicationManager();

  @BeforeSuite
  public void setUp() {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
