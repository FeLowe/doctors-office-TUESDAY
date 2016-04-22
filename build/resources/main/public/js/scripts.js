function cleanText(array){
  for(i = 0; i < array.length; i++){
    if(!(/[a-z]/i.test(array[i]))){
      array.splice(i, 1);
    }
  }
  for(i = 0; i < array.length; i++){
    if(array[i] == " "){
      array.splice(i, 1);
    }
  }
  return array
}

$(document).ready(function(){

  var javaOutput = $("#gameOutput")[0].innerText.split("");
  var userInputArray = $(".userInputValue")[0].innerText.split("");
  var cleanUserInputArray = cleanText(userInputArray);

  $("#gameOutput").empty();

  for(i = 0; i < javaOutput.length; i++){
    $("#gameOutput").append("<span class = 'letters'>" + javaOutput[i] + "</span>");
  }

  $("span").click(function(){
    var thisIndex = $(this)[0];
    var spanIndex = $("span").index(thisIndex);
    $(this).text(cleanUserInputArray[spanIndex]);
  })


})
