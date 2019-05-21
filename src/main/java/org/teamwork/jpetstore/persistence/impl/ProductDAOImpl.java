package org.teamwork.jpetstore.persistence.impl;

import org.teamwork.jpetstore.domain.object.Product;
import org.teamwork.jpetstore.persistence.DBUtil;
import org.teamwork.jpetstore.persistence.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 17:21
 */

public class ProductDAOImpl implements ProductDAO {
    private static final String GET_PRODUCT_LIST_BY_CATEGORY = "SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE CATEGORY = ?";
//    private static final String GET_PRODUCT_LIST_BY_CATEGORY = "SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE CATEGORY = ";

    private static final String GET_PRODUCT = "SELECT PRODUCTID,NAME,DESCN as description, CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ?";
//    private static final String GET_PRODUCT = "SELECT PRODUCTID,NAME,DESCN as description, CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ";

    private static final String SREACH_PRODUCT_LIST_STRING = "select PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId from PRODUCT WHERE lower(name) like ?";
//    private static final String SREACH_PRODUCT_LIST_STRING = "select PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId from PRODUCT WHERE lower(name) like ";

    @Override
    public List<Product> getProductListByCategory(String categoryId) throws Exception {
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST_BY_CATEGORY);
        preparedStatement.setString(1, categoryId);
        ResultSet resultSet = preparedStatement.executeQuery();
//        String str = GET_PRODUCT_LIST_BY_CATEGORY + "'" + categoryId + "'";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getString(1));
            product.setName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setCategoryId(resultSet.getString(4));
            productList.add(product);
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
//        DBUtil.closeStatement(statement);
        DBUtil.closeConnection(connection);
        return productList;
    }


    @Override
    public Product getProduct(String productId) throws Exception {
        Product product = null;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
        preparedStatement.setString(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
//        String str = GET_PRODUCT + "'" + productId + "'";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(str);
        if (resultSet.next()) {
            product = new Product();
            product.setProductId(resultSet.getString(1));
            product.setName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setCategoryId(resultSet.getString(4));

        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
//        DBUtil.closeStatement(statement);
        DBUtil.closeConnection(connection);
        return product;
    }


    @Override
    public List<Product> searchProductList(String keywords) throws Exception {
        List<Product> productList = new ArrayList<Product>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SREACH_PRODUCT_LIST_STRING);
        preparedStatement.setString(1, keywords);
        ResultSet resultSet = preparedStatement.executeQuery();
//        String str = SREACH_PRODUCT_LIST_STRING + "'" + keywords + "'";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getString(1));
            product.setName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setCategoryId(resultSet.getString(4));
            productList.add(product);
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
//        DBUtil.closeStatement(tatement);
        DBUtil.closeConnection(connection);
        return productList;
    }
}
