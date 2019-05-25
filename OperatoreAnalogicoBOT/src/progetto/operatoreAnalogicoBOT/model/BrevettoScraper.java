package progetto.operatoreAnalogicoBOT.model;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class BrevettoScraper {
	
	static WebClient webClient;
	String pageURL;
	HtmlPage page;
	
	public BrevettoScraper() {
		webClient = new WebClient();
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
		String title = page.getHtmlElementById("title").asText();
		return title;
	}
	
	
	
}
