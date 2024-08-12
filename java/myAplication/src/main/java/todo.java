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

@WebServlet("/todo")
public class todo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public todo() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
        String todoText = request.getParameter("todo");
        String todoId = request.getParameter("id");

        String todo = request.getParameter("todo");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("DriverLoaded");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","d191");
		System.out.println("Connected");
		PreparedStatement ps = conn.prepareStatement("insert into todos(todo) values(?);");
		ps.setString(1, todo);
		
		int count = ps.executeUpdate();		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(count > 0) {
			response.sendRedirect("welcome.jsp");
		}
		else {
			out.write("Undable to add todo");
		}
	}
    catch(Exception e) {
		System.out.println(e);
	}
}

}