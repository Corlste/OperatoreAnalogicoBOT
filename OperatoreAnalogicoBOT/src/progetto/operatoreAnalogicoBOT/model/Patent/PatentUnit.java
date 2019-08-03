package progetto.operatoreAnalogicoBOT.model.Patent;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import progetto.operatoreAnalogicoBOT.db.DBConnect;
import progetto.operatoreAnalogicoBOT.db.OperatoreDAO;
import progetto.operatoreAnalogicoBOT.model.Azienda;

public class PatentUnit {
	
	ArrayList<String> link_brevetti = new ArrayList<String>();
	final private String authentication = "Bearer LyKxlDIoVT6YzHFSxTrK73CyDOAe";
	
	final String CSV_folder = "C:\\Users\\Fabio\\Documents\\GitHub\\OperatoreAnalogicoBOT\\CSV_Downloads\\";
	final File folder = new File(CSV_folder);
	
	
	public PatentUnit() {
		
	}

	public ArrayList<Brevetto> searchForGooglePatents(Azienda azienda) {
		
		ArrayList<Brevetto> patents = new ArrayList<Brevetto>();
		
		String dw_link = this.downloadLinkGeneration(azienda.getNomeAzienda());		
		
		BrevettoScraper bs = new BrevettoScraper();
		
		// DOWNLOAD CSV, MODIFICA IL NOME DEL CSV CON pIVA, PRENDE LISTA LINK DEI BREVETTI
		bs.downloadCSV(dw_link, azienda.getPartitaIVA(), CSV_folder);
		bs.modifyFileName(folder, azienda.getPartitaIVA(), CSV_folder);
		link_brevetti = bs.getPatentsURLs(azienda.getPartitaIVA(), CSV_folder);
					
		
		// PER OGNI BREVETTO CERCA LE INFO SU G_Patents
		for (String url_brevetto : link_brevetti) {
			bs.setPage(url_brevetto);
			String assignee = bs.getCurrentAssignee();
			System.out.println("%%%%"+assignee+"%%%%%");
				
			if (this.checkAssignee(azienda, assignee)) {
				Brevetto brev = bs.extractBrevetto(azienda.getPartitaIVA());
				System.out.println(brev.toString());

				patents.add(brev);
			}				
		}
			
		return patents;
		
	}
	
	
	public ArrayList<Brevetto> searchForEPOPatents(Azienda azienda) {
		
		ArrayList<Brevetto> patents = new ArrayList<Brevetto>();		
		
		EPOWebService epoService = new EPOWebService (this.authentication);
		
		patents = epoService.getPatents(azienda.getNomeAzienda(), azienda.getRagioneSociale());
		
		for (Brevetto b : patents) {
			epoService.getPatentInfo(b);
			patents.add(b);
		}
		
		azienda.insertBrevetti(patents);
		
//		// PER OGNI BREVETTO CERCA LE INFO SU G_Patents
//		for (String url_brevetto : link_brevetti) {
//			bs.setPage(url_brevetto);
//			String assignee = bs.getCurrentAssignee();
//			System.out.println("%%%%"+assignee+"%%%%%");
//				
//			if (this.checkAssignee(azienda, assignee)) {
//				Brevetto brev = bs.extractBrevetto(azienda.getPartitaIVA());
//				System.out.println(brev.toString());
//
//				patents.add(brev);
//			}				
//		}
//			
		return patents;
		
	}
	
	
	
	private boolean checkAssignee (Azienda az, String as) {
		
		if (as == null) return false;
		
		String azienda = az.getNomeAzienda().toUpperCase();
		String assignee = as.trim().toUpperCase();
		String ragione = az.getRagioneSociale().replace(".", "").toUpperCase();
		
		if (azienda.compareTo(assignee)==0) return true;
		
		if (assignee.contains(azienda+" "+ragione)) return true;
		
		return false;
	}
	
	
	
	
	private String downloadLinkGeneration (String nome) {
		
		// DOWNLOAD LINK GENERATION
			String[] parole = nome.split(" ");
						
			String prov="";
			for (int i=0; i<parole.length; i++) {
				if (parole[i]==parole[parole.length-1]) {
					prov = prov+parole[i];
				}else 
					prov = prov+parole[i]+"+";
			}		
				
			//String gSearchLink ="https://patents.google.com/?assignee="+prov+"&oq=assignee:("+prov+")";	
			//String patentLink = "https://patents.google.com/patent/EP2480734A1/en?oq=assignee:+%22proalia%22";
			String dw_link = "https://patents.google.com/xhr/query?url=assignee%3D"+prov+"%26oq%3Dassignee%3A("+prov+")&exp=&download=true";
			return dw_link;
		
	}

}
