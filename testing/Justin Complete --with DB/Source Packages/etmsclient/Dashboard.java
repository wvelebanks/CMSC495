package etmsclient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Send to jsp page
        request.getRequestDispatcher("/WEB-INF/Dashboard.jsp").forward(request, response);
        //initialize list to store employees (if needed, possibly for manage screen)
        List<Employee> employees = new ArrayList<>();
        //initialize list to store time entries 
        List<PunchTime> timeEntries = new ArrayList<>();

        //add lists to session scope
        //that way app can access these variables anywhere
        getServletContext().setAttribute("employees", employees);
        getServletContext().setAttribute("timeEntries", timeEntries);
        int employeeID = (int) request.getSession().getAttribute("employeeID");
        Connection conn = (Connection) getServletContext().getAttribute("connection");
        try {
            int payperiod = 1;

            String query = "SELECT * FROM etms_schemma.timesheet WHERE PayPeriod = ? AND EmployeeID = ?";

            PreparedStatement timesheet = conn.prepareStatement(query);
            timesheet.setInt(1, payperiod);
            timesheet.setInt(2, employeeID);
            ResultSet rs1 = timesheet.executeQuery();

            while (rs1.next()) {
                String strIn = rs1.getTimestamp("TimeIn").toString();
                String strOut = rs1.getTimestamp("TimeOut").toString();
                String date = strIn.substring(0, strIn.indexOf(' '));
                String timeIn = strIn.substring(strIn.indexOf(' ') + 1);
                String timeOut = strOut.substring(strOut.indexOf(' ') + 1);
                
                timeEntries.add(new PunchTime(employeeID, rs1.getInt("TimeSheetID"), timeIn, timeOut, date));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
