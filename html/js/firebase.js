var config = {
  apiKey: "AIzaSyDF5kudIsloz3Z-71VSc1ckz1e-FUYDdTI",
  authDomain: "stick-game.firebaseapp.com",
  databaseURL: "https://stick-game.firebaseio.com/",
  projectId: "stick-game",
  storageBucket: "stick-game.appspot.com",
  messagingSenderId: "624366143716"
};

// var hp = document.getElementsByClassName(hp)
//
// firebase.initializeApp(config);
//
// var database = firebase.database();
// var updateGames = function(element, value) {
//     element.textContent = value;
// };
// var hp = document.getElementsByClassName(hp)
//
// var games = firebase.database().ref('games/Battle between cc and CKOOL uuidkey1860242248/player1');
// games.on('value', function(snapshot) {
// updateGames (hp, snapshot.val());
// });
// ---------------------------------------- LISTEN

firebase.initializeApp(config);
var hp = document.getElementById("hp")
var database = firebase.database();
var updateGames = function(element, value) {
    element.textContent = value;
};


var games = firebase.database().ref('games/')
games.on('value', function(snapshot) {
updateGames (hp, snapshot.val().TAMER);
});

// ---------------------------------------- UPDATES
function changeHp() {
var hpContent = document.getElementById('hp');
console.log(hp.textContent);
console.log(hpContent.textContent);
var FirstUpdate = {TAMER: hpContent}
// var hp2 = firebase.database().ref('games').child('games').key;
// var updates = {};
//  updates= hp;

 return firebase.database().ref('games/').update(FirstUpdate);
}
