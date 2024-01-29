package ficheros_almacen_artículos;

import java.io.Serializable;

public class Artículo implements Serializable{
	
	private static final long serialVersionUID = -4213427856846111419L;
	
	    
	    private int id;
	    private String nombre;
	    private String descripcion;
	    private int stock;
	    private double precio;

	 
		
	    public Artículo(int id, String nombre, String descripcion, int stock, double precio) {
	        this.id = id;
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.stock = stock;
	        this.precio = precio;
	    }

	   
	    public int getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public int getStock() {
	        return stock;
	    }

	    public double getPrecio() {
	        return precio;
	    }


	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public void setStock(int stock) {
	        this.stock = stock;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	   
	    @Override
	    public String toString() {
	        return "Articulo{" +
	                "id=" + id +
	                ", nombre='" + nombre + '\'' +
	                ", descripcion='" + descripcion + '\'' +
	                ", stock=" + stock +
	                ", precio=" + precio +
	                '}';
	    }
	}