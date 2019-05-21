package org.teamwork.jpetstore.action;

import com.opensymphony.xwork2.Action;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.serivce.AccountService;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 9:03
 */
public class AccountAction implements Action {
    private Account account;
    private AccountService accountService;

    AccountAction() {
        this.accountService = new AccountService();
    }

    @Override
    public String execute() throws Exception {
        return "input";
    }

    public String login() throws Exception {
        System.out.println(account.getUsername() + " " + account.getPassword());
        if (accountService.getAccount(account.getUsername(), account.getPassword()) == null)
            return "inout";
        else return "success";
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
