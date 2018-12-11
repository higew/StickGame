<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>
<h1>Cards</h1>



<div class="contMenu">
<ul>
    <#list roles as r>           
		 <#if "${r}" == "ROLE_ADMIN">
		  <li><a class="menumodif" href="/cards/edit/">Create New</a></li>
      <li><a class="menumodif" href="/cards/find/">Find</a></li>
		  <li><a class="menumodif" href="/cards/delete/">Delete</a></div></li>
		</#if>
		<#if "${r}" != "ROLE_ANONYMOUS">
		 <li><a class="menumodif" href="/cards/find/">Find</a></li>
		</#if>
     </#list>
</ul>
<p>Session: <#if user??> ${user.firstname} ${user.lastname} </#if> </p>		
</div>

<div><a href="/">Back</a></div>
