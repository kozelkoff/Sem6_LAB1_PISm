/*var button=document.getElementsByClassName("button");
var emptyError = false;
var illegalNumbersError = false;
var illegalLetterError = false;
button[0].onclick = function(){
    var arrOfInputs = document.getElementsByTagName("input");
    for(var i=0; i<arrOfInputs.length-1; i++){
        if(arrOfInputs[i].value==""){
            arrOfInputs[i].style.border = "2px solid red";
            emptyError = true;
        }
        if(i%3==0){
            illegalNumbersError = /[0-9]/.test(arrOfInputs[i].value);
            arrOfInputs[i].style.border = "2px solid red";
        }
        if(i%3!=0){
            if((arrOfInputs[i].value).search(/a/i)!= -1){
                illegalLetterError = true;
                arrOfInputs[i].style.border = "2px solid red";
            }
        }
    }
    var errorAlert="";
    if(emptyError) errorAlert += "Some inputs are empty!" + "\n";
    if(illegalLetterError) errorAlert += "There are letters in 'Mark' or/and 'Grade' fields" + "\n";
    if(illegalNumbersError) errorAlert += "There are numbers in 'Surname' field" + "\n";
    alert(errorAlert);
}*/

var emptyError = 0;
var illegalNumbersError = 0;
var illegalLetterError = 0;
function checkForm(){
    emptyError = 0;
    illegalNumbersError = 0;
    illegalLetterError = 0;



    var arrOfInputs = document.getElementsByTagName("input");
    for(var i=0; i<arrOfInputs.length-1; i++){
        arrOfInputs[i].style.border = "2px solid gray";
        if(arrOfInputs[i].value==""){
            arrOfInputs[i].style.border = "2px solid red";
            emptyError++;
        }
        if(i%3==0){
            if(/[0-9]/.test(arrOfInputs[i].value)) {
                arrOfInputs[i].style.border = "2px solid red";
                illegalNumbersError++;
            }
        }
        if(i%3!=0){
            if((arrOfInputs[i].value).search(/a/i)!= -1){
                illegalLetterError++;
                arrOfInputs[i].style.border = "2px solid red";
            }
        }
    }
    var errorAlert="";
    if(emptyError>0){
        errorAlert += "Some inputs are empty!";
        errorAlert += "\n";
    }
    if(illegalLetterError>0){
        errorAlert += "There are letters in 'Mark' or/and 'Grade' fields!";
        errorAlert += "\n";
    }
    if(illegalNumbersError>0){
        errorAlert += "There are numbers in 'Surname' field!";
        errorAlert += "\n";
    }

    if(errorAlert!=""){
      alert(errorAlert);
      return false;
    }
    else return true;
}