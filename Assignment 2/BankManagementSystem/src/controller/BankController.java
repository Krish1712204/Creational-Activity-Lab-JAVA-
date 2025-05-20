package controller;

import dao.AccountDAO;
import model.Account;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BankController extends HttpServlet {
    private AccountDAO accountDAO;

    public void init() {
        accountDAO = new AccountDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String name = request.getParameter("name");
            double balance = Double.parseDouble(request.getParameter("balance"));

            Account account = new Account(name, balance);
            accountDAO.createAccount(account);
        }

        response.sendRedirect("BankController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Account> accounts = accountDAO.getAllAccounts();
        request.setAttribute("accountList", accounts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAccounts.jsp");
        dispatcher.forward(request, response);
    }
}