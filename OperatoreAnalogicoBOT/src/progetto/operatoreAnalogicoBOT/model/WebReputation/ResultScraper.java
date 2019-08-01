package progetto.operatoreAnalogicoBOT.model.WebReputation;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import progetto.operatoreAnalogicoBOT.model.VirtualWebClient;

public class ResultScraper {
	
	
	public ResultScraper () {

	}
	
	public String getBody (String url) {
		
//		HtmlPage page = VirtualWebClient.setPage(url);
		String page_text = VirtualWebClient.setSimpletHttpRequest(url);
		System.out.println(url);
//		String firstbody = page.asText();
//		System.out.println(page_text);
		
		return page_text;
	}

}
