package com.bank.controller;

import com.bank.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("account", new Account());
        return "accountForm";
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute("account") Account account, Model model) {
        model.addAttribute("message", "Account created for " + account.getHolderName() +
                " with balance: $" + account.getBalance());
        return "success";
    }
}
