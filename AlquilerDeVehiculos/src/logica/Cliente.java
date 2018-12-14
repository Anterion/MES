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
	 * @param direccion La dirección postal del cliente.
	 * @param poblacion La población del cliente.
	 * @param codPostal El código postal de esta población.
	 * @param fechaCarnetConducir La fecha de obtención del carnet de conducir.
	 * @param digitosTC Dígitos de la tarjeta de crédito del cliente.
	 * @param mesTC Mes de caducidad de la tarjeta de crédito.
	 * @param anyoTC Año de caducidad de la tarjeta de crédito.
	 * @param cvcTC Código cvc de la tarheta de crédito.
	 * @param tipoTC Tipo de tarjeta de crédito (visa, mastercard, etc).
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
	 * Obtiene la dirección del cliente. 
	 * @return La dirección del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Establece la dirección del cliente.
	 * @param direccion La nueva dirección del cliente.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Obtiene la población del cliente.
	 * @return La población en la que reside el cliente.
	 */
	public String getPoblacion() {
		return poblacion;
	}
	/**
	 * Establece la población del cliente.
	 * @param poblacion La nueva población del cliente.
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	/**
	 * Obtiene el código postal del cliente.
	 * @return El código postal del cliente.
	 */
	public String getCodPostal() {
		return codPostal;
	}
	/**
	 * Establece el código postal del cliente
	 * @param codPostal El nuevo código postal del cliente.
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	/**
	 * Obtiene la fecha de obtención del carnet de conducir.
	 * @return La fecha de obtención del carnet.
	 */
	public LocalDateTime getFechaCarnetConducir() {
		return fechaCarnetConducir;
	}
	/**
	 * Establece la fecha de obtención del carnet de conducir.
	 * @param fechaCarnetConducir La fecha de obtención del carnet de conducir.
	 */
	public void setFechaCarnetConducir(LocalDateTime fechaCarnetConducir) {
		this.fechaCarnetConducir = fechaCarnetConducir;
	}
	/**
	 * Obtiene el tipo de tarjeta de crédito.
	 * @return El tipo de tarjeta de crédito.
	 */
	public String getTipoTC() {
		return tipoTC;
	}
	/**
	 * Establece el tipo de la tarjeta de crédito.
	 * @param tipoTC El tipo de la tarjeta de crédito.
	 */
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
	}
	/**
	 * Obtiene los dígitos de la tarjeta de crédito.
	 * @return
	 */
	public String getDigitosTC() {
		return digitosTC;
	}
	/**
	 * Establece los dígitos de la tarjeta de crédito.
	 * @param digitosTC
	 */
	public void setDigitosTC(String digitosTC) {
		this.digitosTC = digitosTC;
	}
	/**
	 * Obtiene el mes de caducidad de la terjeta de crédito.
	 * @return El mes de caducidad de la tarjerta de crédito.
	 */
	public int getMesTC() {
		return mesTC;
	}
	/**
	 * Establece el mes de caducidad de la tarjeta de crédito.
	 * @param mesTC El nuevo mes de caducidad de la tarjeta de crédito.
	 */
	public void setMesTC(int mesTC) {
		this.mesTC = mesTC;
	}
	/**
	 * Obtiene el año de caducidad de la tarjeta de crédito.
	 * @return El año de caducidad.
	 */
	public int getAnyoTC() {
		return anyoTC;
	}
	/**
	 * Establece el año de caducidad de la tarjeta de crédito.
	 * @param anyoTC El año de caducidad de la tarjeta de crédito.
	 */
	public void setAnyoTC(int anyoTC) {
		this.anyoTC = anyoTC;
	}
	/**
	 * Obtiene el código CVC de la tarjeta del cliente.
	 * @return Código CVC de la tarjeta.
	 */
	public int getCvcTC() {
		return cvcTC;
	}
	/**
	 * Establece el código CVC de la tarjeta de crédito.
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
