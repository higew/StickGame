<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css"
      href="<@spring.url '/css/social.css'/>"/>
      <link rel="stylesheet" type="text/css"
         href="<@spring.url '/css/default.css'/>"/>
      <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
      <script src="<@spring.url 'javascript/jQuery.js'/>"></script>
      <script src="<@spring.url 'javascript/jQueryUI.js'/>"></script>
      <script src="<@spring.url 'javascript/script.js'/>" type="text/javascript"></script>

<nav id="menuGlobal" class="base">
  <ul>
    <li><a href="#">Rechercher</a></li>
    <li><a href="#">Liste d'ami(s)</a></li>
    <li><a href="#">Invitation(s)</a></li>
  </ul>
  <ul>
    <li><a href="#">Wiki</a></li>
    <li><a href="#">Jouer</a></li>
  </ul>
</nav>
<nav id="top">
  <a id="logo" href="/"></a>
  <a id="account" href="#">Mon compte</a>
</nav>
<section id="wrapper">
  <div id="friendList">
    <div class="contact first focus">
      <div class="avatar">
        <img src="media/cat.jpg" alt="NomDuGars">
      </div>
      <div class="text">
        <p><strong>Serge Karamazov</strong></p>
        <p>Oh répond !</p>
        <p>Ven. 30 Nov - 18:02</p>
      </div>
    </div>
    <hr/>
    <div class="contact">
      <div class="avatar">
        <img src="media/cat2.jpg" alt="NomDuGars">
      </div>
      <div class="text">
        <p><strong>Commissaire Patrick Bialès</strong></p>
        <p>Tu bluff Martoni !</p>
        <p>Ven. 30 Nov - 18:02</p>
      </div>
    </div>
    <hr/>
    <div class="contact">
      <div class="avatar">
        <img src="media/cat3.jpg" alt="NomDuGars">
      </div>
      <div class="text">
        <p><strong>Jean-Paul Martoni</strong></p>
        <p>J'veux un hélicoptère sinon j'la bute !</p>
        <p>Ven. 30 Nov - 18:02</p>
      </div>
    </div>
  </div>
  <div id="contentRight">
    <div class="dialog">
      <div class="messageReceived">
        <p class="speech-bubble">Aucun lien, fils unique.</p>
        <p class="nameSenders">Serge Karamazov</p>
        <p class="dateTime">Jeudi 1 Avril 2018, 22:22</p>
      </div>
      <div class="messageReceived">
        <p class="speech-bubble">Dites, on attend pas votre soeur ?</p>
        <p class="nameSenders">Serge Karamazov</p>
        <p class="dateTime">Vendredi 2 Avril 2018, 11:11</p>
      </div>
      <div class="messageSent">
        <p class="speech-bubble">Ah !</p>
        <p class="nameSenders">Brice Leet</p>
        <p class="dateTime">Lundi 24 Mai 2018, 04:04</p>
      </div>
      <div class="messageReceived">
        <p class="speech-bubble">Oh répond !</p>
        <p class="nameSenders">Serge Karamazov</p>
        <p class="dateTime">Mercredi 30 Novembre 2018, 18:02</p>
      </div>
    </div>
    <div class="sendingMessage">
      <textarea name="name" rows="8" cols="80" placeholder="Veuillez entrer votre message ici..."></textarea>
      <input id="validSending" type="submit" name="messageContent" value="Envoyer">
    </div>
  </div>
</section>
<footer>
  <article>
    <p>© 2018 Copyright - StickGame Team</p>
  </article>
  <article>
    <p>Designed by <span>Jean-jean Jean</span></p>
  </article>
</footer>
