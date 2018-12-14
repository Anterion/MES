package persistencia.dto;

import java.time.LocalDateTime;

/**
 * @author Lois
 * Data transfer object de Reserva. Utilizada para generar las tablas SQL.
 */
public class ReservaDTO {
	private int id;
	private LocalDateTime fechaRecogida;
	private LocalDateTime fechaDevolucion;
	private int modalidadAlquiler;
	private String dniCliente;
	private String nombreCategoria;
	private int idSucursalRecogida;
	private int idSucursalDevolucion;
	
	/**
	 * El constructor de Reserva.
	 * @param id ID de la entrega.
	 * @param fechaRecogida Fecha de recogida del coche.
	 * @param fechaDevolucion Fecha de devoluci�n del coche
	 * @param modalidadAlquiler Modalidad de alquiler del coche, puede 0 = por km, 1 = ilimitado.
	 * @param dniCliente Dni del cliente que realiza la reeserva.
	 * @param nombreCategoria Nombre de la categor�a que desea el cliente.
	 * @param idSucursalRecogida Id de la sucursal en la que se recoge el veh�culo.
	 * @param idSucursalDevolucion Id de la sucursal en la que se devuelve el veh�culo.
	 */
	public ReservaDTO(int id, LocalDateTime fechaRecogida,
			LocalDateTime fechaDevolucion, int modalidadAlquiler,
			String dniCliente, String nombreCategoria, int idSucursalRecogida,
			int idSucursalDevolucion) {
		setId(id);
		setFechaRecogida(fechaRecogida);
		setFechaDevolucion(fechaDevolucion);
		setModalidadAlquiler(modalidadAlquiler);
		setDniCliente(dniCliente);
		setNombreCategoria(nombreCategoria);
		setIdSucursalRecogida(idSucursalRecogida);
		setIdSucursalDevolucion(idSucursalDevolucion);
	}

	/**
	 * Obtiene el ID de la reserva.
	 * @return ID de reserva.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el ID de la reserva.
	 * @param id El nuevo ID de la reserva.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene la fecha de recogida del coche establecido en la reserva.
	 * @return La fecha ded recogida.
	 */
	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}
	/**
	 * Establece una nueva fecha de recogida para la reserva.
	 * @param fechaRecogida La nueva fecha de recogida.
	 */
	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
	/**
	 * Obtiene la fecha de devoluci�n del veh�culo.
	 * @return La susodicha fecha de devoluci�n.
	 */
	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}
	/**
	 * Establece una fecha de devoluci�n para el veh�culo.
	 * @param fechaDevolucion La nueva fecha de decoluci�n.
	 */
	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	/**
	 * Obtiene la modalidad de alquiler del veh�culo en esta reserva.
	 * @return La modalidad de alquiler, 0 = Por km, 1 = ilimitado
	 */
	public int getModalidadAlquiler() {
		return modalidadAlquiler;
	}
	/**
	 * Establecec la modadlidad de alquiler del veh�culo.
	 * @param modalidadAlquiler La modalidad de alquiler, 0 = por km, 1= ilimitado
	 */
	public void setModalidadAlquiler(int modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
	}
	/**
	 * Obtiene el DNI del cliente que realiza la reserva.
	 * @return El DNI del cliente.
	 */
	public String getDniCliente() {
		return dniCliente;
	}
	/**
	 * Establece el DNI del cliente que realiza la reserva.
	 * @param dniCliente El dni del cliente.
	 */
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	/**
	 * Obtiene el nombre de la categor�a de reserva
 	 * @return El nombre de la categor�a.
	 */
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	/**
	 * Establece el nombre de la categor�a de reserva.
	 * @param nombreCategoria El nuevo nombre de categor�a.
	 */
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	/**
	 * Obtiene el ID de la sucursal de recogida del coche.
	 * @return EL ID de la sucursal de recogida.
	 */
	public int getIdSucursalRecogida() {
		return idSucursalRecogida;
	}
	/**
	 * Establece el ID de sucursal de recogida del coche.
	 * @param idSucursalRecogida El ID de la nueva sucursal de recogida.
	 */
	public void setIdSucursalRecogida(int idSucursalRecogida) {
		this.idSucursalRecogida = idSucursalRecogida;
	}
	/**
	 * Obtiene el ID de la sucursal de devoluci�n del coche.
	 * @return El ID de la sucursal de devoluci�n.
	 */
	public int getIdSucursalDevolucion() {
		return idSucursalDevolucion;
	}
	/**
	 * Establece el ID de la sucursal de devoluci�n del coche.
	 * @param idSucursalDevolucion El ID de la nueva sucursal ded devoluci�n.
	 */
	public void setIdSucursalDevolucion(int idSucursalDevolucion) {
		this.idSucursalDevolucion = idSucursalDevolucion;
	}		
}