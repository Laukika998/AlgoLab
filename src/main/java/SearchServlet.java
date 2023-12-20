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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve data from the HTML form
            String arrayInput = request.getParameter("arrayInput");
            String targetInput = request.getParameter("targetInput");
            int target = Integer.parseInt(targetInput);

            // Convert the comma-separated array input to an array of integers
            String[] arrayString = arrayInput.split(",");
            int[] array = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();

            // Prepare the response
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            boolean isSorted = isSorted(array);

            // Perform linear search and measure time
            long startTime = System.nanoTime();
            int linearResult = linearSearch(array, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            // Perform binary search if the array is sorted and measure time
            int binaryResult = -1;
            long binaryTime = 0;
            if (isSorted) {
                startTime = System.nanoTime();
                binaryResult = binarySearch(array, target);
                endTime = System.nanoTime();
                binaryTime = endTime - startTime;
            }

            // Perform hashing (hash table) search if the array is sorted and measure time
            List<Integer> hashResults = isSorted ? hashSearch(array, target) : new ArrayList<>();
            long hashTime = isSorted ? System.nanoTime() - startTime : 0;

            // Generate the response
            out.println("<html><body>");
            out.println("<h2>Search Results</h2>");

            out.println("<p>Array: " + Arrays.toString(array) + "</p>");
            out.println("<p>Target: " + target + "</p>");

            if (linearResult != -1) {
                out.println("<p>Linear Search Result: Element " + target + " found at index [" + linearResult
                        + "] (Time: " + linearTime + " ns)</p>");
            } else {
                out.println("<p>Linear Search Result: Element " + target + " not found</p>");
            }

            if (isSorted) {
                if (binaryResult != -1) {
                    out.println("<p>Binary Search Result: Element " + target + " found at index [" + binaryResult
                            + "] (Time: " + binaryTime + " ns)</p>");
                } else {
                    out.println("<p>Binary Search Result: Element " + target + " not found</p>");
                }

                if (!hashResults.isEmpty()) {
                    out.println("<p>Hashing Search Result: Element " + target + " found at indices "
                            + hashResults.toString() + " (Time: " + hashTime + " ns)</p>");
                } else {
                    out.println("<p>Hashing Search Result: Element " + target + " not found</p>");
                }
            }

            out.println("</body></html>");
        } catch (NumberFormatException e) {
            // Handle the exception when the user input cannot be parsed as integers
            // You can redirect the user to another HTML file here
            response.sendRedirect("inputerror.html"); // Assuming "error.html" is the error page
        }
    }

    private boolean isSorted(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        return Arrays.equals(arr, sortedArray);
    }

    private int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target element found, return its index
            }
        }
        return -1; // Target element not found in the array
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target element found, return its index
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target element not found in the array
    }

    private List<Integer> hashSearch(int[] arr, int target) {
        int tableSize = arr.length;
        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable, -1);

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = hash(arr[i], tableSize);

            while (hashTable[index] != -1) {
                index = (index + 1) % tableSize; // Linear probing
            }

            hashTable[index] = arr[i];
        }

        int index = hash(target, tableSize);
        int originalIndex = index; // Save the original index to check for loop completion

        while (hashTable[index] != -1 && hashTable[index] != target) {
            index = (index + 1) % tableSize; // Continue linear probing
            if (index == originalIndex) {
                // If we come back to the original index, the target is not present in the hash table
                break;
            }
        }

        while (hashTable[index] == target) {
            indices.add(index);
            index = (index + 1) % tableSize; // Continue linear probing
        }

        return indices;
    }

	private int hash(int i, int tableSize) {
		// TODO Auto-generated method stub
		return 0;
	}
}