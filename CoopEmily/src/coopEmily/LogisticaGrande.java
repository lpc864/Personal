package coopEmily;

public class LogisticaGrande extends Logistica {
	private int numeroTramos;
	private int numeroTrayectos;
	private double precioTramo;
	private int numeroToneladas;
	private double precio;
	
	public LogisticaGrande(double cantidad, Producto producto, double distancia, double precioKilometro) {
		super(cantidad, producto, distancia, precioKilometro);
		
		//Determinamos el numero de tramos en el que el trayecto se dividira
		if (producto.getEsPerecedero()) {
			this.numeroTramos = 1;
		}
		else {
			this.numeroTramos = (int) (this.distancia / 50);
		}
		
		//Determinamos el precio de la logistica
		//Si la cantidad comprada es inferior a una tonelada, solo se necesitara un trayecto
		//Caso contrario se necesitaran mas de un trayecto
		if (this.cantidad < 1000) {
			//Determinamos el precio del tramo
			this.precioTramo = (0.5 * producto.getValorReferencia() * this.cantidad) * this.numeroTramos;
			//Determinamos el precio (precio del trayecto)
			this.precio = this.precioTramo + this.precioDistancia;
		}
		else {
			//Determinamos el numero de toneladas a partir de la cual determinamos el precio del tramo para transportar una tonelada X veces
			this.numeroToneladas = (int) (this.cantidad / 1000);
			this.precioTramo = ((0.5 * producto.getValorReferencia() * 1000) * this.numeroTramos) * this.numeroToneladas;
			double cantidadLeft = this.cantidad - (1000 * this.numeroToneladas);
			//Si quedase cantidad restante habria que contabilizarlo
			if (cantidadLeft != 0) {
				this.precioTramo *= ((0.5 * producto.getValorReferencia() * cantidadLeft) * this.numeroTramos);
			}
			//Determinamos el precio (precio del trayecto)
			this.precio = this.precioTramo + (this.precioDistancia * this.numeroToneladas);
		}
	}

	public void setPrecioTramo(double precioTramo) {
		this.precioTramo = precioTramo;
	}
	
	public double getPrecioTramo() {
		return precioTramo;
	}

	public void setNumeroTrayectos(int numeroTrayectos) {
		this.numeroTrayectos = numeroTrayectos;
	}
	
	public int getNumeroTrayectos() {
		return numeroTrayectos;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
}
