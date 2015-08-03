package common;

import org.openqa.selenium.By;

public class WebElementData {
	
	public enum LocatorType {
		ID, NAME, CLASS, CSS, LINK_TEXT, PARTIAL_LINK_TEXT, TAG_NAME, XPATH 
	}
	public LocatorType locatorType; //
	public String locator; //This can be ID, Class, xpath, cssSelector, Link Text, etc
	public String text; //Optional this is text inside the element
	
	
	public WebElementData(){}
	public WebElementData(String locator, LocatorType locatorType){
		this.locatorType=locatorType;
		this.locator=locator;
	}
	public WebElementData(String locator, LocatorType locatorType, String text){
			this.locator=locator;
			this.locatorType=locatorType;
			this.text= text;
	}
	public By by() {
		switch(locatorType) {
		case ID:
			return By.id(locator);
		case CSS:
			return By.cssSelector(locator);
		case XPATH:
			return By.xpath(locator);
		case CLASS:
			return By.className(locator);
		case LINK_TEXT:
			return By.linkText(locator);
		case NAME:
			return By.name(locator);
		default:
			return By.id(locator);
		}
	}
	
	/**
	 * Use this for dynamic ids, xpaths, classNames, etc..
	 * For Example: base id=message_box which is dynamically changed to us_message_box_1 or gb_us_message_box_2
	 *  By(countryCode + this.locator + incremental_value);
	 * @param custom
	 * @return
	 */
	public By by(String custom) {
		switch(locatorType) {
		case ID:
			return By.id(custom);
		case CSS:
			return By.cssSelector(custom);
		case XPATH:
			return By.xpath(custom);
		case CLASS:
			return By.className(custom);
		case LINK_TEXT:
			return By.linkText(custom);
		case NAME:
			return By.name(custom);
		default:
			return By.id(custom);
		}
	}

}
