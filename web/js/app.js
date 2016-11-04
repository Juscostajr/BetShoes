
$(document).ready(function () {
//Carrega Carrinho de Compras
    $.get("carrinho.jsp", function (data, status) {
        $("#carrinho").html(data);
    });
    //Requisição Ajax ao clicar em adicionar ao carrinho
    $(".item-shop").click(function () {
        $.get("ServletProdutoList?id=" + $(this).attr("data-item-id"), function (data, status) {
            $("#shopping-cart-count").html(data);
            $.get("carrinho.jsp", function (data, status) {
                $("#carrinho").html(data);
            });
        });
    });



    $("#valorConsulta").keyup(function() {
        if ($("#valorConsulta").val().length > 3) {
            var table = $("<table></table>").attr("class", "table table-striped table-responsive");
            $.ajax({
                url: "ServletConsultaProduto?consulta=" + $("#valorConsulta").val(),
                type: "get",
                dataType: "json",
                success: function (result) {
                    if (result.length == 0) {
                        table = "Nenhum resultado encontrado!";
                    } else {
                    $.each(result, function (i, field) {

                        var tr = $("<tr></tr>");
                        var td = $("<td></td>");
                        var img = $("<img>").attr("class", "img-small").attr("src", "img/" + pad(field.codigo, 6) + ".jpg");
                        var bot = $("<button></button>").attr("class", "btn btn-success item-shop").attr("data-item-id", pad(field.codigo, 6)).html("Adicionar ao Carrinho");

                        td.append(img);
                        td.clone().appendTo(tr);
                        td.text(field.descricao);
                        td.clone().appendTo(tr);
                        td.text(field.valor);
                        td.clone().appendTo(tr);
                        td.text(field.quantidade);
                        td.clone().appendTo(tr);
                        td.html(bot);
                        td.clone().appendTo(tr);
                        table.append(tr);

                    });
                }               
                    $("#resultadoConsulta").html(table);
                    $("#resultadoConsulta").prepend("<h2>Consulta</h2>");
                }
            });
        } else {
            $("#resultadoConsulta").html(null);
        }
    });
});



// Instancia Bootstrap carousel
$('.multi-item-carousel').carousel({
    interval: false
});
$('.multi-item-carousel .item').each(function () {
    var next = $(this).next();
    if (!next.length) {
        next = $(this).siblings(':first');
    }
    next.children(':first-child').clone().appendTo($(this));
    if (next.next().length > 0) {
        next.next().children(':first-child').clone().appendTo($(this));
    } else {
        $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
    }
});
function pad(str, max) {
    str = str.toString();
    return str.length < max ? pad("0" + str, max) : str;
}


