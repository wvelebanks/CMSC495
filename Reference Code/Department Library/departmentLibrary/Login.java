package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;   
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//calls the javascript page
		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//post process returned by the javascript page
		//in this case to do a simple validation of user credentials
		//our project will do the check against the database here instead
		if( request.getParameter( "username" ).equals( "epetrosy" )
	            && request.getParameter( "password" ).equals( "abcd" ) )
	        {
	            //set the session username
				request.getSession().setAttribute( "username", "epetrosy" );
				//redirects to the next java servlet program (not inluded)
	            response.sendRedirect( "DepartmentLibraryServlet" );
	        }
	        else
	            response.sendRedirect( "Login" );
	}

}
