package coopEmily;

import java.util.TreeMap;
import java.util.Map.Entry;

public class EmpresaLogistica implements Comparable<EmpresaLogistica> {
	private int id;
	private String nombreEmpresa;
	private TreeMap<String, TreeMap<String, Double>> provinciasPrecioKilometro;
	
	public EmpresaLogistica(String nombreEmpresa, TreeMap<String, TreeMap<String, Double>> provinciasPrecioKilometro) {
		this.id = ((int) (Math.random() * 10000 + 1));
		this.nombreEmpresa = nombreEmpresa;
		this.provinciasPrecioKilometro = provinciasPrecioKilometro;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setProvinciasPrecioKilometro(TreeMap<String, TreeMap<String, Double>> provinciasPrecioKilometro) {
		this.provinciasPrecioKilometro = provinciasPrecioKilometro;
	}
	
	public TreeMap<String, TreeMap<String, Double>> getProvinciasPrecioKilometro() {
		return provinciasPrecioKilometro;
	}

	@Override
	public int compareTo(EmpresaLogistica other) {
		int compare = this.nombreEmpresa.compareTo(other.nombreEmpresa);
		if (compare != 0) {
			return compare;
		}
		compare = Integer.compare(this.id, other.id);
		return compare;
	}
	
	public void mostraConsola() {
		int contador = 1;
		String tipoLogistica;
		System.out.println("ID: " + this.id);
		System.out.println("Empresa logistica: " + this.nombreEmpresa);
		System.out.println("Precio por kilometro por provincia: ");
		for (Entry<String, TreeMap<String, Double>> provinciasPrecioKilometro : this.provinciasPrecioKilometro.entrySet()) {
			System.out.print(contador++ + "- " + provinciasPrecioKilometro.getKey() + ": ");
			for (Entry<String, Double> precioKilometro : provinciasPrecioKilometro.getValue().entrySet()) {
				tipoLogistica = precioKilometro.getKey();
				if (tipoLogistica.equals("logisticagrande")) {
					System.out.print("logistica grande (" + precioKilometro.getValue() + " euros), ");
				}
				else {
					System.out.println("logistica pequena (" + precioKilometro.getValue() + " euros)");
				}
			}
		}
	}
}
