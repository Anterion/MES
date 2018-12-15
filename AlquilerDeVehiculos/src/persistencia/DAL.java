package persistencia;

import excepciones.DAOExcepcion;

import java.util.*;

import persistencia.dto.*;


/**
 * @author Lois
 * Clase Data Acess Layer. Proporciona aceso simplificado a los datos de la base de datos SQL, hace todas las operaciones CRUD de forma transparente.
 */
public class DAL {
	
	private static DAL instancia;
	private ICategoriaDAO categoriaDAO;
	private ISucursalDAO sucursalDAO;
	private IReservaDAO reservaDAO;
	private IClienteDAO clienteDAO;
	private ICocheDAO cocheDAO;
	private IEntregaDAO entregaDAO;
	
	/**
	 * Constructor, inicializa los objetos de acceso a los datos.
	 * @throws DAOExcepcion
	 */
	public DAL() throws DAOExcepcion{
			categoriaDAO = new CategoriaDAOImp();
			sucursalDAO = new SucursalDAOImp();
			clienteDAO = new ClienteDAOImp();
			reservaDAO = new ReservaDAOImp();
			cocheDAO = new CocheDAOImp();
			entregaDAO = new EntregaDAOImp();
	}
	/**
	 * Obtiene las reservas de una sucursal.
	 * @param idSucursal Id de la sucursal en cuestión.
	 * @return La lista de reservas.
	 */
	public List<ReservaDTO> obtenerReservas(int idSucursal) {
		try {
		return reservaDAO.obtenerReservasPorSucursalOrigen(idSucursal);
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	/**
	 * Obtiene la lista de todas las reservas que existen.
	 * @return La lista de reservad.
	 */
	public List<ReservaDTO> obtenerReservas() {
		try {
		return reservaDAO.obtenerReservas();
		} catch (DAOExcepcion e) {
		return null;
		}
	}

	/**
	 * Obtiene la lista de coches de una sucursal.
	 * @param idSucursal El ID de la sucursal.
	 * @return La lista de coches de la sucursal.
	 */
	public List<CocheDTO> obtenerCoches(int idSucursal) {
		try {
		return cocheDAO.obtenerCoches(idSucursal);
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	/*public List<CocheDTO> obtenerCoches() {
		try {
		return cocheDAO.obtenerCoches();
		} catch (DAOExcepcion e) {
		return null;
		}
	}*/
	/**
	 * Obtiene la lista de todos los clientes que existen.
	 * @return La lista de clientes.
	 */
	public List<ClienteDTO> obtenerClientes() {
		try {
		return clienteDAO.obtenerClientes();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	/**
	 * Obtiene la lista de todas las sucursales que existen.
	 * @return La lista de sucursales.
	 */
	public List<SucursalDTO> obtenerSucursales() {
		try {
		return sucursalDAO.obtenerSucursales();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	
	/**
	 * Obtiene la lista de todas las entregas que existen
	 * @return La lista de entregas.
	 */
	public List<EntregaDTO> obtenerEntregas() {
		try {
		return entregaDAO.obtenerEntregas();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	
	/**
	 * Obtiene la lista de todas las categorías que existen.
	 * @return La lista de categorías.
	 */
	public List<CategoriaDTO> obtenerCategorias() {
		try {
		return categoriaDAO.obtenerCategorias();
		} catch (DAOExcepcion e) {
		return null;
		}
	}
	/**
	 * Crea una nueva categoría.
	 * @param c La nueva categoría.
	 */
	public void crearCategoria (CategoriaDTO c){
		try {
			categoriaDAO.crearCategoria(c);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	/**
	 * Crea una nueva sucursal.
	 * @param s El objeto sucursal a añadir
	 */
	public void crearSucursal(SucursalDTO s){
		try {
			sucursalDAO.crearSucursal(s);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	/**
	 * Crea un nuevo cliente.
	 * @param c El objeto cliente a añadir.
	 */
	public void crearCliente(ClienteDTO c) {
	
		try {
			clienteDAO.crearCliente(c);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
	/**
	 * Crea una nueva entrega.
	 * @param en El objeto Entrega a añadir.
	 */
	public void crearEntrega(EntregaDTO en) {
		
		try {
			entregaDAO.crearEntrega(en);
		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
	}
    /**
     * Crea una nueva reserva.
     * @param reserva El objeto reserva a añadir.
     */
    public void crearReserva(ReservaDTO reserva) {
    	try {
    		reservaDAO.crearReserva(reserva);
    	}catch (DAOExcepcion e) {
    		e.printStackTrace();
    	}
    }
    /**
     * Busca un cliente por su ID (dni)
     * @param dni El ID(dni) del cliente a buscar
     * @return
     */
    public ClienteDTO buscarCliente(String dni) {
    	try {
    		return clienteDAO.buscarCliente(dni);
    	} catch (DAOExcepcion e) {
    		return null;
    	}	
    }
    /**
     * Busca una sucursal por su ID
     * @param id El ID de la sucursal a buscar
     * @return
     */
    public SucursalDTO buscarSucursal(int id) {
    	try {
    		return sucursalDAO.buscarSucursal(id);
    	} catch (DAOExcepcion e) {
    		return null;
    	}
    }
	//PATRON SINGLETON
	/**
	 * Constructor Singleton del DAL
	 * @throws DAOExcepcion Lanzada cuando no se puede crear el objeto.
	 */
	private static void crearDAL() throws DAOExcepcion {
	        if (instancia == null) { 
	            instancia = new DAL();
	        }
	    }

    /**
     * Obtiene la instancia del singleton
     * @return
     * @throws DAOExcepcion Lanzada cuando no se puede acceder al objeto.
     */
    public static DAL getDAL() throws DAOExcepcion {
	        if (instancia == null) crearDAL();
	        return instancia;
	 }

}

