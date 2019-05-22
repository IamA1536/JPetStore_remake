package org.teamwork.jpetstore.action;


import com.opensymphony.xwork2.Action;
import org.teamwork.jpetstore.domain.orders.Order;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 22:57
 */
public class OrderAction implements Action {
    private Order order;

    @Override
    public String execute() throws Exception {
        return null;
    }

    public String neworderform(){

        return INPUT;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
