
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );
		//request.getRequestDispatcher( "/WEB-INF/Dashboard.jsp" ).forward(request, response );
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		//getServletContext().setAttribute("currentUser", currentUser);
		
		if( request.getParameter( "username" ).equals( "epetrosy" )
	            && request.getParameter( "password" ).equals( "abcd" ) )
	        {
	            
				//This is a sample current user. 
				//This would be pulled from the DB upon proper authentication
				Employee currentUser = new Employee(1, "John", "M", "Doe",
				            "123-45-6789", "01-15-1987", "123 Main St.", "Los Angeles", "CA", "91001", "555-123-4567", "jdoe1@mail.com");
				
				//set the session username
				request.getSession().setAttribute( "currentUser", currentUser );
								
				//redirects to the next java servlet program (not inluded)
		        response.sendRedirect( "Dashboard" );
	            
	        }
	        else
	            response.sendRedirect( "Login" );
	}

}
