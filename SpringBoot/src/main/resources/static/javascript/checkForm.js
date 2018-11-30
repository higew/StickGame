function surligne(champ, erreur)
{
   if(erreur)
      champ.style.backgroundColor = "#fba";
   else
      champ.style.backgroundColor = "";
}

function verifName(champ)
{
   if(champ.value.length < 2 || champ.value.length > 32)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifMail(champ)
{
   var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
   if(!regex.test(champ.value))
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}


function verifPassword(champ){
   var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,32})/;
   if(!regex.test(champ.value)){
      surligne(champ, true);
      return false;
   }
   else{
      surligne(champ, false);
      return true;
   }
}

function verifForm(f)
{
   var firstnameOk = verifName(f.firstname);
   var lastnameOk = verifName(f.lastname);
   var mailOk = verifMail(f.email);
   var passwordOk = verifPassword(f.password);
   if(firstnameOk && lastnameOK && mailOk && passwordOk)
      return true;
   else
   {
      alert("Veuillez remplir correctement tous les champs");
      return false;
   }
}
