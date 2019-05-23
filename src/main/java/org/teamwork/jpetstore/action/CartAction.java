package org.teamwork.jpetstore.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.teamwork.jpetstore.domain.account.Account;
import org.teamwork.jpetstore.domain.carts.Cart;
import org.teamwork.jpetstore.domain.carts.CartItem;
import org.teamwork.jpetstore.domain.object.Item;
import org.teamwork.jpetstore.serivce.CatalogSerivce;

import java.util.Iterator;
import java.util.Map;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 22:57
 */
public class CartAction implements Action {
    private ActionContext actionContext = ActionContext.getContext();
    private Map<String, Object> session = actionContext.getSession();
    private String workingItemId;
    private Cart cart;
    private CatalogSerivce catalogSerivce;


    @Override
    public String execute() throws Exception {
        return null;
    }

    public String AddItemToCart() {
        cart = (Cart) session.get("cart");
        Account account = (Account) session.get("account");
        if (account == null) {
            String message = "Please sign in first!";
            session.put("message", message);
            return ERROR;
        }
        if (cart == null)
            cart = new Cart();
        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
            session.put("cart", cart);
//            LogSerive logSerive = new LogSerive();
//            try {
//
//                Item item = catalogSerivce.getItem(workingItemId);
//                String str = account.getUsername() + "adds" + item.getItemId() + "to cart";
//                logSerive.InsertLog(account, str);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            return SUCCESS;
        } else {
            catalogSerivce = new CatalogSerivce();
            try {
                boolean isInStock = catalogSerivce.isItemInStock(workingItemId);
                Item item = catalogSerivce.getItem(workingItemId);
                cart.addItem(item, isInStock);
                session.put("cart", cart);
                return SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return INPUT;
    }

    public String removeitemfromcart() {
        cart = (Cart) session.get("cart");
        Item item = cart.removeItemById(workingItemId);
        if (item == null) {
            session.put("message", "Attempted to remove null CartItem from Cart.");
            return ERROR;
        } else return SUCCESS;
    }

    public String vcart(){
        Cart cart = (Cart) session.get("cart");
        Account account = (Account) session.get("account");
        if (account == null) {
            String message = "Please sign in first!";
            session.put("message", message);
            return ERROR;
        }
        if (cart == null) {
            cart = new Cart();
            session.put("cart", cart);
        }
        return SUCCESS;
    }

    public void setWorkingItemId(String workingItemId) {
        this.workingItemId = workingItemId;
    }
}
