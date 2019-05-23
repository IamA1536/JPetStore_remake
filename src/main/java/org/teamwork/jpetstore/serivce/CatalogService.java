package org.teamwork.jpetstore.serivce;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.teamwork.jpetstore.domain.object.Category;
import org.teamwork.jpetstore.domain.object.Item;
import org.teamwork.jpetstore.domain.object.Product;
import org.teamwork.jpetstore.persistence.Mapper.CategoryMapper;
import org.teamwork.jpetstore.persistence.Mapper.ItemMapper;
import org.teamwork.jpetstore.persistence.Mapper.ProductMapper;
import org.teamwork.jpetstore.persistence.SessionFactoryUtil;

import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 17:42
 */
public class CatalogService {

    private SqlSessionFactory sqlSessionFactory;

    public CatalogService() {

    }

    public List<Category> getCategoryList() throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        return categoryMapper.getCategoryList();
    }

    public Category getCategory(String categoryId) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        return categoryMapper.getCategory(categoryId);
    }

    public Product getProduct(String productId) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        return productMapper.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        return productMapper.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        return productMapper.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemMapper itemMapper = sqlSession.getMapper(ItemMapper.class);
        return itemMapper.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemMapper itemMapper = sqlSession.getMapper(ItemMapper.class);
        return itemMapper.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) throws Exception {
        sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemMapper itemMapper = sqlSession.getMapper(ItemMapper.class);
        return itemMapper.getInventoryQuantity(itemId) > 0;
    }
}
