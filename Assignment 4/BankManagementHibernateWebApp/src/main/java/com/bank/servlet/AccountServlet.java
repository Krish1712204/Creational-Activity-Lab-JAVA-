package com.bank.servlet;

import com.bank.model.Account;
import com.bank.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String holderName = request.getParameter("holderName");
        double balance = Double.parseDouble(request.getParameter("balance"));

        Account acc = new Account(holderName, balance);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(acc);
        tx.commit();
        session.close();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Account Created Successfully!</h2>");
        out.println("<p>Name: " + holderName + "</p>");
        out.println("<p>Balance: " + balance + "</p>");
    }
}
