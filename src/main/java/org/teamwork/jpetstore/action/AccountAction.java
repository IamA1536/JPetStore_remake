package org.teamwork.jpetstore.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.serivce.AccountService;

import java.util.Map;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 9:03
 */
public class AccountAction extends ActionSupport implements Action, ModelDriven<Account> {
    private ActionContext actionContext = ActionContext.getContext();
    private Map<String, Object> session = actionContext.getSession();
    private Account account = new Account();
    private String username;
    private String password;
    private String vcstring;

    @Override
    public String execute() {
        return INPUT;
    }

    public String loginForm() {
        return INPUT;
    }

    public String login() {
        AccountService accountService = new AccountService();
        String str2 = (String) session.get("random");
        //取得session保存中的字符串
        //下面就是将session中保存验证码字符串与客户输入的验证码字符串对比了
        if (str2.equalsIgnoreCase(this.vcstring)) {
            try {
                this.account = accountService.getAccount(account);
                if (account == null) {
                    this.session.put("imageMess", "Invalid username or password.  login failed.");
                    return INPUT;
                } else {
                    this.session.put("account", account);
                    return SUCCESS;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.session.put("imageMess", "Verification code error!");
            return INPUT;
        }
        return INPUT;
    }

    public String signout() {
        session.clear();
        return INPUT;
    }

    public String newaccountform() {
        if (session.get("aflag") != null) {
            AccountService accountService = new AccountService();
            try {
                accountService.insertAccount(account);
                session.put("account", account);
                return SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            session.put("aflag", "ok");
            return INPUT;
        }
        return INPUT;
    }

    public String editaccountform() {

        AccountService accountService = new AccountService();
        try {
            accountService.updateAccount(account);
            session.put("account", account);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INPUT;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVcstring(String vcstring) {
        this.vcstring = vcstring;
    }

    @Override
    public Account getModel() {
        return account;
    }
}
