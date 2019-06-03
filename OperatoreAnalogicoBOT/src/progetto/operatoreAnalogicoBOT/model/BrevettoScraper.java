package progetto.operatoreAnalogicoBOT.model;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
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
		DomElement title = page.getElementByName("DC.title");	
		//		String title = page.getTitleText();
//				getHtmlElementById("title").asText();
		System.out.println(title.getAttribute("content"));
		return title.getAttribute("content");
	}
	
		
	public Brevetto extractBrevetto() {
		String partita_iva = "11111111111";

		String title_text = page.getTitleText();
		StringTokenizer token_title = new StringTokenizer(title_text);
		String app_num = token_title.nextToken();

		String title = page.getElementByName("DC.title").getAttribute("content");

		String abstr = page.getElementByName("DC.description").getAttribute("content");
		
		String assignee =null;
		try {
		DomNode assignee_node = (DomNode) page.getByXPath("//dd[@itemprop='assigneeCurrent']").get(0);
		assignee = assignee_node.getTextContent();
		}catch(Exception e) {
		}
		
		List<DomNode> inventor_nodes = new LinkedList<DomNode>();
		for (Object n: page.getByXPath("//dd[@itemprop='inventor']")) {
			inventor_nodes.add((DomNode)n);
		}
		String inventors ="";
		for (DomNode n: inventor_nodes) {
			inventors += n.getTextContent() +", ";
		}
		
		String data = null;
		try {
		DomNode data_node = (DomNode) page.getByXPath("//time[@itemprop='publicationDate']").get(0);
		data = data_node.getTextContent();
		}catch(Exception e) {
			System.out.println("dataaaaaa");
		}
		
		List<DomNode> key_nodes = new LinkedList<DomNode>();
		for (Object n: page.getByXPath("//dd[@itemprop='priorArtKeywords']")) {
			key_nodes.add((DomNode)n);
		}
		String keywords ="";
		for (DomNode n: key_nodes) {
			keywords += n.getTextContent() +", ";
		}
	
		
		Map<DomNode,DomNode> nations_map = new HashMap<DomNode,DomNode>();
		int i=0;
		for (Object n: page.getByXPath("//li[@itemprop='application']/span[@itemprop='countryCode']")) {
			
			DomNode nat = (DomNode)n;
			Object s = page.getByXPath("//li[@itemprop='application']/span[@itemprop='legalStatusCat']").get(i); 
			DomNode status = (DomNode)s;

			nations_map.put(nat, status);

			i++;
		}		
		String nations_active ="";	
		for (DomNode dom: nations_map.keySet()) {
			if (nations_map.get(dom).getTextContent().equals("active")){
				nations_active+=dom.getTextContent() + ", ";
			}
		}
		
         
        List<DomNode> codclass_nodes = new LinkedList<DomNode>();
 		for (Object n: page.getByXPath("//li[@itemprop='cpcs']/span[@itemprop='Code']")) {
 			codclass_nodes.add((DomNode)n);
 		}
 		String codclass ="";
 		for (DomNode n: codclass_nodes) {
 			codclass += n.getTextContent() +", ";
 		}
         
				
		
				
		
		
		Brevetto brevetto = new Brevetto(partita_iva, app_num, title, assignee, inventors, data, nations_active,  abstr, codclass, keywords); 
		
		System.out.println(brevetto.toString());
		return brevetto;
					
	}
	
	
	
}
