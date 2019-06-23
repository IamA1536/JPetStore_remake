<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <table>
        <tr>
            <th align="center" colspan="2">Order #${session.order.orderId}
                <fmt:formatDate value="${session.order.orderDate}"
                                pattern="yyyy/MM/dd hh:mm:ss"/></th>
        </tr>
        <tr>
            <th colspan="2">Payment Details</th>
        </tr>
        <tr>
            <td>Card Type:</td>
            <td><s:property value="#session.order.cardType"/></td>
        </tr>
        <tr>
            <td>Card Number:</td>
            <td><s:property value="#session.order.creditCard"/> * Fake
                number!
            </td>
        </tr>
        <tr>
            <td>Expiry Date (MM/YYYY):</td>
            <td><s:property value="#session.order.expiryDate"/></td>
        </tr>
        <tr>
            <th colspan="2">Billing Address</th>
        </tr>
        <tr>
            <td>First name:</td>
            <td><s:property value="#session.order.billToFirstName"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><s:property value="#session.order.billToLastName"/></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><s:property value="#session.order.billAddress1"/></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><s:property value="#sessionS.order.billAddress2"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><s:property value="#session.order.billCity"/></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><s:property value="#session.order.billState"/></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><s:property value="#sessione.order.billZip"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><s:property value="#session.order.billCountry"/></td>
        </tr>
        <tr>
            <th colspan="2">Shipping Address</th>
        </tr>
        <tr>
            <td>First name:</td>
            <td><s:property value="#session.order.shipToFirstName"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><s:property value="#session.order.shipToLastName"/></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><s:property value="#session.order.shipAddress1"/></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><s:property value="#session.order.shipAddress2"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><s:property value="#session.order.shipCity"/></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><s:property value="#session.order.shipState"/></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><s:property value="#session.order.shipZip"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><s:property value="#session.order.shipCountry"/></td>
        </tr>
        <tr>
            <td>Courier:</td>
            <td><s:property value="#sessionScope.order.courier"/></td>
        </tr>
        <tr>
            <td colspan="2">Status: <s:property value="#session.order.status"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td colspan="2">--%>
<%--                <table>--%>
<%--                    <tr>--%>
<%--                        <th>Item ID</th>--%>
<%--                        <th>Description</th>--%>
<%--                        <th>Quantity</th>--%>
<%--                        <th>Price</th>--%>
<%--                        <th>Total Cost</th>--%>
<%--                    </tr>--%>
<%--                    <s:iterator var="lineItem" value="#session.order.lineItems">--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <a href="vitem?itemId=${lineItem.item.itemId}&productId= ${lineItem.item.product.productId}">--%>
<%--                                        ${lineItem.item.itemId}--%>
<%--                                </a>--%>
<%--                            </td>--%>
<%--                            <td><s:if test="${lineItem.item != null}">--%>
<%--                                ${lineItem.item.attribute1}--%>
<%--                                ${lineItem.item.attribute2}--%>
<%--                                ${lineItem.item.attribute3}--%>
<%--                                ${lineItem.item.attribute4}--%>
<%--                                ${lineItem.item.attribute5}--%>
<%--                                ${lineItem.item.product.name}--%>
<%--                            </s:if>--%>
<%--                                <s:else>--%>
<%--                                    <i>{description unavailable}</i>--%>
<%--                                </s:else></td>--%>

<%--                            <td>${lineItem.quantity}</td>--%>
<%--                            <td><fmt:formatNumber value="${lineItem.unitPrice}"--%>
<%--                                                  pattern="$#,##0.00"/></td>--%>
<%--                            <td><fmt:formatNumber value="${lineItem.total}"--%>
<%--                                                  pattern="$#,##0.00"/></td>--%>
<%--                        </tr>--%>
<%--                    </s:iterator>--%>
<%--                    <tr>--%>
<%--                        <th colspan="5">Total: <fmt:formatNumber--%>
<%--                                value="${session.order.totalPrice}" pattern="$#,##0.00"/></th>--%>
<%--                    </tr>--%>
<%--                </table>--%>
<%--            </td>--%>
<%--        </tr>--%>

    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>
