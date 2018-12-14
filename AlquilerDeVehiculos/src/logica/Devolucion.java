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
	 * Constructor de la clase Devoluci�n
	 * @param fecha Fecha de la devoluci�n.
	 * @param totalACobrar Precio total que se debe cobrar por el servicio.
	 * @param cobrado Precio que ya ha sido cobrado.
	 * @param kms Kil�metros que han sido recorridos por el Coche
	 * @param combustible litros de combustible gastados por el Coche.
	 * @param empleado el empleado que tramita la devoluci�n.
	 * @param entrega el objeto Entrega que inici� la transacci�n.
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
	 * Obtiene la fecha en la que se tramit� la devoluci�n
	 * @return La fecha de devoluci�n.
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Establece la fecha en la que se tramita la devoluci�n.
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
	 * Obtiene el n�mero de kil�metros que se ha recorrido durante el alquiler del veh�culo en esta transacci�n particular.
	 * @return El n�mero de kil�metros.
	 */
	public double getKms() {
		return kms;
	}
	/**
	 * Establece el n�mero de kil�metros que ha recorrido el veh�culo durante esta reserva.
	 * @param kms El n�mero de km.
	 */
	public void setKms(double kms) {
		this.kms = kms;
	}
	/**
	 * Obtiene los litros de combustible que se han gastado durante el periodo de uso del veh�culo en pr�stamo.
	 * @return Los litros de combustible gastados.
	 */
	public double getCombustible() {
		return combustible;
	}
	/**
	 * Establece los litros de combustible gastados durante el pr�stamo del veh�culo.
	 * @param combustible Los litros de combuistible gastados.
	 */
	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}
	/**
	 * Obtiene el objeto entrega que inici� este pr�stamo.
	 * @return El objeto entrega.
	 */
	public Entrega getEntrega() {
		return entrega;
	}
	/**
	 * Establece el objeto Entrega que inicia el pr�stamo.
	 * @param entrega El objeto entrega.
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	/**
	 * Obtiene el empleado que tramita la devoluci�n.
	 * @return El empleado que tramita la devoluci�n.
	 */
	public Empleado getEmpleado() {
		return empleado;
	}
	/**
	 * Establece el empleado que tramita la devoluci�n.
	 * @param empleado El empleado que tramita la devoluci�n.
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	/**
	 * Obtiene la lista de da�os que ha sufrido el veh�culo durante el pr�stamo.
	 * @return La lista de da�os.
	 */
	public List<Danyo> getListaDanyo() {
		return listaDanyo;
	}
	/**
	 * Establece la lista de da�os que ha sufrido el veh�culo durante el pr�stamo.
	 * @param listaDanyo
	 */
	public void setListaDanyo(List<Danyo> listaDanyo) {
		this.listaDanyo = listaDanyo;
	}
	/** 
	 * Obtiene la ID de esta devoluci�n.
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece la ID de esta devoluci�n.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
