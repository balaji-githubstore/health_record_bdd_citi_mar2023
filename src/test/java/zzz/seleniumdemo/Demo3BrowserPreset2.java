package zzz.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demo3BrowserPreset2 {
	
	public static void main(String[] args) {
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("--disable-notifications");
		opt.addArguments("--Headless");
		
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
