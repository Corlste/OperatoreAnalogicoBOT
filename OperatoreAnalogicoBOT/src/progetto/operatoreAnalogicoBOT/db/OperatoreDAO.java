package progetto.operatoreAnalogicoBOT.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import progetto.operatoreAnalogicoBOT.model.Brevetto;

public class OperatoreDAO {
	Connection connection = null;
	
	String sqlBrevetto = "INSERT INTO 'brevetti' (bla bla bla)";
	String sqlTitle = "INSERT INTO 'brevetti' ('titolo') VALUES(?);";
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void insertBrevetto(Brevetto brevetto) {
		
		///////////////////
		//assignee: (fondazione+torino+wireless)
		//////////////////
		////////////////
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
