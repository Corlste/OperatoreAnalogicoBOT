package progetto.operatoreAnalogicoBOT.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/scorl/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://didattica.polito.it/portal/page/portal/home/Studente");

	}

}
