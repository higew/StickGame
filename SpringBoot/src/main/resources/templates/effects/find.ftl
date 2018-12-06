<#import "/spring.ftl" as spring/>

<form action="/effects/find" method="POST">
<#include "../effects/specific/emptyshowform.ftl"/>
  <input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
  <input type="submit" value="Search">
</form>

<div>
  <#if items??>
     <#list items as i>
         <#include "/effects/specific/show.ftl"/>
     </#list>
  </#if>
  <#if notFound??>
     ${notFound}
  </#if>
</div>

<div><a href="/effects/index">Back</a></div>
