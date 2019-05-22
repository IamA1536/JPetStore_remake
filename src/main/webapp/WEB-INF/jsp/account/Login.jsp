<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="login" method="post">
        <p>Please enter your username and password.</p>
        <p>
            <tr>
                <td>
                    Username:<input type="text" name="username" value=""><br/>
                </td>
                <td>
                    Password:<input type="password" name="password" value=""><br/>
                </td>
                <td>
                    VerifyCode:<input type="text" name="vcstring">
                    <br/>
                    <%--<img src="img/vc.gif">--%>
                    <img src="securityCode.action" onclick="">
                    <%--<br/>--%>
                    <a id="btn" href="">
                        <small>change to another one</small>
                    </a>
                    <font color="red">
                        ${session.imageMess}
                    </font>
                    <br/>
                </td>
            </tr>
        </p>

        <input type="submit" name="login" value="Login"/>
    </form>

    Need a username and password?
    <a href="newaccountform">
        Register Now!
    </a>
</div>

<script src="js/LoginForm.js"></script>

<%@ include file="../common/IncludeBottom.jsp" %>

