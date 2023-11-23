package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesDAO extends BancoDeDados {
	
	public  boolean adicionarCliente(String nome, String cpf, int idade ) {
		try {
	      Statement st = conexao.createStatement();
	      st.executeUpdate("INSERT INTO tbl_cliente VALUES ('" +  cpf  + "','" + nome + "','" + idade + "');" );
	      
	      return true;
	    } catch (SQLException e) { 
	    	System.out.println(e.getMessage());
	    	System.out.println("Erro na Insercao no BD...");
	    	return false; 
	    }
	}
	
	public boolean verificaAluguelCpf(String cpf) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT CPF_cadastrado FROM tbl_aluguel WHERE CPF_cadastrado ='" +  cpf + "';" );
			
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
	
	public String getNome(String cpf) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT Nome_completo FROM tbl_cliente WHERE CPF ='" +  cpf + "';" );
			
			if(rs.next()) {
				return rs.getString(1);
			}else {
				return "";
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta do CPF no BD...");
			return "";
		}
		
	}
	public String getIdade(String cpf) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT idade FROM tbl_cliente WHERE CPF ='" +  cpf + "';" );
			
			if(rs.next()) {
				return rs.getString(1);
			}else {
				return "";
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta do CPF no BD...");
			return "";
		}
		
	}
	
	public String listaCliente(){
		String result = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tbl_cliente;" );
			
			while(rs.next()){
				result += "Nome: " +  rs.getString(2) + ", " + 
						 "CPF: " + rs.getString(1) + ", " +
						 "Idade: " + rs.getString(3) + "\n";
			}
			return result;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta da placa da moto no BD...");
			return "";
		}
		
	}
	public boolean verificaCpf(String cpf) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT CPF FROM tbl_cliente WHERE CPF ='" +  cpf + "';" );
			
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
	
	
	public boolean remover(String cpf){
		try {
			Statement st = conexao.createStatement();
			if(verificaCpf(cpf)) {
				st.executeUpdate("DELETE FROM tbl_cliente WHERE CPF ='" + cpf + "';");
				return true;
			}else return false;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na remoçao do aluguel no BD...");
			return false;
		}
	}

}
