<#import "/spring.ftl" as spring/>

<form action="/cards/edit" method="POST">
    <div>Name</div>
    <input type="text" name="name" value="">
    <div>Life</div>
    <input type="text" name="hp" value="">
    <div>Attack</div>
    <input type="text" name="atk" value="">
    <div>Ink Cost</div>
    <input type="text" name="inkCost" value="">
       <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <input type="submit" value="Add">
</form>


<div><a href="/cards/index">Back</a></div>