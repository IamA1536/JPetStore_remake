package org.teamwork.jpetstore.persistence.Mapper;


import org.teamwork.jpetstore.domain.orders.LineItem;

import java.util.List;

public interface LineItemMapper {

  List<LineItem> getLineItemsByOrderId(int orderId);

  void insertLineItem(LineItem lineItem);

}
