package coopEmily;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Productor implements Comparable<Productor>{

	private int id;
	private String nombre;
	private String apellido;
	private TreeMap<Producto, Double> productoExtension;
	private double extensionTotal;
	private boolean esProductorPequeno;
	private boolean existeCambio;

	/**
	 * Constructor para la clase Productor. 
	 * 
	 * El id se define arbitrareamente dentro del rango de [0, 10000]
	 * 
	 * @param nombre            El nombre del productor.
	 * @param apellido          El apellido del productor.
	 * @param productoExtension La estructura de datos que permite definir la
	 *                          extensión de tierra que un productor tiene destinada
	 *                          a un producto.
	 */

	public Productor(String nombre, String apellido, TreeMap<Producto, Double> productoExtension) {
		this.id = (int) (Math.random() * 10000 + 1);
		this.nombre = nombre;
		this.apellido = apellido;
		this.productoExtension = productoExtension;
		for (Double extension : productoExtension.values()) this.extensionTotal += extension;
		this.esProductorPequeno = true;
		existeCambio = false;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setProductoExtension(TreeMap<Producto, Double> productoExtension) {
		this.productoExtension = productoExtension;
		this.existeCambio = true;
	}

	public TreeMap<Producto, Double> getProductoExtension() {
		return productoExtension;
	}

	public double getExtensionTotal() {

		if (!existeCambio) {
			return this.extensionTotal;
		} else {
			this.extensionTotal = 0;

			for (Double extension : productoExtension.values()) {
				this.extensionTotal += extension;
			}
			return this.extensionTotal;
		}

	}

	public void setEsProductorPequeno(double hectariaAnoFiscal) {
		this.esProductorPequeno = (this.extensionTotal <= hectariaAnoFiscal) ? true : false;
	}
	
	public boolean getEsProductorPequeno() {
		return this.esProductorPequeno;
	}
	
	public void setExisteCambio(boolean existeCambio) {
		this.existeCambio = existeCambio;
	}

	public boolean existeCambio() {
		return existeCambio;
	}
	
	public void mostrarSalida() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellido: " + this.apellido);
		String productos = "Productos: ";
		int numeroProductos = this.productoExtension.keySet().size() - 1;
		int contador = 0;
		for(Entry<Producto, Double> producto : this.productoExtension.entrySet()) {
			if (contador != numeroProductos) {
				productos += producto.getKey().getNombre() + " (" + producto.getValue() + " ha), ";
			} else {
				productos += producto.getKey().getNombre() + " (" + producto.getValue() + " ha) ";
			}
			contador++;
		}
		System.out.println(productos);
		System.out.printf("Extension total: %.3f ha\n", this.extensionTotal);
		String tipoDeProductor = "Tipo de productor: ";
		if (this.getEsProductorPequeno()) {
			tipoDeProductor += "pequeno";
		} else {
			tipoDeProductor += "grande";
		}
		System.out.println(tipoDeProductor);
	}
	
	@Override
	public int compareTo(Productor other) {
		int compare = this.nombre.compareTo(other.nombre);
		if (compare != 0) {
			return compare;
		}
		compare = this.apellido.compareTo(other.apellido);
		if (compare != 0) {
			return compare;
		}
		compare = Integer.compare(this.id, other.id);
		return compare;
	}
	
}
