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
        //DatabaseConnection test = new DatabaseConnection();
        Connection conn = DatabaseConnection.dbConnect(Helper.loadConfig(1));

        try {
            // query string
            query = "SELECT usertable.EmployeeID FROM usertable WHERE usertable.UserName = ?"
                    + " AND usertable.UserPassWord = ?";

            // run the query as a statement
            PreparedStatement pstmt = conn.prepareStatement(query);

            // replace the "?" symbols in the query with the
            // the parameters received from the webpage
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // execute the query and get the result set
            ResultSet rs = pstmt.executeQuery();

            // if the query returns a value...
            if (rs.next()) {
                // create a new session attribute called "employeeID" and set it
                // to the EmployeeID from the table
                request.getSession().setAttribute("employeeID", rs.getInt("usertable.EmployeeID"));
                response.sendRedirect("TestVerify");
            } else {
                response.sendRedirect("Login.jsp");
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

        // if it fails to find a user then it will redirect back to the login
        // screen
        //response.sendRedirect("Login");
    }
}
