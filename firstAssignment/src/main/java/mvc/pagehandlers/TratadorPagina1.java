package mvc.pagehandlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.*;
import mvc.IFTratadorDePaginas;
import java.text.*;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 *
 * @author santi
 */

public class TratadorPagina1 implements IFTratadorDePaginas {
    
    @Override
    public String processar(HttpServletRequest request, HttpServletResponse response) {
    
        String jspURL = null;
        
        String botaoBuscar = request.getParameter("botaobuscar");
        if (botaoBuscar.equals("BUSCAR")){
            jspURL = "index.jsp";
            SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            
            MedidasAutomaticas medidas = new MedidasAutomaticas();
            Observacoes obs = new Observacoes();
            String data = request.getParameter("buscardatahora");
            Date datahora;
            
            if (data == null || data.isEmpty()) data = ft.format(new Date());
            
            try {
                datahora = ft.parse(data);
            }
            catch (ParseException pe){
                request.setAttribute("BUSCAR_DATA_HORA", "Formato: YYYY/MM/DD hh:mm");
                return jspURL;
            }
            
            medidas.setDataHoraBusca(datahora);
            obs.setDataHoraBusca(datahora);
            
            medidas.setValues();
            obs.setValues();
            
            LinkedHashMap<String,Object> mapMed = medidas.getValues();
            LinkedHashMap<String,Object> mapObs = obs.getValues();
            
            for (String key : mapMed.keySet()){
                request.setAttribute(key, mapMed.get(key));
            }
            
            for (String key : mapObs.keySet()){
                request.setAttribute(key, mapObs.get(key));
            }
            
            String color = obs.getCorDaBandeira(mapObs.get("bandeira").toString());
            request.setAttribute("cor", color);
            request.setAttribute("BUSCAR_DATA_HORA", ft.format(datahora));
            
        }
        return jspURL;
    }
    
}
