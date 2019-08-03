package progetto.operatoreAnalogicoBOT.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import progetto.operatoreAnalogicoBOT.db.DBConnect;
import progetto.operatoreAnalogicoBOT.db.OperatoreDAO;
import progetto.operatoreAnalogicoBOT.model.Patent.Brevetto;
import progetto.operatoreAnalogicoBOT.model.Patent.PatentUnit;
import progetto.operatoreAnalogicoBOT.model.WebReputation.WebRepUnit;

public class Model {
	
	private WebRepUnit webUnit;
	private PatentUnit patentUnit;
	private OperatoreDAO opDAO;
//	private VirtualWebClient VWClient;
	
	
	public Model (boolean connect_to_db) {
		
		this.webUnit = new WebRepUnit();
		this.patentUnit = new PatentUnit();
		this.opDAO = new OperatoreDAO();
//				this.vwClient = new VirtualWebClient();
		
		// DATABASE CONNECTION ////////////////////////////////////////////
		if (connect_to_db) {
			Connection con = DBConnect.getConnection();
			opDAO.setConnection(con);
		}
		
	}
	
	
	// PATENTS MODULE //////////////////////////////////////////////// PATENTS MODULE ////////////////
	
	public void patents_test (Azienda azienda) {
		
//		ArrayList<Brevetto> patents = patentUnit.searchForGooglePatents(azienda);
		ArrayList<Brevetto> patents = patentUnit.searchForEPOPatents(azienda);
		
//		for (Brevetto b : patents) {
//			opDAO.insertBrevettoFromGpatent(b);
//		}
		
		for (Brevetto b : patents) {
			opDAO.insertEPOpatent(b);
		}
		
	}
	
	
	// WEB REP MODULE //////////////////////////////////////////////// WEB REP MODULE ////////////////
	public void webReputation_test (Azienda azienda) {
		webUnit.getReputation(azienda);
		
		for (Risultato res : azienda.getArticoli()) {
			opDAO.insertArticle(res);
		}
		
	}


	
}
