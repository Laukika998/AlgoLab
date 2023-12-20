import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MergeSortServlet")
public class MergeSortServlet extends HttpServlet {
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
        
        // Perform Merge Sort on the array and capture intermediate steps
        mergeSort(array, 0, array.length - 1, response);
        
        // Convert the final sorted array back to a string
        String sortedArray = Arrays.toString(array);
        
        // Display the final sorted array on the mergesort.html page
        response.getWriter().write("<h3>Final Sorted Array:</h3>");
        response.getWriter().write(sortedArray);
        // Go back to current file
        out.println("<h3><a href =mergesort.html>Merge Sort</a></h3>");
    }
    
  catch(Exception e) {
	  response.sendRedirect("inputerror.html");
  }
 }
    
    // Merge Sort algorithm to sort an array of integers
    private void mergeSort(int[] arr, int left, int right, HttpServletResponse response) throws IOException {
        if (left < right) {
            int mid = (left + right) / 2;
            
            // Recursively sort the left and right halves
            mergeSort(arr, left, mid, response);
            mergeSort(arr, mid + 1, right, response);
            
            // Merge the sorted halves
            merge(arr, left, mid, right, response);
        }
    }
    
    private void merge(int[] arr, int left, int mid, int right, HttpServletResponse response) throws IOException {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
            
            // Display the intermediate step
            String intermediateStep = "Sorting Steps: " + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1));
            response.getWriter().write("<p>" + intermediateStep + "</p>");
        }
        
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}