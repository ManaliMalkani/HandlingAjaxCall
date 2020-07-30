package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuggestionsPage {
	
	
	public WebDriver driver;
	
	public SuggestionsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//p[@class='product-name']")
	
	@FindBy(xpath="//ul[@class='list-group constituent-list clearfix']//li[1]//div[@class='col-xs-12']//div[3]//span[1]")
	WebElement spdr;
	
	
	public WebElement spdr()
    {
		 return spdr;
    }
	
	
	

}
