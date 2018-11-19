<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css" 
   href="<@spring.url '/css/default.css'/>"/>

 <nav id="menuGlobal" class="fixed hidden">
      <ul>
        <li><a href="#section1">Actualités</a></li>
        <li><a href="#section2">Histoire</a></li>
        <li><a href="#section3">Classes</a></li>
        <li><a href="#section4">Cartes</a></li>
      </ul>
      <a href="#">Wiki</a>
    </nav>
    <header>
      <nav id="top">
        <a id="logo" href="#"></a>
        <div id="account" class="dropdown" href="#">Administration
        	<div class="dropdown-content">
    			<a href="/cards">Cards</a><br/>
    			<a href="/cards">Classes</a><br/>
    			<a href="/effects">Effects</a><br/>
    			<a href="/players">Players</a>
  			</div>
        </div>
      </nav>
      <nav id="menuBase" class="base">
        <ul>
          <li><a href="#section1">Actualités</a></li>
          <li><a href="#section2">Histoire</a></li>
          <li><a href="#section3">Classes</a></li>
          <li><a href="#section4">Cartes</a></li>
        </ul>
        <a href="#">Wiki</a>
      </nav>
		</header>
<div>
<#if items??>
	<#list items as u>
	<div>
		<div>${u.getId()}</div>
		<#if u.getFirstname()??>
		<div>${u.getFirstname()}</div>
		<#else>
		<div>NULL</div>
		</#if>
		<#if u.getLastname()??>
		<div>${u.getLastname()}</div>
		<#else>
		<div>NULL</div>
		</#if>
		<div>
			<a href="/users/edit/${u.getId()}">Show</a>
			<a href="/users/delete/${u.getId()}">Delete</a>
		</div>
	</div>
	</#list>
</#if>
</div>