package Controlador;

import erpBD.Categoria;
import erpBD.Productos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;



public class controlDatos {

    private conexion conectar;
    private Categoria cat;
    private Productos prod;
    private Connection con;
    
    
public controlDatos(){
   conectar = new conexion();
   cat = new Categoria();
   prod = new Productos();
}

public void insertarCategoria(String nombre){
    PreparedStatement ps;
    String sql;
    cat.setCategoria(nombre);
    
    try{
        con = conectar.getConexion();
        sql="insert into Categorias(nombre) values(?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, cat.getCategoria());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Se ha logrado insertar la categoria");
        conectar.desconectar();
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
    }

}

public void insertarProducto(String sku,int idcategoria,String nombre, int stock, String estado, String ruta) throws FileNotFoundException{
        File archivofoto = new File(ruta);
        PreparedStatement ps;
        String sql;
        prod.setSKU(sku);
        prod.setNombre(nombre);
        prod.setStock(stock);
        prod.setEstado(estado);
        prod.setRuta(ruta);
        prod.setId(idcategoria);
        System.out.println("Setearon los datos");
                
        try{
            FileInputStream convertir_imagen = new FileInputStream (archivofoto);
            con = conectar.getConexion();
            sql = "insert into Productos(SKU, idcategoria , nombre , stock, estado, imagen) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getSKU());
            ps.setInt(2, prod.getId());
            ps.setString(3, prod.getNombre());
            ps.setInt(4, prod.getStock());
            ps.setString(5, prod.getEstado());
            //ps.setString(6, prod.getImagen());
            ps.setBlob(6, convertir_imagen, archivofoto.length());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha logrado insertar el producto");
            conectar.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        
    }    



    
}
