package progetto.operatoreAnalogicoBOT.model;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		String link = "https://patents.google.com/patent/US20070017957?oq=assignee:+(fondazione%2btorino%2bwireless)";
		model.test(link);
		

		
		
	}
	
	

}
