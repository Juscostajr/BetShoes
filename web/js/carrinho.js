/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//exlui item do carrinho
$(document).ready(function () {
    $(".delete").click(function () {
        $.get("ServletProdutoListDelete?id=" + $(this).attr("data-item-id"), function (data, status) {
            $("#shopping-cart-count").html(data);
            $.get("carrinho.jsp", function (data, status) {
                $("#carrinho").html(data);
            });
        });

    });

    //Atualiza total dos itens de acordo com a quantidade de cada
    $(".input-sm").change(function () {
        var val = $(this).parent().parent().first().find('.value').html();
        var factor = parseFloat(val) * $(this).val();
        var total = $("#total").html();
        var previousdiscounts = this.defaultValue * parseFloat(val);
        this.defaultValue = this.value;
        total = parseFloat(total) - previousdiscounts + factor;
        $("#total").html(total.toFixed(2));
    });

});
