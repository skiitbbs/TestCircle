package Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import lib.ExcelData;

//import lib.ExcelData;

public class PlanSwitch {
	
	WebDriver pdriver;
	public String order;
	
	public PlanSwitch(WebDriver driver) {
		pdriver = driver;
	}
	
	public void planswitch() {
		pdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/ul/li[4]/a")).click();
		
		ExcelData data = new ExcelData();
		String order = data.getorderno();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/form/div[3]/div[1]/div/input")).sendKeys(order);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[3]/button")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)pdriver;
		jse.executeScript("window.scrollBy(0,400)", "");
		
		pdriver.findElement(By.xpath("//*[@id=\"order_detail_quick_view_details\"]/div[3]/ul/li[9]/a")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		jse.executeScript("window.scrollBy(0,1000)", "");
		
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/div[3]/div/div[9]/div/div[2]/div[7]/div[2]/form/input[2]")).click();
		
		Alert simpleAlert = pdriver.switchTo().alert();
		simpleAlert.accept();
		
	}

}
