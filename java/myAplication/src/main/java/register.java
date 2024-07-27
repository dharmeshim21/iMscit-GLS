

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String country = request.getParameter("country");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
			PreparedStatement ps = conn.prepareStatement("insert into users(email,username,password,gender,country) values(?,?,?,?,?);");
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, country);
			
			int count = ps.executeUpdate();
			
	        if (count > 0) {
	        	response.sendRedirect("login.jsp");
				System.out.println("SUCCESS");
	        } else {
	        	response.sendRedirect("forgotPass.jsp");
				System.out.println("SUCCESS");
	        }

	        ps.close();
	        conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
