/**
 * 
 */
    
    
window.addEventListener("load", () => {
    let regexaZ = new RegExp('^[a-zA-Z-]{1,}$');
    let regexMail = new RegExp('^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$');
//    let inputLastName = document.querySelector('#lastName');
//    let inputFirstName = document.querySelector('#firstName');
//    let inputEmail =document.querySelector('#email');
//    let inputConfirmEmail =document.querySelector('#confirmEmail');
//    let inputPassword = document.querySelector('#password');
//    let inputConfirmPassword = document.querySelector('#confirmPassword');
//      
//    let displayLastName = document.querySelector('#displayLastName');
//    let displayFirstName = document.querySelector('#displayFirstName');
//    let displayError = document.querySelector('#displayError')
//    let displayConfirmPassword = document.querySelector('#displayConfirmPassword');
//    
//    let valider =document.querySelector('#valider');
//    
//    let validationPassword = false;
//    let validationEmail = false;
//    let validationConfirmationEmail =false;
//    let validationLastName = false;
//    let validationFirstName = false;

    
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
    
    
    
    
    
    //let errorAz = '<tag:message code="CONFIRMPASSWORD" text="traduction manquante!"></tag>';

//    inputLastName.addEventListener("keydown", (event) => {
//        regAZ(regexaZ, event, displayLastName);
//       if (displayLastName == "") {  validationLastName = true; 
//       }else{validationLastName = false; }
//    })
//
//    inputFirstName.addEventListener("keydown", (event) => {
//        regAZ(regexaZ, event, displayFirstName);
//        if (displayLastName == "") {  validationFirstName = true; 
//        }else{validationLastName = false; }
//    })
//    
//

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
       
        inputEmail.addEventListener("blur", (event)  => {

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
        }else{
            displayConfirmEmail.innerHTML = "Erreur: Email non identiques";
            validationConfirmationEmail="false";
        }
    })
      
        inputConfirmPassword.addEventListener("blur", (event)  => {
        if (inputConfirmPassword.value === inputPassword.value){
            displayConfirmPassword.innerHTML = "";
            validationPassword="true";
        }else{
            displayConfirmPassword.innerHTML = "Erreur: MDP non identiques";
            validationPassword="false";
        }
    })

   document.getElementById("valider").addEventListener('click', function(){
        if((validationEmail==='false')||(validationPassword==='false')||(validationFirstName==='false')
        		||(validationLastName==='false')||(validationConfirmationEmail==='false')){
            event.preventDefault();
            displayError.innerHTML="Veuillez renseigner correctement les champs";
        }else {
            displayError.innerHTML="";
        }
    })
})


//function regAZ(regexaZ, event, display) {
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
