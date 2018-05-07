package mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
/**
 *
 * @author santi
 */
public class Observacoes implements Serializable {
    private static Query q;
    private LinkedHashMap<String,Object> map;
    private static Date searchTime;
  
    public Observacoes() {
        q = new Query();
        this.map = new LinkedHashMap<>();
        this.map.put("nome", "");
        this.map.put("datahoraobservacao", "");
        this.map.put("alturaondas", "");
        this.map.put("temperaturaagua", "");
        this.map.put("bandeira", "");
    }
    
    public void setDataHoraBusca(Date date){
        searchTime = date;
    }
    
    public Date getDataHoraBusca() {
        return searchTime;
    }
    
    public void setValues(){
        
        Object obj = null;
        for(String key : this.map.keySet()){
            obj = q.getObservationsFromDatabase(searchTime, key);
            this.map.put(key, obj);
        }
    }
    
    public LinkedHashMap<String,Object> getValues() {
        return this.map;
    }
    
    public String getCorDaBandeira(String color) {
        switch(color){
            case "amar":{
                return "yellow";
            }
            case "azul":{
                return "blue";
            }
            case "verm":{
                return "red";
            }
            case "verd":{
                return "forestgreen";
            }
            case "roxo":{
                return "purple";
            }
            case "pret":{
                return "black";
            }
            default:{
                return "brown";
            }
        }
    }
    
/*    public Date getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(Date datahora) {
        this.dateTime = datahora;
    }
    
    public double getAlturaDaOnda() {
        return waveHeight;
    }
    
    public void setAlturaDaOnda(double alturaDaOnda) {
        this.waveHeight = alturaDaOnda;
    }
    
    public double getTemperaturaDaAgua() {
        return waterTemperature;
    }
    
    public void setTemperaturaDaAgua(double temperaturaDaAgua) {
        this.waterTemperature = temperaturaDaAgua;
    }
    
    public String getBandeiraSalvaVidas() {
        return lifeguardFlag;
    }

    public void setBandeiraSalvaVidas(String bandeira) {
        this.lifeguardFlag = bandeira;
    }    
*/}