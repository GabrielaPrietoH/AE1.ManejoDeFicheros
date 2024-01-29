package es.cristian.modelo.entidad;

import java.io.Serializable;

public class Articulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7428757527789268930L;
	
	
	private String nombre, descripcion;
	private int id;
	private double stock, precio;
	
	public Articulo (int id, String nombre, String descripcion, double stock, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}
	public Articulo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int contador) {
		this.id = contador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precio=" + precio + "]";
	}
	
	

}
