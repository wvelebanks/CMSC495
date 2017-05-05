package etmsclient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elvin and Justin
 */
@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // calls the javascript page
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This is the paramaters that are passed FROM the javascript page when
        // the user enters their information
        String username = request.getParameter("username");
        String password = Helper.bytesToHex(Helper.hashString(request.getParameter("password")));

        // This is where the query needs to be, to check against the database
        // This portion will need to be modified
        String query;
        String idDB;
        String passDB;
        CurrentUser user;
        Connection conn = DatabaseConnection.dbConnect(Helper.loadConfig(1));

        try {
            // query string
            query = "SELECT usertable.EmployeeID FROM usertable WHERE "
                    + "usertable.UserName = ? AND usertable.UserPassWord = ?";

            // run the query as a statement
            PreparedStatement empID = conn.prepareStatement(query);
            empID.setString(1, username);
            empID.setString(2, password);
            ResultSet rs1 = empID.executeQuery();

            query = "SELECT * FROM etms_schemma.employee where EmployeeID = ?";

            // run the query as a statement
            PreparedStatement employeeObj = conn.prepareStatement(query);

            if (rs1.next()) {
                // create a new session attribute called "employeeID" and set it
                // to the EmployeeID from the table
                int employeeID = rs1.getInt("usertable.EmployeeID");
                request.getSession().setAttribute("employeeID", employeeID);
                getServletContext().setAttribute("connection", conn);
               // request.getSession().setAttribute("connection", conn);

                employeeObj.setInt(1, employeeID);
                ResultSet rs2 = employeeObj.executeQuery();
                rs2.next();
                Employee currentEmployee = new Employee(rs2.getInt("EmployeeID"), rs2.getString("FirstName"),
                        rs2.getString("MiddleName"), rs2.getString("LastName"), rs2.getString("SSN"),
                        rs2.getDate("Birthdate"), rs2.getString("StreetNumber"), rs2.getString("City"),
                        rs2.getString("State"), rs2.getString("ZipCode"), rs2.getString("Phone"),
                        rs2.getString("Email"), rs2.getInt("PositionID"), rs2.getInt("EmployeeTypeID"));
                
                request.getSession().setAttribute("currentUser", currentEmployee);

                response.sendRedirect("Dashboard");
            } else {
                response.sendRedirect("Login");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            // close out the connection to the database if there is one
            // this is to clean up and insure there are no extraneous
            // connections
            if (conn != null) {
                //conn.close();
            }
        }
    }
}
