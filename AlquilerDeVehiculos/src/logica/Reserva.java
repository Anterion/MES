package logica;

import java.time.LocalDateTime;


/**
 * @author Lois
 * Clase reserva, representa la reserva de un cliente en una sucursal.
 */
public class Reserva {

	private int id;
	private LocalDateTime fechaRecogida;
	private LocalDateTime fechaDevolucion;
	private int modalidadAlquiler;
	private Sucursal sucursalRecogida;
	private Sucursal sucursalDevolucion;
	private Entrega entrega;
	private Cliente cliente;
	private AlquilerVehiculos alquilerVehiculos; 
	private Categoria categoria;
	private String dniCliente;
	private int idSucursalDevolucion;
	private int idSucursalRecogida;
	private String nombreReserva;
	
	
	/**
	 * Constructor de la clase Reserva
	 * @param id La clave de la reserva.
	 * @param fechaRecogida Fecha de recogida del veh�culo.
	 * @param fechaDevolucion Fecha de devoluci�n del veh�culo.
	 * @param modalidadAlquiler Modalidad de alquiler del veh�culo.
	 * @param categoria Categor�a de alquiler del veh�culo.
	 * @param dniCliente Dni del cliente que solicita la reserva.
	 * @param idSucursalRecogida ID de la sucursal de recogida del veh�culo.
	 * @param idSucursalDevolucion ID de la sucursal de devoluci�n del veh�culo.
	 */
	public Reserva(int id, LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion, int modalidadAlquiler, Categoria categoria, String dniCliente ,int idSucursalRecogida, int idSucursalDevolucion) {
		setId(id);
		setFechaRecogida(fechaRecogida);
		setFechaDevolucion(fechaDevolucion);
		setModalidadAlquiler(modalidadAlquiler);
		setCategoria(categoria);
		setIdSucursalRecogida(idSucursalRecogida);
		setIdSucursalDevolucion(idSucursalDevolucion);
		setDniCliente(dniCliente);		
		setCliente(AlquilerVehiculos.getAlquilerVehiculos().buscarCliente(getDniCliente()));
		setCategoria(categoria);
		setSucursalDevolucion(AlquilerVehiculos.getAlquilerVehiculos().buscarSucursal(getIdSucursalDevolucion()));
		setSucursalRecogida(AlquilerVehiculos.getAlquilerVehiculos().buscarSucursal(getIdSucursalRecogida()));
	
	}

	/**
	 * Obtiene la fecha de recogida del veh�culo.
	 * @return La fecha de recogida del veh�culo.
	 */
	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}
	/**
	 * Establece la fecha de recogida del veh�culo.
	 * @param fechaRecogida Establece la fecha de recogida del veh�culo.
	 */
	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
	/**
	 * Obtiene la fecha de devoluci�n del veh�culo.
	 * @return La fecha de devoluci�n del veh�culo.
	 */
	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}
	/**
	 * Establece la fecha de devoluci�n del veh�culo.
	 * @param fechaDevolucion La nuea fecha de devoluci�n del veh�culo.
	 */
	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	/**
	 * Obtiene la modalidad de alquiler deseada en la reserva.
	 * @return La modadlida de alquiler deseada.
	 */
	public int getModalidadAlquiler() {
		return modalidadAlquiler;
	}
	/**
	 * Establece la modalidad de alquiler de la reserva.
	 * @param modalidadAlquiler La nueva modalidad de alquiler.
	 */
	public void setModalidadAlquiler(int modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
	}
	/**
	 * Obtiene la sucursal de recogida del veh�culo en esta reserva.
	 * @return El Objeto sucursal de recogida.
	 */
	public Sucursal getSucursalRecogida() {
		return sucursalRecogida;
	}
	/**
	 * Establece la sucursal de recogida del veh�culo en esta reserva.
	 * @param sucursalRecogida La nueva sucursal de recogida.
	 */
	public void setSucursalRecogida(Sucursal sucursalRecogida) {
		this.sucursalRecogida = sucursalRecogida;
	}
	/**
	 * Obtiene la sucursal de devoluci�n del veh�culo en esta reserva.
	 * @return El objeto sucursal de devoluci�n.
	 */
	public Sucursal getSucursalDevolucion() {
		return sucursalDevolucion;
	}
	/**
	 * Establece la sucursal de devoluci�n del veh�culo en esta reserva.
	 * @param sucursalDevolucion La nueva sucursal de devoluci�n de la reserva.
	 */
	public void setSucursalDevolucion(Sucursal sucursalDevolucion) {
		this.sucursalDevolucion = sucursalDevolucion;
	}
	/**
	 * Obtiene el objeto entrega asociado a este tr�mite de reserva.
	 * @return El objeto entrega
	 */
	public Entrega getEntrega() {
		return entrega;
	}
	/**
	 * Establece el objeto entrega asociado a este tr�mite de reserva.
	 * @param entrega
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	/**
	 * Obtiene el cliente que solicita la reserva.
	 * @return El Objeto cliente que solicita.
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * Establece el clientee que solicita la reserva.
	 * @param Cliente El objeto cliente que solicita.
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * Obtiene la clase Singleton de AlquilerVehiculos.
	 * @return El Singleton AlquilerdeVehiculos.
	 */
	public AlquilerVehiculos getAlquilerVehiculos() {
		return alquilerVehiculos;
	}
	/**
	 * Establece el Singleton AlquilerVeh�culos.
	 * @param alquilerVehiculos
	 */
	public void setAlquilerVehiculos(AlquilerVehiculos alquilerVehiculos) {
		this.alquilerVehiculos = alquilerVehiculos;
	}
	/**
	 * Obtiene la categor�a de la reserva.
	 * @return La categor�a de la reserva.
	 */
	public Categoria getCategoria() {
		
		return categoria;
	}
	/**
	 * Establece la categor�a de la reserva actual.
	 * @param categoria La nueva categor�a de reserva.
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	/**
	 * Obtiene el ID de la reserva.
	 * @return El Id de la reserva actual.
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
	 * Obtiene el DNI del cliente que ha realizado la reserva.
	 * @return El DNI del cliente que ha realizado la reserva.
	 */
	public String getDniCliente() {
		return dniCliente;
	} 
	/**
	 * Establece el DNI del cliente que ha realizado la reserva.
	 * @param dniCliente El DNI del nuevo cliente.
	 */
	public void setDniCliente(String dniCliente) {
		this.dniCliente=dniCliente;
	}
	/**
	 * Obtiene el ID de la sucursal de devoluci�n del veh�culo.
	 * @return El ID de la sucursal de devoluci�n.
	 */
	public int getIdSucursalDevolucion() {
		return idSucursalDevolucion;
	}
	/**
	 * Establece el ID de la sucursal de devoluci�n.
	 * @param idSucursalDevolucion El nuevo ID de la sucursal.
	 */
	public void setIdSucursalDevolucion(int idSucursalDevolucion) {
		this.idSucursalDevolucion = idSucursalDevolucion;
	}
	/**
	 * Obtiene el ID de la sucursal de recogida.
	 * @return El ID de la sucursal de recogida.
	 */
	public int getIdSucursalRecogida() {
		return idSucursalRecogida;
	}
	/**
	 * Establece el ID de la sucursal de recogida.
	 * @param idSucursalRecogida El ID de la sucursal de recogida.
	 */
	public void setIdSucursalRecogida(int idSucursalRecogida) {
		this.idSucursalRecogida = idSucursalRecogida;
	}
	/**
	 * Obtiene el nombre de la reserva.
	 * @return El nombre de la reserva.
	 */
	public String getNombreReserva() {
		return nombreReserva;
	}
	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
	}
}