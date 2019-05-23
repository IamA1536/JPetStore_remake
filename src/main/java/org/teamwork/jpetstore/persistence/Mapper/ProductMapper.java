package org.teamwork.jpetstore.persistence.Mapper;


import org.teamwork.jpetstore.domain.object.Product;

import java.util.List;

public interface ProductMapper {

  List<Product> getProductListByCategory(String categoryId);

  Product getProduct(String productId);

  List<Product> searchProductList(String keywords);

}
