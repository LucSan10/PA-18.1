package mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
/**
 *
 * @author santi
 */
public class MedidasAutomaticas implements Serializable {
    private static Query q;
    private LinkedHashMap<String,Object> map;
    private static Date searchTime;
    
    public MedidasAutomaticas(){
        q = new Query();
        this.map = new LinkedHashMap<>();
        this.map.put("descricao", "");
        this.map.put("datahora", "");
        this.map.put("temperatura", "");
        this.map.put("umidade", "");
        this.map.put("orvalho", "");
        this.map.put("pressao", "");
        this.map.put("taxaprecipitacao", "");
        this.map.put("precipitacaoacum", "");
        this.map.put("velvento", "");
        this.map.put("dirvento", "");
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
            obj = q.getMeasurementsFromDatabase(searchTime, key);
            this.map.put(key, obj);
        }
    }
    
    public LinkedHashMap<String,Object> getValues() {
        return this.map;
    }
    
/*    public void setDataHora(Date datahora) {
        Query.getObservationsFromDatabase();
        this.dateTime = datahora;
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public double getUmidade() {
        return umidade;
    }
    
    public void setUmidade(double umid) {
        this.umidade = umid;
    }
    
    public double getOrvalho() {
        return orvalho;
    }
    
    public void setOrvalho(double orvalho) {
        this.orvalho = orvalho;
    }
    
    public double getPressao() {
        return pressao;
    }
    
    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
    
    public double getPrecipitacao() {
        return taxaprecipitacao;
    }
    
    public void setPrecipitacao(double precipitacao) {
        this.taxaprecipitacao = precipitacao;
    }
    
    public double getPrecipitacaoAcumulada() {
        return precipitacaoacum;
    }
    
    public void setPrecipitacaoAcumulada(double precipitacaoAcumulada) {
        this.precipitacaoacum = precipitacaoAcumulada;
    }
    
    public double getVelocidadeDoVento() {
        return velvento;
    }
    
    public void setVelocidadeDoVento(double velocidadeDoVento) {
        this.velvento = velocidadeDoVento;
    }
    
    public String getDirecaoDoVento() {
        return dirvento;
    }

    public void setDirecaoDoVento(String direcaoDoVento) {
        this.dirvento = direcaoDoVento;
    }    
*/}