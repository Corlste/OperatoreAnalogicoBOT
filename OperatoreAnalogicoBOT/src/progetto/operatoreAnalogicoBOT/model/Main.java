package progetto.operatoreAnalogicoBOT.model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {
	
	

	public static void main(String[] args) {
		
		Model model = new Model(true); // IF FALSE, DOES NOT CONNECT TO DB
		
		String nomeAzienda = "sea marconi technologies";
		String partitaIVA = "11111111111";
		String ragioneSociale = "";
		
		Azienda az_test = new Azienda (nomeAzienda, partitaIVA, ragioneSociale);
		
		
//		model.patents_test(az_test); // DECOMMENTARE PER BREVETTI
		
		
		model.webReputation_test(az_test); // DECOMMENTARE PER REPUTATION
		
		
		

		
		
	}
	
	

}
