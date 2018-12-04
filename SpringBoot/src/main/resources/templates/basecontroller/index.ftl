<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/home.css'/>"/>
<!-- <link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/reset.css'/>"/> -->
<script src="<@spring.url 'javascript/jQuery.js'/>"></script>
<script src="<@spring.url 'javascript/jQueryUI.js'/>"></script>
<script src="<@spring.url 'javascript/script.js'/>" type="text/javascript"></script>

<nav id="menuGlobal" class="base">
  <ul>
    <li><a href="/index">Accueil</a></li>
    <li><a href="#section1">Actualités</a></li>
    <li><a href="#section2">Histoire</a></li>
    <li><a href="#section3">Classes</a></li>
    <li><a href="#section4">Cartes</a></li>
  </ul>
  <a href="#">Wiki</a>
</nav>
<nav id="top">
  <a id="logo" href="#"></a>
  <a id="account" href="#">Mon compte</a>
</nav>
<style media="screen">
  .cheat {
    height: 200px;
  }
  .center {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
    margin-left: auto;
    margin-right: auto;
  }
</style>
<div class="cheat"></div>
<div class="center">
