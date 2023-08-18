package coopEmily;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


/*
 * NOTA IMPORTANTE
 * ---------------
 * 
 * 1. Las estructura de datos almanecenan valores expresados en hectarias, toneladas y euro respectivamente
 * 2. En cuanto a la operaciones de cantidad: TODAS LAS OPERACIONES SE REALIZAN EN KG, PERO LO GUARDAMOS EN TONELADAS
 */

public class CooperativaEmpresarial {
		
	private int id;
	private String nombre;
	private double hectariaAnoFiscal;
	private double precioKilometroPequenaLogistica;
	private double precioKilometroGranLogistica;
	private double valorProductoDistribuidor; 
	private double valorProductoConsumidorFinal;
	private double valorLogistica; 
	private double valorVentaDistribuidor; 
	private double valorVentaConsumidorFinal; 
	private boolean existeCambioValorReferencia;
	private TreeMap<Productor, TreeSet<Producto>> productoresGrandes;
	private TreeMap<Productor, TreeSet<Producto>> productoresPequenos;
	private TreeSet<ProductorFederado> productoresFederados;
	private TreeMap<Producto, TreeMap<String, Double>> productosProductores;
	private TreeMap<Producto, CantidadHectarias> productosCooperativa;
	private TreeSet<EmpresaLogistica> empresasLogistica;
	private TreeSet<Pedido> pedidos; 
	private TreeSet<Cliente> clientes;
	private TreeMap<String, TreeMap<Producto, Double>> productorCantidadVendida;
	private TreeMap<String, TreeMap<Producto, Double>> importeProductoresProducto;
	private TreeMap<EmpresaLogistica, TreeMap<String, Double>> importeEmpresasLogistica;
	private TreeMap<Producto, TreeMap<String, Double>> beneficioProductos;

	private static final String ANSI_LIGHT_BLUE = "\u001B[94m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_GREEN_DARK = "\u001B[32m";
	private static final String ANSI_RESET = "\u001B[0m";
	
	/**
	 * Constructor de la clase CooperativaEmpresarial
	 * 
	 * El id se define arbitrareamente dentro del rango de [0, 10000]
	 * 
	 * @param nombre El nombre de la cooperativa empresarial.0
	 * @param hectariaAnoFiscal Las hectarias definidas en un ano fiscal
	 */
	
	public CooperativaEmpresarial(String nombre) {
		this.id = (int) (Math.random() * 10000 + 1);
		this.nombre = nombre;
		this.hectariaAnoFiscal = 5;
		this.existeCambioValorReferencia = false;
		this.productoresGrandes = new TreeMap<>();
		this.productoresPequenos = new TreeMap<>();
		this.productoresFederados = new TreeSet<>();
		this.productosProductores = new TreeMap<>();
		this.productosCooperativa = new TreeMap<>();
		this.empresasLogistica = new TreeSet<>();
		this.pedidos = new TreeSet<>();
		this.clientes = new TreeSet<>();
		this.productorCantidadVendida = new TreeMap<>();
		this.importeProductoresProducto = new TreeMap<>();
		this.importeEmpresasLogistica = new TreeMap<>();
		this.beneficioProductos = new TreeMap<>();
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

	public void setHectariaAnoFiscal(double hectariaAnoFiscal) {
		this.hectariaAnoFiscal = hectariaAnoFiscal;
	}

	public double getHectariaAnoFiscal() {
		return hectariaAnoFiscal;
	}
	
	public void setPrecioKilometroPequenaLogistica (double precioKilometroPequenaLogistica) {
		this.precioKilometroPequenaLogistica = precioKilometroPequenaLogistica;
	}
	
	public double getPrecioKilometroPequenaLogistica () {
		return this.precioKilometroPequenaLogistica;
	}
	
	public void setPrecioKilometroGranLogistica (double precioKilometroGranLogistica) {
		this.precioKilometroGranLogistica = precioKilometroGranLogistica;
	}
	
	public double getPrecioKilometroGranLogistica () {
		return this.precioKilometroGranLogistica;
	}
	
	public void setValorProductoDistribuidor(Producto producto, double cantidad) {
		this.valorProductoDistribuidor = producto.getPrecioDistribuidor() * cantidad;
	}
	
	public double getValorProductoDistribuidor() {
		return valorProductoDistribuidor;
	}

	public void setValorProductoConsumidorFinal(Producto producto, double cantidad) {
		this.valorProductoConsumidorFinal = producto.getPrecioConsumidorFinal() * cantidad;
	}
	
	public double getValorProductoConsumidorFinal() {
		return valorProductoConsumidorFinal;
	}
	
	public void setValorLogistica(LogisticaPequena logisticaPequena, LogisticaGrande logisticaGrande) {
		this.valorLogistica = logisticaPequena.getPrecio() + logisticaGrande.getPrecio();
	}
	
	public double getValorLogistica() {
		return valorLogistica;
	}

	public void setValorVentaDistribuidor () {
		this.valorVentaDistribuidor = this.valorProductoDistribuidor + this.valorLogistica;
	}
	
	public double getValorVentaDistribuidor() {
		return valorVentaDistribuidor;
	}

	public void setValorVentaConsumidorFinal() {
		this.valorVentaConsumidorFinal = this.valorProductoConsumidorFinal + this.valorLogistica * 1.10;
	}
	
	public double getValorVentaConsumidorFinal() {
		return valorVentaConsumidorFinal;
	}
	
	public void setProductoresGrandes(TreeMap<Productor, TreeSet<Producto>> productoresGrandes) {
		this.productoresGrandes = productoresGrandes;
	}

	public TreeMap<Productor, TreeSet<Producto>> getProductoresGrandes() {
		return this.productoresGrandes;
	}

	public void setProductoresPequenos(TreeMap<Productor, TreeSet<Producto>> productoresPequenos) {
		this.productoresPequenos = productoresPequenos;
	}

	public TreeMap<Productor, TreeSet<Producto>> getProductoresPequenos() {
		return this.productoresPequenos;
	}

	public void setProductoresFederados(TreeSet<ProductorFederado> productoresFederados) {
		this.productoresFederados = productoresFederados;
	}

	public TreeSet<ProductorFederado> getProductoresFederados() {
		return this.productoresFederados;
	}
	
	public void setProductosProductores(TreeMap<Producto, TreeMap<String, Double>> productosCooperativa) {
		this.productosProductores = productosCooperativa;
	}

	public TreeMap<Producto, TreeMap<String, Double>> getProductosProductores() {
		return productosProductores;
	}
	
	public void setProductosCooperativa(TreeMap<Producto, CantidadHectarias> productosCooperativa) {
		this.productosCooperativa = productosCooperativa;
	}

	public TreeMap<Producto, CantidadHectarias> getProductosCooperativa() {
		return productosCooperativa;
	}
	
	public void setEmpresasLogistica(TreeSet<EmpresaLogistica> empresasLogistica) {
		this.empresasLogistica = empresasLogistica;
	}
	
	public TreeSet<EmpresaLogistica> getEmpresasLogistica() {
		return empresasLogistica;
	}
	
	public void setPedidos(TreeSet<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public TreeSet<Pedido>  getPedidos() {
		return this.pedidos;
	}
	
	public void setClientes(TreeSet<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public TreeSet<Cliente> getClientes() {
		return clientes;
	}
	
	public void setProductorCantidadVendida(TreeMap<String, TreeMap<Producto, Double>> productorCantidadVendida) {
		this.productorCantidadVendida = productorCantidadVendida;
	}
	
	public TreeMap<String, TreeMap<Producto, Double>> getProductorCantidadVendida() {
		return productorCantidadVendida;
	}

	public void setImporteProductoresProducto(TreeMap<String, TreeMap<Producto, Double>> importeProductoresProducto) {
		this.importeProductoresProducto = importeProductoresProducto;
	}
	
	public TreeMap<String, TreeMap<Producto, Double>> getImporteProductoresProducto() {
		return importeProductoresProducto;
	}
	
	public void setImporteEmpresasLogistica(TreeMap<EmpresaLogistica, TreeMap<String, Double>> importeEmpresasLogistica) {
		this.importeEmpresasLogistica = importeEmpresasLogistica;
	}	
	
	public TreeMap<EmpresaLogistica, TreeMap<String, Double>> getImporteEmpresasLogistica() {
		return importeEmpresasLogistica;
	}	
	
	public void setBeneficioProducto(TreeMap<Producto, TreeMap<String, Double>> beneficioProducto) {
		this.beneficioProductos = beneficioProducto;
	}
	
	public TreeMap<Producto, TreeMap<String, Double>> getBeneficioProducto() {
		return beneficioProductos;
	}
	
	/**
	 * Agrega un nuevo productor a la cooperativa empresarial realizando la
	 * distincion entre un productor pequeno con respecto a un productor grande
	 * 
	 * @param productor El nuevo productor a agregar.
	 */

	public void agregarProductor(Productor productor, TreeSet<Producto> productos) {
		//Se verifica si el productor dispone de los productos con los que desea entrar a la cooperativa
		boolean encontrado = false;
		for (Producto productoEntrarCooperativa : productos) {
			for (Producto productoProductor : productor.getProductoExtension().keySet()) {
				if (productoEntrarCooperativa.equals(productoProductor)) {
					encontrado = true;
					break;
				}
			}
			if (encontrado == false) {
				throw new RuntimeException(
						"¡ERROR! El productor desea entrar a la cooperativa con un producto el cual no produce");
			}
		}
		
		//Se clasifica al productor en funcion de las hectarias definidas en el ano fiscal
		productor.setEsProductorPequeno(this.hectariaAnoFiscal);
		if (productor.getEsProductorPequeno()) {
			this.productoresPequenos.put(productor, productos);
		} else {
			this.productoresGrandes.put(productor, productos);
		}
		
		//Se guarda un registro para cada uno de los productos con lo que se desee entrar indicando el productor que lo produce (pueden haber
		//varios productores produciendolos) y las hectarias que tiene destinada para tal producto
		for (Producto productoEntrarCooperativa : productos) {
			for (Entry<Producto, Double> productoProductor : productor.getProductoExtension().entrySet()) {
				if (productoEntrarCooperativa.equals(productoProductor.getKey())) {
					TreeMap<String, Double> productoresHectarias = this.productosProductores.get(productoEntrarCooperativa);
					if (productoresHectarias == null) productoresHectarias = new TreeMap<>();
					productoresHectarias.put(productor.getNombre() + " " + productor.getApellido(), productoProductor.getValue());
					this.productosProductores.put(productoEntrarCooperativa, productoresHectarias);
				}
			}
		}
		
		//Se guarda un registro para cada uno de los productos con los que se desea entrar indicando las hectarias totales que se tiene destinadas
		//para tal producto junto a la cantidad que se produce. Se tiene en cuenta cada productor que produce tal producto (Estructura de datos anterior)
		for (Producto producto : productos) {
			//Llegado a este punto, el producto habra pasado cada prueba necesaria. No existe ninguna probabilidad de error. Imposibilidad que devuelva null
			TreeMap<String, Double> productoresHectarias = this.productosProductores.get(producto);
			double hectariasTotal = 0;
			for (Double hectarias : productoresHectarias.values()) {
				hectariasTotal += hectarias;
			}
			CantidadHectarias cantidadHectarias = this.productosCooperativa.get(producto);
			if (cantidadHectarias == null) {
				cantidadHectarias = new CantidadHectarias(producto.getRendimiento() * hectariasTotal, hectariasTotal);
			} else {
				cantidadHectarias.setCantidad(producto.getRendimiento() * hectariasTotal);
				cantidadHectarias.setHectarias(hectariasTotal);
			}
			this.productosCooperativa.put(producto, cantidadHectarias);
		}
	}

	/**
	 * Agrega un nuevo productor federado a la cooperativa empresarial.
	 * 
	 * @param productores La lista de productores que componen al nuevo productor
	 *                    federado.
	 * @param producto    El producto del nuevo productor federado.
	 */

	public void agregarProductorFederado(ArrayList<Productor> productores, Producto producto) {
		//Un productor federado debe estar compuesto por al menos dos productores
		if (productores.size() < 2) {
			throw new RuntimeException(
					"¡ERROR! Un productor federado debe estar compuesto por al menos dos productores");
		}
		
		//No pueden haber dos productores federados produciendo el mismo producto
		String nombreProductorFederado = "Productor federado de " + producto.getNombre();
		for (ProductorFederado productor : this.productoresFederados) {
			if (productor.getNombre().toLowerCase().trim().equals(nombreProductorFederado.toLowerCase().trim())) {
				throw new RuntimeException("¡ERROR! No pueden haber dos productores federados produciendo el mismo producto");
			}
		}
		
		//Creamos al productor federado
		ProductorFederado productorFederado = new ProductorFederado(productores, producto);
				
		//Se verifica que el productor federado sea un productor pequeno
		productorFederado.setEsProductorPequeno(this.hectariaAnoFiscal);
		if (!productorFederado.getEsProductorPequeno()) {
			throw new RuntimeException("¡ERROR! Un productor federado debe ser un productor pequeno");
		}
		
		//Agregamos al productor federado en mi lista de productores federados
		this.productoresFederados.add(productorFederado);
		
		//Se actualiza en los productores que producen dicho producto
		TreeMap<String, Double> productoresHectaria = this.productosProductores.get(producto);
		if(productoresHectaria == null) productoresHectaria = new TreeMap<>();
		productoresHectaria.put(productorFederado.getNombre(), productorFederado.getExtensionTotal());
		this.productosProductores.put(producto, productoresHectaria);
		
		//Se actualiza la cantidad que se tiene para este el producto que el productor federado desea agregar
		TreeMap<String, Double> productoresHectarias = this.productosProductores.get(producto);
		double hectariasTotal = 0;
		for (Double hectarias : productoresHectarias.values()) {
			hectariasTotal += hectarias;
		}
		CantidadHectarias cantidadHectarias = this.productosCooperativa.get(producto);
		if (cantidadHectarias == null) {
			cantidadHectarias = new CantidadHectarias(producto.getRendimiento() * hectariasTotal, hectariasTotal);
		} else {
			cantidadHectarias.setCantidad(producto.getRendimiento() * hectariasTotal);
			cantidadHectarias.setHectarias(hectariasTotal);
		}
		this.productosCooperativa.put(producto, cantidadHectarias);
	}

	/**
	 * Agrega un nuevo productor a un productor federado de la cooperativa
	 * empresarial
	 * 
	 * @param nombre    El nombre del productor federado.
	 * @param productor El productor que se desea agregar
	 */

	public void agregarProductorProductorFederado(String nombre, Productor productor) {
		//Partimos del supuesto que todo productor perteneciente a un productor federado ha sido agregado previamente siendo clasificado como pequeno o grande
		if (productor.getEsProductorPequeno()) {
			for (ProductorFederado productorFederado : this.productoresFederados) {
				if (productorFederado.getNombre().toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
					productorFederado.agregarProductor(productor);
					
				}
			}
		}
	}
	
	public void generarPedido (Cliente cliente, double cantidadComprar, Producto productoComprar, EmpresaLogistica empresaLogisticaSolicitada) {
		if (cantidadComprar <= 0) {
			throw new RuntimeException("¡ERROR! La cantidad de compra de un producto ha de ser superior a cero");
		}
		
		boolean encontrado = false;
		for(Producto producto : this.productosCooperativa.keySet()) {
			if (producto.equals(productoComprar)) {
				encontrado = true;
				break;
			}
		}
		
		if (!encontrado) {
			throw new RuntimeException("¡ERROR! El producto que se desea comprar no lo dispone la cooperativa");
		}
		
		boolean cantidadSuficiente = (this.productosCooperativa.get(productoComprar).getCantidad() >= cantidadComprar) ? true : false;
		
		if (!cantidadSuficiente) {
			throw new RuntimeException("¡ERROR! La cantidad de compra excede lo que se dispone en stock");
		}
		
		encontrado = false;
		for (EmpresaLogistica empresaLogistica : this.empresasLogistica) {
			if (empresaLogistica.equals(empresaLogisticaSolicitada)) {
				encontrado = true;
				break;
			}
		}
	
		if (!encontrado) {
			throw new RuntimeException("¡ERROR! La empresa de logistica que se menciona no existe");
		}
		
		String nombreProvincia = cliente.getProvincia().toLowerCase().trim();
		TreeMap<String, Double> provinciaPrecioKilometro = empresaLogisticaSolicitada.getProvinciasPrecioKilometro().get(nombreProvincia);
		
		if (provinciaPrecioKilometro == null) {
			throw new RuntimeException("¡ERROR! La empresa de logistica que se menciona no ofrece servicios hacia la provincia del cliente");
		}
		
		this.precioKilometroGranLogistica = provinciaPrecioKilometro.get("logisticagrande");
		this.precioKilometroPequenaLogistica = provinciaPrecioKilometro.get("logisticapequena");
				
		//Pasamos de toneladas a kilogramos
		double cantidadComprarKg =  cantidadComprar * 1000;
		
		double distancia;
		
		Pedido pedido = null;;
		
		if (cliente.isEsDistribuidor()) {
			if (cantidadComprarKg < 1000) {
				throw new RuntimeException("¡ERROR! La cantidad de compra de un producto ha de ser igual o superior a mil cuando el cliente es un distribuidor");
			} 	
			else {
				distancia = cliente.getDistancia();
				
				if (distancia <= 100) {
					setValorProductoDistribuidor(productoComprar, cantidadComprarKg);
					
					LogisticaGrande logisticaGrande = new LogisticaGrande(0, productoComprar, 0, 0);
					LogisticaPequena logisticaPequena = new LogisticaPequena(cantidadComprarKg, productoComprar, distancia, this.precioKilometroPequenaLogistica);
					setValorLogistica(logisticaPequena, logisticaGrande);
					
					setValorVentaDistribuidor();
				} 
				else {
					if (productoComprar.getEsPerecedero()) {
						setValorProductoDistribuidor(productoComprar, cantidadComprarKg);
						
						double distanciaLogisticaGrande = 0;
						double distanciaLogisticaPequena = 0;
						
						while (distancia > 0) {
							if (distancia > 100) {
								distancia -= 100;
								distanciaLogisticaGrande += 100;
							} 
							else {
								distanciaLogisticaPequena += distancia;
								distancia -= distancia;
							}
						}
						
						LogisticaGrande logisticaGrande = new LogisticaGrande(cantidadComprarKg, productoComprar, distanciaLogisticaGrande, this.precioKilometroGranLogistica);
						LogisticaPequena logisticaPequena = new LogisticaPequena(cantidadComprarKg, productoComprar, distanciaLogisticaPequena, this.precioKilometroPequenaLogistica);
						setValorLogistica(logisticaPequena, logisticaGrande);
						
						setValorVentaDistribuidor();
					} 
					else {
						//En primer lugar, se determina el valor del producto en si mismo
						setValorProductoDistribuidor(productoComprar, cantidadComprarKg);
						
						//En segundo lugar, se determina el valor de la logistica.  
						double distanciaLogisticaGrande = 0; 
						double distanciaLogisticaPequena = 0;
						
						while (distancia > 0) {
							if (distancia > 50) {
								distancia -= 50;
								distanciaLogisticaGrande += 50;
							} 
							else {
								distanciaLogisticaPequena += distancia;
								distancia -= distancia;
							}
						}
						
						LogisticaGrande logisticaGrande = new LogisticaGrande(cantidadComprarKg, productoComprar, distanciaLogisticaGrande, this.precioKilometroGranLogistica);
						LogisticaPequena logisticaPequena = new LogisticaPequena(cantidadComprarKg, productoComprar, distanciaLogisticaPequena, this.precioKilometroPequenaLogistica);
						setValorLogistica(logisticaPequena, logisticaGrande);
						
						//En tercer lugar, se determina el valor de venta 
						setValorVentaDistribuidor();
					}
					//Se genera el pedido que asocia a un cliente una factura
					pedido = new Pedido(cliente, empresaLogisticaSolicitada, cantidadComprar, productoComprar, this.valorVentaDistribuidor);
					this.pedidos.add(pedido);
				}
			} 
		}
		else {
			if (cantidadComprarKg > 100) {
				throw new RuntimeException("¡ERROR! La cantidad de compra de un producto ha de ser igual o inferior a cien cuando el cliente es un consumidor final");		
			}
			else {
				distancia = cliente.getDistancia();
					if (distancia <= 100) {
						setValorProductoConsumidorFinal(productoComprar, cantidadComprarKg);
						
						LogisticaGrande logisticaGrande = new LogisticaGrande(0, productoComprar, 0, 0);
						LogisticaPequena logisticaPequena = new LogisticaPequena(cantidadComprarKg, productoComprar, distancia, this.precioKilometroPequenaLogistica);
						setValorLogistica(logisticaPequena, logisticaGrande);
						
						setValorVentaConsumidorFinal();
					} 
					else {
						if (productoComprar.getEsPerecedero()) {
							setValorProductoConsumidorFinal(productoComprar, cantidadComprarKg);
							
							double distanciaLogisticaGrande = 0;
							double distanciaLogisticaPequena = 0;
							
							while (distancia > 0) {
								if (distancia > 100) {
									distancia -= 100;
									distanciaLogisticaGrande += 100;
								} 
								else {
									distanciaLogisticaPequena += distancia;
									distancia -= distancia;
								}
							}
							
							LogisticaGrande logisticaGrande = new LogisticaGrande(cantidadComprarKg, productoComprar, distanciaLogisticaGrande, this.precioKilometroGranLogistica);
							LogisticaPequena logisticaPequena = new LogisticaPequena(cantidadComprarKg, productoComprar, distanciaLogisticaPequena, this.precioKilometroPequenaLogistica);
							setValorLogistica(logisticaPequena, logisticaGrande);
							
							setValorVentaConsumidorFinal();
						} 
						else {
							setValorProductoConsumidorFinal(productoComprar, cantidadComprarKg);
							
							double distanciaLogisticaGrande = 0;
							double distanciaLogisticaPequena = 0;
							
							while (distancia > 0) {
								if (distancia > 50) {
									distancia -= 50;
									distanciaLogisticaGrande += 50;
								} 
								else {
									distanciaLogisticaPequena += distancia;
									distancia -= distancia;
								}
							}
							
							LogisticaGrande logisticaGrande = new LogisticaGrande(cantidadComprarKg, productoComprar, distanciaLogisticaGrande, this.precioKilometroGranLogistica);
							LogisticaPequena logisticaPequena = new LogisticaPequena(cantidadComprarKg, productoComprar, distanciaLogisticaPequena, this.precioKilometroPequenaLogistica);
							setValorLogistica(logisticaPequena, logisticaGrande);
							
							setValorVentaConsumidorFinal();
						}
						pedido = new Pedido(cliente, empresaLogisticaSolicitada, cantidadComprar, productoComprar, this.valorVentaConsumidorFinal);
						this.pedidos.add(pedido);
					}
				} 
			}
		
		//Registramos al cliente
		clientes.add(cliente);
		
		//Asociamos este pedido al cliente para tener un registro sobre los pedidos que han sido realizado sobre este producto por parte de este cliente
		cliente.registarProductoComprado(productoComprar, pedido, existeCambioValorReferencia);
		
		//Generamos un reparto proporcional a cada productor de acuerdo al pedido realizado
		generarReparto(pedido);
		
		//Registramos el importe obtenido por la empresa de logistica
		generarImporteEmpresaLogistica(empresaLogisticaSolicitada, nombreProvincia);
		
		//Registramos el beneficio que se lleva la cooperativa
        generarBeneficioProducto(cliente, cantidadComprarKg, productoComprar);
	}
	
	private void generarReparto (Pedido pedido) {
		if (pedido == null) {
			throw new RuntimeException("¡ERROR! Pedido inexistente");
		}
		
		//Se realiza la conversion de toneladas a kg 
		double cantidadComprada = pedido.getCantidadComprada() * 1000;
		Producto productoComprado = pedido.getProductoComprado(); 
		CantidadHectarias hectariasExistenteProducto = this.productosCooperativa.get(productoComprado);
		
		//Determinamos los productores que producen el producto que ha sido comprado
		for (Entry<Producto, TreeMap<String, Double>> productoProductores : this.productosProductores.entrySet()) {
			if (productoProductores.getKey().equals(productoComprado)) {
				//Una vez hemos determinado los productores es momento de determinar la cantidad vendida del producto por cada productor
				///(El valor double indica las hectarias destinadas al producto)
				for (Entry<String, Double> productor: productoProductores.getValue().entrySet()) {
					//Determinamos las hectarias que el productor destina a la produccion del producto
					Double productorHectariasProducidas = productor.getValue();
					//Determinamos la proporcion que le corresponde al productor
					double productorProporcion = productorHectariasProducidas / hectariasExistenteProducto.getHectarias();
					//Determinamos la cantidad que habria sido vendida al cliente por parte del productor en funcion de la proporcion que
					//se obtuvo
					double productorCantidadVendida = productorProporcion * cantidadComprada;
					
					//Generamos un registro
					//Para ello, verificamos si el productor tenia abierto un registro. Caso contrario, lo creamos
					TreeMap<Producto, Double> productorProductosCantidadVendida = this.productorCantidadVendida.get(productor.getKey());
					if (productorProductosCantidadVendida == null) {
						productorProductosCantidadVendida = new TreeMap<>();
					}
					//Si tenia el registro abierto existe la posibilidad que haya vendido previamente cierta cantidad del producto dado
					Double productorCantidadVendidaRegistro = productorProductosCantidadVendida.get(productoProductores.getKey());
					if (productorCantidadVendidaRegistro == null) {
						productorCantidadVendidaRegistro = (productorCantidadVendida / 1000);
					} 
					else {
						productorCantidadVendidaRegistro += (productorCantidadVendidaRegistro / 1000);
					}
					productorProductosCantidadVendida.put(productoProductores.getKey(), productorCantidadVendidaRegistro);
					this.productorCantidadVendida.put(productor.getKey(), productorProductosCantidadVendida);
					
					generarImporteProductores(productor.getKey(), productorCantidadVendida, productoProductores.getKey());
				}
				break;
			}
		}
		
	}
	
	private void generarImporteProductores (String productor, Double cantidadTotalVendida, Producto producto) {
		//Determinamos si el productor tiene registro abierto. Caso contrario, se abre
		TreeMap<Producto, Double> productorProductosImporte = this.importeProductoresProducto.get(productor);
		if (productorProductosImporte == null) {
			productorProductosImporte = new TreeMap<>();
		}
		//Sobreescribimos el valor que tenga para aquel producto
		double importe = producto.getValorReferencia() * cantidadTotalVendida;
		productorProductosImporte.put(producto, importe);
		//Sobreescribimos la estructura de datos
		this.importeProductoresProducto.put(productor, productorProductosImporte);
	}
	
	private void generarImporteEmpresaLogistica (EmpresaLogistica empresaLogistica, String nombreProvincia) {
		TreeMap<String, Double> provinciasImporte = this.importeEmpresasLogistica.get(empresaLogistica);
		if (provinciasImporte == null) {
			provinciasImporte = new TreeMap<>();
		}
		Double provinciaImporte = provinciasImporte.get(nombreProvincia);
		if (provinciaImporte == null) {
			provinciaImporte = this.valorLogistica;
		}
		else {
			provinciaImporte += this.valorLogistica;
		}
		provinciasImporte.put(nombreProvincia, provinciaImporte);
		this.importeEmpresasLogistica.put(empresaLogistica, provinciasImporte);
	}
	
	private void generarBeneficioProducto (Cliente cliente, double cantidadComprar, Producto productoComprar) {
		TreeMap<String, Double> beneficioProductos = this.beneficioProductos.get(productoComprar);
		if (beneficioProductos == null) {
			beneficioProductos = new TreeMap<>();
		}
		
		String tipoCliente;
		double beneficioActual;
		Double beneficioAcumulado;
		
		if (cliente.isEsDistribuidor()) {
			tipoCliente = "distribuidor";
			beneficioActual = this.valorProductoDistribuidor - (productoComprar.getValorReferencia() * cantidadComprar);
			beneficioAcumulado = beneficioProductos.get(tipoCliente);
			
		}
		else {
			tipoCliente = "consumidorfinal";
			beneficioActual = this.valorProductoConsumidorFinal - (productoComprar.getValorReferencia() * cantidadComprar);
			beneficioAcumulado = beneficioProductos.get(tipoCliente);
		}
		
		
		if (beneficioAcumulado == null) {
			beneficioAcumulado = beneficioActual;
		}
		else {
			beneficioAcumulado += beneficioActual;
		}
		
		beneficioProductos.put(tipoCliente, beneficioAcumulado);
		this.beneficioProductos.put(productoComprar, beneficioProductos);

	}
	
	public void mostrarSalida() {
		Scanner scanner = new Scanner(System.in);
		mostrarCabeceraV2(scanner);
	}

	private void mostrarCabecera(Scanner scanner) {
		int opcion;
		
		do {
			System.out.println(ANSI_LIGHT_BLUE + " -----------------------------------");
			System.out.println("|Cooperativa empresarial: " + this.nombre + " |");
			System.out.println(" -----------------------------------");

			System.out.println();
			
			System.out.println(ANSI_YELLOW + "1.  Mostrar productores");
			System.out.println("2.  Mostrar productos");
			System.out.println("3.  Mostrar empresas de logistica");
			System.out.println("4.  Mostrar pedidos");
			System.out.println("5.  Mostrar clientes");
			System.out.println();
			System.out.println("6.  Mostrar ventas totales en un periodo determinado de cada uno de los productos de la cooperativa");
			System.out.println("7.  Mostrar importes obtenidos por cada uno de los productores (desglosados por productos)");
			System.out.println("8.  Mostrar importes obtenidos por cada una de las empresas de logística");
			System.out.println("9.  Mostrar beneficios de la cooperativa por cada uno de los productos");
			System.out.println("10. Mostrar evolución de los precios de referencias de cada productos");
			System.out.println();
			System.out.println("11. Modificar valor de referencia de un producto");
			System.out.println();
			System.out.println("12. Salir");

			System.out.println();

			System.out.print("Selecciona una opcion: ");
			opcion = scanner.nextInt();

			//consumir el carácter de nueva línea que quedó en el búfer de entrada
			//Evita posibles
			scanner.nextLine(); 
			
			System.out.println(ANSI_RESET);

			switch (opcion) {
			case 1:
				mostrarProductores();
				break;
			case 2:
				mostrarProductos();
				break;
			case 3:
				mostrarEmpresasLogistica();
				break;
			case 4:
				mostrarPedidos();
				break;
			case 5: 
				mostrarClientes();
				break;
			case 6:
				mostrarVentasTotalesProducto();
				break;
			case 7:
				mostrarImportePorProductoProductores();
				break;
			case 8:
				mostrarImporteEmpresasLogistica();
				break;
			case 9:
				mostrarBeneficioProductoCooperativa();
				break;
			case 10:
				mostrarEvolucionPrecioReferenciaProducto();
				break;
			case 11:
				String nombreProducto = "";
				System.out.print("Ingrese el nombre del producto que se desee modificar: ");
				nombreProducto = scanner.nextLine();
				Producto productoModificar = obtenerProducto(nombreProducto);
				if (productoModificar == null) {
					throw new RuntimeException("¡ERROR! El producto que se desea modificar no lo dispone la cooperativa");
				}
				modificarValorReferenciaProducto(scanner, productoModificar);
				generarPedidoProductoModificado(productoModificar);
				break;
			default:
				if (opcion != 12) {
					System.out.println("Opcion invalida. Intente de nuevo");
					System.out.println();
					break;
				}
			}
			
		} while (opcion != 12);

		System.out.print(ANSI_RESET);
		System.out.println("¡Nos vemos pronto!");
	}

	private void mostrarCabeceraV2(Scanner scanner) {
		int opcion = 0;
		
		do {
			System.out.print(ANSI_LIGHT_BLUE);
			System.out.println(" -----------------------------------");
			System.out.println("|Cooperativa empresarial: " + this.nombre + " |");
			System.out.println(" -----------------------------------");

			System.out.println();
			
			System.out.print(ANSI_YELLOW);
			System.out.println("1. Estadisticas");
			System.out.println("2. Modificar");
			System.out.println("3. Mostrar");
			
			System.out.println();
			
			System.out.print("Selecciona una opcion (presione 12 para salir): ");
			opcion = scanner.nextInt();
			
			//Para evitar futuros errores, se ha de consumir el carácter de nueva línea que quedó en el búfer de entrada
			scanner.nextLine(); 
			
			switch(opcion) {
			case 1:
				do {
					System.out.println(ANSI_GREEN_DARK);
					System.out.println("Estadisticas");
					System.out.println("------------");
					
					System.out.println();
					
					System.out.println("1. Mostrar ventas totales en un periodo determinado de cada uno de los productos de la cooperativa");
					System.out.println("2. Mostrar importes obtenidos por cada uno de los productores (desglosados por productos)");
					System.out.println("3. Mostrar importes obtenidos por cada una de las empresas de logística");
					System.out.println("4. Mostrar beneficios de la cooperativa por cada uno de los productos");
					System.out.println("5. Mostrar evolución de los precios de referencias de cada productos");
					
					System.out.println();
					
					System.out.print("Selecciona una opcion (presione 12 para salir): ");
					opcion = scanner.nextInt();
					
					scanner.nextLine(); 
					
					System.out.println(ANSI_RESET);
					
					switch(opcion) {
					case 1:
						mostrarVentasTotalesProducto();
						break;
					case 2:
						mostrarImportePorProductoProductores();
						break;
					case 3:
						mostrarImporteEmpresasLogistica();
						break;
					case 4:
						mostrarBeneficioProductoCooperativa();
						break;
					case 5:
						mostrarEvolucionPrecioReferenciaProducto();
						break;
					default:
						if (opcion != 12) {
							System.out.println("Opcion invalida. Intente de nuevo");
							break;
						}
					}
					
				} while (opcion != 12);
				opcion = 0;
				break;
				
				
			case 2:
				do {
					System.out.println(ANSI_GREEN_DARK);
					System.out.println("Modificar");
					System.out.println("---------");
					
					System.out.println();
					
					System.out.println("1. Modificar valor de referencia de un producto");
					
					System.out.println();
					
					System.out.print("Selecciona una opcion (presione 12 para salir): ");
					opcion = scanner.nextInt();
					
					scanner.nextLine(); 
					
					System.out.println(ANSI_RESET);
					
					switch(opcion) {
					case 1:
						String nombreProducto = "";
						System.out.print("Ingrese el nombre del producto que se desee modificar: ");
						nombreProducto = scanner.nextLine();
						Producto productoModificar = obtenerProducto(nombreProducto);
						if (productoModificar == null) throw new RuntimeException("¡ERROR! El producto que se desea modificar no lo dispone la cooperativa");
						modificarValorReferenciaProducto(scanner, productoModificar);
						generarPedidoProductoModificado(productoModificar);
						break;
					default:
						if (opcion != 12) {
							System.out.println("Opcion invalida. Intente de nuevo");
							break;
						}
					}
				} while(opcion != 12);
				opcion = 0;
				break;
			
				
			case 3:
				do {
					System.out.println(ANSI_GREEN_DARK);
					System.out.println("Mostrar");
					System.out.println("---------");
					
					System.out.println();
					
					System.out.println("1.  Mostrar productores");
					System.out.println("2.  Mostrar productos");
					System.out.println("3.  Mostrar empresas de logistica");
					System.out.println("4.  Mostrar pedidos");
					System.out.println("5.  Mostrar clientes");
					
					System.out.println();
					
					System.out.print("Selecciona una opcion (presione 12 para salir): ");
					opcion = scanner.nextInt();
					
					scanner.nextLine(); 
					
					System.out.println(ANSI_RESET);
					
					switch(opcion) {
					case 1:
						mostrarProductores();
						break;
					case 2:
						mostrarProductos();
						break;
					case 3:
						mostrarEmpresasLogistica();
						break;
					case 4:
						mostrarPedidos();
						break;
					case 5: 
						mostrarClientes();
						break;
					default:
						if (opcion != 12) {
							System.out.println("Opcion invalida. Intente de nuevo");
							break;
						}
					}
				} while(opcion != 12);
				opcion = 0;
				break;
			
				
			default:
				if (opcion != 12) {
					System.out.println(ANSI_RESET);
					System.out.println("Opcion invalida. Intente de nuevo");
					System.out.println();
					break;
				}
			}
		} while(opcion!= 12);
		
		
		System.out.println(ANSI_RESET);
		
		System.out.println("¡Nos vemos pronto!");
	}
	
	private void mostrarProductores() {
		int contador;

		System.out.println("Productores grandes");
		System.out.println("-------------------");
		System.out.println();
		contador = this.productoresGrandes.keySet().size();
		if (contador == 0) {
			System.out.println("No existe ningun productor grande");
			System.out.println();
		} else {
			for (Productor productor : this.productoresGrandes.keySet()) {
				productor.mostrarSalida();
				System.out.println();
			}
		}

		System.out.println("Productores pequenos");
		System.out.println("--------------------");
		System.out.println();
		contador = this.productoresPequenos.keySet().size();
		if (contador == 0) {
			System.out.println("No existe ningun productor pequeno");
		} else {
			for (Productor productor : this.productoresPequenos.keySet()) {
				productor.mostrarSalida();
				System.out.println();
			}
		}

		System.out.println("Productores federados");
		System.out.println("---------------------");
		System.out.println();
		contador = this.productoresPequenos.keySet().size();
		if (contador == 0) {
			System.out.println("No existe ningun productor federado");
		} else {
			for (ProductorFederado productor : this.productoresFederados) {
				productor.mostrarSalida();
				System.out.println();
			}
		}
	}

	private void mostrarProductos() {
		if (this.productosCooperativa.size() == 0) {
			System.out.println("No se tiene registro sobre ningun producto");
			System.out.println();
			return;
		}
		for (Entry<Producto, CantidadHectarias> producto : this.productosCooperativa.entrySet()) {
			producto.getKey().mostrarSalida();
			System.out.printf("Hectarias que se dispone del producto: %.3f ha\n",  producto.getValue().getHectarias());
			System.out.printf("Cantidad que se dispone del producto: %.3f toneladas\n", producto.getValue().getCantidad());
			System.out.println();
		}
	}
	
	private void mostrarEmpresasLogistica() {
		if (this.empresasLogistica.size() == 0) {
			System.out.println("No se tiene registro sobre ninguna empresa de logistica");
			System.out.println();
			return;
		}
		for (EmpresaLogistica empresaLogistica : this.empresasLogistica) {
			empresaLogistica.mostraConsola();
			System.out.println();
		}
	}
	
	private void mostrarPedidos() {
		if (this.pedidos.size() == 0) {
			System.out.println("No se tiene registro sobre ningun pedido");
			System.out.println();
			return;
		}
		for (Pedido pedido : this.pedidos) {
			pedido.mostrarConsola();
			System.out.println();
		}
	}
	
	private void mostrarClientes() {
		if (clientes.size() == 0) {
			System.out.println("No se tiene registro sobre ningun cliente");
			System.out.println();
			return;
		} 
		for (Cliente cliente : this.clientes) {
			cliente.mostrarConsola();
			System.out.println();
		}
		
	}
	
	private void mostrarVentasTotalesProducto() {
		int contador;
		for (Producto producto : this.productosCooperativa.keySet()) {
			contador = 0;
			for (Pedido pedido : this.pedidos) {
				if (pedido.getProductoComprado().equals(producto)) {
					contador++;
				}
			}
			System.out.println("Producto: " + producto.getNombre());
			System.out.println("Numero de ventas generadas: " + contador);
			System.out.println();
		}	
	}
	
	private void mostrarImportePorProductoProductores() {
		String nombreProductor;
		String nombreProducto;
		boolean seTieneRegistroProductor;
		boolean seTieneRegistroProducto;
		
		//Iteramos sobre el conjunto de productores grandes
		for (Entry<Productor, TreeSet<Producto>> productor : this.productoresGrandes.entrySet()) {
			nombreProductor = productor.getKey().getNombre() + " " + productor.getKey().getApellido();
			System.out.println("Productor: " + nombreProductor);
			seTieneRegistroProductor = false;
			//Iteramos sobre el conjunto de productos que tiene el productor
			for (Producto producto : productor.getValue()) {
				seTieneRegistroProducto = false;
				//Iteramos sobre la estructura de datos que registra los productores que han generado ventas en busca del productor sobre 
				//el cual se esta iterando
				for (Entry<String, TreeMap<Producto, Double>> productorProductosImporte: this.importeProductoresProducto.entrySet()) {
					//Se tiene registro sobre el productor sobre el que se itera. El productor ha generado ventas de al menos uno de sus productos
					if (nombreProductor.equals(productorProductosImporte.getKey())) {
						seTieneRegistroProductor = true;
						nombreProducto = producto.getNombre();
						System.out.print("Producto: " + nombreProducto + ", ");
						for (Entry<Producto, Double> productoImporte : productorProductosImporte.getValue().entrySet()) {
							//Se tiene registro sobre el producto sobre el que se itera
							if (nombreProducto.equals(productoImporte.getKey().getNombre())) {
								seTieneRegistroProducto = true;
								System.out.println("importe: " + productoImporte.getValue() + " euros");
							}
						}
						//No se encontro ninguna coincidencia sobre el producto sobre el cual se itera
						if (!seTieneRegistroProducto) {
							System.out.println("importe: " + 0 + " euros");
						}
					}
				}
			}
			//No se encontro ninguna coincidencia sobre el productor sobre el cual se itera
			if (seTieneRegistroProductor == false) {
				System.out.println("El productor no ha generado venta de ninguno de sus productos");
			}
			System.out.println();
		}
		
		//Iteramos sobre el conjunto de productores pequenos
		for (Entry<Productor, TreeSet<Producto>> productor : this.productoresPequenos.entrySet()) {
			nombreProductor = productor.getKey().getNombre() + " " + productor.getKey().getApellido();
			System.out.println("Productor: " + nombreProductor);
			seTieneRegistroProductor = false;
			//Iteramos sobre el conjunto de productos que tiene el productor
			for (Producto producto : productor.getValue()) {
				seTieneRegistroProducto = false;
				//Iteramos sobre la estructura de datos que registra los productores que han generado ventas en busca del productor sobre 
				//el cual se esta iterando
				for (Entry<String, TreeMap<Producto, Double>> productorProductosImporte: this.importeProductoresProducto.entrySet()) {
					//Se tiene registro sobre el productor sobre el que se itera. El productor ha generado ventas de al menos uno de sus productos
					if (nombreProductor.equals(productorProductosImporte.getKey())) {
						seTieneRegistroProductor = true;
						nombreProducto = producto.getNombre();
						System.out.print("Producto: " + nombreProducto + ", ");
						for (Entry<Producto, Double> productoImporte : productorProductosImporte.getValue().entrySet()) {
							//Se tiene registro sobre el producto sobre el que se itera
							if (nombreProducto.equals(productoImporte.getKey().getNombre())) {
								seTieneRegistroProducto = true;
								System.out.println("importe: " + productoImporte.getValue() + " euros");
							}
						}
						//No se encontro ninguna coincidencia sobre el producto sobre el cual se itera
						if (!seTieneRegistroProductor) {
							System.out.println("importe: " + 0 + " euros");
						}
					}
				}
			}
			//No se encontro ninguna coincidencia sobre el productor sobre el cual se itera
			if (!seTieneRegistroProductor) {
				System.out.println("El productor no ha generado venta de ninguno de sus productos");
			}
			System.out.println();
		}
	
		//Iteramos sobre el conjunto de productores grandes
		for (ProductorFederado productor : this.productoresFederados) {
			nombreProductor = productor.getNombre();
			System.out.println("Productor: " + nombreProductor);
			seTieneRegistroProductor = false;
			//Un productor federado comercializa un unico producto
			nombreProducto = productor.getProducto().getNombre();
			//Iteramos sobre la estructura de datos que registra los productores que han generado ventas en busca del productor sobre 
			//el cual se esta iterando
			for (Entry<String, TreeMap<Producto, Double>> productorProductosImporte: this.importeProductoresProducto.entrySet()) {
				//Se tiene registro sobre el productor sobre el que se itera. El productor ha generado ventas de al menos uno de sus productos
				if (nombreProductor.equals(productorProductosImporte.getKey())) {
					seTieneRegistroProductor = true;
					System.out.print("Producto: " + nombreProducto + ", ");
					//Un productor federado comercializa un unico producto
					for (Entry<Producto, Double> productoImporte : productorProductosImporte.getValue().entrySet()) {
						System.out.println("importe: " + productoImporte.getValue() + " euros");
					}
				}
			}
			//No se encontro ninguna coincidencia sobre el productor sobre el cual se itera
			if (!seTieneRegistroProductor) {
				System.out.println("El productor no ha generado venta de ninguno de sus productos");
			}
			System.out.println();
		}
	}
	
	private void mostrarImporteEmpresasLogistica() {
		for (EmpresaLogistica empresaLogistica : this.empresasLogistica) {
			System.out.println("Empresa logistica: " + empresaLogistica.getNombreEmpresa());
			TreeMap<String, Double> provinciasImporte = this.importeEmpresasLogistica.get(empresaLogistica);
			
			if (provinciasImporte == null) {
				System.out.println("La empresa de logistica no ha generado ninguna venta");
			}
			else {
				double importeAcumulado = 0;
				for (Double importe : provinciasImporte.values()) {
					importeAcumulado += importe;
				}
				System.out.println("Importe: " + importeAcumulado + " euros");
			}
			System.out.println();
		}
	}
	
	private void mostrarBeneficioProductoCooperativa() {
		boolean encontrado;
		String nombreProducto;
		int suma;
		
		for (Producto productoCooperativa : this.productosCooperativa.keySet()) {
			nombreProducto = productoCooperativa.getNombre();
			System.out.println("Producto: " + nombreProducto);
			encontrado = false;
			for (Entry<Producto, TreeMap<String, Double>> producto : this.beneficioProductos.entrySet()) {
				if (nombreProducto.equals(producto.getKey().getNombre())) {
					encontrado = true;
					suma = 0;
					for (Entry<String, Double> beneficioTipoCliente : producto.getValue().entrySet()) {
						suma += beneficioTipoCliente.getValue();
					}
					System.out.println("Beneficio: " + suma + " euros");
				}
			}
			if (!encontrado) {
				System.out.println("No se ha generado ventas de este producto. Por tanto, no se puede generar su beneficio");
			}
			System.out.println();
		}
	}
	
	private void mostrarEvolucionPrecioReferenciaProducto() {
		for (Producto producto : this.productosCooperativa.keySet()) {
			System.out.println("Producto: " + producto.getNombre());
			for (Entry<String, Double> valorReferencia : producto.getEvolucionValorReferencia().entrySet()) {
				System.out.println("Fecha: " + valorReferencia.getKey() + ", valor de referencia: " + valorReferencia.getValue());
			}
			System.out.println();
		}
	}
	
	private void modificarValorReferenciaProducto(Scanner scanner, Producto productoModificar) {
		System.out.print("Ingrese el nuevo valor de referencia del producto: ");
		double nuevoValorReferencia = scanner.nextDouble();
		
		productoModificar.setValorReferencia(nuevoValorReferencia);
		
		System.out.println("Operacion realizada correctamente");
		
		System.out.println();
	}
	
	private void generarPedidoProductoModificado (Producto productoModificar) {
		//Definimos las variables que usaremos
		Producto producto;
		
		//Registramos sobre una estructura de datos los pedidos que se eliminaran
		//con el objetivo de mantener consistente nuestra BD
		//(No lo podemos realizar sobre el for-each porque lanzaria un error
		//de concurrencia)
		TreeSet<Pedido> pedidosEliminar = new TreeSet<>();
		for (Pedido pedido : this.pedidos) {
			//Se verifica si el pedido sobre el cual se itera contiene el producto que se desea modificar
			//De esta forma, se guarda en la estructura de datos de pedidos a eliminar (estan desactualizados)
			producto = pedido.getProductoComprado();
			if (producto.equals(productoModificar)) {
				pedidosEliminar.add(pedido);	
			}
		}
		
		//Se verifica si se ha encontrado alguna coincidencia, sino detenemos la ejecucion del metodo
		if (pedidosEliminar.size() == 0) {
			return;
		}
		
		//Eliminamos los pedidos desactualizados
		this.pedidos.removeAll(pedidosEliminar);
		
		//Actualizamos los pedidos
		//(NOTA jugamos con la variable existeCambioValorReferencia para evitar cambiar el precio de venta de un producto innecesariamente)
		this.existeCambioValorReferencia = true;
		for (Pedido pedido : pedidosEliminar) {
			Cliente cliente = pedido.getCliente();
			double cantidadComprada = pedido.getCantidadComprada();
			producto = pedido.getProductoComprado();
			EmpresaLogistica empresaLogistica = pedido.getEmpresaLogistica();
			//Eliminamos el pedido desactualizados sobre el cliente
			cliente.getProductosComprados().get(productoModificar).remove(pedido);
			//Actualizamos el pedido
			generarPedido(cliente, cantidadComprada, producto, empresaLogistica);
			if (this.existeCambioValorReferencia) {
				this.existeCambioValorReferencia = false;
			}
		}
		
		//Deshacemos cambios
		this.existeCambioValorReferencia = true;
	}
	
	public Producto obtenerProducto (String nombreProducto) {
		Producto productoDevolver = null;
		nombreProducto = nombreProducto.toLowerCase().trim();
		for (Producto producto : this.productosCooperativa.keySet()) {
			if (producto.getNombre().equals(nombreProducto)) {
				//Se realiza para evitar posibles fallos de referencia
				productoDevolver = producto;
				break;
			}
		}
		
		return productoDevolver;
	}
}
