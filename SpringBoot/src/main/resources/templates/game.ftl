<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
      href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css"
      href="<@spring.url '/css/home.css'/>"/>
<link rel="stylesheet" type="text/css"
      href="<@spring.url '/css/reset.css'/>"/>

<#if play == false >
<p>En attente d'un autre joueur...</p>
<img src="https://img.buzzfeed.com/buzzfeed-static/static/2016-05/25/11/asset/buzzfeed-prod-fastlane01/anigif_sub
-buzz-5187-1464189371-3.gif" />
<p>Et parce que le monde est trop dur... Voici Brice avec des oreilles de chat.</p>
<img src="/media/profilBrice.jpeg" />
</#if>