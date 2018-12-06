<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>
<h1>Cards</h1>



<div class="contMenu">
<ul>
 <#if roles??>
        <#list roles as r>
		 <#if "${r}" == "ROLE_ADMIN">
		  <li><a class="menumodif" href="/cards/edit/">Create New</a></li>
      <li><a class="menumodif" href="/cards/find/">Find</a></li>
		  <li><a class="menumodif" href="/cards/delete/">Delete</a></div></li>
		</#if>
		<#if "${r}" == "ROLE_USER">
		 <li><a class="menumodif" href="/cards/find/">Find</a></li>
		</#if>
     </#list>
    </#if>
</ul>
</div>

<div><a href="/">Back</a></div>
