package sfoDemo;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.ExplorePortfolioPage;
import pageObjects.ModelPortfolioPage;
import pageObjects.SuggestionsPage;
import pageObjects.WeatherPortfolioPage;
import resources.base;

public class TestCases extends base {

	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver=initializeDriver();	
		
				
	}
		
   @Test
    public void TC01() throws IOException, InterruptedException
    {
    	
    	
		driver.get(prop.getProperty("url"));
		ModelPortfolioPage mp= new ModelPortfolioPage(driver);
		//Thread.sleep(5000);
		mp.weatherPortfolio();
		WeatherPortfolioPage wp= new WeatherPortfolioPage(driver);
		wp.weatherPortfolio();
		ExplorePortfolioPage ep= new ExplorePortfolioPage(driver);
		ep.CustomiseButton().click();
		System.out.println(ep.Slider().getAttribute("value"));
		Actions action=new Actions(driver);
		action.click(ep.Slider()).build().perform();
		for (int i = 0; i < 10; i++) 
	    {
	        action.sendKeys(Keys.ARROW_RIGHT).build().perform();
	        Thread.sleep(200);
	        if(ep.Slider().getAttribute("value").equals("50"))
	        break;
	    }
		ep.Rebalance().click();
		ep.InvestNow();
		SuggestionsPage sp=new SuggestionsPage(driver);
		String text=sp.spdr().getText();
		System.out.println(text);
		//Assert.assertEquals("50", "text");
		
    }
    @Test
    public void TC02() throws IOException, InterruptedException
    {
    	
    	boolean flag=false;
		driver.get(prop.getProperty("url"));
		ModelPortfolioPage mp= new ModelPortfolioPage(driver);
		//Thread.sleep(5000);
		mp.weatherPortfolio();
		WeatherPortfolioPage wp= new WeatherPortfolioPage(driver);
		wp.weatherPortfolio();
		ExplorePortfolioPage ep= new ExplorePortfolioPage(driver);
		ep.CustomiseButton().click();
		String text =ep.ResetButton().getText();
		if(text.equals("Reset"))
			flag=true;
		else 
			flag=false;
		Assert.assertTrue(flag);
		ep.AddStock().click();
		Actions action=new Actions(driver);
		for (int i = 0; i < 10; i++) 
	    {
	        action.sendKeys(Keys.ARROW_DOWN).build().perform();
	         if(ep.AddBTStock().isDisplayed())
	        	break;
	        Thread.sleep(2000);
	    }
		//action.click(ep.AddBTStock()).build()
        ep.AddBTStock().click();
        Thread.sleep(2000);
        ep.Done().click();
        Thread.sleep(2000);
        boolean result=ep.BT().isDisplayed();
        Assert.assertTrue(result);
    }
   
    @Test
    public void TC03() throws IOException, InterruptedException
    {
    	driver.get(prop.getProperty("url"));
    	ModelPortfolioPage mp= new ModelPortfolioPage(driver);
    	String ExpectedRecommendMsg="3 Portfolio recommendations based on your preferences";
    	String ExpectedOthersMsg="15 other portfolio choices available";
    	String ExpectedRecommendMsgSizeChange="Recommended (3)";
    	String ExpectedOthersMsgSizeChange="Others (15)";
    	String actualRecommendMsgText=mp.Recommend().getText();
    	String recommend=actualRecommendMsgText.split(" ")[0];
    	String actualOthersText=mp.Others().getText();
    	String others=actualOthersText.split(" ")[0];
  
    	
		Dimension d = new Dimension(375,667);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(d);
        System.out.println(driver.manage().window().getSize());
        String actualRecommendMsgTextSizeChange=mp.RecommendSizeChange().getText();
    	String rec=actualRecommendMsgTextSizeChange.split(" ")[1];
    	rec=rec.replace("(","");
    	String recommendSizeChange=rec.replace(")","");
    	String actualOthersMsgTextSizeChange=mp.OthersSizeChange().getText();
    	String oth=actualOthersMsgTextSizeChange.split(" ")[1];
    	oth=oth.replace("(","");
    	String otherssizeChange=oth.replace(")","");
    	
    	Assert.assertEquals(ExpectedRecommendMsg, actualRecommendMsgText);
    	Assert.assertEquals(ExpectedOthersMsg, actualOthersText);
    	Assert.assertEquals(ExpectedRecommendMsgSizeChange, actualRecommendMsgTextSizeChange);
    	Assert.assertEquals(ExpectedOthersMsgSizeChange, actualOthersMsgTextSizeChange);
    	Assert.assertEquals(recommend, recommendSizeChange);
    	Assert.assertEquals(others, otherssizeChange);
		
    }
    	@AfterMethod
		public void AfterMethod() {
			driver.close();
			
		}
		

}