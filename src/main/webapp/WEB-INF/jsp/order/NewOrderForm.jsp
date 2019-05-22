<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="#" method="post">
        <table>
            <tr>
                <th colspan=2>Payment Details</th>
            </tr>
            <tr>
                <td>Card Type:</td>
                <td>
                    <select name="cardtype">
                        <option selected="selected" value="Visa">Visa</option>
                        <option value="MasterCard">MasterCard</option>
                        <option value="American Express">American Express</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Credit Card:</td>
                <td><input name="creditcard" value="000 0000 0000 0000" type="text"></td>
            </tr>
            <tr>
                <td>Expiry Date:</td>
                <td><input name="expirydate" value="12/03" type="text"></td>
            </tr>
            <tr>
                <th colspan=2>Billing Address</th>
            </tr>

            <tr>
                <td>First name:</td>
                <td><input type="text" name="billtofirstName" value="${session.account.firstName}"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="billtolastName" value="${session.account.lastName}"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40" name="billaddress1" value="${session.account.address1}"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40" name="billaddress2" value="${session.account.address2}"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="billcity" value="${session.account.city}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="billstate" value="${session.account.state}"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="billzip" value="${session.account.zip}"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" size="15" name="billcountry" value="${session.account.country}"/></td>
            </tr>
            <tr class="ship">
                <td colspan=2>
                    <a id="shippingAddress" type="button" name="shippingAddressRequired" value="true">
                        Ship to different address...
                    </a>
                </td>
            </tr>
        </table>
        <table class="shiptable">
            <tr>
                <th colspan=2>Shipping Address</th>
            </tr>
            <tr>
                <td>First name:</td>
                <td><input type="text" name="shiptofirstName" value="${session.order.shipToFirstName}"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="shiptolastName" value="${session.order.shipToLastName}"/></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40" name="shipaddress1" value="${session.account.address1}"/></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40" name="shipaddress2" value="${session.account.address2}"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="shipcity" value="${session.account.city}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="shipstate" value="${session.account.state}"/></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="shipzip" value="${session.account.zip}"/></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" size="15" name="shipcountry" value="${session.account.country}"/></td>
            </tr>
        </table>

        <div id="Separator">&nbsp;</div>
        <input name="newOrder" value="Continue" type="submit">
    </form>
    <script src="js/NewOrder.js"></script>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>