package progetto.operatoreAnalogicoBOT.model;
import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class BrevettoScraper {
	
	static WebClient webClient;
	String pageURL;
	HtmlPage page;
	
	public BrevettoScraper() {
		try {
		webClient = new WebClient();
		}catch(Exception e) {
			
			System.out.println("aaaaaaaa non riesco a aprirti il webclient");
			e.printStackTrace();
		}
	}
		
		
	
//		---------------
//		System.setProperty("webdriver.chrome.driver", "/Users/scorl/Desktop/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://didattica.polito.it/portal/page/portal/home/Studente");
//		--------------------
		


	public void setPage(String s) {
		try {
			this.pageURL=s;
			this.page=webClient.getPage(s);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public String extractTitle() {
//		String title = page.querySelector(".title").getNodeValue();
		String title = page.getTitleText();
//				getHtmlElementById("title").asText();
		System.out.println(title);
		return title;
	}
	
	
	
}
