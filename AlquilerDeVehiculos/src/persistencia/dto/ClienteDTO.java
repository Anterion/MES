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
	private int a�oTC;
	private int cvcTC;
	private String tipoTC;
	
	/**
	 * Constructor de Cliente
	 * @param dni El dni del cliente
	 * @param nombreyApellidos Nombre y apellidos del cliente
	 * @param direccion Direccion f�sical del cliente.
	 * @param poblacion Poblaci�n del cliente.
	 * @param codPostal C�digo postal del cliente.
	 * @param fechaCanetConducir Fecha de obtenci�n del carnet de conducir del cliente.
	 * @param digitosTC d�gitos de la tarjeta de cr�dito del cliente
	 * @param mesTC Mes de caducidad de la tarjeta de cr�dito del cliente.
	 * @param a�oTC A�o de caducidad de la tarjeta de cr�dito del cliente.
	 * @param cvcTC D�gitos CVC de la tarjeta de cr�dito del cliente.
	 * @param tipoTC Tipo de tarjeta de cr�dito (Visa, mastercard, etc.)
	 */
	public ClienteDTO(String dni, String nombreyApellidos,
			String direccion, String poblacion, String codPostal,
			LocalDateTime fechaCanetConducir, String digitosTC, int mesTC,
			int a�oTC, int cvcTC, String tipoTC) {
		setDni(dni);
		setNombreyApellidos(nombreyApellidos);
		setDireccion(direccion);
		setPoblacion(poblacion);
		setCodPostal(codPostal);
		setFechaCarnetConducir(fechaCanetConducir);
		setDigitosTC(digitosTC);
		setMesTC(mesTC);
		setA�oTC(a�oTC);
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
	 * Obtiene el c�digo postal del cliente.
	 * @return El c�digo postal del cliente.
	 */
	public String getCodPostal() {
		return codPostal;
	}
	/**
	 * Establece el c�digo postal del cliente.
	 * @param codPostal El nuevo c�digo postal.
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	/**
	 * Obtiene la fecha de obtenci�n del carnet de conducir del cliente.
	 * @return La decha de obtenci�n del carnet de conducir del cliente.
	 */
	public LocalDateTime getFechaCanetConducir() {
		return fechaCarnetConducir;
	}
	/**
	 * Establece la fecha de obtenci�n del carnet de conducir del cliente.
	 * @param fechaCanetConducir La nueva fecha del carnet de conducir del cliente.
	 */
	public void setFechaCarnetConducir(LocalDateTime fechaCanetConducir) {
		this.fechaCarnetConducir = fechaCanetConducir;
	}
	/**
	 * Obtiene los d�gitos de la tarjeta de cr�dito del cliente.
	 * @return Los d�gitos de la tarjeta de cr�dito.
	 */
	public String getDigitosTC() {
		return digitosTC;
	}
	/**
	 * Establece los d�gitos de la terjeta de cr�dito del cliente.
	 * @param digitosTC Los nuevos d�gitos de la tarjeta de cr�dito.
	 */
	public void setDigitosTC(String digitosTC) {
		this.digitosTC = digitosTC;
	}
	/**
	 * Obtiene el mes de caducidad de la tarjeta de cr�dito.
	 * @return El mes de caducidad de la tarjeta de cr�dito.
	 */
	public int getMesTC() {
		return mesTC;
	}
	/**
	 * Establece el mes de caducidad de la tarjeta de cr�dito.
	 * @param mesTC El nuevo mes de caducidad para la tarjeta de cr�dito.
	 */
	public void setMesTC(int mesTC) {
		this.mesTC = mesTC;
	}
	/**
	 * Obtiene el a�o de caducidad de la tarjeta de cr�dito del cliente.
	 * @return El a�o de caducidad de la tarjet ade cr�dito del cliente
	 */
	public int getA�oTC() {
		return a�oTC;
	}
	/**
	 * Establece el a�o de caducidad de la tarjeta de cr�dito del cliente
	 * @param a�oTC El a�o de caducidad de la tarjeta de cr�dito.
	 */
	public void setA�oTC(int a�oTC) {
		this.a�oTC = a�oTC;
	}
	/**
	 * Obtiene el c�digo CVC de la tarjeta de cr�dito
	 * @return el c�digo CVC.
	 */
	public int getCvcTC() {
		return cvcTC;
	}
	/**
	 * Establece el c�digo CVC de la tarjeta de cr�dito.
	 * @param cvcTC El nuevo c�digo CVC
	 */
	public void setCvcTC(int cvcTC) {
		this.cvcTC = cvcTC;
	}
	/**
	 * Obtiene el tipo de tarjeta de cr�dito(visa, mastercard, etc) del cliente.
	 * @return el tipo de tarjeta.
	 */
	public String getTipoTC() {
		return tipoTC;
	}
	/**
	 * Establece el tipo de tarjeta de cr�dito.
	 * @param tipoTC El nuevo tipo de tarjeta de cr�dito.
	 */
	public void setTipoTC(String tipoTC) {
		this.tipoTC = tipoTC;
	}
	/**
	 * Obtiene la poblaci�n donde vive el cliente.
	 * @return La poblaci�n del cliente.
	 */
	public String getPoblacion() {
		return poblacion;
	}
	/**
	 * Establece la poblaci�n donde vive el cliente.
	 * @param poblacion La nueva poblaci�n del cliente.
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