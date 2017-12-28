package WebsiteTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Admin.DocApproval;
import Admin.Login;
import Admin.OrderDelivery;
import Admin.OrderRefNumber;
import Admin.PlanSwitch;
import Pages.logIn;
import Pages.mobileDevice;
import Pages.normalUser;
import Pages.paymentPage;
import lib.ExcelData;

public class TC5_SimAndPhone {
	
	WebDriver driver;
	ExcelData data = new ExcelData();
	String Auth = data.getauthurl();
	String url = data.getstagurl();
	String borgurl = data.getborgurl();
	/*
	String url = data.getprodurl();
	String vulcurl = data.getvulcanurl();
	String rikerurl = data.getrikerurl();
	String kirkurl = data.getkirkurl();
	*/
	
	@BeforeTest
 	private WebDriver getBrowser() 
 	{
		
	System.setProperty("webdriver.chrome.driver","//Users//sumitkumar//Downloads//Automation//chromedriver");
	driver= new ChromeDriver(); // Create a new instance for the Chrome Driver.
	//driver.manage().window().maximize();
	driver.get(Auth);
	driver.get(url);
	
	return driver;
     }
	
	@Test
	public void simandphone() {
		
		logIn login = new logIn(driver);
		login.login();
		
		mobileDevice md = new mobileDevice(driver);
		md.before();
		md.fullpayment();
		md.after();
		
		normalUser nu = new normalUser(driver);
		nu.NormalUser();
		
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
		
		driver.get(borgurl);
		
		Login li = new Login(driver);
		li.login();
		
		DocApproval da = new DocApproval(driver);
		da.docapprove();
		
		OrderDelivery del = new OrderDelivery(driver);
		del.orderdelivery();
		
		PlanSwitch ps = new PlanSwitch(driver);
		ps.planswitch();
		
		//login.logout();
		
	}

}