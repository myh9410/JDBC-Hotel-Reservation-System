package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	private static Connection dbTest;
	
	DB_Connect(){
		connectDB();
	}
	
	private void connectDB() {
		try{
			//JDBC Driver Loading
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:" + "@localhost:1521:XE" , "root", "941021");
			System.out.println("�����ͺ��̽��� ����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���ῡ �����Ͽ����ϴ�.");
			System.out.println("SQLException: "+ e);
		} catch (Exception e){
			System.out.println("Exception: "+ e);
		}
	}
	
	public static void main(String[] args) {
		new DB_Connect();
		try{
			dbTest.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("SQLException: " + e);
		}
	}
}