package org.teamwork.jpetstore.action;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.domain.carts.Cart;
import org.teamwork.jpetstore.domain.orders.Order;
import org.teamwork.jpetstore.serivce.OrderSerive;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 22:57
 */
public class OrderAction implements Action, ModelDriven<Order> {
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    private Order order = new Order();

    @Override
    public String execute() throws Exception {
        return null;
    }

    public String neworderform() {
        Account account = (Account) this.session.get("account");
        String flag = (String) session.get("flag");
        if (account == null) {
            String message = "Please sign in first!";
            session.put("message", message);
            return ERROR;
        }
        return SUCCESS;
//        else
//            if (flag == null) {
//            session.put("flag", "ok");
////            this.order = new Order();
//            this.order.initOrder(account, cart);
//            Calendar c = Calendar.getInstance();
//            String str = c.get(Calendar.MONTH) + String.valueOf(c.get(Calendar.DATE)) + c.get(Calendar.HOUR_OF_DAY) + String.valueOf(c.get(Calendar.MINUTE)) + String.valueOf(c.get(Calendar.SECOND));
//            int orderId = Integer.valueOf(str);
//            this.order.setOrderId(orderId);
//            System.out.println(this.order.getOrderId() + " " + this.order.getCreditCard() + " " + this.order.getShipToLastName());
//            session.put("order", this.order);
//            return INPUT;
//        } else {
//            System.out.println(order.getOrderId()+" "+order.getShipToLastName());
//            session.put("order", this.order);
//        }
////        else {
//////            order.setCreditCard(request.getParameter("creditcard"));
//////            order.setExpiryDate(request.getParameter("expirydate"));
//////            order.setCardType(request.getParameter("cardtype"));
//////            order.setShipToFirstName(request.getParameter("shiptofirstName"));
//////            order.setShipToLastName(request.getParameter("shiptolastName"));
//////            order.setShipAddress1(request.getParameter("shipaddress1"));
//////            order.setShipAddress2(request.getParameter("shipaddress2"));
//////            order.setShipCity(request.getParameter("shipcity"));
//////            order.setShipState(request.getParameter("shipstate"));
//////            order.setShipZip(request.getParameter("shipzip"));
//////            order.setShipCountry(request.getParameter("shipcountry"));
////
////            session.put("order", this.order);
////        }
//
//        return SUCCESS;
    }

    public String confirmorder() {
        System.out.println(order.getOrderId() + " " + order.getShipToLastName());
        session.put("order", this.order);
        return SUCCESS;
    }

    public String vorder() {
        Account account = (Account) session.get("account");
        Cart cart = (Cart) session.get("cart");
        this.order.initOrder(account, cart);
        Calendar c = Calendar.getInstance();
        String str = c.get(Calendar.MONTH) + String.valueOf(c.get(Calendar.DATE)) + c.get(Calendar.HOUR_OF_DAY) + String.valueOf(c.get(Calendar.MINUTE)) + String.valueOf(c.get(Calendar.SECOND));
        int orderId = Integer.valueOf(str);
        this.order.setOrderId(orderId);
        OrderSerive orderSerive = new OrderSerive();
//        try {
//            orderSerive.insertOrder(order);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        LogSerive logSerive = new LogSerive();
//        String str = "Make a order:" + order.getOrderId();
//        try {
//            logSerive.InsertLog(account, str);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return SUCCESS;
    }

    public String listorders(){
        OrderSerive orderSerive = new OrderSerive();
        Account account= (Account) session.get("account");
        try {
            List<Order> orderList;
            orderList = orderSerive.getOrdersByUsername(account.getUsername());
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
