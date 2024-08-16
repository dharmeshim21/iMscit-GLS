

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
//			Connection conn =DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/imsc7it191","imsc7it191","sumo@123");
			System.out.println("Connected");
			PreparedStatement ps = conn.prepareStatement("delete from users where email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			PrintWriter out = response.getWriter();
			int ex = ps.executeUpdate();
			if(ex > 0) {
				response.sendRedirect("register.jsp");
			}
			else {
				out.print("<h1 style='color:red'>Failed to Delete Account</h1>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
