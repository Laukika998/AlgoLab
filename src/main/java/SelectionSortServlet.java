import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SelectionSortServlet")
public class SelectionSortServlet extends HttpServlet {
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
        
        // Perform Selection Sort on the array and capture intermediate steps
        selectionSort(array, response);
        
        // Convert the final sorted array back to a string
        String sortedArray = Arrays.toString(array);
        
        // Display the final sorted array on the selectionsort.html page
        response.getWriter().write("<h3>Final Sorted Array:</h3>");
        response.getWriter().write(sortedArray);
        
        // Go back to current file
           out.println("<h3><a href =selectionsort.html>Selection Sort</a></h3>");
       }
       
     catch(Exception e) {
   	  response.sendRedirect("inputerror.html");
     }
    }
    // Selection Sort algorithm to sort an array of integers
    private void selectionSort(int[] arr, HttpServletResponse response) throws IOException {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the elements
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            // Display the intermediate step
            String intermediateStep = "Step " + (i + 1) + ": " + Arrays.toString(arr);
            response.getWriter().write("<p>" + intermediateStep + "</p>");
        }
    }
}