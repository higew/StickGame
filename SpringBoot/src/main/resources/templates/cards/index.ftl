<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>
<h1>Cards</h1>

<div class="contMenu">
<ul>
	<li><a class="menumodif" href="/cards/edit/">Create New</a></li>
	<li><a class="menumodif" href="/cards/find/">Find</a></li>
	<li><a class="menumodif" href="/cards/delete/">Delete</a></div></li>
</ul>

<div>
 <#if roles??>
        <#list roles as r>
        ${r}              
		 <#if "${r}" == "ROLE_ADMIN">
		  It is Big Joe
		</#if>
		<#if "${r}" == "ROLE_USER">
		  It is not Big Joe
		</#if>
     </#list>
    </#if>
</div>
mlmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
<div><a href="/">Back</a></div>
