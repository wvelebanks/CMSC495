package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Return")
public class Return extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Return() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if( request.getSession().getAttribute( "username" ) == null )
        {
            response.sendRedirect( "Login" );
            return;
        }
		
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		List<User> libusers = (List<User>)getServletContext().getAttribute("libusers");
		int index = Integer.parseInt(request.getParameter("index"));
		int uindex = Integer.parseInt(request.getParameter("uindex"));
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		
		User libuser = libusers.get(uindex);				
		LibraryModel libentry = libentries.get(index);		
		
		libuser.setDateReturn(dateFormat.format(date));
		libentry.setAvailable("Yes");
		
		response.sendRedirect("ViewLog?index="+index);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
