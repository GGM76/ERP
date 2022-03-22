package Controlador;

import erpBD.Categoria;
import erpBD.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class buscadores {
    
    private conexion conectar;
    private Categoria cat;
    private Connection con;
    private Productos prod;
    
    public int buscarIDcat(String categoria){
        int idcat=0;
        conectar = new conexion(); 
        PreparedStatement statement=null;
        ResultSet result=null; 
        String SSQL = "select idcategoria from categorias where nombre=\""+categoria+"\";";
        con = conectar.getConexion();
       try {
        if (con!=null) {
            statement=con.prepareStatement(SSQL);    
            result=statement.executeQuery();
             if(result.next())   idcat=((Number) result.getObject(1)).intValue();
        conectar.desconectar();}
    } catch (SQLException e) {
        System.out.println("Error en la consulta "+e.getMessage());
        }
        return idcat;
    }
    
}
