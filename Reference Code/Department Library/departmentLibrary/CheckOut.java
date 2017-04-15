package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckOut() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 	{
		
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		int index = Integer.parseInt(request.getParameter("index"));
		LibraryModel libentry = libentries.get(index);
		
		request.setAttribute( "libentry", libentry );		
        request.getRequestDispatcher( "/WEB-INF/CheckOut.jsp" ).forward(request, response );		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cin = request.getParameter("cin");
		String name = request.getParameter("name");
		String due = request.getParameter("due");
				
		int id = Integer.parseInt(request.getParameter("index"));
		int index = id-1;
		int intcin = Integer.parseInt(cin);
		int userIndex = 0;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();		
		
		List<User> libusers = (List<User>)getServletContext().getAttribute("libusers");
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		
		userIndex= libusers.size();
		
		libusers.add(new User(intcin, id, name, dateFormat.format(date), "<a href='Return?uindex=" + userIndex + "&index=" + index + "'>Return", due ));
		libentries.get(index).setAvailable("No");
			
		response.sendRedirect("ViewLog?index="+index);
		

	}

}
