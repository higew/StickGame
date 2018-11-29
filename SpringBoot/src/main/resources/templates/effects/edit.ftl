<#import "/spring.ftl" as spring/>

<form action="/item/find" method="POST">
    <div>Name</div>
    <input type="text" name="name" value="">
    <div>Ink Cost</div>
    <input type="text" name="inkCost" value="">
    <input type="submit" value="Add">
</form>

<div><a href="/effects/index">Back</a></div>