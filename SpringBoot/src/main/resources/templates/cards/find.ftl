<#import "/spring.ftl" as spring/>


<form action="/cards/find" method="POST">
<#include "../cards/specific/emptyshowform.ftl"/>
<input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
<input type="submit" value="Search">
</form>

 <div>
<#if items??>
    <#list items as i>
        <#include "/cards/specific/show.ftl"/>
    </#list>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>


<div><a href="/cards/index">Back</a></div>