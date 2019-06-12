package org.teamwork.jpetstore.action;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.domain.carts.Cart;
import org.teamwork.jpetstore.domain.orders.Order;
import org.teamwork.jpetstore.serivce.OrderService;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 22:57
 */
public class OrderAction implements Action, ModelDriven<Order> {
    private ActionContext actionContext = ActionContext.getContext();
    private Map<String, Object> session = actionContext.getSession();
    private Order order = new Order();

    @Override
    public String execute() {
        return null;
    }

    public String neworderform() {
        Account account = (Account) this.session.get("account");
        if (account == null) {
            String message = "Please sign in first!";
            this.session.put("message", message);
            return ERROR;
        }
        return SUCCESS;
    }

    public String confirmorder() {
//        System.out.println(order.getOrderId() + " " + order.getShipToLastName());
        this.session.put("order", this.order);
        return SUCCESS;
    }

    public String vorder() {
        Account account = (Account) session.get("account");
        Cart cart = (Cart) session.get("cart");
        this.order.initOrder(account, cart);
        Calendar c = Calendar.getInstance();
        String str = c.get(Calendar.MONTH) + String.valueOf(c.get(Calendar.DATE)) + c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.MINUTE) + c.get(Calendar.SECOND);
        int orderId = Integer.valueOf(str);
        this.order.setOrderId(orderId);
        return SUCCESS;
    }

    public String listorders() {
        OrderService orderService = new OrderService();
        Account account = (Account) session.get("account");
        try {
            List<Order> orderList;
            orderList = orderService.getOrdersByUsername(account.getUsername());
            session.put("orderList", orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INPUT;
    }

    @Override
    public Order getModel() {
        return order;
    }
}
