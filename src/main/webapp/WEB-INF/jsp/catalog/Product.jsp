<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ include file="../common/IncludeTop.jsp" %>


<div id="BackLink">
    <a href="vcategory">Return
        to ${session.product.categoryId}</a>
</div>

<div id="Catalog">
    <h2>${session.product.name}</h2>

    <table>
        <tr>
            <th>Item ID</th>
            <th>Product ID</th>
            <th>Description</th>
            <th>List Price</th>
            <th>&nbsp;</th>
        </tr>
        <s:iterator var="item" value="#session.itemList">
            <tr>
                <td>
                    <a class="button" id="product">${item.itemId}</a>
                </td>
                <td>
                        ${item.product.productId}
                </td>
                <td>${item.attribute1} ${item.attribute2} ${item.attribute3}
                        ${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
                </td>
                <td><fmt:formatNumber value="${item.listPrice}"
                                      pattern="$#,##0.00"/>
                </td>
                <td>
                    <a class="Button" href="AddItemToCart?workingItemId=${item.itemId}">
                        Add to Cart</a>
                </td>
            </tr>
        </s:iterator>
        <s:iterator var="item" value="#session.itemList">
            <div>
                <table id="choiceWindow" class=${item.itemId}>
                    <tr>
                        <td>${item.product.description}</td>
                    </tr>
                    <tr>
                        <td><b> ${item.itemId} </b></td>
                    </tr>
                    <tr>
                        <td>
                            <b><span style="font-size: medium; ">
                                    ${item.attribute1}
                                    ${item.attribute2} ${item.attribute3}
                                    ${item.attribute4} ${item.attribute5}
                                    ${session.product.name}
                            </span>
                            </b>
                        </td>
                    </tr>
                    <tr>
                        <td>${item.product.name}</td>
                    </tr>
                    <tr>
                        <td>
                            <s:if test="#item.quantity <= 0">
                                Back ordered.
                            </s:if>
                            <s:else>
                                ${item.quantity} in stock.
                            </s:else>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00"/></td>
                    </tr>
                </table>
            </div>
            <div id="backGround"></div>
        </s:iterator>
    </table>
    <script src="js/Product.js"></script>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>



