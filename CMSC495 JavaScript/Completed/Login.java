

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	
	
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//calls the javascript page
		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//This is the paramaters that are passed FROM the javascript page when the user enters their information
		String username = request.getParameter( "username" );
		String password = request.getParameter("password");
		
		//This is where the query needs to be, to check against the database
		//JConnector is not set up, I dont know how.
		//This portion will need to be modified
		
		String query;
		String idDB;
		String passDB;
		Connection c = null;
		
		
		try
        {
            //database url
			//this is for a locally running sql database using JDBC
			//this will have to be changed to match the table
			String url = "jdbc:mysql://localhost/database";
			
			//database login (if there is one)
            String userAdmin = "admin";
            String passAdmin = "admin123";

            //query string
            query = "SELECT usertable.EmployeeID"
            	  + "FROM usertable"
            	  + "WHERE usertable.UserName = ?"
                  + "AND usertable.UserPassWord = ?";
            
            //establish a connection with the database
            c = DriverManager.getConnection( url, userAdmin, passAdmin );
            
            //run the query as a statement
            PreparedStatement pstmt = c.prepareStatement( query );
            
            //replace the "?" symbols in the query with the
            //the parameters received from the webpage 
            pstmt.setString( 1, username );
            pstmt.setString( 2, password );
            
            //execute the query and get the result set
            ResultSet rs = pstmt.executeQuery();

            //if the query returns a value...
            if( rs.next() ) {
            	//create a new session attribute called "employeeID" and set it to the EmployeeID from the table
            	request.getSession().setAttribute( "employeeID", rs.getInt( "usertable.EmployeeID" ) );				
	            response.sendRedirect( "TestVerify" );
            }
                
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                //close out the connection to the database if there is one
            	//this is to clean up and insure there are no extraneous connections
            	if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
		
		//if it fails to find a user then it will redirect back to the login screen
		response.sendRedirect( "Login" );
    }
		
		
	}

}
