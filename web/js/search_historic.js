/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const SEARCH_BY_HISTORIC_NUMBER = 1; 
let select_count = $("#select_count");

select_count.on('change', function (e) {
    //make the request
    search_by_number(select_count.val());
});

function search_by_number(historic_number) {
    $("#name").text($("#select_count option:selected" ).text());
    $.ajax({
        type: "POST",
        url: "HistoricServlet",
        data: {process_number: historic_number, option: SEARCH_BY_HISTORIC_NUMBER}, // parameters
        dataType: "json",
        success: function (list) {
            var line = '';//this will hold the tr(line) into table
            var final_line = '';//the final line bottom of table with total of processes
            var final_value = 0;
            //for each element, add to a new line and put on table
            $.each(list, function (index) {
                if(list[index].tipo === "credito"){
                    line += '<tr><td>'+list[index].data+'</td><td>'+list[index].id+'</td><td>'+list[index].conta_codigo+'</td><td></td><td></td><td>'+list[index].valor+'</td><td>C</td></tr>';
                }else{
                    line += '<tr><td>'+list[index].data+'</td><td>'+list[index].id+'</td><td>'+list[index].conta_codigo+'</td><td></td><td>'+list[index].valor+'</td><td></td><td>D</td></tr>';
                }
            });

            line += '<tr><td><b>Total<b></td><td></td><td></td><td></td><td></td><td></td><td><b>' + list.length + '<b></td></tr>';
            //erase previous element on table body
            $("#t_body").empty();
            //add content to table
            $("#processes").prepend(line);
        }
    });
}

function gerarPDF() {
    var mywindow = window.open('', 'PRINT', 'height=1000,width=1000');
    mywindow.document.write(document.getElementById('historics').innerHTML);
    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/

    mywindow.print();
    mywindow.close();
}