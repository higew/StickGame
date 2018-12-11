<#import "/spring.ftl" as spring/>

<form action="/delete" method="POST">
    <div>Nom de la classe</div>
    <input type="text" name="name" value="">
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <input type="submit" value="Delete">
</form> 

<div><a href="/classes/index">Back</a></div>