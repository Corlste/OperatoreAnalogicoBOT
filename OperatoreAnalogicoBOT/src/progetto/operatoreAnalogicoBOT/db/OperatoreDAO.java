package progetto.operatoreAnalogicoBOT.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import progetto.operatoreAnalogicoBOT.model.Brevetto;

public class OperatoreDAO {
	Connection connection = null;
	
	String sqlBrevetto = "INSERT INTO `brevetti` (`p_iva`, `app_number`,`titolo`, `assegnatario`, `inventore`, `data_rilascio`, `luogo_validita` , `abstract`, `cod_classificazione`, `keywords`) VALUES (?,?,?,?,?,?,?,?,?,?);";
	String sqlTitle = "INSERT INTO 'brevetti' ('titolo') VALUES(?);";
	String sqlDelete = "TRUNCATE `brevetti`";
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	public void insertBrevetto(Brevetto b) {
		try {
			PreparedStatement stat;
			stat = connection.prepareStatement(sqlDelete);
			stat.execute();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			PreparedStatement st;
			st = connection.prepareStatement(sqlBrevetto);
			st.setString(1, b.getP_iva());
			st.setString(2, b.getApp_number());
			st.setString(3, b.getTitolo());
			st.setString(4, b.getAssegnatario());
			st.setString(5, b.getInventori());
			st.setString(6, b.getData());
			st.setString(7, b.getLuogo());
			st.setString(8, b.getAbstract_text());
			st.setString(9, b.getCodclass());
			st.setString(10, b.getKeywords());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void insertTitolo(String title) {
		try {
			PreparedStatement st = connection.prepareStatement(sqlTitle, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, title);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			System.out.println("rs");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
