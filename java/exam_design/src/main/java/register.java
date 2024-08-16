

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
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
//			Connection conn =DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/imsc7it191","imsc7it191","sumo@123");
			System.out.println("Connected");
			PreparedStatement ps = conn.prepareStatement("insert into users(email,username,password,gender,country) values(?,?,?,?,?);");
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, country);
			
			PrintWriter out = response.getWriter();
			int ex = ps.executeUpdate();
			if(ex > 0) {
				response.sendRedirect("index.jsp");
			}
			else {
				out.print("<h1 style='color:red'>Failed to Register</h1>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
