package logica;

import java.util.List;


/**
 * @author Lois
 * Clase empleado, contiene los atributos de los empleados de la empresa de alquiler.
 */
public class Empleado {

	private int id;
	private String nombre;
	private boolean	administrador; 
	private Sucursal sucursal;
	private List<Entrega> listaEntrega;
	private List<Devolucion> listaDevolucion;
	
	/**
	 * Constructor de la clase empleado.
	 * @param id El ID (DNI) del empleado
	 * @param nombre El Nombre del empleado.
	 * @param administrador Si es administrador(true) o empleado normal (false)
	 * @param sucursal La sucursal en la que trabaja
	 * @param listaEntrega La lista de entregas que ha realizado
	 * @param listaDevolucion La lista de devoluciones que ha tramitado.
	 */
	public Empleado(int id, String nombre, boolean administrador, Sucursal sucursal, List<Entrega> listaEntrega, List<Devolucion> listaDevolucion){
		setId(id);
		setNombre(nombre);
		setAdministrador(administrador);
		setSucursal(sucursal);
		setListaEntrega(listaEntrega);
		setListaDevolucion(listaDevolucion);
	}
	
	/**
	 * Obtiene el nombre del empleado.
	 * @return El nombre del empleado.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre del empleado.
	 * @param nombre El nuevo nombre del empleado.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Comprueba si es administrador.
	 * @return True si es administrador, owise False.
	 */
	public boolean isAdministrador() {
		return administrador;
	}
	/**
	 * Establece la propiedad administrador.
	 * @param administrador El estado del empleado, true si es administrador, owise false.
	 */
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	/**
	 * Obtiene la sucursal en la que trabaja el empleado.
	 * @return El objeto sucursal.
	 */
	public Sucursal getSucursal() {
		return sucursal;
	}
	/**
	 * Establece la sucursal en la que treabaja el empleado.
	 * @param sucursal
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * Obtiene la lista de entregas que ha realizado este empleado.
	 * @return La lista de entregas de esta empleado.
	 */
	public List<Entrega> getListaEntrega() {
		return listaEntrega;
	}
	/**
	 * Establece la lista de entregas de este empleado.
	 * @param listaEntrega La nueva lista de entregas
	 */
	public void setListaEntrega(List<Entrega> listaEntrega) {
		this.listaEntrega = listaEntrega;
	}
	/**
	 * Obtiene la lista de devoluciones tramitadas por este empleado.
	 * @return La lista de devoluciones.
	 */
	public List<Devolucion> getListaDevolucion() {
		return listaDevolucion;
	}
	/**
	 * Establece la lista de devoluciones de este empleado.
	 * @param listaDevolucion La nueva lista de devoluciones.
	 */
	public void setListaDevolucion(List<Devolucion> listaDevolucion) {
		this.listaDevolucion = listaDevolucion;
	}
	/**
	 * Obtiene la ID del empleado ( su DNI )
	 * @return El dni del empleado.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece la ID del empleado
	 * @param id El nuevo ID del empleado.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
