package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
	
	public static void main(String[] args) {
		ConnectionManager ConnectionManager = new ConnectionManager();
		
		Connection connection = ConnectionManager.connectDB();
		try {
			ConnectionManager.sqlTest(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection connectDB() {
		Connection connection = null;
		
		String url = "jdbc:oracle:thin:@oracle11g.cin.ufpe.br:1521:Instance01";
		try {
			connection = DriverManager.getConnection(url, "g181if685cc_eq03", "mriknlwk");
	        
		} catch (SQLException e) {
			e.printStackTrace(System.err);
            System.err.println("SQLState: " +
                ((SQLException)e).getSQLState());
		}
		
		return connection;
	}
	
	public void sqlTest(Connection connection) throws SQLException {
		/*podem usar esse código pra testar e depois 
		 * é só deletar, quando fizerem as consultas oficiais da entrega*/
		
		
		//<------------ DAQUI ------------>
		
		String createSQL = "CREATE TABLE Pessoa2 (Nome varchar(255))";
		String insertPessoa = "INSERT INTO Pessoa2 (Nome) values ('Vinicius')";
		String consultaSQL = "SELECT * FROM Pessoa2";
		
		Statement stmt = connection.createStatement();
        //ResultSet createResult = stmt.executeQuery(createSQL);
        //ResultSet insertResult = stmt.executeQuery(insertPessoa);
        ResultSet queryResult = stmt.executeQuery(consultaSQL);
        
        while(queryResult.next())
        {
        	System.out.println(queryResult.getString(1));
        }
		
        //<------------ ATÉ AQUI ------------> 
	}
}
