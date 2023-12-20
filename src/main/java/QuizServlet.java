import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Correct answers
        String[] correctAnswers = {"C", "A", "C", "A", "C", "D", "A", "A", "B", "A"};

        // User's answers
        String[] userAnswers = new String[correctAnswers.length];

        // Retrieve user's answers from the request
        for (int i = 0; i < correctAnswers.length; i++) {
            String paramName = "question-" + (i + 1) + "-answers";
            userAnswers[i] = request.getParameter(paramName);
        }

        // Calculate the score
        int score = calculateScore(correctAnswers, userAnswers);

        // Pass the score as an attribute to the request
        request.setAttribute("score", score);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/score.jsp").forward(request, response);
    }

    private int calculateScore(String[] correctAnswers, String[] userAnswers) {
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equals(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }
}