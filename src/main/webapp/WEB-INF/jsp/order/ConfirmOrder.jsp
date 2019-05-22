<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
    <a href="main">
        Return to Main Menu
    </a>
</div>

<div id="Catalog">Please confirm the information below and then press continue...

    <table>
        <tr>
            <th align="center" colspan="2"><span style="font-size: medium; "><b>Order</b></span>
                <br/>
                <span style="font-size: small; ">
                    <b>
                    <fmt:formatDate
                            value="${session.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss"/>
                    </b>
                </span>
            </th>
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
            <td><s:property value="#session.order.billAddress2"/></td>
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
            <td><s:property value="#session.order.billZip"/></td>
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

    </table>

    <a class="Button" href="vorder">
        Confirm
    </a>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>





