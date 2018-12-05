<#import "/spring.ftl" as spring/>

<form action="/effects/find" method="POST">
    <div>Effect Identifier</div>
    <input type="text" name="effectIdentifier" value="">
    <div>Description</div>
    <input type="text" name="description" value="">
    <input type="submit" value="Add">
    <input type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
</form>

<div><a href="/effects/index">Back</a></div>