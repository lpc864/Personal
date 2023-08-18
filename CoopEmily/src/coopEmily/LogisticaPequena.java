package coopEmily;

public class LogisticaPequena extends Logistica {
	private double precio;

	public LogisticaPequena(double cantidad, Producto producto, double distancia, double precioKilometro) {
		super(cantidad, producto, distancia, precioKilometro);
		this.precio = cantidad * this.precioDistancia;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}	
}
