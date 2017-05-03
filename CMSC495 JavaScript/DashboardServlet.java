package etmsclient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  @date created 
 *  @author Ian Spooner
 */

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // calls the javascript page
        request.getRequestDispatcher("/WEB-INF/Dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Startup Requests, retrive information, etc.
        String FirstName = null, LastName = null;
        Date StartDate = null, DateSubmitted = null; 
        Time TimeIn = null, TimeOut = null;
        Byte Approval = null;
        int PayPeriod = 0;
        
        //open a database connection
        Connection conn = DatabaseConnection.dbConnect(Helper.loadConfig(1));

        //get username from the session, use it to get user id
        String username = request.getParameter("username");
        String userIDQuery;
        try {
            userIDQuery = "SELECT usertable.EmployeeID \n" +  
                          "FROM etms_schemma.usertable \n" + 
                          "WHERE etms_schemma.usertable.UserName = " + username + ";";
            // run the query as a statement
            PreparedStatement userIDStmt = conn.prepareStatement(userIDQuery);
            // replace the "?" symbols in the query with the
            // the parameters received from the webpage
            userIDStmt.setString(1, username);
            // execute the query and get the result set
            ResultSet rs = userIDStmt.executeQuery();
            if (rs.next()) {
                // create a new session attribute called "employeeID" and set it
                // to the EmployeeID from the table
                request.getSession().setAttribute("employeeID", rs.getInt("usertable.EmployeeID"));
            }
        }
        catch (SQLException e) {
            Error.warning(e.toString());
        } finally {
            try {
                // close out the connection to the database if there is one
                // this is to clean up and insure there are no extraneous
                // connections
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Error.warning(e.toString());
            }
        }
        
        
        //get basic timesheet info for logged on user
        String timesheetInfoQuery;
        try {
            // query string
            timesheetInfoQuery = "SELECT employee.FirstName, employee.LastName, timesheet.StartDate, timesheet.TimeIn, timesheet.TimeOut, timesheet.DateSubmitted, timesheet.PayPeriod, timesheet.Approval  \n" +
                            "FROM etms_schemma.timesheet JOIN etms_schemma.employee\n" +
                            "WHERE employee.employeeID = timesheet.EmployeeID;  ";
            // run the query as a statement
            PreparedStatement timesheetStmt = conn.prepareStatement(timesheetInfoQuery);
            // replace the "?" symbols in the query with the
            // the parameters received from the webpage
            Employee employee = new Employee();
            Timesheet timesheet = new Timesheet();
            
            timesheetStmt.setString(1, FirstName);
            timesheetStmt.setString(2, LastName);
            timesheetStmt.setDate(3, StartDate);
            timesheetStmt.setTime(4, TimeIn);
            timesheetStmt.setTime(5, TimeOut);
            timesheetStmt.setDate(6, DateSubmitted);
            timesheetStmt.setInt(7, PayPeriod);
            timesheetStmt.setByte(8, Approval);
            
            // execute the query and get the result set
            ResultSet rs = timesheetStmt.executeQuery();
            
            if(rs.next())   {                      
            employee.setFirstName(FirstName);
            employee.setLastName(LastName);
            }

            else {
                Error.warning("Failed to load data");
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                // close out the connection to the database if there is one
                // this is to clean up and insure there are no extraneous
                // connections
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        
        //update data based on information entered in account page
        //if(buttonpush=save changes)
            //updateUser(parms);
        //elseif(buttonpush=clock out)
            //call clockout.java
    }
    
    private void updateUser (String name)   {
        
    }
    
    private void submitTimesheet(HttpServletResponse response, String somestrings) throws IOException    {
        //logic
        response.sendRedirect("Dashboard.jsp");
    }
    
    private void clockOut (HttpServletResponse response, String name) throws IOException   {
        //logic
        response.sendRedirect("Dashboard.jsp");
    }
    
    private void viewTimesheet (HttpServletResponse response, String name) throws IOException   {
        //logic
        response.sendRedirect("Dashboard.jsp");
    }
    
    private void approveTimesheet (HttpServletResponse response, String name) throws IOException   {
        //logic
        response.sendRedirect("Dashboard.jsp");
    }
    
    private void rejectTimesheet (HttpServletResponse response, String name) throws IOException   {
        //logic
        response.sendRedirect("Dashboard.jsp");
    }
    
    
}
