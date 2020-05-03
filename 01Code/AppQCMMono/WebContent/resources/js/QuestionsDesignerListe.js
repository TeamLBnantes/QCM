

document.getElementById('motCle').addEventListener('keyup', function(e) {
	
    var recherche = this.value.toLowerCase();
    var documents = document.querySelectorAll('.question');

//   alert('mot rechercher : '+recherche);
//   alert('nombre de noeuds trouves : '+documents.length);
//    alert(documents)
   for (i = 0; i < documents.length; i++){

//	   alert("noeud niveau 0 "+documents[i].textContent )
	   if (documents[i].textContent.toLowerCase().indexOf(recherche) > -1) {
		   documents[i].style.display = 'block';
	      } else {
	       documents[i].style.display = 'none';
	      }
   }

	   
   
});




function visibilite(thingId) { 
	var targetElement; 
	targetElement = document.getElementById(thingId) ; 
	if (targetElement.style.display == "none") { 
		targetElement.style.display = "" ; } else { 
			targetElement.style.display = "none" ; } 
	} 





