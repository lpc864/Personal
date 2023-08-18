package coopEmily;

public class CantidadHectarias {
	private double cantidad;
	private double hectarias;
	
	public CantidadHectarias(double cantidad, double hectarias) {
		this.cantidad = cantidad;
		this.hectarias = hectarias;
	}

	public void setHectarias(double hectarias) {
		this.hectarias = hectarias;
	}
	
	public double getHectarias() {
		return hectarias;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
}
