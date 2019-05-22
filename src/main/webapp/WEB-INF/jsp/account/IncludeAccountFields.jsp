<h3>Account Information</h3>

<table>
    <tr>
        <td>First name:</td>
        <td>
            <input type="text" name="firstName" value=${session.account.firstName}>
        </td>
        <td></td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td><input type="text" name="lastName" value=${session.account.lastName}></td>
        <td></td>
    </tr>
    <tr>
        <td>Email*:</td>
        <td><input id="Email" type="text" size="40" name="email" value=${session.account.email}>
            <%--<font color="#FF0000">--%>
            <%--<small>--%>
            <%--<p id="EmailError"></p>--%>
            <%--</small>--%>
            <%--</font>--%>
        </td>
        <td>
            <span style="color: #FF0000; ">
                <small id="EmailError">
                    <%--<p id="EmailError"></p>--%>
                </small>
            </span>
        </td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td><input type="text" name="phone" value=${session.account.phone}></td>
        <td></td>
    </tr>
    <tr>
        <td>Address 1:</td>
        <td><input type="text" size="40" name="address1" value=${session.account.address1}></td>
        <td></td>
    </tr>
    <tr>
        <td>Address 2:</td>
        <td><input type="text" size="40" name="address2" value=${session.account.address2}></td>
        <td></td>
    </tr>
    <tr>
        <td>City:</td>
        <td><input type="text" name="city" value=${session.account.city}></td>
        <td></td>
    </tr>
    <tr>
        <td>State:</td>
        <td><input type="text" size="4" name="state" value=${session.account.state}></td>
        <td></td>
    </tr>
    <tr>
        <td>Zip:</td>
        <td><input type="text" size="10" name="zip" value=${session.account.zip}></td>
        <td></td>
    </tr>
    <tr>
        <td>Country:</td>
        <td>
            <input type="text" size="15" name="country" value=${session.account.country}>
        </td>
        <td></td>
    </tr>
</table>

<h3>Profile Information</h3>

<table>
    <tr>
        <td>Language Preference:</td>
        <td>
            <select name="languagePreference">
                <option value="">${session.account.languagePreference}</option>
                <option value="English">English</option>
                <option value="Chinese">Chinese</option>
                <%--<option value="日本語">日本語</option>--%>
                <%--<option value="русский язык">русский язык</option>--%>
                <option value="Deutsch">Deutsch</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>Favourite Category:</td>
        <td>
            <select name="favouriteCategoryId">
                <option selected="selected" value=${session.account.favouriteCategoryId}></option>
                <option value="FISH">FISH</option>
                <option value="REPTILES">REPTILES</option>
                <option value="CATS">CATS</option>
                <option value="BIRDS">BIRDS</option>
            </select>
        </td>
    </tr>

    <tr>
        <td>Enable MyList</td>
        <td>
            <s:if test="#session.account.listOption != null">
                <input type="checkbox" name="listOption" value="1"/>
            </s:if>
            <s:else>
                <input type="checkbox" name="listOption" value="0"/>
            </s:else>
        </td>
    </tr>
    <tr>
        <td>Enable MyBanner</td>
        <td>
            <s:if test="#session.account.bannerOption != null}">
                <input type="checkbox" name="bannerOption" value="true"/>
            </s:if>
            <s:else>
                <input type="checkbox" name="bannerOption" value="true"/>
            </s:else>
        </td>
    </tr>

</table>
