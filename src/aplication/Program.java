package aplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//conecta o banco
		Connection conn = null;
		
		//consulta todos os departamento no banco de dados
		Statement st = null;
		
		//resultado da consulta 
		ResultSet rs = null;
		
		try {
			
			conn = DB.getConnection();
			st = conn.createStatement();
			
			//
			rs = st.executeQuery("Select * from department");
			
			//enquanto next não retorna false. 
			while(rs.next()) {
				
				//acessando nome do campo no banco de dados. 
				System.out.println(rs.getInt("Id") + ", "+rs.getString("Name") );
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			//excesões personalizada
			DB.closeResults(rs);
			DB.closeStatement(st);
			DB.closedConnection();
		}
		
		
	}

}
