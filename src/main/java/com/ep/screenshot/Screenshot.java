package com.ep.screenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {

	public static void main(String a[]) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		System.out.println("in method=========================");

		System.out.println(driver);
		driver.get("http://google.co.in");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "\\screenShot1.png"));
			System.out.println("Screenshot is captured and stored in your "
					+ System.getProperty("user.dir") + "\\screenShot1.png");

		} catch (Exception e) {
			System.out.println("Error in loading the Google page");
		}
		driver.quit();
	}

}