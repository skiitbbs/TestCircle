package ProdWebTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Admin.DocApproval;
import Admin.Login;
import Admin.OrderDelivery;
import Admin.OrderRefNumber;
import Admin.PlanSwitch;
import Pages.ChooseNumber;
import Pages.deliveryInfo;
import Pages.logIn;
import Pages.paymentPage;
import lib.ExcelData;

public class PTC10_ChooseNumber {
	
	WebDriver driver;
	//below lines of code is going to extract the information from excel file.
	//Please use(Initialize) those data only which you want to use and assign accordingly
	ExcelData data = new ExcelData();
	String url = data.getstagurl();
	String vulcan = data.getvulcanurl();

	@BeforeTest
 	private WebDriver getBrowser() 
 	{
		
	System.setProperty("webdriver.chrome.driver","//Users//sumitkumar//Downloads//Automation//chromedriver");
	driver= new ChromeDriver(); // Create a new instance for the Chrome Driver.
	//driver.manage().window().maximize();
	driver.get(url);
	
	return driver;
     }
	
	@Test
	public void chooseNumber() {
		
		logIn login = new logIn(driver);
		login.login();
		
		ChooseNumber cn = new ChooseNumber(driver);
		cn.chooseNumber();
		
		deliveryInfo di = new deliveryInfo(driver);
		di.DeliveyInfo();
		
		paymentPage pg = new paymentPage(driver);
		pg.PaymentPage();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		OrderRefNumber orn = new OrderRefNumber(driver);
		orn.orderRefnumber();
		orn.writeOrder();
		
		System.out.println("Order Ref number called in test case.");
		
		driver.get(vulcan);
		
		Login li = new Login(driver);
		li.login();
		
		DocApproval da = new DocApproval(driver);
		da.docapprove();
		
		OrderDelivery del = new OrderDelivery(driver);
		del.orderdelivery();
		
		PlanSwitch ps = new PlanSwitch(driver);
		ps.planswitch();
		
	}
	
	@AfterTest
	public void browserclose() {
		driver.close();
	}

}
