package com.example.tests;


import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KendoUI extends TestBase{
  @Test
  public void checkKendoContent() throws Exception {
    openMainPage();
    openKendoFolder();
    getFolders();
    
  }
  
  public void getFolders() {
	  WebDriverWait wait= new WebDriverWait(driver,30 );
		List<WebElement> nestedFolders = driver.findElements(By.cssSelector("div+.rtUL li"));

		for (WebElement element : nestedFolders) {
			wait.until(ExpectedConditions.visibilityOfAllElements(nestedFolders));
			String folderHeaderTextOld = driver.findElement(By.cssSelector("div#subject")).getText();		
				element.click();
				wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("div#subject"), folderHeaderTextOld));
				String folderHeaderTextNew = driver.findElement(By.cssSelector("div#subject")).getText();
				Assert.assertNotEquals(folderHeaderTextOld, folderHeaderTextNew);
	
		}

	}
  

public void openKendoFolder() throws InterruptedException {
	driver.findElement(By.cssSelector("div#ctl00_FolderContent_FolderNavigationControl_rtvFolders span.rtPlus")).click();
	
}

public void openMainPage() {
	//driver.get(baseUrl + "/aspnet-ajax/webmail/default.aspx");
	  driver.get("http://demos.telerik.com/aspnet-ajax/webmail/default.aspx");
}
}
