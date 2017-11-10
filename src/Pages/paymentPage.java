package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import lib.ExcelConfig;

public class paymentPage {
	
	WebDriver pdriver;
	
	public paymentPage(WebDriver driver) {
		pdriver = driver;
	}
	
	public void PaymentPage() {
		
		ExcelConfig excel = new ExcelConfig("/Users/sumitkumar/eclipse-workspace/CirclesLife/src/Test Data.xlsx");
		String visa = excel.getData(0, 11, 1);
		String.valueOf(visa);
		String cvv = excel.getData(0, 12, 1);
		String name = excel.getData(0, 13, 1);

		pdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		pdriver.findElement(By.xpath("//*[@id=\'logo\']")).click();
		pdriver.findElement(By.xpath("//*[@id=\'creditCardNum\']")).sendKeys(visa);
		
		WebElement month = pdriver.findElement(By.xpath("//select[@name='expMonth']")); Select ExpMon = new Select(month); ExpMon.selectByValue("06");
		WebElement year = pdriver.findElement(By.xpath("//select[@name='expYear']")); Select ExpYear = new Select(year); ExpYear.selectByValue("22");
		
		pdriver.findElement(By.xpath("//input[@id='creditCardCvv2']")).sendKeys(cvv);
		pdriver.findElement(By.xpath("//*[@id=\'creditCardName\']")).sendKeys(name);
		
		pdriver.findElement(By.xpath("//*[@id=\'submitBtn\']")).click();
		
	}

	
}
