package coopEmily;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cliente implements Comparable<Cliente>{
	private int id;
	private String nombre;
	private boolean esDistribuidor;
	private String provincia;
	private double distancia;
	private TreeMap<Producto, TreeSet<Pedido>> productosComprados;
	private TreeMap<Producto, Double> productosPrecioVenta;
	
	public Cliente(String nombre, boolean esDistribuidor, String provincia, double distancia) {
		this.id = (int) (Math.random() * 10000 + 1);
		this.nombre = nombre;
		this.esDistribuidor = esDistribuidor;
		this.provincia = provincia;
		this.distancia = distancia;
		this.productosComprados = new TreeMap<>();
		this.productosPrecioVenta = new TreeMap<>();
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

	public void setEsDistribuidor(boolean esDistribuidor) {
		this.esDistribuidor = esDistribuidor;
	}
	
	public boolean isEsDistribuidor() {
		return esDistribuidor;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}	
	
	public double getDistancia() {
		return distancia;
	}

	public void setProductosComprados(TreeMap<Producto, TreeSet<Pedido>> productosComprados) {
		this.productosComprados = productosComprados;
	}
	
	public TreeMap<Producto, TreeSet<Pedido>> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosPrecioVenta(TreeMap<Producto, Double> productosPrecioVenta) {
		this.productosPrecioVenta = productosPrecioVenta;
	}
	
	public TreeMap<Producto, Double> getProductosPrecioVenta() {
		return productosPrecioVenta;
	}
	
	public void registarProductoComprado(Producto producto, Pedido pedido, boolean existeCambioValorReferencia) {
		TreeSet<Pedido> pedidos = this.productosComprados.get(producto);
		if (pedidos == null) {
			pedidos = new TreeSet<>();
		}
		pedidos.add(pedido);
		this.productosComprados.put(producto, pedidos);
		
		double cantidadCompradaKG = pedido.getCantidadComprada() * 1000;
		if (pedidos.size() == 1 || existeCambioValorReferencia) {
			double precioVenta = pedido.getFactura() / cantidadCompradaKG;
			this.productosPrecioVenta.put(producto, precioVenta);
		}
	}
	
	public void mostrarConsola() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre del cliente: " + this.nombre);
		System.out.println("Provincia en la que se encuentra el cliente: " + this.provincia);
		System.out.println("Distancia a la que se encuentra el cliente con respecto a la cooperativa: " + this.distancia);
		String tipoDeCliente = "";
		if (this.esDistribuidor) {
			tipoDeCliente = "distribuidor";
		}
		else {
			tipoDeCliente = "consumidor final";
		}
		System.out.println("Tipo de cliente: " + tipoDeCliente);
		System.out.println("Pedidos generado por producto junto al precio de venta correspondiente al producto: ");
		if (this.productosComprados.size() == 0) {
			System.out.println("El cliente no ha comprado ningun producto");
		}
		else {
			for (Entry<Producto, TreeSet<Pedido>> productoComprado : this.productosComprados.entrySet()) {
				String nombreProducto = productoComprado.getKey().getNombre();
				int pedidosGenerados = productoComprado.getValue().size();
				String salida = "Producto: " + nombreProducto + ", pedidos generados: " + pedidosGenerados + " (id de los pedidos: ";
				int contador = 1;
				for (Pedido pedido : productoComprado.getValue()) {
					if (contador != pedidosGenerados) {
						salida += pedido.getId() + ", ";
					}
					else {
						salida += pedido.getId() + "), precio de venta:  ";
					}
					contador++;
				}
				salida += this.productosPrecioVenta.get(productoComprado.getKey()) + " euros";
				System.out.println(salida);
			}
		}
	}
	
	public void mostrarConsolaResumido() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre del cliente: " + this.nombre);
		System.out.println("Provincia en la que se encuentra el cliente: " + this.provincia);
		System.out.println("Distancia a la que se encuentra el cliente con respecto a la cooperativa: " + this.distancia);
		String tipoDeCliente = "";
		if (this.esDistribuidor) {
			tipoDeCliente = "distribuidor";
		}
		else {
			tipoDeCliente = "consumidor final";
		}
		System.out.println("Tipo de cliente: " + tipoDeCliente);
	}

	@Override
	public int compareTo(Cliente other) {
		int compare = this.nombre.compareTo(other.nombre);
		if (compare != 0) {
			return compare;
		}
		compare = Integer.compare(this.id, other.id);
		return compare;
	}
}
