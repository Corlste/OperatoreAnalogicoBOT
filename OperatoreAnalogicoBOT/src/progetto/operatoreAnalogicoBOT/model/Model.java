package progetto.operatoreAnalogicoBOT.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import progetto.operatoreAnalogicoBOT.db.DBConnect;
import progetto.operatoreAnalogicoBOT.db.OperatoreDAO;

public class Model {
	
	OperatoreDAO dao = new OperatoreDAO();
	BrevettoScraper brevetto = new BrevettoScraper();
	DBConnect dbConn = new DBConnect();
	
	
	public void test(String link) {
		try {
			BrevettoScraper bs = new BrevettoScraper();
			Connection conn = dbConn.getConnection();
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tripadvisor?user=root");
			dao.setConnection(conn);
			bs.setPage(link);
			String titolo = bs.extractTitle();
			dao.insertTitolo(titolo);
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
