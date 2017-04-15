package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/DepartmentLibraryServlet", loadOnStartup = 1)
public class DepartmentLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepartmentLibraryServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		List<LibraryModel> libentries = new ArrayList<LibraryModel>();
		List<User> libusers = new ArrayList<User>();
		getServletContext().setAttribute("libentries", libentries);
		getServletContext().setAttribute("libusers", libusers);	
		
		//Some sample books that have been added to the "database"
		libentries.add(new LibraryModel(1,"Lord of the Rings","Book", "JRR Tolkien", "Yes"));
		libentries.add(new LibraryModel(2,"News Week"," Magazine", "August 2016 Edition", "No"));
		libentries.add(new LibraryModel(3,"Grapes of Wrath","Book", "John Steinbeck", "Yes"));
						
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 request.getRequestDispatcher( "/WEB-INF/DepartmentLibrary.jsp" ).forward(request, response );	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
