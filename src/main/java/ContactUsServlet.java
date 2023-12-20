import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String message = request.getParameter("message");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/algolab";
            String dbUser = "root";
            String dbPassword = "Laukika@123";

            // JDBC variables for opening, closing, and managing connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, dbUser, dbPassword);

            // SQL query to insert data into the messages table
            String sql = "INSERT INTO messages (name, email, mobile, message) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, mobile);
            preparedStatement.setString(4, message);

            // Execute the SQL query
            preparedStatement.executeUpdate();

            response.sendRedirect("Success.jsp"); // Redirect to a success page
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}