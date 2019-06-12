<%@ include file="../common/IncludeTop.jsp" %>

<div id="Catalog">
    <form action="login" method="post">
        <p><s:text name="form.pey"/>.</p>
        <p>
            <tr>
                <td>
                    <s:text name="form.username"/>:<input type="text" name="username" value=""><br/>
                </td>
                <td>
                    <s:text name="form.password"/>:<input type="password" name="password" value=""><br/>
                </td>
                <td>
                    <s:text name="form.verifyCode"/>:<input type="text" name="vcstring">
                    <br/>
                    <%--<img src="img/vc.gif">--%>
                    <img src="securityCode.action" onclick="">
                    <%--<br/>--%>
                    <a id="btn" href="">
                        <small><s:text name="form.ctao" /></small>
                    </a>
                    <span style="color: red; ">
                        ${session.imageMess}
                    </span>
                    <br/>
                </td>
            </tr>
        </p>

        <input type="submit" name="login" value="Login"/>
    </form>

    <s:text name="form.Nauap" />?
    <a href="newaccountform">
        <s:text name="form.rn" />!
    </a>
</div>

<script src="js/LoginForm.js"></script>

<%@ include file="../common/IncludeBottom.jsp" %>

