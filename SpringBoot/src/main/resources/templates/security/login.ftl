<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css"
      href="<@spring.url '/css/profil.css'/>"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<script src="<@spring.url 'javascript/script.js'/>" type="text/javascript"></script>

<html>
  <head>
    <title tiles:fragment="title">Authentification</title>

  </head>
  <body onload="document.f.username.focus();">
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
        <li><a href="/registration">S'enregistrer</a></li>
      </ul>
      <ul>
        <li><a href="#">Wiki</a></li>
      </ul>
    </nav>
    <nav id="top">
      <a id="logo" href="/"></a>
      <a id="account" href="#">Mon compte</a>
    </nav>

    <div class="cheat"></div>
    <div class="center">
    <h2>Connexion</h2>
    <div id="editProfil" style="margin-left: 0;">
      <form action="/login" method="POST">
        <div class="form-group">
          <label for="email">Email:</label>
          <input class="form-control" type='text' name='${form_username}' value=''/>
          <label for="password">Password:</label>
          <input class="form-control" type='password' name='${form_password}' value=''/>
          <input type="hidden"
              name="${_csrf.parameterName}"
              value="${_csrf.token}"/>
          <button name="submit" type="submit">Connexion</button>
          <button name="reset" type="reset">Réinitialiser</button>
        </div>
      </form>
      <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
          <h3 style="color: red;">Mauvais email ou mot de passe.</h3>
      </#if>
    </div>
  </div>
  </body>
</html>
