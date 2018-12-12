<#import "/spring.ftl" as spring />

<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>C'est l'heure du Dududududuuuuueel !</title>
  <link rel="stylesheet" href="/css/reset.css">
  <link rel="stylesheet" href="/css/jquery-ui.css">
  <link rel="stylesheet" href="/css/styleGame.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Indie+Flower|Open+Sans" rel="stylesheet">
  <script src="/javascript/jQuery.js" type="text/javascript"></script>
  <script src="/javascript/jQueryUI.js" type="text/javascript"></script>
  <script src="https://www.gstatic.com/firebasejs/5.7.0/firebase.js"></script>
</head>


<body>
<div>gameReference : ${gameReference}, playerReference : ${playerReference}</div>
  <div class="gameContainer">
    <div id="player1">
      <div class="side" name="opponentside">
        <div class="avatar">
          <div class="picture">
            <img src="/media/terry2Bis.png" alt="" class="avatarPict">
          </div>
          <div class="hp">
            <p id="hp1"></p>
          </div>
        </div>
        <div class="hand">
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg" draggable="true" class="cardPict" id="cardPict11" alt="">
          </div>
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg" draggable="true" class="cardPict" id="cardPict12" alt="">
          </div>
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg" draggable="true" class="cardPict" id="cardPict13" alt="">
          </div>
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg" draggable="true" class="cardPict" id="cardPict14" alt="">
          </div>
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg""/media/dosCarteY.png" draggable="true" class="cardPict" id="cardPict15" alt="">
          </div>
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg" draggable="true" class="cardPict" id="cardPict16" alt="">
          </div>
          <div class="handCards2">
            <img src="/media/cardBackDraw.jpeg" draggable="true" class="cardPict" id="cardPict17" alt="">
          </div>
        </div>
        <div class="mana" id="mana1">
        </div>
        <div class="inkCount">
          <p id="ink1"></p>
        </div>
      </div>

      <div class="side2" name="opponentSide2">
        <div class="discardContainer">
          <div class="discard">
            <p id="discard1"></p>
          </div>
        </div>
        <div class="board">
          <div class="cardBoard">
          </div>
          <div class="cardBoard">
          </div>
          <div class="cardBoard">
          </div>
          <div class="cardBoard">
          </div>
          <div class="cardBoard">
          </div>
        </div>
        <div class="drawContainer">
          <div class="draw">
            <p id="draw1"></p>
          </div>
        </div>
      </div>
    </div>
    <div class="side2" name="playerSide2">
      <div class="discardContainer">
        <div class="discard">
          <p id="discard2"></p>
        </div>
      </div>
      <div class="board">
        <div class="cardBoard2" id="0">
        </div>
        <div class="cardBoard2" id="1">
        </div>
        <div class="cardBoard2" id="2">
        </div>
        <div class="cardBoard2" id="3">
        </div>
        <div class="cardBoard2" id="4">
        </div>
      </div>
      <div class="drawContainer">
        <div class="draw">
          <p id="draw2"></p>
        </div>
      </div>
    </div>

    <div class="side" name="playerSide">
      <div class="avatar">
        <div class="picture">
          <img src="/media/terry3Bis.png" alt="SurprisedCat" class="avatarPict">
        </div>
        <div class="hp">
          <p id="hp2"></p>
        </div>
      </div>
      <div class="hand" id="handPlayer1">
      </div>
      <div class="mana" id="mana2">
      </div>
      <div class="inkCount">
        <p id="ink2"></p>
      </div>
    </div>
  </div>
</body>

<script type="text/javascript">
  var config = {
    apiKey: "AIzaSyDF5kudIsloz3Z-71VSc1ckz1e-FUYDdTI",
    authDomain: "stick-game.firebaseapp.com",
    databaseURL: "https://stick-game.firebaseio.com/",
    projectId: "stick-game",
    storageBucket: "stick-game.appspot.com",
    messagingSenderId: "624366143716"
  };

  //---------------------------------------- LISTEN
  firebase.initializeApp(config);
  var database = firebase.database();
  var update = function(element, value) {
    element.textContent = value
  };

  function setToHand(player, card, position) {
    $('#handPlayer1').append('<div class="handCards" ' + position + '><img src="' + card.picture + '" draggable="true" class="cardPict2" id="' + card.id + '" alt=""></div>');
  }

  (function() {
    var dndHandler2 = {
      draggedElement: null,
      applyDragEvents: function(element2) {
        element2.cardPict = true;
        var dndHandler2 = this;
        element2.addEventListener('dragstart', function(e2) {
          dndHandler2.draggedElement = e2.target;
          e.dataTransfer.setData('text/plain', '');
        });
      },

      applyDropEvents: function(dropper2) {
        dropper2.addEventListener('dragover', function(e2) {
          e2.preventDefault();
          this.className = 'cardBoard2 drop_hover';
        });

        dropper2.addEventListener('dragleave', function() {
          this.className = 'cardBoard2';
        });

        var dndHandler2 = this;
        dropper2.addEventListener('drop', function(e2) {

          var target2 = e2.target,
            draggedElement2 = dndHandler2.draggedElement,
            clonedElement2 = draggedElement2.cloneNode(true);

          if (target2.className.indexOf('cardBoard2') == -1) {
            target2 = null;
          }

          target2.className = 'cardBoard2';
          clonedElement2 = target2.appendChild(clonedElement2);
          dndHandler2.applyDragEvents(clonedElement2);
          changeFirebase("/games/Battle between cc and CKOOL uuidkey282003293/player1/battlefield/monsterZone/", target2.id, clonedElement2.id);
          draggedElement2.parentNode.removeChild(draggedElement2);
        });
      }
    };
    function applyDragAndDrop() {
      var elements2 = document.querySelectorAll('.cardPict2'),
        elementsLen2 = elements2.length;
      for (var i = 0; i < elementsLen2; i++) {
        dndHandler2.applyDragEvents(elements2[i]);
      }

      var droppers2 = document.querySelectorAll('.cardBoard2'),
        droppersLen2 = droppers2.length;
      for (var i = 0; i < droppersLen2; i++) {
        dndHandler2.applyDropEvents(droppers2[i]);
      }
    }

    //------------------------- Player 1
    var gamesHand1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/player1/").child("hand/")
    gamesHand1.on('value', function(snapshot) {
      var loop = 0;
      document.getElementById('handPlayer1').innerHTML = "";
      snapshot.forEach(function(childSnapshot) {
        var key = childSnapshot.key;
        var childData = childSnapshot.val();
        setToHand("handPlayer1", childData, loop);
        loop++;
      });
      applyDragAndDrop();
    });

    var gamesHp1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/")
    gamesHp1.on('value', function(snapshot) {
      update(document.getElementById("hp1"), snapshot.val().hp);
    });

    var gamesDiscard1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/").child("battlefield")
    gamesDiscard1.on('value', function(snapshot) {
      update(document.getElementById("discard1"), snapshot.val().sizeDiscardDeck);
    });

    var gamesDraw1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/").child("deck/")
    gamesDraw1.on('value', function(snapshot) {
      update(document.getElementById("draw1"), snapshot.val().size);
    });

    var gamesInk1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/")
    gamesInk1.on('value', function(snapshot) {
      update(document.getElementById("ink1"), snapshot.val().ink);
      document.getElementById('mana1').innerHTML = "";
      for (i = 0; i < snapshot.val().ink; i++) {
        $('#mana1').append('<div class="inkStain"><img src="/media/inkStain.png" class="inkStainPict" alt=""></div>');
      }
    });

    //------------------------- Player 2

    var gamesHp2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/")
    gamesHp2.on('value', function(snapshot) {
      update(document.getElementById("hp2"), snapshot.val().hp);
    });

    var games2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/").child("battlefield")
    games2.on('value', function(snapshot) {
      update(document.getElementById("discard2"), snapshot.val().sizeDiscardDeck);
    });

    var gamesDraw2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/").child("deck/")
    gamesDraw2.on('value', function(snapshot) {
      update(document.getElementById("draw2"), snapshot.val().size);
    });

    var gamesInk2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/")
    gamesInk2.on('value', function(snapshot) {
      update(document.getElementById("ink2"), snapshot.val().ink);
      document.getElementById('mana2').innerHTML = "";
      for (i = 0; i < snapshot.val().ink; i++) {
        $('#mana2').append('<div class="inkStain"><img src="/media/inkStain.png" class="inkStainPict" alt=""></div>');
      }
    });

    function changeFirebase(ref, valueName, newValue) {
      firebase.database().ref(ref + valueName).set(newValue);
    }
  })();
</script>
</html>
