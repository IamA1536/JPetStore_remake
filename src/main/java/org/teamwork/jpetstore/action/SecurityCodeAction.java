package org.teamwork.jpetstore.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.teamwork.jpetstore.domain.extra.SecurityCode;

import java.io.ByteArrayInputStream;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/22 18:09
 */
public class SecurityCodeAction extends ActionSupport {

    private ByteArrayInputStream inputStream;

    public String execute() {
        SecurityCode securityCode = SecurityCode.Instance();
        this.inputStream = securityCode.getImage();
        //取得带有随机字符串的图片
        ActionContext.getContext().getSession().put("random", securityCode.getString());//取得随机字符串放入HttpSession
        return SUCCESS;
    }

    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }
}
