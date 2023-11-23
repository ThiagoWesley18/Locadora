package bd;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AluguelDAO extends BancoDeDados{

	public  boolean adicionarAluguel(String placa, String cpf, String nome, int idade, String retirada, String devoluçao, String opçao,int valor ) {
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO tbl_aluguel VALUES ('" +placa
	    		  											   	 + "','" + cpf 
	    		  											   	 + "','" + nome
	    		  											     + "','" + idade 
		      													 + "','" + retirada 
		      													 + "','" + devoluçao
		      													 + "','" + opçao
		      													 + "','" + valor
		      													 + "');" );
	      
	      return true;
	    } catch (SQLException e) { 
	    	System.out.println(e.getMessage());
	    	System.out.println("Erro na Insercao no BD...");
	    	return false; 
	    }
	}
	
	public String motosDisponivel(){
		try {
			String result = "";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM motos WHERE placa NOT IN (SELECT Placa_Moto_Alugado FROM tbl_aluguel);" );
			
			while(rs.next()) {
				result += "Placa: " + rs.getString(1) + ", " +
					   "Marca: " + rs.getString(2) + ", " + 
					   "Valor: R$" + rs.getString(9) + "\n";
				
			}
			return result;
	    } catch (SQLException e) { 
	    	System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta de motos disponiveis no BD...");
	    	return "";
	    }
	}
	
	public String motosAlugadas(){
		try {
			String result = "";
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tbl_aluguel;" );
			
			if(rs.next()) {
				
				ResultSet re = st.executeQuery("SELECT * FROM tbl_aluguel;" );
				while(re.next()){
					result += "Placa: " + re.getString(1) + ", " +
							"Nome: " + re.getString(3) + ", " + 
							"CPF: " + re.getString(2) + ", " +
							"Valor: R$" + re.getString(8) +"\n";
				}
			}else {
				
				result = "Sem motos alugadas.";
				
			}
			return result;
	    } catch (SQLException e) { 
	    	System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta de motos disponiveis no BD...");
	    	return "";
	    }
	}
	
	public boolean verificaAluguel(String placa) {
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
	    	System.out.println("Erro na consulta do aluguel da moto no BD...");
			return false;
		}
	}

	
	public String listaAluguel(){
		String result = "";
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tbl_aluguel;" );
			
			while(rs.next()){
				result += "Placa da Moto: " +  rs.getString(1) + ", " + 
						 "Nome: " + rs.getString(3) + ", " +
						 "Valor do Aluguel: R$" + rs.getString(8) + "\n";
			}
			return result;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na listagem da moto no BD...");
			return "";
		}
	}
	
	public boolean remover(String placa){
		try {
			Statement st = conexao.createStatement();
			if(verificaAluguel(placa)) {
				st.executeUpdate("DELETE FROM tbl_aluguel WHERE Placa_Moto_Alugado ='" + placa + "';");
				return true;
			}else return false;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na remoçao do aluguel no BD...");
			return false;
		}
	}
	
	public int valorMoto(String placa, String opçao, String retirada, String dev) {
		int valor = 0;
		int valorDia = 0;
		int dia = Integer.parseInt(dev.split("/")[0]) - Integer.parseInt(retirada.split("/")[0]);
		int mes = (Integer.parseInt(dev.split("/")[1]) - Integer.parseInt(retirada.split("/")[1])) * 30;
		int ano = (Integer.parseInt(dev.split("/")[2]) - Integer.parseInt(retirada.split("/")[2])) * 365;
		
		switch(opçao) {
		case "Combustível pré-pago": valor += 150;break;
		case "Aluguel da Jaqueta": valor += 80;break;
		case "Seguro": valor += 800;break;
		}
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM motos WHERE placa ='" +  placa + "';" );
			if(rs.next()) {
				valorDia = rs.getInt(9) ;
			}
			valor += (dia+mes+ano)*valorDia;
			return valor;
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    	System.out.println("Erro na consulta do valor da moto no BD...");
			return 0;
		}
	}
	
	 public static boolean isDataValida(String data) {
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 formato.setLenient(false);
	        try {
	            formato.parse(data);

	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	 }
	 
	 public static int numLinhaTabelaAluguel(){
	        try{
	            int numLinhas = 0;
	            Statement st = conexao.createStatement();
	            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_aluguel");

	            while(rs.next()){
	                numLinhas++;
	            }
	            return numLinhas;
	        }catch (SQLException e) { return 0; }
	 }
	 
	 public static Object[][] tabelaAluguel() {
		 try{
			 Object[][] dados = new Object[numLinhaTabelaAluguel()][8];
			 int i = 0;
			 Statement st = conexao.createStatement();
	         ResultSet rs =  st.executeQuery("SELECT * FROM tbl_aluguel");
	         
	         while(rs.next()){
	        	for(int j = 0; j < 8; j++) {
	        		dados[i][j] = rs.getString(j+1);
	        	}
	        	i++;
	         }
	         return dados;
	     }catch (SQLException e) { 
	    	return null ;
	     }
	 }
	 
	 public static String valorTotal() {
		 String result = "0";
			try {
				Statement st = conexao.createStatement();
				ResultSet rs = st.executeQuery("SELECT valor_total_pago FROM tbl_aluguel;" );
				int valor = 0;
				while(rs.next()){
					valor += rs.getInt(1);
				}
				result = String.valueOf(valor);
				return result;
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
		    	System.out.println("Erro na listagem da moto no BD...");
				return "0";
			}

	 }

}
