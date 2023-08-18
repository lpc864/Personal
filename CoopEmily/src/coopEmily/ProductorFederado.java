package coopEmily;

import java.util.ArrayList;

public class ProductorFederado implements Comparable<ProductorFederado>{

	private int id;
	private String nombre;
	private ArrayList<Productor> productores;
	private Producto producto;
	private double extensionTotal;
	private boolean esProductorPequeno;
	private boolean existeCambio;

	/**
	 * Constructor para la clase ProductorFederado.
	 * 
	 * El id se define arbitrareamente dentro del rango de [0, 10000].
	 * 
	 * @param productores Una lista de productores que forman parte del productor
	 *                    federado.
	 * @param producto    El producto que comercializa el productor federado.
	 */

	public ProductorFederado(ArrayList<Productor> productores, Producto producto) {
		this.id = (int) (Math.random() * 10000 + 1);
		this.nombre = "Productor federado de " + producto.getNombre();
		this.productores = productores;
		this.producto = producto;
		for (Productor productor : productores) {
			if (!productor.getEsProductorPequeno()) {
				throw new RuntimeException("¡ERROR! Existe un productor grande: /n/n" + "ID: " + productor.getId()
						+ "Nombre: " + productor.getNombre() + "Apellido: " + productor.getApellido());
			}

			if (!productor.getProductoExtension().keySet().contains(producto)) {
				throw new RuntimeException("¡ERROR! Existe un productor que no comercializa el producto indicado: /n/n"
						+ "ID: " + productor.getId() + "Nombre: " + productor.getNombre() + "Apellido: "
						+ productor.getApellido());
			}
			this.extensionTotal += productor.getProductoExtension().get(producto);
		}
		this.esProductorPequeno = true;

		this.existeCambio = false;
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

	public void setProductores(ArrayList<Productor> productores) {
		this.productores = productores;
		for (Productor productor : productores) {
			if (!productor.getEsProductorPequeno()) {
				throw new RuntimeException("¡ERROR! Existe un productor grande: /n/n" + "ID: " + productor.getId()
						+ "Nombre: " + productor.getNombre() + "Apellido: " + productor.getApellido());
			}

			if (!productor.getProductoExtension().keySet().contains(producto)) {
				throw new RuntimeException("¡ERROR! Existe un productor que no comercializa el producto indicado: /n/n"
						+ "ID: " + productor.getId() + "Nombre: " + productor.getNombre() + "Apellido: "
						+ productor.getApellido());
			}
			this.extensionTotal += productor.getProductoExtension().get(producto);
		}
		// this.existeCambio = true; No hace falta. Si pongo a true, se recalculafia
		// abajo. Con esta variable mi intencion es controlar esto
	}

	public ArrayList<Productor> getProductores() {
		return productores;
	}

	public Producto getProducto() {
		return producto;
	}

	/**
	 * Obtiene el valor del campo extensionTotal. Si el valor del campo existeCambio
	 * es verdadero, recalcula el valor del campo extensionTotal.
	 * 
	 * @return El valor del campo extensionTotal.
	 */

	public double getExtensionTotal() {
		if (!existeCambio) {
			return this.extensionTotal;
		} else {
			this.extensionTotal = 0;
			for (Productor productor : productores) {
				if (!productor.getEsProductorPequeno()) {
					throw new RuntimeException("¡ERROR! Existe un productor grande: /n/n" + "ID: " + productor.getId()
							+ "Nombre: " + productor.getNombre() + "Apellido: " + productor.getApellido());
				}

				if (!productor.getProductoExtension().keySet().contains(producto)) {
					throw new RuntimeException(
							"¡ERROR! Existe un productor que no comercializa el producto indicado: /n/n" + "ID: "
									+ productor.getId() + "Nombre: " + productor.getNombre() + "Apellido: "
									+ productor.getApellido());
				}
				this.extensionTotal += productor.getProductoExtension().get(producto);
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
	
	public void agregarProductor(Productor productor) {
		if (!productor.getEsProductorPequeno()) {
			throw new RuntimeException("¡ERROR! Existe un productor grande: /n/n" + "ID: " + productor.getId()
					+ "Nombre: " + productor.getNombre() + "Apellido: " + productor.getApellido());
		}

		if (!productor.getProductoExtension().keySet().contains(producto)) {
			throw new RuntimeException("¡ERROR! Existe un productor que no comercializa el producto indicado: /n/n"
					+ "ID: " + productor.getId() + "Nombre: " + productor.getNombre() + "Apellido: "
					+ productor.getApellido());
		}
		this.productores.add(productor);
		this.extensionTotal += productor.getProductoExtension().get(producto);
		
	}
	
	public void mostrarSalida() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre: " + this.nombre);
		String productores = "Productores: ";
		int numeroProductores = this.productores.size() - 1;
		int contador = 0;
		for (Productor productor : this.productores) {
			if (contador != numeroProductores) {
				productores += productor.getNombre() + " " + productor.getApellido() + ", ";
			} else {
				productores += productor.getNombre() + " " + productor.getApellido();
			}
			contador++;
		}
		System.out.println(productores);
		System.out.println("Producto: " + this.producto.getNombre());
		System.out.printf("Extension total: %.1f ha\n", this.extensionTotal);
	}

	@Override
	public int compareTo(ProductorFederado other) {
		int compare = this.nombre.compareTo(other.nombre);
		if (compare != 0) {
			return compare;
		}
		compare = Integer.compare(this.id, other.id);
		return compare;
	}

}
