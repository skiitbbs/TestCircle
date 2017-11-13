package Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import lib.ExcelData;

public class OrderDelivery {
	
	WebDriver pdriver;
	
	public OrderDelivery(WebDriver driver) {
		pdriver = driver;
	}
	
	public void orderdelivery() {
		pdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		ExcelData data = new ExcelData();
		String order = data.getorderno();
		
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/ul/li[4]/a\"")).click();
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/form/div[3]/div[1]/div/input")).sendKeys(order);
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[3]/button")).click();
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/div[3]/ul/li[9]/a")).click();
		pdriver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/div[3]/div/div[9]/div/div[2]/div[5]/div[2]/form[1]/input[2]")).click();
		
		Alert simpleAlert = pdriver.switchTo().alert();
		simpleAlert.accept();
		
	}

}