package org.teamwork.jpetstore.persistence.Mapper;


import org.teamwork.jpetstore.domain.object.Category;

import java.util.List;

public interface CategoryMapper {

  List<Category> getCategoryList();

  Category getCategory(String categoryId);

}
