

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ClockIn")
public class ClockIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pull up the servlet variables
		List<PunchTime> timeEntries = (List<PunchTime>)getServletContext().getAttribute("timeEntries");
		
		//Pull up the current user from the session scope
		Employee currentUser = (Employee) request.getSession(true).getAttribute("currentUser");		
		
		//Get current users Employee ID
		int eID = currentUser.getEmployeeID();
		
		//Create a unique index
		int timeID = timeEntries.size()+1;	
		
		//***NOTE***
		//We need to have the database create the unique index
		//then once the incomplete time entry is created here, it needs to be passed back to the db
		//INSERT QUERY HERE
		
		//Create a new incomplete time entry
		PunchTime Entry = new PunchTime(eID, timeID, "6:33am", "05-04-2017");
		
		//add it to the servlet variable
		timeEntries.add(Entry);
		
		//Redirect back to dashboard
		response.sendRedirect( "Dashboard" );
	}

}
