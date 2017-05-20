$('#campus').on('change', function (e) {
    var optionSelected = $("option:selected", this);
    var labelSelected = optionSelected.text();
    var divDepartamento = $('input[value="'+ labelSelected +'"]');
    select = document.getElementById('departamento');
    $('#departamento')
        .find('option')
        .remove()
    ;
    addOnSelect(select, "Departamento", "", true, true);
    for (var i = 0; i < divDepartamento.length; i++) {
        var input = $(divDepartamento[i]);
        addOnSelect(select, input.attr('name'), input.attr('id'), false, false);
    }

});

$('#departamento').on('change', function (e) {
    var optionSelected = $("option:selected", this);
    var labelSelected = optionSelected.text();
    var divCurso = $('input[value="'+ labelSelected +'"]');
    console.log(divCurso);
    select = document.getElementById('curso');
    $('#curso')
        .find('option')
        .remove()
    ;
    addOnSelect(select, "Curso", "", true, true);
    for (var i = 0; i < divCurso.length; i++) {
        var input = $(divCurso[i]);
        addOnSelect(select, input.attr('name'), input.attr('id'), false, false);
    }

});

function addOnSelect(select, name, value, disable, selected){
    var opt = document.createElement('option');
    opt.value = value;
    opt.innerHTML = name;
    opt.disabled = disable;
    opt.selected = selected;
    select.appendChild(opt);
}