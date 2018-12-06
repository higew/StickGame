<#import "/spring.ftl" as spring/>

<form action="/delete" method="POST">
    <div>Effect Identifier</div>
    <input type="text" name="effectIdentifier" value="">
    <input type="submit" value="Delete">
    <input type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
</form> 

<div><a href="/effects/index">Back</a></div>