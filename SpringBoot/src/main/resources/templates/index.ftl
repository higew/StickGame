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
        <li><a href="/logout">Logout<a/><li>
		<li><a href="/registration">Register<a/><li>
      </ul>
      <a href="#">Wiki</a>
    </nav>
    <header>
      <nav id="top">
        <a id="logo" href="#"></a>
        <div id="account" class="dropdown" href="#">Administration
        	<div class="dropdown-content">
    			<a href="/cards">Cards</a><br/>
    			<a href="/classes">Classes</a></br>
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
          <li><a href="/logout">Logout<a/><li>
		  <li><a href="/registration">Register<a/><li>
        </ul>
        <a href="#">Wiki</a>
      </nav>
		</header>
    <span class="anchor" id="section1"></span>
    <section id="actu">
      <h1>Actualités</h1>
      <hr/>
      <div id="contentActu">
        <div class="preview">
          <div class="fakeImage1"></div>
          <h3>Lorem ipsum dolor sit amet</h3>
          <p>Nosse digesto quaedam invitari quibus tractatur convivia id exceptis commodis coeperint apparari commodis vicissitudo temporibus.</p>
        </div>
        <div class="preview">
          <div class="fakeImage2"></div>
          <h3>Lorem ipsum dolor sit amet</h3>
          <p>Nosse digesto quaedam invitari quibus tractatur convivia id exceptis commodis coeperint apparari commodis vicissitudo temporibus.</p>
        </div>
        <div class="preview">
          <div class="fakeImage3"></div>
          <h3>Lorem ipsum dolor sit amet</h3>
          <p>Nosse digesto quaedam invitari quibus tractatur convivia id exceptis commodis coeperint apparari commodis vicissitudo temporibus.</p>
        </div>
        <div class="preview">
          <div class="fakeImage4"></div>
          <h3>Lorem ipsum dolor sit amet</h3>
          <p>Nosse digesto quaedam invitari quibus tractatur convivia id exceptis commodis coeperint apparari commodis vicissitudo temporibus.</p>
        </div>
    </div>
    </section>
    <span class="anchor" id="section2"></span>
    <section id="story">
      <h1>Histoire</h1>
      <hr/>
      <div id="contentStory">
        <p>Intellectum est enim mihi quidem in multis, et maxime in me ipso, sed paulo ante in omnibus, cum M. Marcellum senatui reique publicae concessisti, commemoratis praesertim offensionibus, te auctoritatem huius ordinis dignitatemque rei publicae tuis vel doloribus vel suspicionibus anteferre. Ille quidem fructum omnis ante actae vitae hodierno die maximum cepit, cum summo consensu senatus, tum iudicio tuo gravissimo et maximo. Ex quo profecto intellegis quanta in dato beneficio sit laus, cum in accepto sit tanta gloria.<br/><br/>

Utque proeliorum periti rectores primo catervas densas opponunt et fortes, deinde leves armaturas, post iaculatores ultimasque subsidiales acies, si fors adegerit, iuvaturas, ita praepositis urbanae familiae suspensae digerentibus sollicite, quos insignes faciunt virgae dexteris aptatae velut tessera data castrensi iuxta vehiculi frontem omne textrinum incedit: huic atratum coquinae iungitur ministerium, dein totum promiscue servitium cum otiosis.
<br/><br/>
Plebeiis de vicinitate coniunctis: postrema multitudo spadonum a senibus in pueros desinens, obluridi distortaque lineamentorum conpage deformes, ut quaqua incesserit quisquam cernens mutilorum hominum agmina detestetur memoriam Samiramidis reginae illius veteris, quae teneros mares castravit omnium prima velut vim iniectans naturae, eandemque ab instituto cursu retorquens, quae inter ipsa oriundi crepundia per primigenios seminis fontes tacita quodam modo lege vias propagandae posteritatis ostendit.</p>
        <div class="fakeImageStory"></div>
      </div>
    </section>
    <span class="anchor" id="section3"></span>
    <section id="class">
      <h1>Classes</h1>
      <hr/>
      <div id="contentClass">
        <div class="previewClass">
          <div class="fakeClass1"></div>
          <h3>Almighty Terry</h3>
        </div>
        <div class="previewClass">
          <div class="fakeClass2"></div>
          <h3>Popopower Terry</h3>
        </div>
        <div class="previewClass">
          <div class="fakeClass3"></div>
          <h3>Lover Terry</h3>
        </div>
        <div class="previewClass">
          <div class="fakeClass4"></div>
          <h3>RacaTerry</h3>
        </div>
      </div>
    </section>
    <span class="anchor" id="section4"></span>
    <section id="card">
      <h1>Cartes</h1>
      <hr/>
      <div id="contentCard">
        <div class="previewCard">
          <div class="fakeClass1"></div>
          <h3>Almighty Kuriboh</h3>
        </div>
        <div class="previewCard">
          <div class="fakeClass2"></div>
          <h3>Popopower Kuriboh</h3>
        </div>
        <div class="previewCard">
          <div class="fakeClass3"></div>
          <h3>Lover Kuriboh</h3>
        </div>
        <div class="previewCard">
          <div class="fakeClass4"></div>
          <h3>RacaKuriboh</h3>
        </div>
        <div class="previewCard">
          <div class="fakeClass5"></div>
          <h3>RacaKuribohboh</h3>
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
 
