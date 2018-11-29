<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css" 
   href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" 
   href="<@spring.url '/css/home.css'/>"/>
<link rel="stylesheet" type="text/css" 
   href="<@spring.url '/css/reset.css'/>"/>
<script src="<@spring.url 'javascript/jQuery.js'/>"></script>
<script src="<@spring.url 'javascript/jQueryUI.js'/>"></script>
<script src="<@spring.url 'javascript/script.js'/>" type="text/javascript"></script>

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
