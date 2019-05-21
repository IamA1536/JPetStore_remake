package org.teamwork.jpetstore.persistence.impl;

import org.teamwork.jpetstore.domain.object.Item;
import org.teamwork.jpetstore.domain.object.Product;
import org.teamwork.jpetstore.persistence.DBUtil;
import org.teamwork.jpetstore.persistence.ItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/6 23:00
 */
public class ItemDAOImpl implements ItemDAO {
    private static final String getItemListByProduct = "SELECT I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\",NAME AS \"product.name\", DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\", STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
    //    private static final String getItemListByProduct = "SELECT I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\",NAME AS \"product.name\", DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\", STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ";
    private static final String getItem = "select I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\", DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\", STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5, QTY AS quantity from ITEM I, INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID  and I.ITEMID = V.ITEMID and I.ITEMID = ?";
    //    private static final String getItem = "select I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\", DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\", STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5, QTY AS quantity from ITEM I, INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID  and I.ITEMID = V.ITEMID and I.ITEMID = ";
    private static final String getInventoryQuantity = "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ?";
    //    private static final String getInventoryQuantity = "SELECT QTY AS value FROM INVENTORY WHERE ITEMID = ";
    private static final String updateInventoryQuantity = "UPDATE INVENTORY SET QTY = QTY - ? WHERE ITEMID = ?";
//    private static final String updateInventoryQuantity = "UPDATE INVENTORY SET QTY = QTY - #{increment} WHERE ITEMID = #{itemId}";

    @Override
    public void updateInventoryQuantity(Map<String, Object> param) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(updateInventoryQuantity);
        String itemId = param.keySet().iterator().next();
        itemId = (String) param.get(itemId);

        Integer increment = (Integer) param.get("increment");


        preparedStatement.setInt(1, increment);
        preparedStatement.setString(2, itemId);

        preparedStatement.execute();
//        DBUtil.closeStatement(statement);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);

    }

    @Override
    public int getInventoryQuantity(String itemId) throws Exception {
        int result = -1;
        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(getInventoryQuantity);
        preparedStatement.setString(1, itemId);
//        String str = getInventoryQuantity + "'" + itemId + "'";
//        ResultSet resultSet = statement.executeQuery(str);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            result = resultSet.getInt(1);

        DBUtil.closeResultSet(resultSet);
//        DBUtil.closeStatement(statement);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
        return result;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) throws Exception {
        List<Item> itemList = new ArrayList<Item>();
        Connection connection = DBUtil.getConnection();
//        Statement statement = connection.createStatement();
//        String str = getItemListByProduct + "'" + productId + "'";
//        ResultSet resultSet = statement.executeQuery(str);
        PreparedStatement preparedStatement = connection.prepareStatement(getItemListByProduct);
        preparedStatement.setString(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Item item = new Item();
            item.setItemId(resultSet.getString(1));
            item.setListPrice(resultSet.getBigDecimal(2));
            item.setUnitCost(resultSet.getBigDecimal(3));
            item.setSupplierId(resultSet.getInt(4));
            Product product = new Product();
            product.setProductId(resultSet.getString(5));
            product.setName(resultSet.getString(6));
            product.setDescription(resultSet.getString(7));
            product.setCategoryId(resultSet.getString(8));
            item.setProduct(product);
            item.setStatus(resultSet.getString(9));
            item.setAttribute1(resultSet.getString(10));
            item.setAttribute2(resultSet.getString(11));
            item.setAttribute3(resultSet.getString(12));
            item.setAttribute4(resultSet.getString(13));
            item.setAttribute5(resultSet.getString(14));
            itemList.add(item);
        }
        DBUtil.closeResultSet(resultSet);
//        DBUtil.closeStatement(statement);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
        return itemList;
    }

    @Override
    public Item getItem(String itemId) throws Exception {
        Item item = null;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(getItem);
        preparedStatement.setString(1, itemId);
        ResultSet resultSet = preparedStatement.executeQuery();
//        String str = getItem + "'" + itemId + "'";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(str);
        if (resultSet.next()) {
            item = new Item();
            item.setItemId(resultSet.getString(1));
            item.setListPrice(resultSet.getBigDecimal(2));
            item.setUnitCost(resultSet.getBigDecimal(3));
            item.setSupplierId(resultSet.getInt(4));
            Product product = new Product();
            product.setProductId(resultSet.getString(5));
            product.setName(resultSet.getString(6));
            product.setDescription(resultSet.getString(7));
            product.setCategoryId(resultSet.getString(8));
            item.setProduct(product);
            item.setStatus(resultSet.getString(9));
            item.setAttribute1(resultSet.getString(10));
            item.setAttribute2(resultSet.getString(11));
            item.setAttribute3(resultSet.getString(12));
            item.setAttribute4(resultSet.getString(13));
            item.setAttribute5(resultSet.getString(14));
            item.setQuantity(resultSet.getInt(15));
        }
        DBUtil.closeResultSet(resultSet);
//        DBUtil.closeStatement(statement);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
        return item;
    }
}
