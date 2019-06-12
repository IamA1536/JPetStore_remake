<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">
        Return to Main Menu
    </a>
</div>

<div id="Catalog">
    <div id="Cart">
        <h2>Shopping Cart</h2>
        <table>
            <tr>
                <th><b>Item ID</b></th>
                <th><b>Product ID</b></th>
                <th><b>Description</b></th>
                <th><b>In Stock?</b></th>
                <th><b>Quantity</b></th>
                <th><b>List Price</b></th>
                <th><b>Total Cost</b></th>

            </tr>
            <s:if test="#session.cart.numberOfItems == 0">
                <tr>
                    <td colspan="8"><b>Your cart is empty.</b></td>
                </tr>
            </s:if>
            <s:iterator var="cartItem" value="#session.cart.cartItems">
                <tr>
                    <td>
                        <a href="" id="product">${cartItem.item.itemId}</a>
                    </td>
                    <td id="productId">
                            ${cartItem.item.product.productId}
                    </td>
                    <td>
                            ${cartItem.item.attribute1} ${cartItem.item.attribute2}
                            ${cartItem.item.attribute3} ${cartItem.item.attribute4}
                            ${cartItem.item.attribute5} ${cartItem.item.product.name}
                    </td>
                    <td>${cartItem.inStock}</td>
                    <td>
                        <input id="quantity" type="text" name="${cartItem.item.itemId}"
                               value="${cartItem.quantity}"/>
                    </td>
                    <td>
                        <fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00"/>
                    </td>
                    <td>
                        <fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00"/>
                    </td>
                    <td>
                        <a id="Remove" class="Button" name="remove"
                           href="removeitemfromcart?workingItemId=${cartItem.item.itemId}">
                            Remove
                        </a>
                    </td>
                </tr>
            </s:iterator>
            <tr>
                <td colspan="7">Sub Total:<fmt:formatNumber value="#session.cart.subTotal"
                                                            pattern="$#,##0.00"/>
                </td>
            </tr>
        </table>
        <s:iterator var="cartItem" value="#session.cart.cartItems">
            <div>
                <table id="choiceWindow" class=${cartItem.item.itemId}>
                    <tr>
                        <td>${cartItem.item.product.description}</td>
                    </tr>
                    <tr>
                        <td><b> ${cartItem.item.itemId} </b></td>
                    </tr>
                    <tr>
                        <td>
                            <b><span style="font-size: medium; ">
                                        ${cartItem.item.attribute1}
                                        ${cartItem.item.attribute2} ${cartItem.item.attribute3}
                                        ${cartItem.item.attribute4} ${cartItem.item.attribute5}
                                        ${cartItem.item.product.name}
                                </span>
                            </b>
                        </td>
                    </tr>
                    <tr>
                        <td>${cartItem.item.product.name}</td>
                    </tr>
                    <tr>
                        <td>
                            <s:if test="#cartItem.item.quantity <= 0">
                                Back ordered.
                            </s:if>
                            <s:else>
                                ${cartItem.item.quantity} in stock.
                            </s:else>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00"/></td>
                    </tr>
                </table>
            </div>
            <div id="backGround"></div>
        </s:iterator>
        <s:if test="#session.cart.numberOfItems > 0">
            <a class="Button" href="neworderform">
                Proceed to Checkout
            </a>
        </s:if>
    </div>
    <script src="js/Carts.js"></script>
    <div id="Separator">&nbsp;</div>
</div>


<%@ include file="../common/IncludeBottom.jsp" %>