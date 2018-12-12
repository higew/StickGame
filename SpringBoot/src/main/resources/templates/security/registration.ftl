<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
      href="<@spring.url '/css/profil.css'/>"/>
<#include "../basecontroller/index.ftl"/>

<script src="<@spring.url '/javascript/checkForm.js'/>"></script>
  <h2>Création du compte</h2>
  <div id="editProfil" style="margin-left: 0;">
    <form name="formulaire" id="formulaire" action="/registration" method="POST" onsubmit="return verifForm(this)" required>
      <div class="form-group">
        <label for="firstname">Prénom *</label>
        <input class="form-control" type="text" id="firstname" name="firstname" value="" onblur="verifName(this)" required>
        <label for="lastname">Nom *</label>
        <input class="form-control" type="text" id="lastname" name="lastname" value="" onblur="verifName(this)" required>
        <label for="email">Email *</label>
        <input class="form-control" type="text" id="email" name="email" value="" onblur="verifMail(this)" required>
        <label for="password">Mot de passe *</label>
        <input class="form-control" type="password" name="password" value="" id="password" onblur="verifPassword(this)" required>
        <p class="help-block">8 caractères minimum dont une lettre majuscule, une lettre miniscule, un caractère spécial, un chiffre.</p>
        <label for="passwordconfirm">Confirmez le mot de passe *</label>
        <input class="form-control" type="password" name="passwordconfirm" value="" id="pass2" onblur="comparePassword(this)" required>
        <input type="hidden"
                name="${_csrf.parameterName}"
                value="${_csrf.token}"/>
        <button type="submit" value="">Inscription</button>
      </div>
    </form>
  </div>
</div>
