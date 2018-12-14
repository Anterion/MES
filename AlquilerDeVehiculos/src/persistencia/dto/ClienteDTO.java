package persistencia.dto;

import java.time.LocalDateTime;

/**
 * @author Lois
 * Data transfer object de Cliente. Utilizada para generar las tablas SQL.
 */
public class ClienteDTO {
	private String dni;
	private String nombreyApellidos;
	private String direccion;
	private String poblacion;
	private String codPostal;
	private LocalDateTime fechaCarnetConducir;
	private String digitosTC;
	private int mesTC;
	private int añoTC;
	private int cvcTC;
	private String tipoTC;
	
	/**
	 * Constructor de Cliente
	 * @param dni El dni del cliente
	 * @param nombreyApellidos Nombre y apellidos del cliente
	 * @param direccion Direccion físical del cliente.
	 * @param poblacion Población del cliente.
	 * @param codPostal Código postal del cliente.
	 * @param fechaCanetConducir Fecha de obtención del carnet de conducir del cliente.
	 * @param digitosTC dígitos de la tarjeta de crédito del cliente
	 * @param mesTC Mes de caducidad de la tarjeta de crédito del cliente.
	 * @param añoTC Año de caducidad de la tarjeta de crédito del cliente.
	 * @param cvcTC Dígitos CVC de la tarjeta de crédito del cliente.
	 * @param tipoTC Tipo de tarjeta de crédito (Visa, mastercard, etc.)
	 */
	public ClienteDTO(String dni, String nombreyApellidos,
			String direccion, String poblacion, String codPostal,
			LocalDateTime fechaCanetConducir, String digitosTC, int mesTC,
			int añoTC, int cvcTC, String tipoTC) {
		setDni(dni);
		setNombreyApellidos(nombreyApellidos);
		setDireccion(direccion);
		setPoblacion(poblacion);
		setCodPostal(codPostal);
		setFechaCarnetConducir(fechaCanetConducir);
		setDigitosTC(digitosTC);
		setMesTC(mesTC);
		setAñoTC(añoTC);
		setCvcTC(cvcTC);
		setTipoTC(tipoTC);
	}

	/**
	 * Obtiene el DNI del cliente.
	 * @return El DNI del cliente.
	 */
	public String getDni() {
		return dni;
	}
	/** Establece el ID (DNI) del cliente
	 * @param dni El nuevo DNI del cliente.
	 */
	public void setIdentificador(String dni) {
		this.dni = dni;
	}
	/**
	 * Obtiene el nombre y apellidos del cliente.
	 * @return El nombre y apellidos del cliente.
	 */
	public String getNombreyApellidos() {
		return nombreyApellidos;
	}
	/**
	 * Establece el nombre y apellidos del cliente.
	 * @param nombreyApellidos Los nuevos nombre y apellidos del cliente.
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
	 * Obtiene el código postal del cliente.
	 * @return El código postal del cliente.
	 */
	public String getCodPostal() {
		return codPostal;
	}
	/**
	 * Establece el código postal del cliente.
	 * @param codPostal El nuevo código postal.
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	/**
	 * Obtiene la fecha de obtención del carnet de conducir del cliente.
	 * @return La decha de obtención del carnet de conducir del cliente.
	 */
	public LocalDateTime getFechaCanetConducir() {
		return fechaCarnetConducir;
	}
	/**
	 * Establece la fecha de obtención del carnet de conducir del cliente.
	 * @param fechaCanetConducir La nueva fecha del carnet de conducir del cliente.
	 */
	public void setFechaCarnetConducir(LocalDateTime fechaCanetConducir) {
		this.fechaCarnetConducir = fechaCanetConducir;
	}
	/**
	 * Obtiene los dígitos de la tarjeta de crédito del cliente.
	 * @return Los dígitos de la tarjeta de crédito.
	 */
	public String getDigitosTC() {
		return digitosTC;
	}
	/**
	 * Establece los dígitos de la terjeta de crédito del cliente.
	 * @param digitosTC Los nuevos dígitos de la tarjeta de crédito.
	 */
	public void setDigitosTC(String digitosTC) {
		this.digitosTC = digitosTC;
	}
	/**
	 * Obtiene el mes de caducidad de la tarjeta de crédito.
	 * @return El mes de caducidad de la tarjeta de crédito.
	 */
	public int getMesTC() {
		return mesTC;
	}
	/**
	 * Establece el mes de caducidad de la tarjeta de crédito.
	 * @param mesTC El nuevo mes de caducidad para la tarjeta de crédito.
	 */
	public void setMesTC(int mesTC) {
		this.mesTC = mesTC;
	}
	/**
	 * Obtiene el año de caducidad de la tarjeta de crédito del cliente.
	 * @return El año de caducidad de la tarjet ade crédito del cliente
	 */
	public int getAñoTC() {
		return añoTC;
	}
	/**
	 * Establece el año de caducidad de la tarjeta de crédito del cliente
	 * @param añoTC El año de caducidad de la tarjeta de crédito.
	 */
	public void setAñoTC(int añoTC) {
		this.añoTC = añoTC;
	}
	/**
	 * Obtiene el código CVC de la tarjeta de crédito
	 * @return el código CVC.
	 */
	public int getCvcTC() {
		return cvcTC;
	}
	/**
	 * Establece el código CVC de la tarjeta de crédito.
	 * @param cvcTC El nuevo código CVC
	 */
	public void setCvcTC(int cvcTC) {
		this.cvcTC = cvcTC;
	}
	/**
	 * Obtiene el tipo de tarjeta de crédito(visa, mastercard, etc) del cliente.
	 * @return el tipo de tarjeta.
	 */
	public String getTipoTC() {
		return tipoTC;
	}
	/**
	 * Establece el tipo de tarjeta de crédito.
	 * @param tipoTC El nuevo tipo de tarjeta de crédito.
	 */
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
	}
	/**
	 * Obtiene la población donde vive el cliente.
	 * @return La población del cliente.
	 */
	public String getPoblacion() {
		return poblacion;
	}
	/**
	 * Establece la población donde vive el cliente.
	 * @param poblacion La nueva población del cliente.
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	/**
	 * Establce el DNI del cliente
	 * @param dni El nuevo DNI del cliente.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
}