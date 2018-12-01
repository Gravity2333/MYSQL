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
		
		//1.注册驱动 
		DriverManager.registerDriver(new Driver());	
		
		//2.建立连接
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javabook", "root","22331144");
	
		//3.创建statement,跟数据库打交道用到的对象 
		Statement st=(Statement) connection.createStatement();
		
		//4.执行查询
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
