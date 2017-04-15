package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewLog")
public class ViewLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewLog() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		List<User> libusers = (List<User>)getServletContext().getAttribute("libusers");
		int index = Integer.parseInt(request.getParameter("index"));
		LibraryModel libentry = libentries.get(index);
		
		
		request.setAttribute( "libentry", libentry );			
        request.getRequestDispatcher( "/WEB-INF/ViewLog.jsp" ).forward(request, response );		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
