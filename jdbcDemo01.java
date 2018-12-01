package cn.gravity;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class jdbcDemo01 {
	public static void main(String[] args)
	{
		
		try {
			//1.ע������
			DriverManager.registerDriver(new Driver());
			
			//2.�������� 
			Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/javabook","root", "22331144");
			
			//3.����Statement����
			Statement statement = (Statement) connection.createStatement();
			
			//4.��ѯ
			String sql="select * from account";
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				String userName=rs.getString("username");
				String passWord=rs.getString("password");
				String name = rs.getString("name");
				System.out.println("username: "+userName+" password: "+passWord+" name: "+name);
			}
			rs.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
