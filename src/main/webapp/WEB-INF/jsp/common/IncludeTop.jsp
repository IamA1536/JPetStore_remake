<%--
  Created by IntelliJ IDEA.
  User: IamA#1536
  Date: 2018/12/4
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="stylesheet" href="css/jpetstore.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/jquery-ui.css" type="text/css"/>
    <link rel="stylesheet" href="css/suspensionwindow.css" type="text/css"/>

    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore By A</title>
    <a href="changelan.action?request_locale=zh_CN">简体中文</a>&nbsp;&nbsp;&nbsp;
    <a href="changelan.action?request_locale=en_US">English</a>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <script src="js/jQuery.js"></script>
    <script src="js/Search.js"></script>
    <script src="js/jquery-ui.js"></script>


</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif"/></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="vcart">
                <img align="middle" name="img_cart" src="images/cart.gif"/>
            </a>
            <img align="middle" src="images/separator.gif"/>

            <s:if test="#session.account==null">
                <a href="loginForm.action"><s:text name="form.li"/></a>
            </s:if>
            <s:else>
                <a href="signout"><s:text name="form.so"/></a>
                <img align="middle" src="images/separator.gif"/>
                <a href="editaccountform">
                    <s:property value="#session.account.username"/>'s account
                </a>
            </s:else>
            <img align="middle" src="images/separator.gif"/>
            <a href="help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="search" method="post">
                <input id="SearchInput" type="text" name="keyword" size="14"/>
                <input type="submit" name="searchProducts" value="Search"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="vcategory?categoryId=FISH"><img src="images/sm_fish.gif"/></a>
        <img src="images/separator.gif"/>
        <a href="vcategory?categoryId=DOGS"><img src="images/sm_dogs.gif"/></a>
        <img src="images/separator.gif"/>
        <a href="vcategory?categoryId=REPTILES"><img src="images/sm_reptiles.gif"/></a>
        <img src="images/separator.gif"/>
        <a href="vcategory?categoryId=CATS"><img src="images/sm_cats.gif"/></a>
        <img src="images/separator.gif"/>
        <a href="vcategory?categoryId=BIRDS"><img src="images/sm_birds.gif"/></a>

    </div>

</div>

<div id="Content">