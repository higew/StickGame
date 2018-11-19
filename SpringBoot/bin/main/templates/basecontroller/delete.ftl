<#import "/spring.ftl" as spring/>


<h1>${pageName}</h1>

<form action="/delete" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="submit" value="Delete">
</form> 

<div>
<#if item??>
<#assign index = 0>
<form action="/item/deletecriteria" method="POST">
    <div class="row">
        <div class="col-md-6">Firstname</div>
        <div class="col-md-6">Lastname</div>
    </div>
    <#list item as u>
    <#include "noteditableform.ftl"/>
    <#assign index++>
    </#list>
    <input type="submit" value="Delete">
</form>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>