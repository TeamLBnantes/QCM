/**
 * 
 */
    
    
window.addEventListener("load", () => {
    let regexaZOld = new RegExp('[a-zéèë]');    
    let regexaZ = new RegExp('^[a-zA-Z-]{1,}$');     //retravailler sur expression reguliere !!!!!!!
    let regexMail = new RegExp('^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$');
    let inputLastName = document.querySelector('#lastName');
    let inputFirstName = document.querySelector('#firstName');
    let inputEmail =document.getElementById('email');
    let inputConfirmEmail =document.querySelector('#confirmEmail');
    let inputPassword = document.querySelector('#password');
    let inputConfirmPassword = document.querySelector('#confirmPassword');
      
    let displayLastName = document.querySelector('#displayLastName');
    let displayFirstName = document.querySelector('#displayFirstName');
    let displayError = document.querySelector('#displayError')
    let displayConfirmPassword = document.querySelector('#displayConfirmPassword');
    let displayConfirmEmail = document.querySelector('#displayConfirmEmail');
    let displayEmail = document.querySelector('#displayEmail');
   
    


    
//    let validationPassword = false;
//    let validationConfirmationEmail =false;
//    let validationLastName = false;
//    let validationFirstName = false;
//    let validationEmail=false;
    

    document.getElementById("gestionMail").value="false"
    document.getElementById("gestionPassword").value="false"

// Afficher masquer les infos mail   
  document.getElementById("gestionMail").addEventListener("click", (event) =>{  
	if (document.getElementById("gestionMail").checked) { 
		document.getElementById("afficherMail").style.display = 'block';
		document.getElementById("gestionMail").value="true";
			document.getElementById("email").required="required";
			document.getElementById("confirmEmail").required="required";
		}else {
		document.getElementById("afficherMail").style.display = 'none';
		document.getElementById("gestionMail").value="false"
			document.getElementById("email").required="";
		document.getElementById("confirmEmail").required="";
		}
});
 // Afficher masquer les infos password       
    document.getElementById("gestionPassword").addEventListener("click", (event) =>{  
    	if (document.getElementById("gestionPassword").checked) { 
    		document.getElementById("afficherPassword").style.display = 'block';
    		document.getElementById("gestionPassword").value="true"
    			document.getElementById("password").required="required";
			document.getElementById("confirmPassword").required="required";
    		}else {
    		document.getElementById("afficherPassword").style.display = 'none';
    		document.getElementById("gestionPassword").value="false"
    			document.getElementById("password").required="";
			document.getElementById("confirmPassword").required="";
    		}
    });    
    
    
    
    
    inputLastName.addEventListener("keyup", (event) => {
    	 console.log("inputLastName.value : "+inputLastName.value)
    	 console.log(regexaZ.test(inputLastName.value))
        if (regexaZ.test(inputLastName.value)) {
            event.target.classList.remove("error");
            displayLastName.innerHTML = " ";
            validationLastName="true";
        }
        else {
            event.target.classList.add("error");
            displayLastName.innerHTML = "N'entrez que des lettres SVP";
            validationLastName="false";
        }
    })

       inputFirstName.addEventListener("keyup", (event) => {
        if (regexaZ.test(inputFirstName.value)) {
            event.target.classList.remove("error");
            displayFirstName.innerHTML = " ";
            validationFirstName="true";
        }
        else {
            event.target.classList.add("error");
            displayFirstName.innerHTML = "N'entrez que des lettres SVP";
            validationFirstName="false";
        }
    }) 
    
    
    
    
//    inputFirstName.addEventListener("keydown", (event) => {
//        regAZ(regexaZ, event, displayFirstName);
//        if (displayFirstName.value == "") {  validationFirstName = true; 
//        }else{validationFirstName = false; }
//    })
    

    inputConfirmPassword.addEventListener("blur", (event)  => {
        if (inputConfirmPassword.value === inputPassword.value){
            displayConfirmPassword.innerHTML = "";
            validationPassword="true";
        }else{
            displayConfirmPassword.innerHTML = "Erreur: MDP non identiques";
            validationPassword="false";
        }
    })

       
        inputEmail.addEventListener("blur", (event)  => {
        	console.log(inputEmail.value +" "+regexMail.test(inputEmail.value));
            if (regexMail.test(inputEmail.value)) {
                event.target.classList.remove("error");
                displayEmail.innerHTML = " ";
                validationEmail="true";
            }
            else {
                event.target.classList.add("error");
                displayEmail.innerHTML = "Email invalide";
                validationEmail="false";
            }
        })
        
        inputConfirmEmail.addEventListener("blur", (event)  => {
        if (inputConfirmEmail.value === inputEmail.value){
            displayConfirmEmail.innerHTML = "";
            validationConfirmationEmail="true";
            console.log(validationConfirmationEmail)
        }else{
        	displayConfirmEmail.innerHTML = "Erreur: Email non identiques";
            validationConfirmationEmail="false";
            console.log(validationConfirmationEmail)
        }
    })
        


   document.getElementById("valider").addEventListener('click', function(){
//	   console.log("==============================================)");
//	   console.log("validationEmail : "+validationEmail)
//	   console.log("validationConfirmationEmail : "+validationConfirmationEmail)
//	   console.log("validationPassword : "+validationPassword)
//	   console.log("validationLastName : "+validationLastName)
//	   console.log("validationFirstName : "+validationFirstName)
//	   console.log("gestion mail : "+(document.getElementById("gestionMail").value))
//	   console.log("gestion passwordl : "+document.getElementById("gestionPassword").value)
//
//	   let eval1=((document.getElementById("gestionMail").value==="true")&&((validationEmail==="false")||(validationConfirmationEmail==="false")))
//	   console.log("eval mail et champs mail  : "+eval1)
//	   let eval2=((document.getElementById("gestionPassword").value==="true") && (validationPassword==="false"))
//	   console.log("eval pass et champs pass  : "+eval2)
//	   let a=(validationFirstName ==='false')
//	   console.log("(validationFirstName==='false')  :"+a)
//	   	   let b=(validationLastName ==='false')
//	   console.log("(validationLastName==='false')  :"+b)
//	   let global=(((document.getElementById("gestionMail").value==="true")&&((validationEmail==="false")||(validationConfirmationEmail==="false")))
//       		||((document.getElementById("gestionPassword").value==="true") && (validationPassword==="false"))
//    		||(validationLastName==="false")||(validationFirstName==="false"))
//       console.log("eval globale  :"+global) 
	   
        if(((document.getElementById("gestionMail").value==="true")&&((validationEmail==="false")||(validationConfirmationEmail==="false")))
        		||((document.getElementById("gestionPassword").value==="true") && (validationPassword==="false"))
        		||(validationLastName==="false")||(validationFirstName==="false"))
        {
            event.preventDefault();
            displayError.innerHTML="Veuillez renseigner correctement les champs";
        }else {
            displayError.innerHTML="";
        }
    })
})

//function regAZ(regexaZ, event, display) {
//	console.log(event.key);
//    if (regexaZ.test(event.key)) {
//        event.target.classList.remove("error");
//        display.innerHTML = "";
//
//    }
//    else {
//        event.target.classList.add("error");
//        display.innerHTML = `N'entrez que des lettres SVP`;
//    }
//}
