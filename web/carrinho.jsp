<%@page import="br.com.controller.ItensListController"%>
<%@page import="br.com.model.Item"%>


<!-- Tenho consciência que o correto aqui seria fazer a requisição ajax em um servlet
e retornar os dados com json ou xml, mas tive problemas com o json, então encontrei essa alternativa.  -->
<form method="get" action="ServletFinalizarCompra">
    <div class="modal-body">


        <% for (Item it : ItensListController.getItensList(request)) {%>

        <div class="row">
            <div class="col-xs-2"><img class="img-responsive" width="80" height="80" src="img/<%= it.getCodigoString()%>.jpg">
            </div>
            <div class="col-xs-4">
                <h4 class="product-name"><strong><%= it.getDescricao()%></strong></h4><h4><small>Unidade</small></h4>
            </div>
            <div class="col-xs-6">
                <div class="col-xs-6 text-right">
                    <h6><strong><span class="value"><%= ItensListController.format(it.getValor())%></span> <span class="text-muted">x</span></strong></h6>
                </div>
                <div class="col-xs-4">
                    <input type="hidden" name="produto[]" value="<%= it.getCodigoString()%>"/>
                    <input type="number" name="quantidade[]" class="form-control input-sm" value="1" min="1">
                </div>
                <div class="col-xs-2">
                    <button type="button" class="btn btn-link btn-xs delete" data-item-id="<%= it.getCodigoString()%>">
                        <span class="glyphicon glyphicon-trash"> </span>
                    </button>
                </div>
            </div>
        </div>
        <hr/>
        <% }%>

    </div>
    <div class="modal-footer">                        
        <div class="row text-center">
            <div class="col-xs-9">
                <h4 class="text-right">Total R$<strong id="total"><%= ItensListController.format(ItensListController.getItensSum(request))%></strong></h4>
            </div>
            <div class="col-xs-3">
                <input type="submit" value="Finalizar pedido" class="btn btn-success btn-block" id="finalizar">
            </div>
        </div>

    </div>
</form>
<script type="text/javascript" src="js/carrinho.js"></script>