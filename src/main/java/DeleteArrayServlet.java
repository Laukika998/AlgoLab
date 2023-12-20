import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteArrayServlet extends HttpServlet {
   // private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try 
    	{
    		
        // Retrieve values from the form
        String arrayInput = request.getParameter("arrayInput");
        String targetInput = request.getParameter("targetInput");

        // Parse the input array and convert it to a List
        List<String> originalArray = new ArrayList<>(Arrays.asList(arrayInput.split(",")));

        // Remove the target element from the array
        boolean removed = originalArray.remove(targetInput);

        // Send a response back to the client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Delete Array Element Operation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Delete Array Element Operation</h2>");
        out.println("<p>Array Input: " + arrayInput + "</p>");
        out.println("<p>Target Element to Delete: " + targetInput + "</p>");

        if (removed) {
            out.println("<p>Target Element successfully removed. Updated Array: " + originalArray + "</p>");
        } else {
            out.println("<p>Target Element not found in the array. Array remains unchanged: " + originalArray + "</p>");
        }
        out.println("<h4><a href =arrayopt.html>Array Opeartion</a></h3>");
        out.println("</body>");
        out.println("</html>");
        
    }
    	catch (Exception e) {
            // Handle the case where targetIndex is not a valid integer
            response.sendRedirect("inputerror.html");
        }
    }
}