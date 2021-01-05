package th.ac.ku.atm.controller;

import org.springframework.ui.Model;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.CustomerService;

public class BankAccountController {
    private BankAccount bankAccount;

    public BankAccountController(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


}
