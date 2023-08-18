package coopEmily;

public class Logistica {
	protected double cantidad;
	protected Producto producto;;
	protected double distancia;
	protected double precioKilometro;
	protected double precioDistancia;
	
	public Logistica (double cantidad, Producto producto, double distancia, double precioKilometro) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.distancia = distancia;
		this.precioKilometro = precioKilometro;
		this.precioDistancia = distancia * precioKilometro;
	}
	
	public void setCantidad (double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getCantidad () {
		return this.cantidad;
	}
	
	public void setProducto (Producto producto) {
		this.producto = producto;
	}
	 
	public Producto getProducto () {
		return this.producto;
	}
	
	public void setDistancia (double distancia) {
		this.distancia = distancia;
	}
	
	public double getDistancia () {
		return this.distancia;
	}
	
	public void setPrecioKilometro (double precioKilometro) {
		this.precioKilometro = precioKilometro;
	}
	
	public double getPrecioKilometro () {
		return precioKilometro;
	}
	
	public void setPrecioDistancia (double precioDistancia) {
		this.precioDistancia = precioDistancia;
	}
	
	public double getPrecioDistancia () {
		return precioDistancia;
	}
}
