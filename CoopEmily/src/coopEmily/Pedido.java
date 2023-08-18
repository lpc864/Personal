package coopEmily;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Pedido implements Comparable<Pedido> {
	private int id;
	private LocalDateTime now;
	private DateTimeFormatter formatter;
	private String fecha;
	private Cliente cliente;
	private EmpresaLogistica empresaLogistica;
	private double cantidadComprada;
	private Producto productoComprado;
	private double factura; 
	
	private static final String formato = "yyyy-MM-dd HH:mm:ss";
	
	public Pedido (Cliente cliente, EmpresaLogistica empresaLogistica, double cantidadComprada, Producto productoComprado, double factura) {
		this.id = (int) (Math.random() * 10000 + 1);
		now = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern(formato);
		fecha = now.format(formatter);
		this.cliente = cliente;
		this.empresaLogistica = empresaLogistica;
		this.cantidadComprada = cantidadComprada;
		this.productoComprado = productoComprado;
		this.factura = factura;
	}

	public void setId (int id) {
		this.id = id;
	}
	
	public int getId () {
		return this.id;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setEmpresaLogistica(EmpresaLogistica empresaLogistica) {
		this.empresaLogistica = empresaLogistica;
	}	
	
	public EmpresaLogistica getEmpresaLogistica() {
		return empresaLogistica;
	}
	
	public void setCantidadComprada(double cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	
	public double getCantidadComprada() {
		return cantidadComprada;
	}

	public void setProductoComprado(Producto productoComprado) {
		this.productoComprado = productoComprado;
	}
	
	public Producto getProductoComprado() {
		return productoComprado;
	}
	
	public void setFactura(double factura) {
		this.factura = factura;
	}
	
	public double getFactura() {
		return factura;
	}

	@Override
	public int compareTo(Pedido other) {
		int compare = this.cliente.getNombre().compareTo(other.cliente.getNombre());
		if (compare != 0) {
			return compare;
		}
		compare = Double.compare(this.factura, other.factura);
		if (compare != 0) {
			return compare;
		} 
		else {
			compare = Integer.compare(this.id, other.id);
			return compare;
		}
	}
	
	public void mostrarConsola() {
		System.out.println("ID: " + this.id);
		System.out.println("Fecha: " + this.fecha);
		this.cliente.mostrarConsolaResumido();
		System.out.println("Empresa de logistica utilizada: " + this.empresaLogistica.getNombreEmpresa());
		System.out.println("Cantidad comprada: " + this.cantidadComprada + " toneladas");
		System.out.println("Producto comprado: " + this.productoComprado.getNombre());
		System.out.println("Importe: " + this.factura + " euros");
	}

}
