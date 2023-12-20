<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - E-Learning Platform</title>
    <style>
        body {
            font-family: Arial, sans-serif;
          
           background-color: #f8f9fa;
        }
        ul {
			
			margin: 0px;
            padding: 20px;
            border-radius: 10px;
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #343A40 ;
           
            width: 100%;
        }

        li {
            float: left;
            
        }
        li strong {
			float: left;
			 color: white;
            text-align: center;
            padding: 14px 110px;
            text-decoration: none;
			
		}

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }      
        
        section {
        color : white;
            margin: 20px;
            padding: 20px;
           background-color: #343A40;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: white;
        }

        p {
            line-height: 1.6;
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

   

    <section>
    <h1>E-Learning Platform</h1>
        <h2>About Us</h2>

        <p>Welcome to E-Learning Platform, your go-to place for online education. Our mission is to provide high-quality courses on various subjects, empowering learners worldwide.</p>

        <h3>Our Team</h3>

        <p>We have a dedicated team of educators and professionals committed to delivering engaging and informative content. Our instructors bring real-world experience to the virtual classroom, ensuring that you receive practical insights.</p>

        <h3>Contact Us</h3>

        <p>If you have any questions or feedback, feel free to reach out to us at <a href="Contactus.jsp">Contact Us</a>.</p>
    </section>
</body>
</html>