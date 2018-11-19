<#import "/spring.ftl" as spring/>

<form action="/item/find" method="POST">
    <div>Name</div>
    <input type="text" name="card name" value="">
    <div>Life</div>
    <input type="text" name="card HP" value="">
    <div>Attack</div>
    <input type="text" name="Card attack" value="">
    <div>Ink Cost</div>
    <input type="text" name="Card cost" value="">
    <input type="submit" value="Add">
</form>

<div><a href="/cards/index">Back</a></div>