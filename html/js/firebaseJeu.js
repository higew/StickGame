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
    element.textContent = value};

//------------------------- Player 1
var hp1 = document.getElementById("hp1")
var gamesHp1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/")
gamesHp1.on('value', function(snapshot) {
update(hp1, snapshot.val().hp);
});

var discard1 = document.getElementById("discard1")
var gamesDiscard1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/").child("battlefield")
gamesDiscard1.on('value', function(snapshot) {
update(discard1, snapshot.val().sizeDiscardDeck);
});

var draw1 = document.getElementById("draw1")
var gamesDraw1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/").child("deck/")
gamesDraw1.on('value', function(snapshot) {
update(draw1, snapshot.val().size);
});

var ink1 = document.getElementById("ink1")
var gamesInk1 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player1/")
gamesInk1.on('value', function(snapshot) {
update(ink1, snapshot.val().ink);
document.getElementById('mana1').innerHTML="";
for(i=0; i<snapshot.val().ink; i++){
$('#mana1').append('<div class="inkStain"><img src="media/inkStain.png" class="inkStainPict" alt=""></div>');
}
});
//------------------------- Player 2

var hp2 = document.getElementById("hp2")
var gamesHp2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/")
gamesHp2.on('value', function(snapshot) {
update(hp2, snapshot.val().hp);
});

var discard2  = document.getElementById("discard2")
var games2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/").child("battlefield")
games2.on('value', function(snapshot) {
update(discard2, snapshot.val().sizeDiscardDeck);
});

var draw2 = document.getElementById("draw2")
var gamesDraw2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/").child("deck/")
gamesDraw2.on('value', function(snapshot) {
update(draw2, snapshot.val().size);
});
var ink2 = document.getElementById("ink2")
var gamesInk2 = firebase.database().ref('games/').child("Battle between cc and CKOOL uuidkey282003293/").child("player2/")
gamesInk2.on('value', function(snapshot) {
update(ink2, snapshot.val().ink);

document.getElementById('mana2').innerHTML="";
for(i=0; i<snapshot.val().ink; i++){
$('#mana2').append('<div class="inkStain"><img src="media/inkStain.png" class="inkStainPict" alt=""></div>');
}
});



//
// // ---------------------------------------- UPDATES
// function changeHp() {
// var hpContent = document.getElementById('hp1');
// console.log(hp.textContent);
// console.log(hpContent.textContent);
// var FirstUpdate = {TAMER: hpContent}
// // var hp2 = firebase.database().ref('games').child('games').key;
// // var updates = {};
// //  updates= hp;
//
//  return firebase.database().ref('games/').update(FirstUpdate);
// }
