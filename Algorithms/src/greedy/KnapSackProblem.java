package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KnapSackProblem {
	
	private static class ObjetoNumerable {
		private int cantidadDisponible;
		private String nombre;
		private int valor;
		private int peso;
		
		public ObjetoNumerable (int cantidadDisponible, String nombre, int valor, int peso) {
			this.cantidadDisponible = cantidadDisponible;
			this.nombre = nombre;
			this.valor = valor;
			this.peso = peso;
		}
	}
	
	private static class Objeto {
		private String nombre;
		private int valor;
		private int peso;
		
		public Objeto (String nombre, int valor, int peso) {
			this.nombre = nombre;
			this.valor = valor;
			this.peso = peso;
		}
	}
	
	private static class comparadorObjetoNumerable implements Comparator<ObjetoNumerable> {
		@Override
		public int compare(ObjetoNumerable obj1, ObjetoNumerable obj2) {
			double beneficioObj1 = (double)obj1.valor / (double)obj1.peso;
			double beneficioObj2 = (double)obj2.valor / (double)obj2.peso;
			if (beneficioObj1 < beneficioObj2) {
				return 1;
			} else if (beneficioObj1 > beneficioObj2) {
				return -1;
			} else {
				return Integer.compare(obj1.valor, obj2.valor);
			}
		}
	}
	
	private static class comparadorObjeto implements Comparator<Objeto> {
		@Override
		public int compare(Objeto obj1, Objeto obj2) {
			double beneficioObj1 = (double)obj1.valor / (double)obj1.peso;
			double beneficioObj2 = (double)obj2.valor / (double)obj2.peso;
			if (beneficioObj1 < beneficioObj2) {
				return 1;
			} else if (beneficioObj1 > beneficioObj2) {
				return -1;
			} else {
				return Integer.compare(obj1.valor, obj2.valor);
			}
		}
	}
	
     	public static void NumerablefractionalKnapSackProblem(ArrayList<ObjetoNumerable> mochila, int capacidadMochila, ObjetoNumerable[] objetos) {
     		ObjetoNumerable[] objetosCopy = new ObjetoNumerable[objetos.length];
    		for (int i = 0; i < objetos.length; i++) {
    			objetosCopy[i] = new ObjetoNumerable(objetos[i].cantidadDisponible, objetos[i].nombre, objetos[i].valor, objetos[i].peso);
    		}
    		
     		int valorMochila = 0;
    		double cantidadIngresadaMochilaObjetoX = 0;
    		int iterador = 0;
    		
    		Arrays.sort(objetosCopy, new comparadorObjetoNumerable());
    		
    		System.out.println("En la mochila se han metido los objetos siguientes: \n");
    		
    		while(capacidadMochila > 0 && iterador != objetosCopy.length) {
    			ObjetoNumerable objeto = objetosCopy[iterador];
    			if (objeto.peso <= capacidadMochila && objeto.cantidadDisponible != 0) {
    				mochila.add(objeto);
    				valorMochila += objeto.valor;
    				capacidadMochila -= objeto.peso;
    				cantidadIngresadaMochilaObjetoX++;
    				objeto.cantidadDisponible--;
    				if (objeto.cantidadDisponible == 0 || capacidadMochila == 0) {
    					System.out.println((iterador+1) + ". Objeto: " + objeto.nombre + ", Valor: " + objeto.valor + ", Peso: " + objeto.peso + ", Cantidad Ingresada: " + cantidadIngresadaMochilaObjetoX);
    					continue;
    				}
    				if (objeto.cantidadDisponible != 0 && objeto.peso > capacidadMochila) {
    					double porcentaje = (double) capacidadMochila / objeto.peso; 
        				int valorFraccionado = (int) (objeto.valor * porcentaje);
        				int pesoFraccionado = (int) (objeto.peso * porcentaje);
        				cantidadIngresadaMochilaObjetoX+=porcentaje;
        				objeto.cantidadDisponible-=porcentaje;
        				ObjetoNumerable objetoFraccionado = new ObjetoNumerable(objeto.cantidadDisponible, objeto.nombre, valorFraccionado, pesoFraccionado);
        				mochila.add(objetoFraccionado);
        				valorMochila += objetoFraccionado.valor;
        				capacidadMochila -= objetoFraccionado.peso;
        				System.out.println((iterador+1) + ". Objeto: " + objeto.nombre + ", Valor: " + objeto.valor + ", Peso: " + objeto.peso + ", Cantidad Ingresada: " + cantidadIngresadaMochilaObjetoX);
        				continue;
    				}
    				continue;
    			}
    			cantidadIngresadaMochilaObjetoX = 0;
    			iterador++;
    		}
    		
    		System.out.println("\nEl valor de la mochila es de " + valorMochila);
	}
	
	public static void NumerableknapSackProblem(ArrayList<ObjetoNumerable> mochila, int capacidadMochila, ObjetoNumerable[] objetos) {
		ObjetoNumerable[] objetosCopy = new ObjetoNumerable[objetos.length];
		for (int i = 0; i < objetos.length; i++) {
			objetosCopy[i] = new ObjetoNumerable(objetos[i].cantidadDisponible, objetos[i].nombre, objetos[i].valor, objetos[i].peso);
		}
		
		int valorMochila = 0;
		int cantidadIngresadaMochilaObjetoX = 0;
		int iterador = 0;
		
		Arrays.sort(objetosCopy, new comparadorObjetoNumerable());
		
		System.out.println("En la mochila se han metido los objetos siguientes: \n");
		
		while(capacidadMochila > 0 && iterador != objetosCopy.length) {
			ObjetoNumerable objeto = objetosCopy[iterador];
			if (objeto.peso <= capacidadMochila && objeto.cantidadDisponible != 0) {
				mochila.add(objeto);
				valorMochila += objeto.valor;
				capacidadMochila -= objeto.peso;
				cantidadIngresadaMochilaObjetoX++;
				objeto.cantidadDisponible--;
				if (objeto.cantidadDisponible == 0 || capacidadMochila == 0 || objeto.peso > capacidadMochila) {
					System.out.println((iterador+1) + ". Objeto: " + objeto.nombre + ", Valor: " + objeto.valor + ", Peso: " + objeto.peso + ", Cantidad Ingresada: " + cantidadIngresadaMochilaObjetoX);
				}
				continue;
			}
			cantidadIngresadaMochilaObjetoX = 0;
			iterador++;
		}
		
		System.out.println("\nEl valor de la mochila es de " + valorMochila);
		
	}
	
	public static void fractionalKnapSackProblem(ArrayList<Objeto> mochila, int capacidadMochila, Objeto[] objetos) {
		int valorMochila = 0;
		int iterador = 0;
		
		Arrays.sort(objetos, new comparadorObjeto());
		
		System.out.println("En la mochila se han metido los objetos siguientes: \n");
		
		while (capacidadMochila > 0 && iterador != objetos.length) {
			Objeto objeto = objetos[iterador];
			if (objeto.peso <= capacidadMochila) {
				mochila.add(objeto);
				valorMochila += objeto.valor;
				capacidadMochila -= objeto.peso;
				System.out.println((iterador+1) + ". Objeto: " + objeto.nombre + ", Valor: " + objeto.valor + ", Peso: " + objeto.peso);
				} else {
				double porcentaje = (double) capacidadMochila / objeto.peso; 
				int valorFraccionado = (int) (objeto.valor * porcentaje);
				int pesoFraccionado = (int) (objeto.peso * porcentaje);
				Objeto objetoFraccionado = new Objeto(objeto.nombre, valorFraccionado, pesoFraccionado);
				mochila.add(objetoFraccionado);
				valorMochila += objetoFraccionado.valor;
				capacidadMochila -= objetoFraccionado.peso;
				System.out.println((iterador+1) + ". Objeto: " + objetoFraccionado.nombre + ", Valor: " + objetoFraccionado.valor + ", Peso: " + objetoFraccionado.peso);
			}
			iterador++;
		}
		
		System.out.println("\nEl valor de la mochila es de " + valorMochila);
	}
	
	public static void knapSackProblem(ArrayList<Objeto> mochila, int capacidadMochila, Objeto[] objetos) {
		int valorMochila = 0;
		int iterador = 0;
		
		Arrays.sort(objetos, new comparadorObjeto());
		
		System.out.println("En la mochila se han metido los objetos siguientes: \n");
		
		while(capacidadMochila > 0 && iterador != objetos.length) {
			Objeto objeto = objetos[iterador];
			if (objeto.peso <= capacidadMochila) {
				mochila.add(objeto);
				valorMochila += objeto.valor;
				capacidadMochila -= objeto.peso;
				System.out.println((iterador+1) + ". Objeto: " + objeto.nombre + ", Valor: " + objeto.valor + ", Peso: " + objeto.peso);
			}
			iterador++;
		}
		
		System.out.println("\nEl valor de la mochila es de " + valorMochila);
		
	}
	
	public static void main (String[] args) {
		ArrayList<Objeto> mochila = new ArrayList<Objeto>();
		int capacidadMochila = 50;
		
		Objeto[] objetos = { new Objeto("Mouse", 60, 10),
							 new Objeto("Camiseta Madrid", 100, 20),
							 new Objeto("Movil", 150, 30) };
		
		ArrayList<ObjetoNumerable> mochilaNumerable = new ArrayList<ObjetoNumerable>();
		
		ObjetoNumerable[] objetosNumerable = { new ObjetoNumerable(3, "Mouse", 60, 10),
											   new ObjetoNumerable(2, "Camiseta Madrid", 100, 20),
											   new ObjetoNumerable(5, "Movil", 150, 30) };
		int capacidadMochilaNumerable = 60;

     
		
		System.out.println("KnapSackProblem 0/1");
		System.out.println("--------------------");
		System.out.println();
        knapSackProblem(mochila, capacidadMochila, objetos);
        
        System.out.println("\nKnapSackProblem 0-1");
		System.out.println("---------------------");
		System.out.println();
        fractionalKnapSackProblem(mochila, capacidadMochila, objetos);
        
    	System.out.println("\nNumerableKnapSackProblem 0/1");
		System.out.println("------------------------------");
		System.out.println();
		NumerableknapSackProblem(mochilaNumerable, capacidadMochilaNumerable, objetosNumerable);
		
		System.out.println("\nNumerableKnapSackProblem 0-1");
		System.out.println("------------------------------");
		System.out.println();
		NumerablefractionalKnapSackProblem(mochilaNumerable, capacidadMochilaNumerable, objetosNumerable);
	}
}
