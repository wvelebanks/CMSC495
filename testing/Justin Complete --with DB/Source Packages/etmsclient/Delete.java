package etmsclient;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the time index parameter from the jsp
        int tID = Integer.parseInt(request.getParameter("timeIndex"));

        // Get servlet variables
        List<PunchTime> timeEntries = (List<PunchTime>) getServletContext().getAttribute("timeEntries");

        // iterate through the entries and find the one with the time index
        // delete it
        // ***NOTE***
        // This needs to be done through a query. Delete the object from the db then update this list
        // INSERT QUERY HERE
        Iterator<PunchTime> it = timeEntries.iterator();
        while (it.hasNext()) {
            PunchTime pt = it.next();
            if (pt.getTimeID() == tID) {
                it.remove();
            }
        }
        response.sendRedirect("Dashboard");
    }
}
