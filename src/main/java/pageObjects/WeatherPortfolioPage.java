package pageObjects;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPortfolioPage {
	
public WebDriver driver;
	
	public WeatherPortfolioPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//p[@class='product-name']")
	
	@FindBy(xpath="//section//div[1]//a[@href='explore_portfolio/1']")
	WebElement CustomizePortfolio;
	
	
	public ExplorePortfolioPage weatherPortfolio()
    {
		CustomizePortfolio.click();
		 ExplorePortfolioPage ep=new ExplorePortfolioPage(driver);
		 return ep;
    }
	
}


