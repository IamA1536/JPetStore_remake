package org.teamwork.jpetstore.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.teamwork.jpetstore.domain.object.Category;
import org.teamwork.jpetstore.domain.object.Item;
import org.teamwork.jpetstore.domain.object.Product;
import org.teamwork.jpetstore.serivce.CatalogService;

import java.util.List;
import java.util.Map;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/5/21 21:00
 */
public class CatalogAction implements Action {

    private ActionContext actionContext = ActionContext.getContext();
    private Map<String, Object> session = actionContext.getSession();
    private String productId;
    private String categoryId;
    private String keyword;


    @Override
    public String execute() {
        return INPUT;
    }

    public String main() {
        return INPUT;
    }

    public String product() {
        CatalogService catalogService = new CatalogService();
        try {
            Product product = catalogService.getProduct(productId);
            List<Item> itemList = catalogService.getItemListByProduct(productId);
            this.session.put("product", product);
            this.session.put("itemList", itemList);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INPUT;
    }

    public String category() {
        CatalogService service = new CatalogService();
        try {
            Category category = service.getCategory(categoryId);
            List<Product> productList = service.getProductListByCategory(categoryId);
            this.session.put("category", category);
            this.session.put("productList", productList);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INPUT;
    }

    public String search() {
        CatalogService service = new CatalogService();
        try {
            List<Product> productList = service.searchProductList(keyword);
            session.put("productList", productList);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INPUT;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
