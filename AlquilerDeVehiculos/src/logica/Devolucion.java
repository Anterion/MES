package logica;

import java.util.ArrayList;
import java.util.List;


public class Devolucion {

	private int id;
	private String fecha;
	private double totalACobrar;
	private double cobrado;
	private double kms;
	private double combustible;
	private Entrega entrega;
	private Empleado empleado;
	private List<Danyo> listaDanyo;
	
	/**
	 * Constructor de la clase Devolución
	 * @param fecha Fecha de la devolución.
	 * @param totalACobrar Precio total que se debe cobrar por el servicio.
	 * @param cobrado Precio que ya ha sido cobrado.
	 * @param kms Kilómetros que han sido recorridos por el Coche
	 * @param combustible litros de combustible gastados por el Coche.
	 * @param empleado el empleado que tramita la devolución.
	 * @param entrega el objeto Entrega que inició la transacción.
	 */
	public Devolucion(String fecha, double totalACobrar, double cobrado,
			double kms, double combustible, Empleado empleado, Entrega entrega
			) {
		super();
		setFecha(fecha);
		setTotalACobrar(totalACobrar);
		setCobrado(cobrado);
		setKms(kms);
		setEmpleado(empleado);
		setEntrega(entrega);
		setListaDanyo(new ArrayList<Danyo>());
	}

	/**
	 * Obtiene la fecha en la que se tramitó la devolución
	 * @return La fecha de devolución.
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Establece la fecha en la que se tramita la devolución.
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * El precio total que se debe cobrar por el servicio prestado.
	 * @return El precio que se debe cobrar.
	 */
	public double getTotalACobrar() {
		return totalACobrar;
	}
	/**
	 * Establece el precio que se debe cobrar por el servicio prestado.
	 * @param totalACobrar El total que se debe cobrar.
	 */
	public void setTotalACobrar(double totalACobrar) {
		this.totalACobrar = totalACobrar;
	}
	/**
	 * Obtiene el precio que ya se ha cobrado al cliente.
	 * @return El precio que ya se ha cobrado al cliente.
	 */
	public double getCobrado() {
		return cobrado;
	}
	/**
	 * Establece el precio que ya se ha cobrado al cliente.
	 * @param cobrado
	 */
	public void setCobrado(double cobrado) {
		this.cobrado = cobrado;
	}
	/**
	 * Obtiene el número de kilómetros que se ha recorrido durante el alquiler del vehículo en esta transacción particular.
	 * @return El número de kilómetros.
	 */
	public double getKms() {
		return kms;
	}
	/**
	 * Establece el número de kilómetros que ha recorrido el vehículo durante esta reserva.
	 * @param kms El número de km.
	 */
	public void setKms(double kms) {
		this.kms = kms;
	}
	/**
	 * Obtiene los litros de combustible que se han gastado durante el periodo de uso del vehículo en préstamo.
	 * @return Los litros de combustible gastados.
	 */
	public double getCombustible() {
		return combustible;
	}
	/**
	 * Establece los litros de combustible gastados durante el préstamo del vehículo.
	 * @param combustible Los litros de combuistible gastados.
	 */
	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}
	/**
	 * Obtiene el objeto entrega que inició este préstamo.
	 * @return El objeto entrega.
	 */
	public Entrega getEntrega() {
		return entrega;
	}
	/**
	 * Establece el objeto Entrega que inicia el préstamo.
	 * @param entrega El objeto entrega.
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	/**
	 * Obtiene el empleado que tramita la devolución.
	 * @return El empleado que tramita la devolución.
	 */
	public Empleado getEmpleado() {
		return empleado;
	}
	/**
	 * Establece el empleado que tramita la devolución.
	 * @param empleado El empleado que tramita la devolución.
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	/**
	 * Obtiene la lista de daños que ha sufrido el vehículo durante el préstamo.
	 * @return La lista de daños.
	 */
	public List<Danyo> getListaDanyo() {
		return listaDanyo;
	}
	/**
	 * Establece la lista de daños que ha sufrido el vehículo durante el préstamo.
	 * @param listaDanyo
	 */
	public void setListaDanyo(List<Danyo> listaDanyo) {
		this.listaDanyo = listaDanyo;
	}
	/** 
	 * Obtiene la ID de esta devolución.
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece la ID de esta devolución.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
