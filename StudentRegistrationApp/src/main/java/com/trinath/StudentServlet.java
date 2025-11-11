package com.trinath;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // Retrieve form data
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");

            // Create student object
            Student student = new Student(id, name, email);

            // DAO operation
            StudentDAO dao = new StudentDAO();
            int result = dao.registerStudent(student);

            // Prepare data for JSP
            if (result > 0) {
                req.setAttribute("status", "success");
                req.setAttribute("message", "Registration Successful!");
                req.setAttribute("name", name);
            } else {
                req.setAttribute("status", "fail");
                req.setAttribute("message", "Registration Failed!");
            }

            // Forward to JSP page
            req.getRequestDispatcher("status.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("status", "error");
            req.setAttribute("message", "⚠️ Error occurred! Please check your input or try again later.");
            req.getRequestDispatcher("status.jsp").forward(req, resp);
        }
    }
}
