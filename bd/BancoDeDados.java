package bd;

import java.sql.*;

public class BancoDeDados {
	private static String url = "jdbc:mysql://localhost:3306/locadorabd";
	private static String user = "user_locadora";
	private static String pass = "password";
	protected static Connection conexao = null;
	
	public BancoDeDados() {
	    if (conexao == null) conecta();
	  }

	private static boolean conecta() {
		try {
			conexao = DriverManager.getConnection(url, user, pass);
			return true;
	    } catch (SQLException e) { 
	    	System.out.println("Erro na conexao com o BD...");
	    	return false; 
	    }
	}
	
	public static boolean desconecta() {
	    try {
	    	conexao.close();
	    	return true;
	    } catch (SQLException e) { return false; }
	}


	
	
}
