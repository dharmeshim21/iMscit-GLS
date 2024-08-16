
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
//			Connection conn =DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/imsc7it191","imsc7it191","sumo@123");
			PreparedStatement ps = conn.prepareStatement("select email,password from users where email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			PrintWriter out = response.getWriter();
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("home.jsp");
			}
			else {
				out.print("<h1 style='color:red'>Unable to login</h1>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
