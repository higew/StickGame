<#import "/spring.ftl" as spring/>

<form action="/delete" method="POST">
    <div>Nom de l'effet</div>
    <input type="text" name="name" value="">
    <input type="submit" value="Search">
    <input type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
</form> 

<div><a href="/effects/index">Back</a></div>