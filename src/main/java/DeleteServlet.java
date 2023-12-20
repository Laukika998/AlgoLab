import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the element to delete from the request parameter
       // String deleteElement = request.getParameter("deleteInput");
    	String arrayInput = request.getParameter("arrayInput");
        String delete = request.getParameter("deleteInput");
        int deleteElement = Integer.parseInt(delete);

        // Get the session
        HttpSession session = request.getSession();

        // Retrieve the array from the session
        ArrayList<String> arrayList = (ArrayList<String>) session.getAttribute("arrayList");

        // Check if the array is not null
        if (arrayList != null) {
            // Perform array deletion logic
            arrayList.remove(deleteElement);
            
            // Update the array in the session
            session.setAttribute("arrayList", arrayList);

            // Redirect back to the main page or display a success message
            response.sendRedirect("index.html");
        } else {
            // Handle the case when the array is not found in the session
            response.getWriter().println("Array not found in session");
        }
    }
}
