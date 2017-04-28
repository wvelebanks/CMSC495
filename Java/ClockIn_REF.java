package etms;

import static etms.DBConnector.dbConnect;
import java.io.IOException;
import java.sql.Connection;
import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  @date created 
 *  @author Ian Spooner
 */

public class ClockIn {
int payPeriod;

public ClockIn (){}

private ClockIn (int payPeriod) {
    payPeriod=this.payPeriod;
    Connection conn = dbConnect();
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        request.getRequestDispatcher( "/js/ClockIn.jsp" ).forward(request, response );		
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get paramiters from page
        String name = request.getParameter("UserName");
        String pass = request.getParameter("UserPassWord");
        
        //pass paramiters to db connection
        DBConnector.dbConnect();
        Query clockIn = new Query();
        //perparedStatement thing here
        clockIn = "INSERT INTO `etms_schemma`.`hourstable` (`HoursTableID`, `TotalWorkedHours`, `DayWorkedHours`) VALUES ('00001', '40', '5');";
        DBConnector.push(clockIn);

        response.sendRedirect("ClockInDone");
    }
}
