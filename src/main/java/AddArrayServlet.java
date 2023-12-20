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

@WebServlet("/add")
public class AddArrayServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve values from the form
        String arrayInput = request.getParameter("arrayInput");
        String targetInput = request.getParameter("targetInput");
        String targetIndex = request.getParameter("targetindex");

        // Parse the input array and convert it to a List
        List<String> originalArray = new ArrayList<>(Arrays.asList(arrayInput.split(",")));

        try {
            // Convert targetIndex to an integer
            int index = Integer.parseInt(targetIndex);

            // Add the target element at the specified index
            originalArray.add(index, targetInput);

            // Send a response back to the client
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Array Element Operation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Add Array Element Operation</h2>");
            out.println("<p>Array Input: " + arrayInput + "</p>");
            out.println("<p>Target Element: " + targetInput + "</p>");
            out.println("<p>Target Index: " + targetIndex + "</p>");
            out.println("<p>Final Array: " + originalArray + "</p>");
            out.println("<h4><a href =arrayopt.html>Array Opeartion</a></h3>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            // Handle the case where targetIndex is not a valid integer
            response.sendRedirect("inputerror.html");
        }
    }
}
