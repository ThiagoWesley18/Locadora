package bd;

import java.sql.*;

public class MotosDAO extends BancoDeDados {
	
	
	public  boolean adicionarMotos(String placa ,String marca, String categoria, String dimensao, String acessorio, int custo, String motor, int tanque, int consumo) {
	    try {
	      Statement st = conexao.createStatement();
	      st.executeUpdate("INSERT INTO motos  VALUES ('" +  placa + "','" + marca + "','" + categoria + "','" + acessorio + "','" +
	      dimensao + "','" + motor + "','" + tanque + "','" + consumo + "','" + custo + "');" );
	      
	      return true;
	    } catch (SQLException e) { 
	    	System.out.println(e.getMessage());
	    	System.out.println("Erro na Insercao no BD...");
	    	return false; 
	    }
	  }
	
	public boolean updateValor(String placa, String valor) {
	    try {
	      Statement st = conexao.createStatement();
	      st.executeUpdate("UPDATE motos SET custo ='"+  valor + "'WHERE placa ='"+ placa+"';");
	      return true;
	      
	    } catch (SQLException e) { 
	    	System.out.println(e.getMessage());
	    	System.out.println("Erro na Insercao no BD...");
	    	return false; 
	    }
	  }
	
	public boolean verificaMoto(String placa) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT placa FROM motos WHERE placa ='" +  placa + "';" );
			
			if (rs.next()) {
				if( rs.getString(1) != null) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta da placa da moto no BD...");
			return false;
		}
		
	}
	
	public boolean verificaAluguelMoto(String placa) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT Placa_Moto_Alugado FROM tbl_aluguel WHERE Placa_Moto_Alugado ='" +  placa + "';" );
			
			if (rs.next()) {
				if( rs.getString(1) != null) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta do aluguel pelo CPF do Cliente no BD...");
			return false;
		}
	}
	
	
	
	public String listaMotos(){
		String result = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM motos;" );
			
			while(rs.next()){
				result += "Placa: " +  rs.getString(1) + ", " + 
						 "Marca: " + rs.getString(2) + ", " +
						 "Valor: R$" + rs.getString(9) + "\n";
			}
			return result;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta da placa da moto no BD...");
			return "";
		}
		
	}
	
	public boolean remover(String placa){
		try {
			Statement st = conexao.createStatement();
			if(verificaMoto(placa)) {
				st.executeUpdate("DELETE FROM motos WHERE placa ='" + placa + "';");
				return true;
			}else return false;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na remoçao do aluguel no BD...");
			return false;
		}
	}

}
