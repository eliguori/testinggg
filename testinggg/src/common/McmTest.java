package common;
import org.testng.annotations.Test;

public class McmTest extends Trackermap{
	static int success=0,fail=0;
	@Test
	public void testStuff() throws InterruptedException{

		driver.navigate().to(url.LOGIN.path);
		
		login(credentials.HOMEDEPOT.company);
		Thread.sleep(1000);   
		driver.navigate().to(url.TRACKERMAP.path);
		Thread.sleep(1000);
		System.out.println("TrackerMap Integrity report for "+credentials.HOMEDEPOT.company);
		System.out.println("The following companies did not have a TrackerMap loaded:");
		listSelector();
	
	
	}
}