<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">
        Return to Main Menu
    </a>
</div>

<div id="Catalog">
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <s:iterator var="product" value="#session.productList">
            <tr>
                <td>
                    <a href="vproduct?productId=${product.productId}">
                            ${product.description}
                    </a>
                </td>
                <td>
                    <a href="vproduct?productId=${product.productId}">
                        <span style="color: BLACK; "> ${product.productId} </span>
                    </a>
                </td>
                <td>${product.name}</td>
            </tr>
        </s:iterator>
        <tr>
            <td></td>
        </tr>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>




