package coopEmily;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class Producto implements Comparable<Producto> {
	
	private int id;
	private String nombre;
	private double rendimiento;
	private double valorReferencia;
	private double precioDistribuidor;
	private double precioConsumidorFinal;
	private boolean esPerecedero;
	private LocalDateTime now;
	private DateTimeFormatter formatter;
	private String fecha;
	private TreeMap<String, Double> evolucionValorReferencia;
	
	private static final String formato = "yyyy-MM-dd HH:mm:ss";
	
	public Producto (String nombre, double rendimiento, double valorReferencia, boolean esPerecedero) {
		this.id = (((int) (Math.random() * 10000 + 1)));
		this.nombre = nombre;
		this.rendimiento = rendimiento;
		this.valorReferencia = valorReferencia;
		this.precioDistribuidor = this.valorReferencia * 1.05;
		this.precioConsumidorFinal = this.valorReferencia * 1.15;
		this.esPerecedero = esPerecedero;
		this.evolucionValorReferencia = new TreeMap<>();
		now = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern(formato);
		fecha = now.format(formatter);
		this.evolucionValorReferencia.put(fecha, valorReferencia);
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setRendimiento(double rendimiento) {
		this.rendimiento = rendimiento;
	}
	
	public double getRendimiento() {
		return rendimiento;
	}
	
	public void setValorReferencia(double valorReferencia) {
		this.valorReferencia = valorReferencia;
		this.precioDistribuidor = this.valorReferencia * 1.05;
		this.precioConsumidorFinal = this.valorReferencia * 1.15;
		now = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern(formato);
		fecha = now.format(formatter);
		this.evolucionValorReferencia.put(fecha, valorReferencia);
	}
	
	public double getValorReferencia() {
		return valorReferencia;
	}
	
	public double getPrecioDistribuidor() {
		return precioDistribuidor;
	}
	
	public double getPrecioConsumidorFinal() {
		return precioConsumidorFinal;
	}
	
	public void setEsPerecedero(boolean esPerecedero) {
		this.esPerecedero = esPerecedero;
	}
	
	public boolean getEsPerecedero() {
		return this.esPerecedero;
	}
	
	public TreeMap<String, Double> getEvolucionValorReferencia() {
		return evolucionValorReferencia;
	}

	public void mostrarSalida() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre: " + this.nombre);
		System.out.printf("Rendimiento: %.3f toneladas/hectaria\n", this.rendimiento);
		System.out.printf("Valor de referencia: %.3f euros\n", this.valorReferencia);
		System.out.printf("Valor de venta para el distribuidor: %.3f euros\n", this.precioDistribuidor);
		System.out.printf("Valor de venta para el consumidor final: %.3f euros\n", this.precioConsumidorFinal);
		String tipoDeProducto = "Tipo de producto: ";
		if (this.getEsPerecedero()) {
			tipoDeProducto += "perecedero";
		} else {
			tipoDeProducto += "no perecedero";
		}
		System.out.println(tipoDeProducto);
	}
	
	@Override
	public int compareTo(Producto other) {
		int compare = this.nombre.compareTo(other.nombre);
		if (compare != 0) {
			return compare;
		}
		compare = Integer.compare(this.id, other.id);
		return compare;
	}
}
