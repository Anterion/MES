package logica;

import java.time.LocalDateTime;


public class Cliente {

	private String dni;
	private String nombreyApellidos;
	private String direccion;
	private String poblacion;
	private String codPostal;
	private LocalDateTime fechaCarnetConducir;
	private String digitosTC;
	private int mesTC;
	private int anyoTC;
	private int cvcTC;
	private String tipoTC;
	/**
	 * Constructor de la clase cliente
	 * @param dni El dni del cliente
	 * @param nombreyApellidos Su nombre y apellidos.
	 * @param direccion La direcci�n postal del cliente.
	 * @param poblacion La poblaci�n del cliente.
	 * @param codPostal El c�digo postal de esta poblaci�n.
	 * @param fechaCarnetConducir La fecha de obtenci�n del carnet de conducir.
	 * @param digitosTC D�gitos de la tarjeta de cr�dito del cliente.
	 * @param mesTC Mes de caducidad de la tarjeta de cr�dito.
	 * @param anyoTC A�o de caducidad de la tarjeta de cr�dito.
	 * @param cvcTC C�digo cvc de la tarheta de cr�dito.
	 * @param tipoTC Tipo de tarjeta de cr�dito (visa, mastercard, etc).
	 */
	public Cliente(String dni, String nombreyApellidos, String direccion, String poblacion, String codPostal, LocalDateTime fechaCarnetConducir, String digitosTC,
			int mesTC, int anyoTC, int cvcTC, String tipoTC) {
		
		setDni(dni);
		setNombreyApellidos(nombreyApellidos);
		setDireccion(direccion);
		setPoblacion(poblacion);
		setCodPostal(codPostal);
		setFechaCarnetConducir(fechaCarnetConducir);
		setDigitosTC(digitosTC);
		setMesTC(mesTC);
		setAnyoTC(anyoTC);
		setCvcTC(cvcTC);
		setTipoTC(tipoTC);
	}
	
	
	/**
	 * Obtiene el nombre y apellidos del cliente.
	 * @return Nombre y apellidos del cliente
	 */
	public String getNombreyApellidos() {
		return nombreyApellidos;
	}
	/**
	 * Establece el nombre y apellidos del cliente.
	 * @param nombreyApellidos El nombre y apellidos del cliente
	 */
	public void setNombreyApellidos(String nombreyApellidos) {
		this.nombreyApellidos = nombreyApellidos;
	}
	/**
	 * Obtiene la direcci�n del cliente. 
	 * @return La direcci�n del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Establece la direcci�n del cliente.
	 * @param direccion La nueva direcci�n del cliente.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Obtiene la poblaci�n del cliente.
	 * @return La poblaci�n en la que reside el cliente.
	 */
	public String getPoblacion() {
		return poblacion;
	}
	/**
	 * Establece la poblaci�n del cliente.
	 * @param poblacion La nueva poblaci�n del cliente.
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	/**
	 * Obtiene el c�digo postal del cliente.
	 * @return El c�digo postal del cliente.
	 */
	public String getCodPostal() {
		return codPostal;
	}
	/**
	 * Establece el c�digo postal del cliente
	 * @param codPostal El nuevo c�digo postal del cliente.
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	/**
	 * Obtiene la fecha de obtenci�n del carnet de conducir.
	 * @return La fecha de obtenci�n del carnet.
	 */
	public LocalDateTime getFechaCarnetConducir() {
		return fechaCarnetConducir;
	}
	/**
	 * Establece la fecha de obtenci�n del carnet de conducir.
	 * @param fechaCarnetConducir La fecha de obtenci�n del carnet de conducir.
	 */
	public void setFechaCarnetConducir(LocalDateTime fechaCarnetConducir) {
		this.fechaCarnetConducir = fechaCarnetConducir;
	}
	/**
	 * Obtiene el tipo de tarjeta de cr�dito.
	 * @return El tipo de tarjeta de cr�dito.
	 */
	public String getTipoTC() {
		return tipoTC;
	}
	/**
	 * Establece el tipo de la tarjeta de cr�dito.
	 * @param tipoTC El tipo de la tarjeta de cr�dito.
	 */
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
	}
	/**
	 * Obtiene los d�gitos de la tarjeta de cr�dito.
	 * @return
	 */
	public String getDigitosTC() {
		return digitosTC;
	}
	/**
	 * Establece los d�gitos de la tarjeta de cr�dito.
	 * @param digitosTC
	 */
	public void setDigitosTC(String digitosTC) {
		this.digitosTC = digitosTC;
	}
	/**
	 * Obtiene el mes de caducidad de la terjeta de cr�dito.
	 * @return El mes de caducidad de la tarjerta de cr�dito.
	 */
	public int getMesTC() {
		return mesTC;
	}
	/**
	 * Establece el mes de caducidad de la tarjeta de cr�dito.
	 * @param mesTC El nuevo mes de caducidad de la tarjeta de cr�dito.
	 */
	public void setMesTC(int mesTC) {
		this.mesTC = mesTC;
	}
	/**
	 * Obtiene el a�o de caducidad de la tarjeta de cr�dito.
	 * @return El a�o de caducidad.
	 */
	public int getAnyoTC() {
		return anyoTC;
	}
	/**
	 * Establece el a�o de caducidad de la tarjeta de cr�dito.
	 * @param anyoTC El a�o de caducidad de la tarjeta de cr�dito.
	 */
	public void setAnyoTC(int anyoTC) {
		this.anyoTC = anyoTC;
	}
	/**
	 * Obtiene el c�digo CVC de la tarjeta del cliente.
	 * @return C�digo CVC de la tarjeta.
	 */
	public int getCvcTC() {
		return cvcTC;
	}
	/**
	 * Establece el c�digo CVC de la tarjeta de cr�dito.
	 * @param cvcTC
	 */
	public void setCvcTC(int cvcTC) {
		this.cvcTC = cvcTC;
	}
	/**
	 * Obtiene el dni del cliente
	 * @return El Dni del cliente
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Establece el DNI del cliente
	 * @param dni el nuevo DNI
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	/*	public AlquilerVehiculos getAlquilerVehiculos() {
	return alquilerVehiculos;
	}
	public void setAlquilerVehiculos(AlquilerVehiculos alquilerVehiculos) {
		this.alquilerVehiculos = alquilerVehiculos;
	}*/
	/*public List<Reserva> getListaReserva() {
		return listaReserva;
	}
	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}*/
}
