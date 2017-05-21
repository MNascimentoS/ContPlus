/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//default colors
const WRONG_COLOR = "#F44336";
const VALID_COLOR = "#4CAF50";
const DEFAULT_COLOR = "#2196F3";

const VERIFY_PROCESS_NUMBER = 1;
const VERIFY_MATRICULA_NUMBER = 2;


let valid_matricula = false;
let valid_process = false;
let valid_rb = false;

let process_number = $("#process_number");
let div_process_error = $("#div_process_error");
let text_process_error = $("#text_process_error");
let user_matricula = $("#matricula");
let div_matricula_error = $("#div_matricula_error");
let text_matricula_error = $("#text_matricula_error");
let motivo_dilatacao = $("#reason");

//disable button
$( document ).ready(function() {
    $("#save_button").prop("disabled",true);
});

/**
 * Initial test ajax
 */
process_number.focusout(function () {

    if (process_number.val() === "") {
        text_process_error.text("Campo vazio");
        text_process_error.css("color", WRONG_COLOR);
        process_number.css("border-bottom", "1px solid " + WRONG_COLOR);
        div_process_error.show();
        valid = false;
    }else{
        checkProcessNumber(process_number.val());
    }
});


user_matricula.focusout(function () {
    if (user_matricula.val() === "") {
        text_matricula_error.text("Campo vazio");
        text_matricula_error.css("color", WRONG_COLOR);
        user_matricula.css("border-bottom", "1px solid " + WRONG_COLOR);
        div_matricula_error.show();
        valid = false;
    }else{
        checkMatricula(user_matricula.val());
    }
});

function checkProcessNumber(number) {
    $.ajax({
        type: "POST",
        url: "ProcessServlet",
        data: {process_number: number, option: VERIFY_PROCESS_NUMBER}, // parameters
        success: function (status) {
            if (status == "jaExiste") {
                text_process_error.text("Este processo já existe");
                text_process_error.css("color", WRONG_COLOR);
                process_number.css("border-bottom", "1px solid " + WRONG_COLOR);
                div_process_error.show();
                valid_process = false;
            } else {
                process_number.css("border-bottom", "1px solid " + VALID_COLOR);
                div_process_error.hide();
                valid_process = true;
            }
             checkEverything();
        }
    });
}

function checkMatricula(number) {
    $.ajax({
        type: "POST",
        url: "ProcessServlet",
        data: {matricula_number: number, option: VERIFY_MATRICULA_NUMBER}, // parameters
        success: function (status) {
            if (status == "naoExiste") {
                text_matricula_error.text("Este discente não existe");
                text_matricula_error.css("color", WRONG_COLOR);
                user_matricula.css("border-bottom", "1px solid " + WRONG_COLOR);
                div_matricula_error.show();
                valid_matricula = false;
            }else{
                user_matricula.css("border-bottom", "1px solid " + VALID_COLOR);
                div_matricula_error.hide();
                valid_matricula = true;
            }
            checkEverything();   
        }
    });
}

$('#rbAprovado, #rbReprovado').click(function () {
    valid_rb = true;
    checkEverything();
});

$("#reason").focusout(function () {
    checkEverything();
});

function checkEverything(){
    if(valid_matricula && valid_process && $("#reason").val() !== ""){
      $("#save_button").prop("disabled", false);    
    }else{
      $("#save_button").prop("disabled", true);    
    }
}
