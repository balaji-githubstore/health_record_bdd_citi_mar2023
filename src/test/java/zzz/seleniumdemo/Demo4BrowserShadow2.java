package zzz.seleniumdemo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demo4BrowserShadow2 {
	
	public static void main(String[] args) {
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("--disable-notifications");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "C:\\");

		opt.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://www.selenium.dev/downloads");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.partialLinkText("32")).click();
		
		//open new tab in current browser
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("chrome://downloads/");
		
//		String actualText=driver.findElement(By.id("show")).getText();
//		System.out.println(actualText);
		//driver.quit();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		String output=js.executeScript
				("return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#show\").innerText").toString();
		
		System.out.println(output);
	
	}

}





