import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BubbleSortServlet")
public class BubbleSortServlet extends HttpServlet {
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
        
        // Perform Bubble Sort on the array and capture intermediate steps
        bubbleSort(array, response);
        
        // Convert the final sorted array back to a string
        String sortedArray = Arrays.toString(array);
        
        // Display the final sorted array on the bubblesort.html page
        response.getWriter().write("<h3>Final Sorted Array:</h3>");
        response.getWriter().write(sortedArray);     
        
     // Go back to current file
        out.println("<h3><a href =bubblesort.html>Bubble Sort</a></h3>");
    }
    
  catch(Exception e) {
	  response.sendRedirect("inputerror.html");
  }
 }
    
    // Bubble Sort algorithm to sort an array of integers
    private void bubbleSort(int[] arr, HttpServletResponse response) throws IOException {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Display the intermediate step
                    String intermediateStep = "Step " + (i + 1) + ": " + Arrays.toString(arr);
                    response.getWriter().write("<p>" + intermediateStep + "</p>");
                }
            }
        }
    }
}