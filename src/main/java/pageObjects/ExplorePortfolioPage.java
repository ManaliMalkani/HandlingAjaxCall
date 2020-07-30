package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePortfolioPage {
	
	
	public WebDriver driver;
	
	public ExplorePortfolioPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//p[@class='product-name']")
	
	@FindBy(xpath="//a[text()='Customise']")
	WebElement CustomiseButton;
	
	@FindBy(xpath="//input[@data-isin='SPY']")
	WebElement Slider;
	
	@FindBy(xpath="//a[text()='Rebalance']")
	WebElement Rebalance;
	
	@FindBy(xpath="//a[text()='Invest Now']")
	WebElement InvestNow;
	
	@FindBy(xpath="//a[text()='Reset']")
	WebElement ResetButton;
	
	@FindBy(xpath="//div[text()='US EQUITIES']/following-sibling::div//a[text()='+ Add Stock']")
	WebElement AddStock;
	
	@FindBy(xpath="//button[@data-isin='BT' and text()='Add Stock' and @data-allocation-name='US EQUITIES']")
	WebElement AddBTStock;
	
	@FindBy(xpath="//*[@id='modal-1']//button[@data-dismiss='modal' and text()='Done']")
	WebElement Done;
	
	@FindBy(xpath="//*[@id='customise-portfolio']/div/div[2]/div/div[3]/div/div[15]/div[3]/a")
	WebElement BT;
	
	
	
	
	public WebElement CustomiseButton()
    {
		 return CustomiseButton;
    }
	
	public WebElement Slider()
    {
		 return Slider;
    }
	
	public WebElement Rebalance()
    {
		 return Rebalance;
    }
	
	public WebElement ResetButton()
    {
		 return ResetButton;
    }
	
	public WebElement AddStock()
    {
		 return AddStock;
    }
	
	public WebElement AddBTStock()
    {
		 return AddBTStock;
    }
	public WebElement Done()
    {
		 return Done;
    }
	public WebElement BT()
    {
		 return BT;
    }
	
	public SuggestionsPage InvestNow()
    {
		InvestNow.click();
		SuggestionsPage sp=new SuggestionsPage(driver);
		 return sp;
		
    }

}
