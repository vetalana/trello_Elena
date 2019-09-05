package com.trello.qa;

import com.trello.qa.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTestsYana extends TestBase {
    @Test
    public void BoardCreationTests() {
        driver.findElement(By.cssSelector("[class=\"board-tile mod-add\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"Add board title\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"Add board title\"]")).clear();
        driver.findElement(By.cssSelector("[placeholder=\"Add board title\"]")).sendKeys("Yana_TEST");
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
    }
}
