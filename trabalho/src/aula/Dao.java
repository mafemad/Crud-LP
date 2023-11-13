package aula;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Dao {
	
	public void inserir(HistoricoPeso peso) {
		
		String sql = "INSERT INTO historico(dataCadastro, peso) VALUES (?, ?) ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar um conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//executa uma query
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1, new Date(peso.getData().getTime()));
			pstm.setDouble(2, peso.getPeso());
			
			//executa a query
			pstm.execute();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			//fecha conexão
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<HistoricoPeso> consultar(){
		String sql = "SELECT * FROM historico";
		List<HistoricoPeso> historico = new ArrayList<HistoricoPeso>(); 
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		//Classe que recupera os dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				HistoricoPeso peso = new HistoricoPeso();
				
				peso.setId(rset.getInt("id"));
				peso.setData(rset.getDate("dataCadastro"));
				peso.setPeso(rset.getDouble("peso"));
				
				historico.add(peso);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return historico;
		}
	
	public void atualizar(HistoricoPeso peso){
		String sql = "UPDATE historico SET dataCadatro = ?, peso = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1, new Date(peso.getData().getTime()));
			
			pstm.setDouble(2, peso.getPeso());
			
			pstm.setInt(3, peso.getId());
			
			pstm.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
	public void deletarId(int id) {
		String sql = "DELETE FROM historico WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
}


