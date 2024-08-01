

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String remeberme = request.getParameter("remeberme");
			if(remeberme == null) {
				out.println("<h1 style='color:red;'>Please check Remeber me </h1>");
				return;
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
			PreparedStatement ps = conn.prepareStatement("select * from users where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();

	        
			
	        if (rs.next()) {
	        	response.sendRedirect("welcome.jsp");
				System.out.println("SUCCESS");
	        } 
	        else if(username == "" || password == "") {
	        	out.println("<h1 style='color:red;'>Please Enter Details</h1>");
	        }
	        else {
	        	response.sendRedirect("forgotPass.jsp");
				System.out.println("SUCCESS");
	        }

	        rs.close();
	        ps.close();
	        conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
