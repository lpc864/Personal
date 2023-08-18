package coopEmilyPruebas;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import coopEmily.Cliente;
import coopEmily.CooperativaEmpresarial;
import coopEmily.EmpresaLogistica;
import coopEmily.Producto;
import coopEmily.Productor;

public class Cooperativa {
	public static void main (String [] args) {
				
		/*
		 * ------
		 * |NOTA|
		 * ------
		 * 
		 * Unidades:
		 * 
		 * 1. Hectarias (Extension de tierra)
		 * 2. Euros (Precio; no centimos)
		 * 3. Toneladas (cantidad de compra)
		 * 4. Kilometros (distancia de un cliente)
		 * 
		 * Adicional:
		 * 
		 * La salida por consola, de momento, solo será para mostrar lo que haya almacenado en la BD.
		 * Por su parte, la BD se irá construyendo con objetos, colecciones... SE HA DE ESCRIBIR EN CODIGO
		 * 
 		 */
		
		
		
		/*
		 *  -----------------------------------
		 *  |Cooperativa empresarial: coopEmily|
		 *  -----------------------------------
		 *  
		 */
		
		CooperativaEmpresarial coopEmily = new CooperativaEmpresarial("CoopEmily");
		
		
		/**
		 * 
		 * ------------------------
		 * |Hectaria de año fiscal|
		 * ------------------------
		 * 
		 */
		
		
		//coopEmily.setHectariaAnoFiscal(5);
		
		/*
		 *  -----------
		 *  |Productos|
		 *  -----------
		 *  
		 */
		
		//Tabla de correspondencia productos:
		//Nombre, precio, rendimiento, valor de referencia, esPerecedero
		//(El rendimiento x hectarias nos permite saber la cantidad de un producto)
		Producto naranjos = new Producto("naranjos", 2.2, 0.9, false);
		Producto algodon = new Producto("algodon", 2.5, 0.8, false);
		Producto melocotoneros = new Producto("melocotoneros", 2, 1, false);
		
		Producto ciruelos = new Producto("ciruelos", 2.4, 0.6, false);
		Producto trigo = new Producto("trigo", 2.6, .8, false);
		
		Producto aceite = new Producto("aceite", 2.5, 0.5, false);
		
		
		/*
		 *  -------------
		 *  |Productores|
		 *  -------------
		 *  
		 */
		
		
		//Juan P
		TreeMap <Producto, Double> juanP_ProductoExtension = new TreeMap<>();
		juanP_ProductoExtension.put(naranjos, 1.5);
		juanP_ProductoExtension.put(algodon, 0.5);
		juanP_ProductoExtension.put(melocotoneros, 1.5);
		Productor juanP = new Productor("Juan", "P", juanP_ProductoExtension);
		
		//Sonia R
		TreeMap<Producto, Double> soniaR_ProductoExtension = new TreeMap<>();
		soniaR_ProductoExtension.put(ciruelos, 2.6);
		soniaR_ProductoExtension.put(trigo, 1.3);
		soniaR_ProductoExtension.put(algodon, 0.2);
		Productor soniaR = new Productor("Sonia", "R", soniaR_ProductoExtension);
		
		//Juan P y Sonia R
		ArrayList<Productor> productoresPertenecenProductorFederadoAlgodon = new ArrayList<Productor>();
		productoresPertenecenProductorFederadoAlgodon.add(juanP);
		productoresPertenecenProductorFederadoAlgodon.add(soniaR);
		
		//Luis P
		TreeMap<Producto, Double> luisP_ProductoExtension = new TreeMap<>();
		luisP_ProductoExtension.put(aceite, 4.0);
		Productor luisP = new Productor("Luis", "P", luisP_ProductoExtension);
		
		//Alexander C
//		TreeMap<Producto, Double> alexanderC_ProductoExtension = new TreeMap<>();
//		alexanderC_ProductoExtension.put(aceite, 2.5);
//		alexanderC_ProductoExtension.put(algodon, 3.5);
//		Productor AlexanderC = new Productor("Alexander", "C", alexanderC_ProductoExtension);
		
		/*
		 *  --------------------------------------------
		 *  |Agregamos los productores a la cooperativa|
		 *  --------------------------------------------
		 *  
		 */
		
		//Se definen los productos con los cuales los productores entran a la cooperativa
		//Se agregan uno a uno
		TreeSet<Producto> juanP_ProductosCoopEmily = new TreeSet<>();
		juanP_ProductosCoopEmily.add(naranjos);
		juanP_ProductosCoopEmily.add(melocotoneros);
		
		TreeSet<Producto> soniaR_ProductosCoopEmily = new TreeSet<>();
		soniaR_ProductosCoopEmily.add(ciruelos);
		soniaR_ProductosCoopEmily.add(trigo);
		
		coopEmily.agregarProductor(juanP, juanP_ProductosCoopEmily);
		coopEmily.agregarProductor(soniaR, soniaR_ProductosCoopEmily);
		coopEmily.agregarProductorFederado(productoresPertenecenProductorFederadoAlgodon, algodon);
//		coopEmily.agregarProductorProductorFederado("productor federado de algodon", AlexanderC);
		
		TreeSet<Producto> luisP_ProductosCoopEmily = new TreeSet<>();
		luisP_ProductosCoopEmily.add(aceite);
	
		TreeSet<Producto> alexanderC_ProductosCoopEmily = new TreeSet<>();
		alexanderC_ProductosCoopEmily.add(aceite);
		alexanderC_ProductosCoopEmily.add(algodon);
		
		coopEmily.agregarProductor(luisP, luisP_ProductosCoopEmily);
//		coopEmily.agregarProductor(AlexanderC, alexanderC_ProductosCoopEmily);
		
		
		/*
		 * 
		 * -------------------
		 * !Empresas logistica!
		 * -------------------
		 * 
		 */
		
		//Empresas de logistica
		EmpresaLogistica logiLink = new EmpresaLogistica("LogiLink", null);
		EmpresaLogistica ecoTrans = new EmpresaLogistica("EcoTrans", null);
		
		//Definimos las provincias en las que operan con sus respectivos precios de kilometraje
		//¡Poner en minusculas el nombre de las provincias!
		
		TreeMap<String, TreeMap<String, Double>> provinciasPrecioKilometrajeLogiLink = new TreeMap<>();
		TreeMap<String, Double> almeriaPrecioKilometroLogiLink = new TreeMap<>();
		TreeMap<String, Double> madridPrecioKilometroLogiLink = new TreeMap<>();
		almeriaPrecioKilometroLogiLink.put("logisticagrande", 0.05);
		almeriaPrecioKilometroLogiLink.put("logisticapequena", 0.01);
		madridPrecioKilometroLogiLink.put("logisticagrande", 0.06);
		madridPrecioKilometroLogiLink.put("logisticapequena", 0.02);
		provinciasPrecioKilometrajeLogiLink.put("almeria", almeriaPrecioKilometroLogiLink);
		provinciasPrecioKilometrajeLogiLink.put("madrid", madridPrecioKilometroLogiLink);
		
		TreeMap<String, TreeMap<String, Double>> provinciasPrecioKilometrajeEcoTrans = new TreeMap<>();
		TreeMap<String, Double> almeriaPrecioKilometroEcoTrans = new TreeMap<>();
		TreeMap<String, Double> barcelonaPrecioKilometroEcoTrans = new TreeMap<>();
		almeriaPrecioKilometroEcoTrans.put("logisticagrande", 0.04);
		almeriaPrecioKilometroEcoTrans.put("logisticapequena", 0.02);
		barcelonaPrecioKilometroEcoTrans.put("logisticagrande", 0.03);
		barcelonaPrecioKilometroEcoTrans.put("logisticapequena", 0.05);
		provinciasPrecioKilometrajeEcoTrans.put("almeria", almeriaPrecioKilometroEcoTrans);
		provinciasPrecioKilometrajeEcoTrans.put("barcelona", barcelonaPrecioKilometroEcoTrans);
		
		logiLink.setProvinciasPrecioKilometro(provinciasPrecioKilometrajeLogiLink);
		ecoTrans.setProvinciasPrecioKilometro(provinciasPrecioKilometrajeEcoTrans);
		
		//Registramos las empresas en la cooperativa
		TreeSet<EmpresaLogistica> empresasLogistica = new TreeSet<>();
		empresasLogistica.add(logiLink);
		empresasLogistica.add(ecoTrans);
		coopEmily.setEmpresasLogistica(empresasLogistica);
		
		
		/*
		 *  ----------
		 *  |Clientes|
		 *  ----------
		 *  
		 */
		
		//Distribuidoras
		Cliente agroHub = new Cliente("AgroHub", true, "almeria", 180);
//		Cliente greenFlow = new Cliente("GreenFlow", true, "almeria", 180);
//		Cliente terraTranz = new Cliente("TerraTranz", true, "madrid", 300);
//		Cliente cropWave = new Cliente("CropWave", true, "barcelona", 500);
		
		//Consumidores finales
//		Cliente natureNosh = new Cliente("NatureNosh", false, "almeria", 180);
//		Cliente greenBite = new Cliente("GreenBite", false, "almeria", 180);
//		Cliente harvestJoy = new Cliente("HarvestJoy", false, "madrid", 300);
//		Cliente agriEats = new Cliente("AgriEats", false, "barcelona", 500);
		
		/*
		 *  ---------
		 *  |Pedidos|
		 *  ---------
		 *  
		 */
		
		coopEmily.generarPedido(agroHub, 2, aceite, logiLink);
//		coopEmily.generarPedido(greenFlow, 2, aceite, ecoTrans);
//		coopEmily.generarPedido(terraTranz, 5, algodon, logiLink);
//		coopEmily.generarPedido(cropWave, 3, ciruelos, ecoTrans);
		
//		coopEmily.generarPedido(natureNosh, 0.08, aceite, logiLink);
//		coopEmily.generarPedido(greenBite, 0.08, aceite, ecoTrans);
//		coopEmily.generarPedido(harvestJoy, 0.05, melocotoneros, logiLink);
//		coopEmily.generarPedido(agriEats, 0.02, naranjos, ecoTrans);
//		coopEmily.generarPedido(agriEats, 0.04, trigo, ecoTrans);
		
		
		/*
		 *  ---------------------
		 *  |Mostrar por consola|
		 *  ---------------------
		 *  
		 */
		
		coopEmily.mostrarSalida();
	}
}
