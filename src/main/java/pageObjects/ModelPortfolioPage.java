package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModelPortfolioPage {
	
	
	public WebDriver driver;
	
	public ModelPortfolioPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//p[@class='product-name']")
	
	@FindBy(css="#btn-explore79")
	WebElement weatherPortfolio;
	
	@FindBy(xpath="//ul[@class='model-portfolio-navs hidden-sm hidden-xs']//a[@href='#selected-model-portfolios']")
	WebElement Recommend;
	
	@FindBy(xpath="//ul[@class='model-portfolio-navs mobile hidden-md hidden-lg']//a[@href='#selected-model-portfolios']")
	WebElement RecommendSizeChange;
	
	@FindBy(xpath="//ul[@class='model-portfolio-navs hidden-sm hidden-xs']//a[@href='#remaining-model-portfolios']")
	WebElement Others;
	
	@FindBy(xpath="//ul[@class='model-portfolio-navs mobile hidden-md hidden-lg']//a[@href='#remaining-model-portfolios']")
	WebElement OthersSizeChange;
	
	
	public WebElement Recommend() {
		return Recommend;
	}
	
	public WebElement RecommendSizeChange() {
		return RecommendSizeChange;
	}
	
	
	public WebElement Others() {
		return Others;
	}
	
	public WebElement OthersSizeChange() {
		return OthersSizeChange;
	}
	
	
	public WeatherPortfolioPage weatherPortfolio()
    {
		weatherPortfolio.click();
		 WeatherPortfolioPage wp=new WeatherPortfolioPage(driver);
		 return wp;
    }
	
	
	

}
