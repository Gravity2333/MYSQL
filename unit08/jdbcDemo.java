package unit08;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class jdbcDemo {
	public static void main(String[] args) throws SQLException
	{
		
		//1.ע������ 
		DriverManager.registerDriver(new Driver());	
		
		//2.��������
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javabook", "root","22331144");
	
		//3.����statement,�����ݿ�򽻵��õ��Ķ��� 
		Statement st=(Statement) connection.createStatement();
		
		//4.ִ�в�ѯ
		String sql = "select * from account";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())//get next recode if ok return true 
		{
			String userName=rs.getString("username");
			String passWord=rs.getString("password");
			String name=rs.getString("name");
			System.out.println("userName:"+userName+"   passWord:"+passWord+"   name"+name);			
		}
		rs.close();
		st.close();
		connection.close();
	}
}
