package org.teamwork.jpetstore.util;


import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.teamwork.jpetstore.serivce.AccountService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/28 12:25
 */


public class ToolsAction implements Action, ServletResponseAware {
    private String usename;
    private HttpServletResponse response;
    private String IsExist;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    public String usenameisexist() throws IOException {
        AccountService accountService = new AccountService();
        PrintWriter out = response.getWriter();
        try {
            if (accountService.getAccount(this.usename) == null) {
                out.print("NotExist");
            } else {
                out.print("Exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INPUT;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }


    public String getIsExist() {
        return IsExist;
    }

    public void setIsExist(String isExist) {
        IsExist = isExist;
    }
}