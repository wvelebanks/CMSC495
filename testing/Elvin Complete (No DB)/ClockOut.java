

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ClockOut")
public class ClockOut extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pull up servlet variable
		List<PunchTime> timeEntries = (List<PunchTime>)getServletContext().getAttribute("timeEntries");
				
		//Get the unique time index from the paramater sent by the jsp
		int tID = Integer.parseInt(request.getParameter("timeIndex"));
		
		//iterate through the entries and find the one with the time index
		//set it as complete
		
		//***NOTE***
		//This needs to be done through a query, and then added to the list
		//INSERT QUERY HERE
		Iterator<PunchTime> it = timeEntries.iterator();
		while (it.hasNext()) {
			PunchTime pt = it.next();
			if (pt.getTimeID() == tID) {
				pt.setTimeOut("5:00pm");
				pt.setCompleted(true);
			}
		}
		
		//redirect
		response.sendRedirect( "Dashboard" );
		
	}

}
