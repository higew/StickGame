<#import "/spring.ftl" as spring/>
<#include "../basecontroller/index.ftl"/>
<link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/profil.css'/>"/>
<link rel="stylesheet" type="text/css"
  href="<@spring.url '/css/default.css'/>"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<script src="<@spring.url 'javascript/jQuery.js'/>"></script>
<script src="<@spring.url 'javascript/jQueryUI.js'/>"></script>
<script src="<@spring.url 'javascript/script.js'/>" type="text/javascript"></script>
<nav id="menuGlobal" class="base">
  <ul>
    <li><a href="/">Retour à l'accueil</a></li>
  </ul>
  <ul>
    <li><a href="#">Wiki</a></li>
  </ul>
</nav>
<nav id="top">
  <a id="logo" href="/"></a>
  <a id="account" href="/profil">Mon compte</a>
</nav>


<div class="contMenu">
<ul>
	<li><a class="menumodif" href="/profil/edit/">Edit Profil</li>
</ul>

