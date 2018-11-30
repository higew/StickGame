<#import "/spring.ftl" as spring/>

<form action="/item/find" method="POST">
    <div>Name</div>
    <input type="text" name="name" value="">
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <input type="submit" value="Add">
</form>

<div><a href="/classes/index">Back</a></div>