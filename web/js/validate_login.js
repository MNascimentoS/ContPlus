/**
* Este Script valida a entrada do usuario na pagina de login
  Created by: junior
  Date: 04/05/2017
*/
//store the min length of matricula, actually is nine
const MAT_LENGTH = 9;
const MIN_USER_LENGTH = 6;//min size of user login in alphanumeric case
const MIN_PASS_LENGTH = 6;//min size of user pass
//error text
const LOGIN_FIELD_EMPTY = "Campo usuário não pode estar vazio.";
const PASS_FIELD_EMPTY = "Campo senha não pode estar vazio.";
//default colors
const WRONG_COLOR = "#F44336";
const VALID_COLOR = "#4CAF50";
const DEFAULT_COLOR = "#2196F3";
//getting values and elements
let user_field = $("#user_name");
let user_name_error = $("#user_name_error");
let user_name_error_div = $("#user_name_error_div");
let pass_field = $("#password");
let pass_error = $("#pass_error");
let pass_error_div = $("#pass_error_div");
/*on focus  clear the error div*/
$("#user_name").focus(function(){
  user_field.css("border-bottom", "1px solid "+DEFAULT_COLOR);
  user_name_error_div.hide();
});

/*on focus out validate user field*/
$("#user_name").focusout(function(){
    if($("#user_name").val() == ''){//case it's empty
      user_name_error.text(LOGIN_FIELD_EMPTY);
      invalid_user();
    }else{
      if($.isNumeric($("#user_name").val())){//case just number, rules for matricula
        if($("#user_name").val().length == MAT_LENGTH){
          valid_user();
        }else{
          user_name_error.text("A matricula deve conter "+MAT_LENGTH+" caracteres.");
          invalid_user();
        }
      }else{//case alphanumeric
        if($("#user_name").val().length >=  MIN_USER_LENGTH){
          valid_user();
        }else{
          user_name_error.text("O nome de usuário deve conter no minímo "+MIN_USER_LENGTH+" caracteres.");
          invalid_user();
        }
      }
    }
});

function valid_user(){
  //hide error field
  user_name_error_div.hide();
  //change the color of input field to green
  user_field.css("border-bottom", "1px solid "+VALID_COLOR);
}


function invalid_user(){
  //hide error field
  user_name_error_div.show();
  //change the color of input field to red
  user_field.css("border-bottom", "1px solid "+WRONG_COLOR);
  user_name_error.css("color", WRONG_COLOR);
}


/*on focus  clear the error div*/
$("#password").focus(function(){
  pass_field.css("border-bottom", "1px solid "+DEFAULT_COLOR);
  pass_error_div.hide();
});

$("#password").focusout(function(){
  if($("#password").val() == ''){//case it's empty
    pass_error.text(PASS_FIELD_EMPTY);
    invalid_pass();
  }else{
    if($("#password").val().length >= MIN_PASS_LENGTH){
      valid_pass();
    }else{
      pass_error.text("Sua senha deve conter no mínimo "+MIN_PASS_LENGTH+" caracteres.");
      invalid_pass();
    }
  }
});

function valid_pass(){
  //hide error field
  pass_error_div.hide();
  //change the color of input field to green
  pass_field.css("border-bottom", "1px solid "+VALID_COLOR);
}


function invalid_pass(){
  //change the color of input field to red
  pass_field.css("border-bottom", "1px solid "+WRONG_COLOR);
  pass_error.css("color", WRONG_COLOR);
  //hide error field
  pass_error_div.show();
}
