package org.teamwork.jpetstore.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.serivce.AccountService;

import java.io.ByteArrayInputStream;
import java.util.Map;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 9:03
 */
public class AccountAction extends ActionSupport implements Action {
    private ActionContext actionContext = ActionContext.getContext();
    private Map<String, Object> session = actionContext.getSession();
    private Account account;
    private String username;
    private String password;
    private String vcstring;
    private String error;

    @Override
    public String execute() throws Exception {
        return INPUT;
    }

    public String loginForm() {
        return INPUT;
    }

    public String login() throws Exception {
        AccountService accountService = new AccountService();

        if (this.username == null || this.password == null)
            return INPUT;
        else {
            String str2 = (String) session.get("random");
            //取得session保存中的字符串
            //下面就是将session中保存验证码字符串与客户输入的验证码字符串对比了
            if (str2.equalsIgnoreCase(this.vcstring)) {
                try {
                    this.account = accountService.getAccount(this.username, this.password);
                    if (account == null) {
                        this.session.put("imageMess", "Invalid username or password.  login failed.");
                        System.out.println(this.username + " " + this.password);
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
        }
        return INPUT;
    }

    public String signout() {
        session.clear();
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
}
