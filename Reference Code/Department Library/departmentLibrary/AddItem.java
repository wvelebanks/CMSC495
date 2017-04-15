package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddItem() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		request.getRequestDispatcher( "/WEB-INF/AddItem.jsp" ).forward(request, response );		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		String type = request.getParameter("type");
		String number = request.getParameter("number");		
		int copies = Integer.parseInt(number);
		int id = libentries.size()+1;		
				
    	for(int i = 0; i < copies; i++)
    	{
    		libentries.add(new LibraryModel(id, type, name, info, "Yes") );
    		id++;
    	}	    
		
		response.sendRedirect("DepartmentLibraryServlet");

	}

}
