<#import "/spring.ftl" as spring/>

<form action="/delete" method="POST">
    <div>Nom de la classe</div>
    <input type="text" name="card name" value="">
    <input type="submit" value="Delete">
</form> 

<div><a href="/cards/index">Back</a></div>