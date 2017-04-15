package departmentLibrary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditEntry() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		int index = Integer.parseInt(request.getParameter("index"));
		LibraryModel libentry = libentries.get(index);
		
		request.setAttribute( "libentry", libentry );
        request.getRequestDispatcher( "/WEB-INF/EditItem.jsp" ).forward(request, response );		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LibraryModel> libentries = (List<LibraryModel>)getServletContext().getAttribute("libentries");
		
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		String type = request.getParameter("type");		
		String id = request.getParameter("id");
		
		int index = Integer.parseInt(id)-1;
		
		libentries.get(index).setName(name);
		libentries.get(index).setType(type);
		libentries.get(index).setInfo(info);
			    
		
		response.sendRedirect("DepartmentLibraryServlet");

	}

}
