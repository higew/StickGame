<#import "/spring.ftl" as spring/>

   
<h1>${pageName}</h1>

<form action="/item/find" method="POST">
    <div>Firstname</div>
    <input type="text" name="firstname" value="">
    <div>Lastname</div>
    <input type="text" name="lastname" value="">
    <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
    <input type="submit" value="Search">
	}
</form> 

<div>
<#if item??>
    <#list item as u>
        <#include "show.ftl"/>
    </#list>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>