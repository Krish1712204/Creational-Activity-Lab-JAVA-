package controller;

import dao.UserDAO;
import model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            User user = new User(name, email);
            userDAO.addUser(user);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            userDAO.deleteUserUsingProcedure(id);
        }

        response.sendRedirect("viewUsers.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        List<User> users = userDAO.getAllUsers();
        request.setAttribute("userList", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewUsers.jsp");
        dispatcher.forward(request, response);
    }
}