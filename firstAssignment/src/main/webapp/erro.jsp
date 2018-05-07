<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="mvcp"
          uri="/WEB-INF/tlds/MVCPages" %>

<mvcp:MVCPages nomeDaPagina="TempoClima"
                 nomeDoTratador="mvc.pagehandlers.TratadorPagina1">

    <div id="divmiolo_1" class="divmiolo">
        <font size="5" style="font-weight:bolder;">ERRO</font>
        <br>
        <br>
        ${EXCESSAO_CONTROLLER}
    </div>
</mvcp:MVCPages>
