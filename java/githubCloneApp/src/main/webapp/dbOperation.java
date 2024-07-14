package databaseOp;
import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
public class dbOperation {
	public static void main(String[] args) throws Exception {
		
			String username = "Sahaj";
			String password = "Sahaj@2013";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root","d191");
			System.out.println("Connect to Db");
//			PreparedStatement exe = con.prepareStatement("insert into login values('"+username+"','"+password+"')");
//			exe.execute();
			
//			PreparedStatement exe = con.prepareStatement("insert into login values(?,?)");
//			exe.setString(1, username);
//			exe.setString(2, password);
//			int i = exe.executeUpdate();
//			if(i > 0) {
//				System.out.println("Inserted Succefully");
//			}
//			else {
//				System.out.println("Operation Failed");
//			}
//			
//			PreparedStatement exe = con.prepareStatement("update login set password=? where username=?");
//			exe.setString(1, password);
//			exe.setString(2, username);
//			int count = exe.executeUpdate();
//			if(count > 0) {
//				System.out.println("Updated Succefully");
//			}
//			else {
//				System.out.println("Operation Failed");
//			}
//			
//			PreparedStatement exe = con.prepareStatement("delete from login where username=?");
//			exe.setString(1, "dom");
//			int count = exe.executeUpdate();
//			if(count > 0) {
//				System.out.println("Deleted Succefully");
//			}
//			else {
//				System.out.println("Operation Failed");
//			}
			
			PreparedStatement exe = con.prepareStatement("select * from login");
			
			ResultSet rs = exe.executeQuery();
			
			while(rs.next()) {
				System.out.println("Username :"+rs.getString("username"));
				System.out.println("Password :"+rs.getString("password"));
				System.out.println();

			}
			
	}
}
