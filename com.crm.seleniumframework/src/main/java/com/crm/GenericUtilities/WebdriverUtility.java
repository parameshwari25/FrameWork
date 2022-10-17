package com.crm.GenericUtilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	/*This method is used to implicitwait
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void waitForpageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	/*This method is used to explicit wait it will check the particular condition
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void waitForElementToClick(WebDriver driver,WebElement Element) 
	{

		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	/*This method is used to scriptimeout
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void scriptTimeout(WebDriver driver)

	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		
	}
	/*This method is used to fluent wait it will check the particular condition
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void FluentWait(WebDriver driver,WebElement element,int pollingTime)
	{
	/*FluentWait  wait= new FluentWait(driver);
	wait.pollingEvery(Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));*/
	}
	/*This method is used to handle both keyboard and mouse 
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void Actionsclass(WebDriver driver,WebElement element)
	
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/*This method is used to mouse right click action 
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void RightClick(WebDriver driver,WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
			
	}
	/*This method is used to move the mouse from one to another
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void MoveByoffset(WebDriver driver,int x,int y )

	{
		Actions act =new Actions(driver);
		act.moveByOffset(x, x).click().perform();
			
	}
	/*This method is used to take the screen shot
	 * @return
	 * @author parameshwari
	 * 
	 */
	public String takeScreenshot(WebDriver driver,String methodname )
	{
		return null;
	}
	/*This method is used to select the drop down button 
	 * by using index no
	 * @return
	 * @author parameshwari
	 * 
	 */
	
	public void SelectMethodIndex(WebElement ele,int Indexno)
	{
		Select s =new Select(ele);
		s.selectByIndex(Indexno);
	}
	/*This method is used to select the drop down button 
	 * by using value no
	 * @return
	 * @author parameshwari
	 * 
	 */
	
	public void SelectMethodString(WebElement ele,String value)
	{
		Select s =new Select(ele);
		s.selectByValue(value);
	}
	/*This method is used to select the drop down button 
	 * by using visible text
	 * @return
	 * @author parameshwari
	 * 
	 */
	
	public void SelectMethodvisibletext(WebElement ele,String value)
	{
		Select s =new Select(ele);
		s.selectByVisibleText(value);
	}
	/*This method is used to handle alert popup 
	 * used to  accept the alert popup
	 * @return
	 * @author parameshwari
	 * 
	 */
	
	public void AlertpopupAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/*This method is used to handle alert popup 
	 * used to  dismiss that pop up
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void Alertpopupdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();

	}
	/*This method is used to frame switching
	 * used to  move to frame by using index
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void Frame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/*This method is used to frame switching
	 * used to  move to frame by frame name
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void FrameID(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	/*This method is used to frame switching
	 * used to  move to frame by using webelement
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void FrameWb(WebDriver driver,WebElement name)
	{
		driver.switchTo().frame(name);
	}
	/*This method is used to handle multiple window
	 * check the condition
	 * @return
	 * @author parameshwari
	 * 
	 */
	public void  SwitchtoWindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String>allId=driver.getWindowHandles();
		Iterator<String>it=allId.iterator();
		while(it.hasNext())
		{
			String wid=it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle))
			{
				break;
			}
		}
		
	}

	
	
}
