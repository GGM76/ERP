package erpBD;

import java.awt.Image;
import java.sql.Blob;
import javax.swing.ImageIcon;


public class Productos {
    private int idcategoria;
    private String SKU;
    private String nombre;
    private int stock;
    private String estado;
    private Blob imagen;
    private String ruta;

    
       public Productos() {
    }
    
      public Productos(String SKU, int idcategoria, String nombre, int stock, String estado, Blob imagen) {
        this.SKU = SKU;
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.stock = stock;
        this.estado = estado;
        this.imagen = imagen;
    }
    
    
    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getId() {
        return idcategoria;
    }

    public void setId(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
