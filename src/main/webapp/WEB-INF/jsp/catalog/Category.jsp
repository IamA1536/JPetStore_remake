<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>
<div id="Catalog">

    <h2>${session.category.name}</h2>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <s:iterator var="product" value="#session.productList">
            <tr>
                <td>
                    <a href="vproduct?productId=${product.productId}">${product.productId}</a>
                </td>
                <td>${product.name}</td>
            </tr>
        </s:iterator>
    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


