<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>
<h1>Cards</h1>



<div class="contMenu">
<ul>
    <#list roles as r>           
		 <#if "${r}" == "ROLE_ADMIN">
		  <li><a class="menumodif" href="/cards/edit/">Create New</a></li>
		  <li><a class="menumodif" href="/cards/delete/">Delete</a></li>
		</#if>
		<#if "${r}" != "ROLE_ANONYMOUS">
		 <li><a class="menumodif" href="/cards/find/">Find</a></li>
		</#if>
     </#list>
</ul>
	
</div>
<br><br>
<div><a href="/">Acceuil</a></div>
