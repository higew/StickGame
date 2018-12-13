<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
   href="<@spring.url '/css/profil.css'/>"/>
<link rel="stylesheet" type="text/css"
  href="<@spring.url '/css/default.css'/>"/>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
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
<div id="wrapper">
  <div id="editProfil">
    <form action="${detailPath}/edit" method="post">
      <div class="form-group">
        <input type="hidden" name="active">
        <input type="hidden" name="picture">
        <label for="nickname">Nom</label>
        <input class="form-control" type="text" name="lastname" placeholder="${user.lastname}" value="">
        <label for="nickname">Prénom</label>
        <input class="form-control" type="text" name="firstname" placeholder="${user.firstname}"  value="">
        <label for="nickname">Email</label>
        <input class="form-control" type="email" name="email" placeholder="${user.email}" value="" disabled>
        <label for="nickname">Mot de passe</label>
        <input class="form-control" type="password" name="password" placeholder="********" value="">
        <p class="help-block">8 caractères minimum dont une lettre majuscule, une lettre miniscule, un caractère spécial, un chiffre.</p>
        <label for="nickname">Confirmez Mot de passe</label>
        <input class="form-control" type="password" name="confirmPass" placeholder="********" value="">
        <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
        <button class="sending" type="submit" name="button">Modifier</button>
      </div>
    </form>
  </div>
  <div id="editAvatar">
    <label>Votre avatar</label>
    <div id="avatarUser">
      <img src="media/cat.jpg" alt="AvatarUtilisateur">
    </div>
      <label>Uploadez une image</label>
      <input type="file">
    <button class="sending" type="button" name="button">Envoyer</button>
  </div>
</div>

