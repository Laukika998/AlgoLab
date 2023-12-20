<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quiz Result</title>
     <style>
     body {
     background-color: #f8f9fa;
      font-family: Arial, sans-serif;
     }
      ul {
			margin: 40px;
            padding: 20px;
            border-radius: 10px;
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #ADB5BD;
           
            width: 100%;
        }
     
     li {
            float: left;
        }
       li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
         li strong {
			float: left;
			 color: black;
            text-align: center;
            padding: 14px 110px;
            text-decoration: none;
			
		}
     .page {
     margin : 20px;
     padding : 20px;
      background-color: #343A40;
       
     }
     h2 {
     color: white;
     }
     p {
     color: white;
     }
     </style>
    
</head>
<body>
     <div class="nav">
        <ul>
               <li><a href="Home.html">Home</a></li>
            <li><a href="input.html">Sorting Algorithms</a></li>
            <li><a href="inputsearch.html">Searching Algorithms</a></li>
            <li><a href="arrayopt.html">Array Operations</a></li>
            <li><a href="learnDSA.html">Learn Data Structure Algorithm</a></li>
             <li><a href="Java_Quiz.jsp">DSA Quiz</a></li>
              <li><a href="About.jsp">About</a></li>
               <li><a href="Contactus.jsp">Contact us</a></li>
                <li><a href="index.jsp">Login</a></li>
                  <li><strong>AlgoLab</strong></li>
        </ul>
    </div>
<div class="page">
 <h2>Quiz Results</h2>
       
    <p>Your Score: ${score}</p>
</div>

      


</body>
</html>