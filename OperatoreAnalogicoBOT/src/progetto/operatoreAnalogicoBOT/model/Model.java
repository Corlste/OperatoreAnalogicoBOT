package progetto.operatoreAnalogicoBOT.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import progetto.operatoreAnalogicoBOT.db.DBConnect;
import progetto.operatoreAnalogicoBOT.db.OperatoreDAO;

public class Model {
	
	OperatoreDAO dao = new OperatoreDAO();
	BrevettoScraper brevetto = new BrevettoScraper();
	DBConnect dbConn = new DBConnect();
	
	final File folder = new File("C:\\Users\\scorl\\Desktop\\Magistrale\\Secondo anno\\GISP ICT");
	
	ArrayList<String> link_brevetti = new ArrayList<String>();
	
	
	public Model(OperatoreDAO dao, BrevettoScraper brevetto, DBConnect dbConn) {
		super();
		this.dao = dao;
		this.brevetto = brevetto;
		this.dbConn = dbConn;
	}
	


	public Model() {
		super();
	}



	public void test(String azRicercata) {
		
		String partita_iva = "11111111116";
		
		String[] parole = azRicercata.split(" ");
				
		String prov="";
		for (int i=0; i<parole.length; i++) {
			if (parole[i]==parole[parole.length-1]) {
				prov = prov+parole[i];
			}else 
				prov = prov+parole[i]+"+";
		}		
//		
		String link ="https://patents.google.com/?assignee="+prov+"&oq=assignee:("+prov+")";	
		
		//String link = "https://patents.google.com/patent/EP2480734A1/en?oq=assignee:+%22proalia%22";
		String dw_link = "https://patents.google.com/xhr/query?url=assignee%3D"+prov+"%26oq%3Dassignee%3A("+prov+")&exp=&download=true";
		
				
		try {
			BrevettoScraper bs = new BrevettoScraper();
			Connection conn = dbConn.getConnection();
			dao.setConnection(conn);
			
			
			//bs.setPage(dw_link);
			
			bs.downloadCSV(dw_link, partita_iva);

			bs.modifyFileName(folder, partita_iva);
			link_brevetti = bs.get_brev_URL(partita_iva);
			
			
			
			for (String brevetto : link_brevetti) {
				bs.setPage(brevetto);
				String assignee = bs.getCurrentAssignee(partita_iva);
				System.out.println("%%%%"+assignee+"%%%%%");
				
//				if (assignee == null) 
//					continue;
				if (assignee != null && azRicercata.compareTo(assignee.trim())==0 ) {
					Brevetto brev = bs.extractBrevetto(partita_iva);
					System.out.println(brev.toString());

					dao.insertBrevetto(brev);
				}
				
				
			}
			
			
//			String titolo = bs.extractTitle();
//			dao.insertTitolo(titolo);
			
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
