<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>

<script src="<@spring.url '/javascript/checkForm.js'/>"></script>

<form action="/registration" method="POST" onsubmit="verifForm(this)">
    <div>Firstname</div>
    <input type="text" name="firstname" value="" onblur="verifName(this)">
    <div>Lastname</div>
    <input type="text" name="lastname" value="" onblur="verifName(this)">
    <div>Email</div>
    <input type="text" name="email" value="" onblur="verifMail(this)">
    <div>Password</div>
    <input type="password" name="password" value="" onblur="verifPassword(this)">
    <div>Password confirm</div>
    <input type="password" name="passwordconfirm" value="" onblur="verifPassword(this)">
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <div><input type="submit" value="Register"></div>
</form>
