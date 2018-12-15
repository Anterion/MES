package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.*;
import persistencia.dto.*;

/**
 * @author Lois
 * Clase Singleton que contiene los objetos de la aplicación en memoria y los carga cuando se inicializa. 
 */
public class AlquilerVehiculos {
	private DAL dal;
	private HashMap<String,Categoria> mapCategoria;
	private HashMap<Integer,Sucursal> mapSucursal;
	private HashMap<Integer,Reserva> mapReserva;
	private HashMap<Integer,Entrega> mapEntrega;
	private HashMap<String,Cliente> mapCliente;
	private HashMap<String,Coche> mapCoche;
	
	private static AlquilerVehiculos instancia = new AlquilerVehiculos();
	
	/**
	 * Constructor de AlquilerVehiculos
	 */
	public AlquilerVehiculos(){ //throws DAOExcepcion {
		mapSucursal = new HashMap<Integer, Sucursal>();
		mapReserva = new HashMap<Integer, Reserva>();
		mapCliente = new HashMap<String, Cliente>();
		mapCategoria = new HashMap<String, Categoria>();
		mapCoche = new HashMap<String, Coche>();
		mapEntrega = new HashMap<Integer, Entrega>();
		try{
			this.dal= DAL.getDAL();
		} 
		catch(DAOExcepcion e){
			System.out.println(e.printStackTrace());
		}
		cargarSistema();
		
	}
	/**
	 * @return El hashmap con los coches disponibles
	 */
	public HashMap<String,Coche> getMapCoche(){
		return mapCoche;
	}
	
    /**
     * @return La instancia de la Clase (patrón singleton)
     */
    public static AlquilerVehiculos	getAlquilerVehiculos() {//throws DAOExcepcion {
	       // if (instancia == null) crearAlquilerVehiculos();
	        return instancia;
	 }
		

    /**
     * Lista los clientes disponibles.
     * @return La lista de clientes.
     */
    public List<Cliente> listarClientes() { 
    	cargarClientes();
    	return new ArrayList<Cliente>(mapCliente.values()); 
    	}
    /**
     * Lista las Categorías disponibles.
     * @return La lista de Categorías.
     */
    public List<Categoria> listarCategorias() { 
    	return new ArrayList<Categoria>(mapCategoria.values()); 
    	}
    /**
     * Lista las reservas disponibles en una sucursal.
     * @param suc El objeto Sucursal desde el que obtenemos las reservas.
     * @return La lista de Reservas.
     */
    public List<Reserva> listarReservas(Sucursal suc) { 
    	return new ArrayList<Reserva>(mapReserva.values()); 
    	}
    /**
     * Lista los coches que están en una Sucursal.
     * @param idSucursal El id de la Sucursal desde la que obtenemos los Coches.
     * @return La lista de Coches.
     */
    public List<Coche> listarCoches(int idSucursal) {
    	mapCoche.clear();
    	cargarCoches(idSucursal);
    	ArrayList <Coche> c = new ArrayList <Coche> ();
		for(Coche x : mapCoche.values()){ 
			if (x.getSucursal()==idSucursal) c.add(x);
		}
		return c;
    	}
    /**
     * Lista todas las sucursales.
     * @return La lista de sucursales.
     */
    public List<Sucursal> listarSucursales() { 
    	return new ArrayList<Sucursal>(mapSucursal.values()); 
    	
    	}
    /**
     * Obtiene la lista de todas las Entregas, en todas las sucursales.
     * @return La lista de entregas.
     */
    public List<Entrega> listarEntregas() { 
    	cargarEntregas();
    	return new ArrayList<Entrega>(mapEntrega.values()); 
    	
    	}
    /**
     * Obtiene la lista de todas las reservas, en todas las sucursales.
     * @return La lista de reservas.
     */
    public List<Reserva> listarReservas() { 
    	cargarReservas();
        ArrayList <Reserva> r = new ArrayList <Reserva> ();
        for(Reserva x : mapReserva.values()){ // x en lista de reservas
                if (!consultar_entrega(x.getId()))
                        r.add(x);
        } // id de reserva es el mismo q id de entrega?
        return r;
    	
    	}
    /**
     * Comprueba su se ha realizado una entrega.
     * @param id La id de la entrega a comprobar
     * @return True si se ha realizado, de otra forma, False.
     */
    public boolean consultar_entrega(int id){
        if(mapEntrega.containsKey(id))
                return true;
        else return false;
}
    /**
     * Comprueba si un coche existe.
     * @param ma La ID (matrícula) del coche.
     * @return True si el coche existe en la base de datos, si no, False.
     */
    public boolean consultar_coche(String ma){
        if(mapCoche.containsKey(ma))
                return true;
        else return false;
}
    /**
     * Lista todas las resevas en una sucursal específica.
     * @param s La id de la Sucursal.
     * @return La lista de reservas.
     */
    public List<Reserva> listarReservasSucursal(int s) {
    	cargarReservas(s);
		ArrayList <Reserva> r = new ArrayList <Reserva> ();
		for(Reserva x : mapReserva.values()){ 
			if (x.getIdSucursalRecogida()==s) r.add(x);
		}
		return r;
	}
    
    
    /**
     * Añade una sucursal.
     * @param c El objeto Sucursal.
     */
    public void anyadirSucursal(Sucursal c){
    	mapSucursal.put(c.getId(), c);   	    	
    }   
    /**
     * Añade un coche.
     * @param c El objeto coche.
     */
    public void anyadirCoche(Coche c){
    	mapCoche.put(c.getMatricula(), c);   	    	
    } 
    /**
     * Añade una reserva.
     * @param r El objeto reserva.
     */
    public void anyadirReserva(Reserva r){
    	mapReserva.put(r.getId(), r);    	    	
    }     
    /**
     * Añade un Cliente.
     * @param c El objeto cliente.
     */
    public void anyadirCliente(Cliente c){
    	mapCliente.put(c.getDni(), c);  	    	
    } 
    /**
     * Añade una categoría.
     * @param c El objeto categoría.
     */
    public void anyadirCategoria(Categoria c){
    	mapCategoria.put(c.getNombre(), c);	    	
    }
    /**
     * Añade una Entrega.
     * @param e El objeto entrega.
     */
    public void anyadirEntrega(Entrega e){
    	mapEntrega.put(e.getId(), e);	    	
    }
        
    /**
     * Busca una sucursal por su identificador.
     * @param id La ID de la sucursal.
     * @return El objeto Sucursal. Null si no existe.
     */
    public Sucursal buscarSucursal(int id){  	
    	if( mapSucursal.containsKey(id)) return mapSucursal.get(id);
		else return null;
   }
	/**
	 * Busca una categoría por su nombre
	 * @param nombre El nombre de la categoría a buscar.
	 * @return El objeto Categoría. Null si no existe.
	 */
	public Categoria buscarCategoria(String nombre){
		if( mapCategoria.containsKey(nombre)) return mapCategoria.get(nombre);
		else return null;
	}
	/**
	 * Busca una reserva por su id.
	 * @param id Le id de la reserva a buscar.
	 * @return El objeto Reserva. Null si no existe.
	 */
	public Reserva buscarReserva(int id){
		if( mapReserva.containsKey(id)) return mapReserva.get(id);
		else return null;
	}
	/**
	 * Crea una nueva categoría.
	 * @param categoria El objeto categoría.
	 */
	public void crearCategoria (Categoria categoria){
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoria.getNombre(),categoria.getPrecioModIlimitada(),categoria.getPrecioModKms(),categoria.getPrecioSeguroTRiesgo(),categoria.getPrecioSeguroTerceros(),categoria.getPrecioKmModKms(),categoria.getSuperior());
		mapCategoria.put(categoria.getNombre(), categoria);
		dal.crearCategoria(categoriaDTO);
	}
	/**
	 * Crea una nueva Entrega.
	 * @param entrega El objeto entrega.
	 */
	public void crearEntrega (Entrega entrega){
		EntregaDTO entregaDTO = new EntregaDTO(entrega.getId(),entrega.getFecha(),entrega.getTipoSeguro(),entrega.getKms(),entrega.getCombustible(),entrega.getCoche(),entrega.getEmpleado());
		mapEntrega.put(entrega.getId(), entrega);
		dal.crearEntrega(entregaDTO);
	}
	/**
	 * Crea una nueva Sucursal.
	 * @param sucursal El objeto sucursal
	 */
	public void crearSucursal(Sucursal sucursal){
		SucursalDTO sucursalDTO = new SucursalDTO(sucursal.getId(),sucursal.getDireccion());
		mapSucursal.put(sucursal.getId(), sucursal);
		dal.crearSucursal(sucursalDTO);
	}
	/**
	 * Crea una nueva reserva.
	 * @param reserva El objeto reserva
	 */
	public void crearReserva(Reserva reserva) {
			
		ReservaDTO reservaDTO = new ReservaDTO(reserva.getId(), reserva.getFechaRecogida(), reserva.getFechaDevolucion(),
				reserva.getModalidadAlquiler(), reserva.getDniCliente(),reserva.getCategoria().getNombre(), reserva.getIdSucursalRecogida(),reserva.getIdSucursalDevolucion());
		mapReserva.put(reserva.getId(), reserva);
		dal.crearReserva(reservaDTO);
	}
	/**
	 * Crea un nuevo Cliente y lo añade a la base de datos.
	 * @param cliente El objeto Cliente.
	 * @throws DAOExcepcion Lanza una excepción DAOExcepcion si los datos del cliente no son correctos.
	 */
	public void crearCliente(Cliente cliente) throws DAOExcepcion { 	
		ClienteDTO clienteDTO=new ClienteDTO(cliente.getDni(), cliente.getNombreyApellidos(), cliente.getDireccion(), 
											 cliente.getPoblacion(), cliente.getCodPostal(),cliente.getFechaCarnetConducir(),
											 cliente.getDigitosTC(),cliente.getMesTC(), cliente.getAnyoTC(), 
											 cliente.getCvcTC(), cliente.getTipoTC());
	
	
			mapCliente.put(cliente.getDni(), cliente);
			dal.crearCliente(clienteDTO); 
		}
	
	/**
	 * Crea un nuevo cliente, sin añadirlo a la base de datos.
	 * @param clienteDTO El objeto Cliente.
	 * @throws DAOExcepcion Lanza una excepción DAOExcepcion si los datos del cliente no son correctos.
	 */
	public void crearCl(Cliente clienteDTO) throws DAOExcepcion { 	
		Cliente cliente=new Cliente(clienteDTO.getDni(), clienteDTO.getNombreyApellidos(), clienteDTO.getDireccion(), 
				clienteDTO.getPoblacion(), clienteDTO.getCodPostal(),clienteDTO.getFechaCarnetConducir(),
				clienteDTO.getDigitosTC(),clienteDTO.getMesTC(), clienteDTO.getAnyoTC(), 
				clienteDTO.getCvcTC(), clienteDTO.getTipoTC());
	
	
			mapCliente.put(cliente.getDni(), cliente);

		}
	
	/**
	 * Busca un cliente por su ID (DNI), primero en memoria y luego en la base de datos.
	 * @param dni El dni del cliente a buscar
	 * @return El objeto cliente, Null si no existe.
	 */
	public Cliente buscarCliente(String dni){

		Cliente cliente = this.mapCliente.get(dni);
		if (cliente==null){ 
			ClienteDTO clienteDTO = dal.buscarCliente(dni);

			if (clienteDTO != null) {
				cliente=new Cliente(clienteDTO.getDni(), clienteDTO.getNombreyApellidos(), clienteDTO.getDireccion(), 
						clienteDTO.getPoblacion(), clienteDTO.getCodPostal(),clienteDTO.getFechaCanetConducir(),
						clienteDTO.getDigitosTC(),clienteDTO.getMesTC(), clienteDTO.getAñoTC(), 
						clienteDTO.getCvcTC(), clienteDTO.getTipoTC());
				this.mapCliente.put(dni, cliente);
				}
		}
	return cliente;

	}


	/**
	 * Carga desde la base de datos las reservas de una sucursal.
	 * @param idSucursal La ID de la sucursal.
	 */
	public void cargarReservas(int idSucursal) {
		List<ReservaDTO> listaresDTO = dal.obtenerReservas(idSucursal);
		//System.out.println(listaresDTO);
		// Crear y añadir todas las Reservas a la colección
		for (ReservaDTO reservaDTO : listaresDTO) {
			anyadirReserva(new Reserva(reservaDTO.getId(),reservaDTO.getFechaDevolucion(),reservaDTO.getFechaRecogida(),
					reservaDTO.getModalidadAlquiler(), buscarCategoria(reservaDTO.getNombreCategoria()),(reservaDTO.getDniCliente()),(reservaDTO.getIdSucursalRecogida()),(reservaDTO.getIdSucursalDevolucion())
					));
		}
	}

	/**
	 * Carga desde la base de datos los coches de una sucursal.
	 * @param idSucursal La ID de la sucursal.
	 */
	public void cargarCoches(int idSucursal){
		List<CocheDTO> listaresDTO = dal.obtenerCoches(idSucursal);
		for (CocheDTO cocheDTO : listaresDTO) {
			//if (!consultar_coche(cocheDTO.getMatricula()))
			anyadirCoche(new Coche(cocheDTO.getMatricula(), cocheDTO.getKmsActuales(),cocheDTO.getSucursal(),cocheDTO.getCategoria(),cocheDTO.getNombre()
					));
		}
	}	
	/**
	 * Carga todos los clientes desde la base de datos.
	 */
	public void cargarClientes(){
		List<ClienteDTO> listaresDTO = dal.obtenerClientes();
		for (ClienteDTO clienteDTO : listaresDTO) {
			anyadirCliente(new Cliente(clienteDTO.getDni(), clienteDTO.getNombreyApellidos(), clienteDTO.getDireccion(),clienteDTO.getPoblacion(),clienteDTO.getCodPostal(),clienteDTO.getFechaCanetConducir(), clienteDTO.getDigitosTC(),clienteDTO.getMesTC(),clienteDTO.getAñoTC(),clienteDTO.getCvcTC(),clienteDTO.getTipoTC()
					));
		}
	}
	/**
	 * Carga todas las entregas desde la base de datos.
	 */
	public void cargarEntregas(){
		List<EntregaDTO> listaresDTO = dal.obtenerEntregas();
		for (EntregaDTO entregaDTO : listaresDTO) {
			anyadirEntrega(new Entrega(entregaDTO.getId(), entregaDTO.getFecha(), entregaDTO.getTipoSeguro(), entregaDTO.getKms(), entregaDTO.getCombustible(), entregaDTO.getCoche(), entregaDTO.getEmpleado()
					));
		}
	}
/*	public void cargarCoches(){
		List<CocheDTO> listaresDTO = dal.obtenerCoches();
		for (CocheDTO cocheDTO : listaresDTO) {
			if (!consultar_coche(cocheDTO.getMatricula()))
			anyadirCoche(new Coche(cocheDTO.getMatricula(), cocheDTO.getKmsActuales(), cocheDTO.getSucursal(),cocheDTO.getCategoria(),cocheDTO.getNombre()
					));
		}
	}*/
/**
 * LLama en serie a todos los métodos de carga de Categorías, Sucursales, Entregas y Coches.
 * Añade los datos en memoria para que estén disponibles para su uso.
 */
public void cargarSistema(){
		
		cargarCategorias();
		cargarSucursales();
		cargarEntregas();
		//cargarCoches();

	}
	/**
	 * Carga todas las categorías desde la base de datos a memoria.
	 */
	private void cargarCategorias() {
		List<CategoriaDTO> listacatDTO = dal.obtenerCategorias();
		// Crear y añadir todas las categorias a la colección
		for (CategoriaDTO catDTO : listacatDTO) {
			anyadirCategoria(new Categoria(catDTO.getNombre(),
			catDTO.getPrecioModIlimitada(), 
			catDTO.getPrecioModKms(),
			catDTO.getPrecioKMModKms(), 
			catDTO.getPrecioSeguroTRiesgo(), 
			catDTO.getPrecioSeguroTerceros(),
			catDTO.getNombreCategoriaSuperior()));
		}
		// Actualizar los enlaces que representan la relación “superior”
		for (CategoriaDTO catDTO : listacatDTO)
			if (catDTO.getNombreCategoriaSuperior() != null) 
				buscarCategoria(catDTO.getNombre()).setSuperior(catDTO.getNombreCategoriaSuperior());
		}
	/**
	 * Carga todas las Sucursales desde la base de datos a memoria.
	 */
	private void cargarSucursales() {
		List<SucursalDTO> listasucDTO = dal.obtenerSucursales();
		// Crear y añadir todas las sucursales a la colección
		for (SucursalDTO sucDTO : listasucDTO) {
			anyadirSucursal(new Sucursal(sucDTO.getId(),
			sucDTO.getDireccion()));
		}
	}
	/**
	 * Carga todas las reservas desde la base de datos a memoria.
	 */
	public void cargarReservas() {
		List<ReservaDTO> listaresDTO = dal.obtenerReservas();
		for (ReservaDTO reservaDTO : listaresDTO) {
			anyadirReserva(new Reserva(reservaDTO.getId(),reservaDTO.getFechaDevolucion(),reservaDTO.getFechaRecogida(),
					reservaDTO.getModalidadAlquiler(), buscarCategoria(reservaDTO.getNombreCategoria()),(reservaDTO.getDniCliente()),(reservaDTO.getIdSucursalRecogida()),(reservaDTO.getIdSucursalDevolucion())
					));
		}
	}
}