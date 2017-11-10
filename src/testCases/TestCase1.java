package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Admin.DocApproval;
import Admin.Login;
import Pages.circleSwitchFlow;
import Pages.logIn;
import Pages.mobileDevice;
import Pages.normalUser;
import Pages.paymentPage;
import Pages.portInFlow;


public class TestCase1 {
	
WebDriver driver;
	
	@BeforeTest
 	private WebDriver getBrowser() 
 	{
		
	System.setProperty("webdriver.chrome.driver","//Users//sumitkumar//Downloads//Automation//chromedriver");
	driver= new ChromeDriver(); // Create a new instance for the Chrome Driver.
	//driver.manage().window().maximize();
	//driver.get("borg.circles.asia:6180");
	driver.get("https://circles-admin:123qweAadmin@staging.circles.asia/login");
	//driver.get("https://www.circles.life/");
	
	return driver;
     }
	
	
	//@Test
	public void normalflow() {
		driver.get("https://staging.circles.asia/login");
		
		logIn login = new logIn(driver);
		login.login();
		
		normalUser nu = new normalUser(driver);
		nu.NormalUser();
		
		paymentPage pg = new paymentPage(driver);
		pg.PaymentPage();
		
		//login.logout();
	}
	
	//@Test
	public void testcase2() {
		driver.get("https://staging.circles.asia/login");
		
		logIn login = new logIn(driver);
		login.login();
		
		mobileDevice md = new mobileDevice(driver);
		//md.fullpayment();
		//md.installment();
		md.splitpayment();
		
		
	}
	
	/*
	/@Test
	public void testcase2() {
		
		driver.get("https://www.circles.life/");
		signUp signup = new signUp(driver);
		signup.signup();
	}
	*/
	
	
	
	//@Test
	public void CirclesSwitch() {
		
		//driver.get("https://circles-admin:123qweAadmin@staging.circles.asia/switch/login");
		driver.get("https://staging.circles.asia/switch/plan");
		//driver.get("https://www.circles.life/");
		
		
		circleSwitchFlow csf = new circleSwitchFlow(driver);
		csf.CircleSwitchFlow();
		
		paymentPage pg = new paymentPage(driver);
		pg.PaymentPage();
		
	}
	
	
	
	@Test
	public void portinUser() {
		
		driver.get("https://staging.circles.asia/login");
		
		logIn login = new logIn(driver);
		login.login();
		
		portInFlow pf = new portInFlow(driver);
		pf.portin();
		
		paymentPage pg = new paymentPage(driver);
		pg.PaymentPage();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
	@AfterTest
	public void browserclose() {
		driver.close();
	}
	
}
