import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertionSortServlet")
public class InsertionSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
    		
   		 response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
        // Get the array input from the request
        String input = request.getParameter("arrayInput");
        String[] elements = input.split(",");
        
        // Convert the input to an array of integers
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }
        
        // Perform Insertion Sort on the array and capture intermediate steps
        insertionSort(array, response);
        
        // Convert the final sorted array back to a string
        String sortedArray = Arrays.toString(array);
        
        // Display the final sorted array on the insertionsort.html page
        response.getWriter().write("<h3>Final Sorted Array:</h3>");
        response.getWriter().write(sortedArray);
    
    	// Go back to current file
        out.println("<h3><a href = insertionsort.html>Insertion Sort</a></h3>");
    }
      catch(Exception e) {
	  response.sendRedirect("inputerror.html");
  }
 }
    
    
    // Insertion Sort algorithm to sort an array of integers
    private void insertionSort(int[] arr, HttpServletResponse response) throws IOException {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            // Display the intermediate step
            String intermediateStep = "Step " + i + ": " + Arrays.toString(arr);
            response.getWriter().write("<p>" + intermediateStep + "</p>");
        }
    }
}