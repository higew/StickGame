<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>

<script src="<@spring.url '/javascript/checkForm.js'/>"></script>

<form name="formulaire" id="formulaire" action="/registration" method="POST" onsubmit="return verifForm(this)" required>
    <div>Firstname *</div>
    <input type="text" id="firstname" name="firstname" value="" onblur="verifName(this)" required>
    <div>Lastname *</div>
    <input type="text" id="lastname" name="lastname" value="" onblur="verifName(this)" required>
    <div>Email *</div>
    <input type="text" id="email" name="email" value="" onblur="verifMail(this)" required>
    <div>Password *</div>
    <input type="password" name="pass1" value="" id="pass1" onblur="verifPassword(this)" required>
    <div>Password confirm *</div>
    <input type="password" name="passwordconfirm" value="" id="pass2" onblur="comparePassword(this)" required>
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <div><input type="submit" value="Register"></div>
</form>
</div>
