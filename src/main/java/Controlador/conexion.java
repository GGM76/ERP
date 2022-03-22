package Controlador;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;



public class conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/erp?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String CLAVE = "root";
    Connection con = null;
    
    
    public Connection getConexion(){    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            //System.out.println("Conexion exitosa");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    public void desconectar(){
        try {
            con.close();
            con=null;
            } catch (SQLException e) {
            e.printStackTrace();
            }
    }
    
}
