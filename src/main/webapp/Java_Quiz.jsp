<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DSA Quiz</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
    <div id="page-wrap">
    
     

        <h2><strong> Data Structures and Algorithms Quiz</h2></strong>
        
        <form action="QuizServlet" method="post" id="quiz">
        
            <ol>
                <!-- Question 1 -->
                <li>
                    <h3>Which of the following sorting algorithms has a worst-case time complexity of O(n^2) but can be improved to O(n log n) by using advanced techniques?</h3>
                    <div>
                        <input type="radio" name="question-1-answers" value="A" />
                        <label for="question-1-answers-A">A) Merge Sort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-1-answers" value="B" />
                        <label for="question-1-answers-B">B) Bubble Sort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-1-answers" value="C" />
                        <label for="question-1-answers-C">C) QuickSort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-1-answers" value="D" />
                        <label for="question-1-answers-D">D) Insertion Sort</label>
                    </div>
                </li>

                <!-- Question 2 -->
                <li>
                    <h3>In binary search, what is the key requirement for the array to perform the search?</h3>
                    <div>
                        <input type="radio" name="question-2-answers" value="A" />
                        <label for="question-2-answers-A">A) The array must be sorted in ascending order</label>
                    </div>
                    <div>
                        <input type="radio" name="question-2-answers" value="B" />
                        <label for="question-2-answers-B">B) The array must be sorted in descending order</label>
                    </div>
                    <div>
                        <input type="radio" name="question-2-answers" value="C" />
                        <label for="question-2-answers-C">C) The array can be unsorted</label>
                    </div>
                    <div>
                        <input type="radio" name="question-2-answers" value="D" />
                        <label for="question-2-answers-D">D) The array must be a two-dimensional array</label>
                    </div>
                </li>

                <!-- Question 3 -->
                <li>
                    <h3>Which sorting algorithm is known for its stability, making it suitable for sorting records with equal keys?</h3>
                    <div>
                        <input type="radio" name="question-3-answers" value="A" />
                        <label for="question-3-answers-A">A) QuickSort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-3-answers" value="B" />
                        <label for="question-3-answers-B">B) Bubble Sort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-3-answers" value="C" />
                        <label for="question-3-answers-C">C) Merge Sort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-3-answers" value="D" />
                        <label for="question-3-answers-D">D) Insertion Sort</label>
                    </div>
                </li>

                <!-- Question 4 -->
                <li>
                    <h3>What is the time complexity of the linear search algorithm?</h3>
                    <div>
                        <input type="radio" name="question-4-answers" value="A" />
                        <label for="question-4-answers-A">A) O(n)</label>
                    </div>
                    <div>
                        <input type="radio" name="question-4-answers" value="B" />
                        <label for="question-4-answers-B">B) O(log n)</label>
                    </div>
                    <div>
                        <input type="radio" name="question-4-answers" value="C" />
                        <label for="question-4-answers-C">C) O(n^2)</label>
                    </div>
                    <div>
                        <input type="radio" name="question-4-answers" value="D" />
                        <label for="question-4-answers-D">D) O(1)</label>
                    </div>
                </li>

                <!-- Question 5 -->
                <li>
                    <h3>Which of the following sorting algorithms has a time complexity that is always O(n log n), regardless of the input?</h3>
                    <div>
                        <input type="radio" name="question-5-answers" value="A" />
                        <label for="question-5-answers-A">A) Bubble Sort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-5-answers" value="B" />
                        <label for="question-5-answers-B">B) QuickSort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-5-answers" value="C" />
                        <label for="question-5-answers-C">C) Heap Sort</label>
                    </div>
                    <div>
                        <input type="radio" name="question-5-answers" value="D" />
                        <label for="question-5-answers-D">D) Insertion Sort</label>
                    </div>
                </li>

                <!-- Question 6 -->
                <li>
                    <h3>What is the time complexity of the QuickSort algorithm in the average case?</h3>
                    <div>
                        <input type="radio" name="question-6-answers" value="A" />
                        <label for="question-6-answers-A">A) O(1)</label>
                    </div>
                    <div>
                        <input type="radio" name="question-6-answers" value="B" />
                        <label for="question-6-answers-B">B) O(log n)</label>
                    </div>
                    <div>
                        <input type="radio" name="question-6-answers" value="C" />
                        <label for="question-6-answers-C">C) O(n)</label>
                    </div>
                    <div>
                        <input type="radio" name="question-6-answers" value="D" />
                        <label for="question-6-answers-D">D) O(n log n)</label>
                    </div>
                </li>

                <!-- Question 7 -->
                <li>
                    <h3>During each iteration of the selection sort, how many elements are actively involved in the comparison and swapping process?</h3>
                    <div>
                        <input type="radio" name="question-7-answers" value="A" />
                        <label for="question-7-answers-A">A) One element</label>
                    </div>
                    <div>
                        <input type="radio" name="question-7-answers" value="B" />
                        <label for="question-7-answers-B">B) Two elements</label>
                    </div>
                    <div>
                        <input type="radio" name="question-7-answers" value="C" />
                        <label for="question-7-answers-C">C) Half of the elements</label>
                    </div>
                    <div>
                        <input type="radio" name="question-7-answers" value="D" />
                        <label for="question-7-answers-D">D) All elements in the unsorted portion</label>
                    </div>
                </li>
                   <!-- Question 8 -->

            <li>
                    <h3>What is the primary operation performed in the selection sort algorithm?</h3>
                    <div>
                        <input type="radio" name="question-8-answers" value="A" />
                        <label for="question-8-answers-A">A) Swapping</label>
                    </div>
                    <div>
                        <input type="radio" name="question-8-answers" value="B" />
                        <label for="question-8-answers-B">B) Partitioning</label>
                    </div>
                    <div>
                        <input type="radio" name="question-8-answers" value="C" />
                        <label for="question-8-answers-C">C) Merging</label>
                    </div>
                    <div>
                        <input type="radio" name="question-8-answers" value="D" />
                        <label for="question-8-answers-D">D) Insertion</label>
                    </div>
                </li>
                
                   <!-- Question 9 -->
                   
                    <li>
                    <h3>In selection sort, the maximum number of comparisons needed for a list of n elements is:?</h3>
                    <div>
                        <input type="radio" name="question-9-answers" value="A" />
                        <label for="question-9-answers-A">A) n</label>
                    </div>
                    <div>
                        <input type="radio" name="question-9-answers" value="B" />
                        <label for="question-9-answers-B">B) n-1</label>
                    </div>
                    <div>
                        <input type="radio" name="question-9-answers" value="C" />
                        <label for="question-9-answers-C">C) n/2</label>
                    </div>
                    <div>
                        <input type="radio" name="question-9-answers" value="D" />
                        <label for="question-9-answers-D">D) n^2</label>
                    </div>
                </li>
                
                 <!-- Question 10 -->
                   
                    <li>
                    <h3>In selection sort, during each iteration, how many elements are actively involved in the comparison and swapping process?</h3>
                    <div>
                        <input type="radio" name="question-10-answers" value="A" />
                        <label for="question-10-answers-A">A) One element</label>
                    </div>
                    <div>
                        <input type="radio" name="question-10-answers" value="B" />
                        <label for="question-10-answers-B">B) Two elements</label>
                    </div>
                    <div>
                        <input type="radio" name="question-10-answers" value="C" />
                        <label for="question-10-answers-C">C) Half of the elements</label>
                    </div>
                    <div>
                        <input type="radio" name="question-10-answers" value="D" />
                        <label for="question-10-answers-D">D) All elements in the unsorted portion</label>
                    </div>
                </li>
                
                

            </ol>
            
            <input type="submit" value="Submit Quiz" name="btnext"/>
        </form>
    
    </div>
    
    <!-- Google Analytics Scripts -->
    <script type="text/javascript">
        var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
        document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
    </script>
    <script type="text/javascript">
        var pageTracker = _gat._getTracker("UA-68528-29");
        pageTracker._initData();
        pageTracker._trackPageview();
    </script>

</body>
</html>