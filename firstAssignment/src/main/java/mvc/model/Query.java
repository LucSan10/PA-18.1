package mvc.model;

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author santi
 */
public class Query {
    
    static ResultSet rsSet;
    static PreparedStatement prepStmt;
    static SimpleDateFormat sdForm;
    static Connection con;
    
    public Object getMeasurementsFromDatabase(java.util.Date datahora, String column) {
        con = null;

        try {
            Class.forName("org.postgresql.Driver");
            
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX");
            String s = ft.format(datahora);
            
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "l1u2c3a4s5!");
            prepStmt = con.prepareStatement(
            "SELECT * FROM public.medidores, public.medidasautomaticas\n" +
            "WHERE medidores.serialmedidores = medidasautomaticas.medidor\n" +
            "AND medidasautomaticas.datahora <= '"+s+"'\n" +
            "ORDER BY medidasautomaticas.datahora DESC LIMIT 1;");
        }
        catch(Exception e) {
            System.out.println("==== Exceção 1: "+ e);
            e.printStackTrace();
        }
        
        Object obj = "null";
        
        try {
            rsSet = prepStmt.executeQuery();
            if (rsSet.next()) {
                obj = rsSet.getObject(column);
            }
        }
        
        catch(Exception e) {
            System.out.println("==== Exceção 2: "+ e);
            e.printStackTrace();
        }
        return obj;
    }

    
    public Object getObservationsFromDatabase(java.util.Date datahora, String column) {
        con = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX");
            String s = ft.format(datahora);
            
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "l1u2c3a4s5!");
            prepStmt = con.prepareStatement(
            "SELECT * FROM public.observacoes, public.observadores\n" +
            "WHERE observacoes.observador = observadores.serialobservadores\n" +
            "AND observacoes.datahoraobservacao <= '"+s+"'\n" +
            "ORDER BY observacoes.datahoraobservacao DESC LIMIT 1;");
        }
        catch(Exception e) {
            System.out.println("==== Exceção 3: "+ e);
            e.printStackTrace();
        }
        
        Object obj = "null";
        
        try {
            rsSet = prepStmt.executeQuery();
            if (rsSet.next()) {
                obj = rsSet.getObject(column);
            }
        }
        catch(Exception e) {
            System.out.println("==== Exceção 4: "+ e);
            e.printStackTrace();
        }
        return obj;
    }
}