<%@page import="model.domain.Conta"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.database.DatabaseMySQL" %>
<!DOCTYPE html>
<html lang="pt-br">
    <body>
    <!-- START CONTENT -->
    <section id="content">
        <!--breadcrumbs start-->
        <div id="breadcrumbs-wrapper" class=" grey lighten-3">
            <div class="container">
                <div class="row">
                    <div class="col s12 m12 l12">
                        <h5 class="breadcrumbs-title">Novo Lançamento</h5>
                        <ol class="breadcrumb">
                            <li><a href="index_aux.jsp">Cont+</a></li>
                            <li class="active">Novo Lançamento</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
        <!--breadcrumbs end-->
        <!--start container-->
        <div class="container">
            <br/>
            <form method="post" action="CadLancamentoServlet">
                <div class="row">
                    <div class="input-field col s6 m3">
                        <%ArrayList<Conta> allConta = Conta.getAllFromDatabase();%>
                        <select id="conta" name="conta" class="browser-default" required>
                            <option value="default" disabled selected>Conta</option>
                            <%for (Conta conta : allConta) {
                                if (conta.getCodigo().length() > 4) {
                                    %><option value="<%out.print(conta.getCodigo());%>"><%out.print(conta.getCodigo());%></option><%
                                }else{
                                    %><option value="<%out.print(conta.getCodigo());%>" disabled><%out.print(conta.getNome());%></option><%
                                }
                            }%>
                        </select>
                    </div>
                    <div class="input-field col s6 m6">
                        <input id="name" name="name" type="text" class="validate" disabled>
                    </div>
                    <div class="input-field col s12 m3">
                        <input id="date"  name="date"type="date" class="datepicker" required>
                        <label for="date">Data</label>
                    </div>
                </div>  
                <div class="row">
                    <div class="input-field col s6">
                        <select name="tipo" class="browser-default" required>
                            <option value="credito">Crédito</option>
                            <option value="debito">Débito</option>
                        </select>
                    </div>
                    <div class="input-field col s6">
                        <input id="valor" name="valor" type="text" class="validate" onclick="money()" onchange="money()" required>
                        <label for="valor">Valor</label>
                    </div>
                </div>  
                <div class="row">
                    <div class="input-field col s12">
                        <textarea id="observacao" name="observacao" class="materialize-textarea"></textarea>
                        <label for="observacao">Observação</label>
                    </div>
                </div>
                <!--botão para salvar as alterações-->
                <div class="row">
                    <div class="col s12">
                        <button class="btn button waves-effect waves-light grey" type="cancell">
                        Cancelar
                        </button>
                        <button class="btn button waves-effect waves-light teal" type="submit">
                        Salvar
                        </button>
                    </div>
                </div>
            </form>
            <div id="search" name="search" style="display: none;"></div>
            <br/><br/><br/><br/>
        </div>
        <!--end container-->
    </section>
    <!-- END CONTENT -->
    <script type="text/javascript">
        $('.datepicker').pickadate({
            selectMonths: true, 
            selectYears: 15,
            labelMonthNext: 'Próximo mês',
            labelMonthPrev: 'Mês Anterior',
            labelMonthSelect: 'Selecione um mês',
            labelYearSelect: 'Selecione um ano',
            monthsFull: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
            monthsShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
            weekdaysFull: [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado' ],
            weekdaysShort: [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
            weekdaysLetter: [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
            today: 'Hoje',
            clear: 'Limpar',
            close: 'Fechar'
        });
        $('#conta').on('change', function (e) {
            var optionSelected = $("option:selected", this);
            var labelSelected = optionSelected.text();
            $("#search").load("search.jsp?find=conta&conta=" + labelSelected);
            var nomeInput = document.getElementById("name");  

            setTimeout(function(){
                var name = $("#search")["0"].firstElementChild.name;
                nomeInput.value = name;
            }, 500);
        });
        var mask = {
            money: function() {
                var el = this
                ,exec = function(v) {
                    v = v.replace(/\D/g,"");
                    v = new String(Number(v));
                    var len = v.length;
                    if (1== len)
                    v = v.replace(/(\d)/,"0,0$1");
                    else if (2 == len)
                    v = v.replace(/(\d)/,"0,$1");
                    else if (len > 2) {
                    v = v.replace(/(\d{2})$/,',$1');
                    }
                    return v;
                };

                setTimeout(function(){
                    el.value = exec(el.value);
                },1);
            }
        }
        function money(){ 
            $('#valor').bind('keypress',mask.money);
            $('#valor').bind('keyup',mask.money);
        }
    </script>
    </body>           
</html>
