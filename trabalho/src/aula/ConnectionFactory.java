package aula;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//nome usuario mysql
			private static final String USERNAME= "root";
			
			//senha do banco 
			private static final String PASSWORD = "Mafemad2005!";
			
			//caminho banco de dados, porta e nome do banco de dados
			private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hist_peso";
			
			//conexão com o banco 
			public static Connection createConnectionToMySQL() throws Exception {
				//faz com que a classe seja carregada pel JVM
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
				
				return connection;
				
				
			}
			
			public static void main(String[] args) throws Exception {
				
				// recuperar uma conexão com o banco de dados 
				Connection con = createConnectionToMySQL();
				
				//testar se a conexão é nula
				if (con != null) {
					System.out.println("conexão obtida com sucesso!");
					con.close();
				}
			}
}
