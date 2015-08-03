package common;
/* 
 * 
 * Prototype MCM automation
 * Sample code for automating integrity of the TrackerMap
 * Programmer : Ed Liguori
 * 
 * */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.thoughtworks.selenium.SeleneseTestBase;

public class WebApps extends SeleneseTestBase{
	ProfilesIni profile = new ProfilesIni();
	FirefoxProfile myprofile = profile.getProfile("QAprofile");
	public WebDriver driver = new FirefoxDriver(myprofile);	
	
	public enum loginId{
		EMAIL("UserName"), 
		PASSWORD("Password"), 
		USER("CompanyIdentifier"),  
		LOGINBUTTON("LoginSubmit");

		public String id;

		loginId(String id) {
			this.id = id;
		}
	}
	public enum url{
		LOGIN("http://app.ghosteryenterprise.com/Login?returnUrl=%2F"),                 //login screen
		TRACKERMAP("http://app.ghosteryenterprise.com/TrackerMap"),                     //trackermap 
		DATAGOVERNANCE("http://app.ghosteryenterprise.com/Report/DataGovernanceReport"),//data governance 
		LATENCY("http://app.ghosteryenterprise.com/Report/LatencyReport"),              //latency report
		BENCH("http://app.ghosteryenterprise.com/Report/BenchmarkingReport"),           //benchmarking report
		BLALERT("http://app.ghosteryenterprise.com/Alerts/AlertList/2"),                //black list alert
		NTALERT("http://app.ghosteryenterprise.com/Alerts/AlertList/3"),                //new list alert
		MTALERT("http://app.ghosteryenterprise.com/Alerts/AlertList/4"),                //missing tag alert
		WLALERT("http://app.ghosteryenterprise.com/Alerts/AlertList/1"),                //white list alert
		NSALERT("http://app.ghosteryenterprise.com/Alerts/AlertList/6"),                //non-secure tag alert
		SSALERT("http://app.ghosteryenterprise.com/Alerts/ScriptSignature");            //script signature alert
		
		public String path;
		
		url(String path){
			this.path = path;
		}
		
		
	}
	

}
//write locater type file
//add ui element enum
//write webdriver wait method

