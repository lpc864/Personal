package backtracking;

public class JobAssignment {
	
	private static int[]solucionMejor;
	private static int rendimientoSolucionMejor;
	private static int[]solucionParcial;
	private static int rendimientoSolucionParcial;
	private static int[]rendimientoEstimadoNivelI;
	private static boolean[]tareaAsignada;
	
	public static void estimacionMejorRama(int[][]rendimiento, int numeroPersonas_Tareas, int[]rendimientoEstimadoNivelI) {
		//El problema representa un arbol en el que cada nivel representa a una persona
		//En cada nivel se tienen tantos nodos como trabajos se tengan
		//Se busca la rama de mayor rendimiento (aun cuando esta esquematicamente no tenga sentido)
		int[] mejorSolucionEstimada = new int[numeroPersonas_Tareas];
		for (int i = 0; i < numeroPersonas_Tareas; i++) {
			mejorSolucionEstimada[i] = rendimiento[i][0];
			for (int j = 1; j < numeroPersonas_Tareas; j++) {
				if (mejorSolucionEstimada[i] < rendimiento[i][j]) {
					mejorSolucionEstimada[i] = rendimiento[i][j];
				}
			}
		}
		
		for (int i = 0; i < numeroPersonas_Tareas; i++) {
			rendimientoEstimadoNivelI[i] = 0;
		}
		
		//Una vez encontrada la rama, se pretende poder determinar sobre cada nivel, el rendimiento que se espera a partir de esta
		//Como resultado, me encuentro en el nivel i, el rendimiento que espero obtener a partir de él se encuentra en el nivel siguiente
		//En concreto, rendimientoEstimadoNivel[i+1] es un valor acumulativo, mientras que mejorSolucionEstima es el valor del nodo del nivel siguiente
		for (int i = numeroPersonas_Tareas - 2; i >= 0; i--) {
			rendimientoEstimadoNivelI[i] = rendimientoEstimadoNivelI[i + 1] + mejorSolucionEstimada[i + 1];
		}
		
		
	}
	
	private static void jobAssignment (int[][]rendimiento, int numeroPersonas, int persona) {
		if (persona == numeroPersonas) {
				System.out.print("Solucion generada: ");
				for (int i = 0; i < numeroPersonas; i++) {
					System.out.print(solucionParcial[i]);
					solucionMejor[i] = solucionParcial[i];
				}
				System.out.println();
				rendimientoSolucionMejor = rendimientoSolucionParcial;
		} 
		else {
			//La intencion de este bucle es asignar una de las tareas a una persona
			for (int tarea = 0; tarea < numeroPersonas; tarea++) {
				if (!tareaAsignada[tarea]) {
					solucionParcial[persona] = tarea;
					tareaAsignada[tarea] = true;;
					rendimientoSolucionParcial +=  rendimiento[persona][solucionParcial[persona]];
					int rendimientoEstimado = rendimientoSolucionParcial + rendimientoEstimadoNivelI[persona];
					if (rendimientoEstimado > rendimientoSolucionMejor) {
						jobAssignment(rendimiento, numeroPersonas, persona + 1);
					}
					tareaAsignada[tarea] = false;
					rendimientoSolucionParcial -= rendimiento[persona][solucionParcial[persona]];
				}
			}
		}
		
	}
	
	public static void jobAssignment (int[][]rendimiento) {
		//Nos basamos en una matriz nxn. Por dicha razon, la distincion entre filas y columnas es indiferente (numeroPersonas_Tareas = numero personas-tarea)
		int numeroPersonas_Tareas = rendimiento.length;
		solucionMejor = new int[numeroPersonas_Tareas];
		rendimientoSolucionMejor = -1;
		solucionParcial = new int[numeroPersonas_Tareas];
		rendimientoSolucionParcial = 0;
		rendimientoEstimadoNivelI = new int[numeroPersonas_Tareas];
		tareaAsignada = new boolean[numeroPersonas_Tareas];
		
		for (int i = 0; i < numeroPersonas_Tareas; i++) {
			solucionMejor[i] = -1;
			solucionParcial[i] = -1;
			tareaAsignada[i] = false;
		}
		
		estimacionMejorRama(rendimiento, numeroPersonas_Tareas, rendimientoEstimadoNivelI);
		
		jobAssignment(rendimiento, numeroPersonas_Tareas,  0);
		
		System.out.println("\nSolucion definitoria");
		System.out.println("----------------------");
		for (int i = 0; i < numeroPersonas_Tareas; i++) {
			System.out.println("Persona: " + (i) + ", Tarea: " + solucionMejor[i] + ", Rendimiento: " + rendimiento[i][solucionMejor[i]]);
		}
		System.out.println("\nRendimiento total: " + rendimientoSolucionMejor);
		
	}
	
	public static void main (String[] args) {
		int [][] B1 = {
			      { 4, 9, 1 },
				  { 7, 2, 3 },
				  { 6, 3, 5 }};
		
		
		int [][] B2 = {
		        	  {9, 2, 7, 8},
		 		      {6, 4, 3, 7},
					  {5, 8, 1, 8},
					  {7, 6, 9, 4}};
		
		int [][] B3 = {
				  { 90,  75,  70,   80},
			   	  { 30,  85,  55,   65},
				  {125,  95,  90,  105},
				  { 45, 110,  95,  115},
								      };
		
		jobAssignment(B2);
		
	}
}
