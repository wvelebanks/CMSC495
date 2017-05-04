

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		//initialize list to store employees (if needed, possibly for manage screen)
		List<Employee> employees = new ArrayList<Employee>();
		//initialize list to store time entries 
		List<PunchTime> timeEntries = new ArrayList<PunchTime>();
				
		//add lists to session scope
		//that way app can access these variables anywhere
		getServletContext().setAttribute("employees", employees);
		getServletContext().setAttribute("timeEntries", timeEntries);	
		
		//add some sample time entries for our user John Doe		
		timeEntries.add(new PunchTime(1, 0, "6:32am", "5:04pm", "05-01-2017"));
		timeEntries.add(new PunchTime(1, 1, "6:27am", "5:09pm", "05-02-2017"));
		timeEntries.add(new PunchTime(1, 3, "6:31am", "4:57pm", "05-03-2017"));
		
		//***NOTE***
		//instead of hardcoding a query needs to run and pull up all time entries for the user
		//then added to the list
						
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Send to jsp page
		request.getRequestDispatcher( "/WEB-INF/Dashboard.jsp" ).forward(request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
