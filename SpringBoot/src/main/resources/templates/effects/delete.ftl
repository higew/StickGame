<#import "/spring.ftl" as spring/>

<form action="/delete" method="POST">
    <div>Nom de l'effet</div>
    <input type="text" name="effect name" value="">
    <input type="submit" value="Delete">
</form> 

<div><a href="/effects/index">Back</a></div>