<#import "/spring.ftl" as spring/>

   
<h1>${pageName}</h1>
<div>
<#if item?? && item.getId()??>
	<div><a href="/item/delete/${item.getId()}">Delete</a></div>
</#if>
<form action="/item/find" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="submit" value="Add">
</form>
</div>