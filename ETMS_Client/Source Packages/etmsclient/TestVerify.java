package etmsclient;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestVerify
 */
@WebServlet("/TestVerify")
public class TestVerify extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u = request.getSession().getAttribute("employeeID").toString();
      /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>login</title></head>");
        out.println("<body");

        out.println("<p>You are logged in with userID: " + u + "</p>");

        out.println("</body></html>");
      */
        System.out.println("You are logged in with userID: " + u);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
