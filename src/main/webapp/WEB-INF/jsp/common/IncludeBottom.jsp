<%--
  Created by IntelliJ IDEA.
  User: IamA#1536
  Date: 2018/12/4
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
</div>

<div id="Footer">

    <div id="PoweredBy">&nbsp<a href="www.csu.edu.cn">www.csu.edu.cn</a>
    </div>

    <div id="Banner">
        <s:if test="#session.account != null }">
                <s:if test="#sessionScope.account.bannerOption">
                    ${session.account.bannerName}
                </s:if>
        </s:if>
    </div>

</div>

</body>
</html>
