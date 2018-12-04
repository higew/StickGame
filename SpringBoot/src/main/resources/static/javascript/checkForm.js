function surligne(champ, erreur) {
   if(erreur)
      champ.style.backgroundColor = "#fba";
   else
      champ.style.backgroundColor = "";
}

function verifName(champ) {
  var regex = new RegExp(/^[a-zA-Z]{2,32}$/);
   if(champ.value === "" || !regex.test(champ.value)) {
     console.log("Le champ Nom ou Prenom n'est pas valide");
      surligne(champ, true);
      return false;
   }
   else {
     console.log("toto");
      surligne(champ, false);
      return true;
   }
}

function verifMail(champ) {
   var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
    if(champ.value === "" || !regex.test(champ.value)) {
     console.log("Le champ Mail n'est pas valide");
      surligne(champ, true);
      return false;
   }
   else {
      surligne(champ, false);
      return true;
   }
}


function verifPassword(champ){
   var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,32})/;
    if(champ.value === "" || !regex.test(champ.value)){
     console.log("Le champ Password n'est pas valide");
      surligne(champ, true);
      return false;
   }
   else{
      surligne(champ, false);
      return true;
   }
}

function comparePassword (champ){
  var pass1 = document.getElementById('pass1');
  var pass2 = document.getElementById('pass2');
  if (pass1.value != pass2.value) {
     alert("Les 2 password ne sont pas identiques.");
     surligne(champ, true);
     return false;
  }
  else {
    surligne(champ, false);
    return true;
  }
}

/*function verifForm(f) {
   var firstnameOk = verifName(f.firstname);
   var lastnameOk = verifName(f.lastname);
   var mailOk = verifMail(f.email);
   var passwordOk = verifPassword(f.password);
   if(firstnameOk !== false && lastnameOK !== false && mailOk !== false && passwordOk !== false) {
       console.log("Le formulaire est passé");
       return true;
   }
   else {
       console.log("GTFO");
       alert("Veuillez remplir correctement tous les champs");
       return false;
   }
}*/

   function verifForm(f){
       var firstnameOk = verifName(f.firstname);
       var lastnameOk = verifName(f.lastname);
       var mailOk = verifMail(f.email);
    if(!verifName(f.firstname) && !verifName(f.lastname) && !verifMail(f.email) && !verifPassword(f.password)) {
      console.log("Le formulaire est passé");
      return true;
    }
   else {
      console.log("GTFO");
      alert("Veuillez remplir correctement tous les champs");
      return false;
   }
}
