package Controlador;


import erpBD.Categoria;
import erpBD.Productos;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class llenarDatos {
    
    private conexion conectar;
    private Categoria cat;
    private Connection con;
    private Productos prod;
    
    public ArrayList<Categoria> LlenaCombo(){
    conectar = new conexion();
    ArrayList categorias=new ArrayList<>(); 
    PreparedStatement statement=null;
    ResultSet result=null; 
    String SSQL = "SELECT nombre FROM categorias ORDER BY nombre ASC";
    con = conectar.getConexion();
    
    try {
        if (con!=null) {
            statement=con.prepareStatement(SSQL);    
            result=statement.executeQuery();
        while(result.next()){
            categorias.add(result.getString(1));
        }
        conectar.desconectar();}
    } catch (SQLException e) {
        System.out.println("Error en la consulta"+e.getMessage());
        }
    return categorias;
    }
    
    public ArrayList<Productos> LlenarTablaadminProd() throws IOException{
    conectar = new conexion();
    ArrayList<Productos> listaprod=new ArrayList<Productos>(); 
    PreparedStatement statement=null;
    ResultSet result=null; 
    String SSQL = "SELECT * FROM Productos ORDER BY nombre ASC";
    Productos product=new Productos();
    con = conectar.getConexion();
    
    try {
        if (con!=null) {
            statement=con.prepareStatement(SSQL);    
            result=statement.executeQuery();
        while(result.next()){
//            Blob blob = result.getBlob("imagen");
//            byte[] data = blob.getBytes(1, (int)blob.length());
//            BufferedImage img = null;
//            img = ImageIO.read(new ByteArrayInputStream(data));
//            ImageIcon icon = new ImageIcon(img);
            product=new Productos(result.getString("SKU"),result.getInt("idcategoria"),result.getString("nombre"),result.getInt("stock"),result.getString("estado"),result.getBlob("imagen"));
//            product.setSKU(result.getString("SKU"));
//            product.setId(result.getInt("idcategoria"));
//            product.setNombre(result.getString("nombre"));
//            product.setStock(result.getInt("stock"));
//            product.setEstado(result.getString("estado"));
            //product.setImagen(icon);
            //product.setImagen(result.getBlob("imagen"));
            listaprod.add(product);
        }}
    } catch (SQLException e) {
        System.out.println("Error en la consulta "+e.getMessage());
        }
    return listaprod;
    
    }
     
}
