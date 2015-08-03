package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class Trackermap extends LoginObject{

	static int success=0,fail=0;
//create enum for trackermap elements
//prototype overlay detection
//	public boolean isOverlayPresent(WebElement cssPath)
//    {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		try {
//		   if( driver.findElement(By.id("TrackerMapIsBusy")).getCssValue("display")!= "block")   
//		    System.out.println("Element Found");
//		} catch (NoSuchElementException e) {
//		    System.out.println("Element Not Found");
//		}
//    }
		
	
	public void listSelector() throws InterruptedException{
		WebElement selection = driver.findElement(By.id("selectDomainGroup"));
		List <WebElement> selections = selection.findElements(By.tagName("option"));
		selection.click();
		WebElement date = driver.findElement(By.id("datePicker"));
		date.click();	
		driver.findElement(By.id("optDomainGroup")).click();   //write function for picking date 
		date.findElements(By.tagName("option")).get(1).click();  //Current week is empty, select previous week
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='treeViewTab']")).click();   //switch to tree view 
		
		
		for(int i = 1; i<selections.size(); i++){  //iterate through the list of domain groups
			selections = selection.findElements(By.tagName("option"));
			Thread.sleep(1000);
			driver.findElement(By.id("optDomainGroup")).click();
			selections.get(i).click();
			driver.findElement(By.id("submitTrackerMap")).click();
			
		//	WebElement overlay = driver.findElement(By.id("TrackerMapIsBusy"));	
			
			Thread.sleep(5000);  //Write function to detect and wait for overlay to disappear
			
			try{
			if(driver.findElement(By.className("treeNode")).isDisplayed())
				success++;
			}
			catch(NoSuchElementException e){         //tree node not found, record failed domain group
				System.out.println(selections.get(i).getText());
				fail++;
			}	
			selection.click();

		}
		System.out.println("Success:"+ success);
		System.out.println("Fail:"+fail);
	}	
}

