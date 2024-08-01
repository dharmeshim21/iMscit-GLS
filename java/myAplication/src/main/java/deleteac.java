

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
 * Servlet implementation class deleteac
 */
@WebServlet("/deleteac")
public class deleteac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteac() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            	
            Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Loaded");
    			
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
    		PreparedStatement ps = conn.prepareStatement("delete from users where username = ? AND password = ?");
    		ps.setString(1, username);
    		ps.setString(2, password);
    			
    		int count = ps.executeUpdate();
    			
    	      if (count > 0) {
    	    	  response.sendRedirect("login.jsp");
    				System.out.println("SUCCESS");
    	       } else {
    	    	   out.println("Deletetion Failed");
    	    	   System.out.println("Failed");
    	       }
			
		}
		catch(Exception e) {
			System.out.println(e);
		
		}
	}

}
