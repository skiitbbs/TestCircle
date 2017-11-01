package lib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebDriver;

public class uploadFile {
	
	public WebDriver pdriver;
	public Robot robot;
		
		public uploadFile(WebDriver driver) {
			pdriver = driver;
		}
		
		
		public void Uploadfile() {
			
			File file = new File("//Users//sumitkumar//Desktop//Screenshots//Screenshot.png");
			 
			StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
			 
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			 
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			// Cmd + Tab is needed since it launches a Java app and the browser looses focus
			
			
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(500);
			 
			//Open Goto window
			 
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_G);
			robot.delay(1000);
			
			//Paste the clipboard value
			 
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_META);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(1000);
			//Press Enter key to close the Goto window and Upload window
			 
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			
			robot.keyPress(KeyEvent.VK_ENTER); 
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			
			
		}
		
		public void pagescroll() {
			
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		
	
}