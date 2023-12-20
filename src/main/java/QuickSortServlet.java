import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/QuickSortServlet")
public class QuickSortServlet extends HttpServlet {
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
        
        // Perform Quick Sort on the array and capture intermediate steps
        quickSort(array, 0, array.length - 1, response);
        
        // Convert the final sorted array back to a string
        String sortedArray = Arrays.toString(array);
        
        // Display the final sorted array on the quicksort.html page
        response.getWriter().write("<h3>Final Sorted Array:</h3>");
        response.getWriter().write(sortedArray);
        // Go back to current file
        out.println("<h3><a href =bubblesort.html>Bubble Sort</a></h3>");
    }
    
  catch(Exception e) {
	  response.sendRedirect("inputerror.html");
  }
 }
    // Quick Sort algorithm to sort an array of integers
    private void quickSort(int[] arr, int low, int high, HttpServletResponse response) throws IOException {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, response);
            
            // Recursively sort the elements before and after the partition
            quickSort(arr, low, partitionIndex - 1, response);
            quickSort(arr, partitionIndex + 1, high, response);
        }
    }
    
    private int partition(int[] arr, int low, int high, HttpServletResponse response) throws IOException {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Display the intermediate step
        String intermediateStep = "Step: " + Arrays.toString(arr);
        response.getWriter().write("<p>" + intermediateStep + "</p>");
        
        return i + 1;
    }
}