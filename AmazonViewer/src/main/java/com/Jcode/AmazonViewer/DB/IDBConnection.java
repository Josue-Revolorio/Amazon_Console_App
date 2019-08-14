package com.Jcode.AmazonViewer.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.Jcode.AmazonViewer.DB.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
		   
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url+db, user, password);
			
			if (connection != null) {
				System.out.println("Connection was established");
				
			}
			
		   
		} catch (SQLException e) {
			System.out.println("Erro de SQl");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tipos de Erroes");
		}finally {
			return connection;
		}
		
	}

}
