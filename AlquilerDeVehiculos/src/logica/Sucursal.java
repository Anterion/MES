package logica;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Lois
 * Clase sucursal, representa los lugares donde se alquilan y devuelven vehículos. Donde trabajan los empleados.
 */
public class Sucursal {

	private int id;
	private String direccion;
	private AlquilerVehiculos alquiler;
	private List<Coche> listaCoche;
	private List<Reserva> reservaRecogida;
	private List<Reserva> reservaDevolucion;
	private List<Empleado> listaEmpleados;
	
	
	/**
	 * Constructor de sucursal.
	 * @param id ID de la sucursal.
	 * @param direccion Dirección física de la sucursal.
	 */
	public Sucursal(int id, String direccion) {
		setId(id);
		setDireccion(direccion);
		setListaCoche(new ArrayList<Coche>());
		setListaEmpleados(new ArrayList<Empleado>());
		setReservaDevolucion(new ArrayList<Reserva>());
		setReservaRecogida(new ArrayList<Reserva>());
	}
	/**
	 * Obtiene la dirección de la sucursal.
	 * @return La dirección de la sucursal.
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Establece la dirección de la sucursal.
	 * @param direccion La direcciónd de la sucursal.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Obttiene la clase Singleton AlquilerVehiculos.
	 * @return El singleton AlquilerVehiculos.
	 */
	public AlquilerVehiculos getAlquiler() {
		return alquiler;
	}
	/**
	 * Establece la clase Singleton AlquilerVehiculos.
	 * @param alquiler
	 */
	public void setAlquiler(AlquilerVehiculos alquiler) {
		this.alquiler = alquiler;
	}
	/**
	 * Obtiene la lista de coches disponibles en esta sucursal.
	 * @return La lista de coches disponibles en esta sucursal.
	 */
	public List<Coche> getListaCoche() {
		return listaCoche;
	}
	/**
	 * Establece la lista de coches disponibles en esta sucursal.
	 * @param listaCoche La nueva lista ded coches disponibles.
	 */
	public void setListaCoche(List<Coche> listaCoche) {
		this.listaCoche = listaCoche;
	}
	/**
	 * Obtiene la lista de empleados que trabajan en esta sucursal.
	 * @return La lista de empleados de esta sucursal.
	 */
	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	/**
	 * Establece la lista de empleados de esta sucursal.
	 * @param listaEmpleado La nueva lista de empleados.
	 */
	public void setListaEmpleados(List<Empleado> listaEmpleado) {
		this.listaEmpleados = listaEmpleado;
	}
	/**
	 * Obtiene la lista de reservas que han sido recogidas en esta sucursal.
	 * @return La lista de reservas.
	 */
	public List<Reserva> getReservaRecogida() {
		return reservaRecogida;
	}
	/**
	 * Establece la lisrta de reservas que han sido recogidas en esta sucursal. 
	 * @param reservaRecogida La nueva lista de reservas.
	 */
	public void setReservaRecogida(List<Reserva> reservaRecogida) {
		this.reservaRecogida = reservaRecogida;
	}
	/**
	 * Obtiene la lista de Reservas que han sido revueltas en esta sucursal.
	 * @return La lista de reservas
	 */
	public List<Reserva> getReservaDevolucion() {
		return reservaDevolucion;
	}
	/**
	 * Establece la lista de reservas que han sido devueltas en esta sucursal.
	 * @param reservaDevolucion La nueva lista de reservas.
	 */
	public void setReservaDevolucion(List<Reserva> reservaDevolucion) {
		this.reservaDevolucion = reservaDevolucion;
	}
	/**
	 * Obtiene el ID de la sucursal.
	 * @return El ID de la sucursal.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el Id de la sucursal.
	 * @param id El nuevo Id
	 */
	public void setId(int id) {
		this.id = id;
	}

}