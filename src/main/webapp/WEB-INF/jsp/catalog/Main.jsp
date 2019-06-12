<%--
  Created by IntelliJ IDEA.
  User: IamA#1536
  Date: 2018/12/4
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/IncludeTop.jsp" %>

<div id="Welcome">
    <div id="WelcomeContent">
        <s:text name="form.wtw"/>!
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="vcategory?categoryId=FISH"><img src="images/fish_icon.gif"/></a>
            <br/> <s:text name="form.sf"/> <br/>
            <a href="vcategory?categoryId=DOGS"><img src="images/dogs_icon.gif"/></a>
            <br/> <s:text name="form.vb"/> <br/>
            <a href="vcategory?categoryId=CATS"><img src="images/cats_icon.gif"/></a>
            <br/> <s:text name="form.vbev"/> <br/>
            <a href="vcategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif"/></a>
            <br/> <s:text name="form.lts"/> <br/>
            <a href="vcategory?categoryId=BIRDS"><img src="images/birds_icon.gif"/></a>
            <br/> <s:text name="form.ev"/>
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="vcategory?categoryId=BIRDS" shape="rect"/>
                <area alt="Fish" coords="2,180,72,250" href="vcategory?categoryId=FISH" shape="rect"/>
                <area alt="Dogs" coords="60,250,130,320" href="vcategory?categoryId=DOGS" shape="rect"/>
                <area alt="Reptiles" coords="140,270,210,340" href="vcategory?categoryId=REPTILES" shape="rect"/>
                <area alt="Cats" coords="225,240,295,310" href="vcategory?categoryId=CATS" shape="rect"/>
                <area alt="Birds" coords="280,180,350,250" href="vcategory?categoryId=BIRDS" shape="rect"/>
            </map>
            <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350"/>
        </div>
    </div>
    <div id="Separator">&nbsp;</div>
</div>

<%@include file="../common/IncludeBottom.jsp" %>