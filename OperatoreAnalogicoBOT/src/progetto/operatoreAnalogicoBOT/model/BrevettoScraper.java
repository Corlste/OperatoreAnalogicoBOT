package progetto.operatoreAnalogicoBOT.model;
import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;

public class BrevettoScraper {
	
	static WebClient webClient;
	String pageURL;
	
	public BrevettoScraper() {
		webClient = new WebClient(BrowserVersion.CHROME);
		try {
			this.pageURL=webClient.getPage("https://www.google.com/?tbm=pts");
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
