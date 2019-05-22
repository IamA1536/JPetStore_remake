<%@ include file="../common/IncludeTop.jsp" %>

<h2>My Orders</h2>

<table>
    <tr>
        <th>Order ID</th>
        <th>Date</th>
        <th>Total Price</th>
    </tr>

    <s:iterator var="order" value="#session.orderList">
        <tr>
            <td>
                <a href="vorder?order=${order}">
                        ${order.orderId}
                </a>
            </td>
            <td><fmt:formatDate value="${order.orderDate}"
                                pattern="yyyy/MM/dd hh:mm:ss"/></td>
            <td><fmt:formatNumber value="${order.totalPrice}"
                                  pattern="$#,##0.00"/></td>
        </tr>
    </s:iterator>
</table>

<%@ include file="../common/IncludeBottom.jsp" %>


