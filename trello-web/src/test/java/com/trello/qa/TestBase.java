package com.trello.qa;

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
