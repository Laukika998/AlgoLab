import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RadixSortServlet")
public class RadixSortServlet extends HttpServlet {
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
        
        // Perform Radix Sort on the array and capture intermediate steps
        radixSort(array, response);
        
        // Convert the final sorted array back to a string
        String sortedArray = Arrays.toString(array);
        
        // Display the final sorted array on the radixsort.html page
        response.getWriter().write("<h3>Final Sorted Array:</h3>");
        response.getWriter().write(sortedArray);
        // Go back to current file
        out.println("<h3><a href =radixsort.html>Radix Sort</a></h3>");
    }
    
  catch(Exception e) {
	  response.sendRedirect("inputerror.html");
  }
 }
    
    // Radix Sort algorithm to sort an array of integers
    private void radixSort(int[] arr, HttpServletResponse response) throws IOException {
        int max = Arrays.stream(arr).max().getAsInt();
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp, response);
            
            // Display the intermediate step
            String intermediateStep = "Step: " + Arrays.toString(arr);
            response.getWriter().write("<p>" + intermediateStep + "</p>");
        }
    }
    
    private void countingSort(int[] arr, int exp, HttpServletResponse response) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}