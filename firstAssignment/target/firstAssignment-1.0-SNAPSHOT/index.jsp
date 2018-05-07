<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% URL contexto = new URL(
            "http",
            request.getServerName(),
            request.getServerPort(),
            request.getContextPath());%>


<%@taglib prefix="header" uri="/WEB-INF/tlds/MVCHeader" %>
<%@taglib prefix="pages" uri="/WEB-INF/tlds/MVCPages" %>

<header:MVCHeader titulo="TempoClima">
    <link rel="stylesheet" type="text/css" href="<%= contexto%>/css/index.css"/>
    <pages:MVCPages
        nomeDaPagina="Lucas Santiago"
        nomeDoTratador="mvc.pagehandlers.TratadorPagina1">
        
        <div id="idDivLocal">
            <br>
            Local: <span class="classTexto1">Rio de Janeiro, RJ, Brasil - Posto 9</span>
        </div>
        <div id="idDivDatahora">
            <br>
            Data-hora: <input type="text" size="16" name="buscardatahora" 
                              value="${BUSCAR_DATA_HORA}"
                              style="font-size:1.05em;text-align:center;"/>
                       <input type="submit" name="botaobuscar" value="BUSCAR" 
                              style="font-size:1.05em;"/>
                       <br>
                       <br>
        </div>

        <div id="idDiv1">

            <div id="idDivMedAutom" class="shadowBorder">
                MEDIDAS AUTOMÁTICAS<br>
                <br>
                Descrição do Medidor: <span id="descricao" class="classTexto1">${descricao}</span><br>
                Data-hora: <span id="datahoraautom" class="classTexto1">${datahora}</span><br>
                Temperatura: <span id="temperatura" class="classTexto1">${temperatura}°C</span><br>
                Umidade: <span id="umidade" class="classTexto1">${umidade}%</span><br>
                Ponto de Orvalho: <span id="orvalho" class="classTexto1">${orvalho}°C</span><br>
                Pressão Atmosférica: <span id="pressao" class="classTexto1">${pressao} hPA</span><br>
                Taxa de Precipitação: <span id="precipitacao" class="classTexto1">${taxaprecipitacao} mm/h</span><br>
                Precipitação Acumulada: <span id="precipacumul" class="classTexto1">${precipitacaoacum} mm</span><br>
                (últimas 24h)<br>
                Velocidade do Vento: <span id="velvento" class="classTexto1">${velvento} km/h</span><br>
                Direção do vento: <span id="dirvento" class="classTexto1">${dirvento}°</span><br>
            </div>

            <div id="idDivObserv" class="shadowBorder">
                OBSERVAÇÕES<br>
                <br>
                Nome do Observador: <span id="nomeobs" class="classTexto1">${nome}</span><br>
                Data-hora: <span id="datahoraobs" class="classTexto1">${datahoraobservacao}</span><br>
                Altura das Ondas: <span id="altondas" class="classTexto1">${alturaondas} m</span><br>
                Temperatura da Água: <span id="tempagua" class="classTexto1">${temperaturaagua}°C</span><br>
                Bandeira do Serviço de Salva-Vidas: 
                <span id="bandsalvavidas" style="color:${cor};font-weight:bold;">
                    ${bandeira}
                </span><br>
            </div>


            <div id="idDivFotos" class="shadowBorder">
                FOTOS<br>
                <img class="meia-caixa" src="<%= contexto%>/images/praia.jpg"/>
                <img class="meia-caixa" src="<%= contexto%>/images/radar.png"/>
            </div>

            <div id="idDivGraficos" class="shadowBorder">
                GRÁFICOS<br>
                <img class="caixa-inteira" src="<%= contexto%>/images/grafico.temper.png"/>
            </div>

            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
        
    </pages:MVCPages>
</header:MVCHeader>