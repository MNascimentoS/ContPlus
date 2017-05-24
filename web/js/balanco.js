function gerarBalanco() {
    document.getElementById('balanco-div').style.display = 'block';
    var dataI = $("#dateI")["0"].value;
    if (dataI[1] === " ") dataI = "0" + dataI;
    dataI = dataI.replace(/\s/g,'');
    dataI = dataI.replace(/,/g,'');
    var dataF = $("#dateF")["0"].value;
    if (dataF[1] === " ") dataI = "0" + dataI;
    dataF = dataF.replace(/\s/g,'');
    dataF = dataF.replace(/,/g,'');
    $("#balanco").load("search.jsp?find=balanco&dataI=" + dataI + "&dataF=" + dataF);
}
            
function gerarPDF() {
    var mywindow = window.open('', 'PRINT', 'height=1000,width=1000');
    mywindow.document.write(document.getElementById('balanco').innerHTML);
    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/

    mywindow.print();
    mywindow.close();
}