import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sorting")
public class SortingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
        String inputArrayStr = request.getParameter("arrayInput");

        if (inputArrayStr != null && !inputArrayStr.isEmpty()) {
            String[] inputArray = inputArrayStr.split(",");
            
            // Convert the input array to int (assuming integer values)
            int[] arr = Arrays.stream(inputArray)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            // Perform sorting using different algorithms
            long startTime, endTime;
            
            // Algorithm 1: Bubble Sort
            int[] bubbleSortArray = Arrays.copyOf(arr, arr.length); // Copy the original array
            startTime = System.nanoTime();
            bubbleSort(bubbleSortArray);
            endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime;
            
            // Algorithm 2: Selection Sort
            int[] selectionSortArray = Arrays.copyOf(arr, arr.length); // Copy the original array
            startTime = System.nanoTime();
            selectionSort(selectionSortArray);
            endTime = System.nanoTime();
            long selectionSortTime = endTime - startTime;
            
            // Algorithm 3: Insertion Sort
            int[] insertionSortArray = Arrays.copyOf(arr, arr.length); // Copy the original array
            startTime = System.nanoTime();
            insertionSort(insertionSortArray);
            endTime = System.nanoTime();
            long insertionSortTime = endTime - startTime;
            
            // Algorithm 4: Merge Sort
            int[] mergeSortArray = Arrays.copyOf(arr, arr.length); // Copy the original array
            startTime = System.nanoTime();
            mergeSort(mergeSortArray);
            endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime;
            
            // Algorithm 5: Quick Sort
            int[] quickSortArray = Arrays.copyOf(arr, arr.length); // Copy the original array
            startTime = System.nanoTime();
            quickSort(quickSortArray);
            endTime = System.nanoTime();
            long quickSortTime = endTime - startTime;
            
            // Algorithm 6: Radix Sort
            int[] radixSortArray = Arrays.copyOf(arr, arr.length); // Copy the original array
            startTime = System.nanoTime();
            radixSort(radixSortArray);
            endTime = System.nanoTime();
            long radixSortTime = endTime - startTime;
            
         // Construct the result HTML
            String resultHTML = "<h2>Sorting Comparison Results</h2>";
            resultHTML += "<p>Array Input: " + Arrays.toString(inputArray) + "</p>";
            resultHTML += "<h3>Sorting Algorithm Comparison:</h3>";
            resultHTML += "<ul>";
            resultHTML += "<li>Bubble Sort Time: " + bubbleSortTime + " nanoseconds</li>";
            resultHTML += "<li>Selection Sort Time: " + selectionSortTime + " nanoseconds</li>";
            resultHTML += "<li>Insertion Sort Time: " + insertionSortTime + " nanoseconds</li>";
            resultHTML += "<li>Merge Sort Time: " + mergeSortTime + " nanoseconds</li>";
            resultHTML += "<li>Quick Sort Time: " + quickSortTime + " nanoseconds</li>";
            resultHTML += "<li>Radix Sort Time: " + radixSortTime + " nanoseconds</li>";
            resultHTML += "</ul>";

            // Include the sorted arrays in the response
            resultHTML += "<h3>Sorted Arrays:</h3>";
            resultHTML += "<ul>";
            resultHTML += "<li>Bubble Sort: " + Arrays.toString(bubbleSortArray) + "</li>";
            resultHTML += "<li>Selection Sort: " + Arrays.toString(selectionSortArray) + "</li>";
            resultHTML += "<li>Insertion Sort: " + Arrays.toString(insertionSortArray) + "</li>";
            resultHTML += "<li>Merge Sort: " + Arrays.toString(mergeSortArray) + "</li>";
            resultHTML += "<li>Quick Sort: " + Arrays.toString(quickSortArray) + "</li>";
            resultHTML += "<li>Radix Sort: " + Arrays.toString(radixSortArray) + "</li>";
            resultHTML += "</ul>";


            // Output the result HTML
            response.setContentType("text/html");
            response.getWriter().write(resultHTML);
        } else {
            // Redirect to output.html when no input is provided
            response.sendRedirect("inputerror.html");
        }
    }
    catch(Exception e)
    {
    	 response.sendRedirect("inputerror.html");
    }
}
    // Sorting algorithm implementations (you can replace with your own implementations)
    private void bubbleSort(int[] arr) {
    	    int n = arr.length;
    	    for (int i = 0; i < n - 1; i++) {
    	        for (int j = 0; j < n - i - 1; j++) {
    	            if (arr[j] > arr[j + 1]) {
    	                int temp = arr[j];
    	                arr[j] = arr[j + 1];
    	                arr[j + 1] = temp;
    	            }
    	        }
    	   
    	    }
    }

    

    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


    private void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    private void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }

            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }


    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];

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