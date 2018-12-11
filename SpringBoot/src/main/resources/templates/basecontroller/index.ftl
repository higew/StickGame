<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/default.css'/>"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<script src="<@spring.url 'javascript/jQuery.js'/>"></script>
<script src="<@spring.url 'javascript/jQueryUI.js'/>"></script>
<script src="<@spring.url 'javascript/script.js'/>" type="text/javascript"></script>
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
<div class="cheat"></div>
<div class="center">
