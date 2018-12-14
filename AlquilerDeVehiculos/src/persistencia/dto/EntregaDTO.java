package persistencia.dto;

import java.time.LocalDateTime;


/**
 * @author Lois
 * Data transfer object de Entrega. Utilizada para generar las tablas SQL.
 */
public class EntregaDTO {
	private int id;
	private LocalDateTime fecha;
	private String tipoSeguro;
	private double kms;
	private double combustible;
	private String coche;
	private String empleado;

	
	/**
	 * Constructor de Entrega.
	 * @param id Id de la entrega
	 * @param fecha fecha de realización de la entrega
	 * @param tipoSeguro Tipo de seguro deseado.
	 * @param kms Kms recorridos
	 * @param combustible Litros de combustible utilizado
	 * @param coche Coche entregado.
	 * @param empleado Empleado que realiza la entrega
	 */
	public EntregaDTO(int id, LocalDateTime fecha, String tipoSeguro, double kms, double combustible, String coche, String empleado){
		setId(id);
		setFecha(fecha);
		setTipoSeguro(tipoSeguro);
		setKms(kms);
		setCombustible(combustible);
		setCoche(coche);
		setEmpleado(empleado);
	}
	
	/**
	 * Obtener la fecha de entrega del coche.
	 * @return La fecha de entrega.
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	/**
	 * Establece la fecha de entrega del coche.
	 * @param fecha La nueva fecha de entrega del coche.
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	/**
	 * Obtiene el tipo de seguro establecido en la reserva.
	 * @return El tipo de seguro.
	 */
	public String getTipoSeguro() {
		return tipoSeguro;
	}
	/**
	 * Establece el tipo de seguro de la entrega.
	 * @param tipoSeguro El tipo de seguro.
	 */
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	/**
	 * Obtiene el número de km recorridos.
	 * @return El numero de km recorridos.
	 */
	public double getKms() {
		return kms;
	}
	/**
	 * Establece los kms recorridos por el vehículo.
	 * @param kms
	 */
	public void setKms(double kms) {
		this.kms = kms;
	}
	/**
	 * Obtiene los litros de conbustible utilizados durante el uso del coche.
	 * @return
	 */
	public double getCombustible() {
		return combustible;
	}
	/**
	 * Establece los litros de combustible utilizados por el cliente
	 * @param combustible
	 */
	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}
	/**
	 * Obtiene el coche entregado.
	 * @return El coche entregado.
	 */
	public String getCoche() {
		return coche;
	}
	/**
	 * Establece el coche entregado.
	 * @param coche El coche entregado.
	 */
	public void setCoche(String coche) {
		this.coche = coche;
	}
	/**
	 * Obtiene el empleado que realiza la entrega
	 * @return El empleado que realiza la entrega.
	 */
	public String getEmpleado() {
		return empleado;
	}
	/**
	 * Establece el empleado que realiza la entrega.
	 * @param empleado El empleado que realiza la entrega.
	 */
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	/**
	 * Obtiene el identificador de esta entrega.
	 * @return ID de la entrega.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el identificador de la entrega.
	 * @param id El identificador de la entrega.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
