package logica;

import java.util.List;


/**
 * @author Lois
 * Diferencia los tipos de coches.
 */
public class Categoria {

	private String nombre;
	private double precioModIlimitada;
	private double precioModKms;
	private double precioKmModKms;
	private double precioSeguroTRiesgo;
	private double precioSeguroTerceros;
	private String superior;
	
	//private AlquilerVehiculos alquilerVehiculo;
	//private List<Reserva> listaReservas;
	private List<Coche> listaCoches;
	/**
	 * Obtiene el precio de la categoría en modalidad ilimitada.
	 * @return El precio en modalidad ilimitada.
	 */
	public double getPrecioModIlimitada() {
		return precioModIlimitada;
	}
	/**
	 * Establece el precio de la categoria en modalidad ilimitada.
	 * @param precioModIlimitada El precio en modalidad ilimitada.
	 */
	public void setPrecioModIlimitada(double precioModIlimitada) {
		this.precioModIlimitada = precioModIlimitada;
	}
	/**
	 * Obtiene el precio por km de la categoría.
	 * @return El precio por km de la categoría.
	 */
	public double getPrecioModKms() {
		return precioModKms;
	}
	/**
	 * Establece el precio por km de la categoría.
	 * @param precioModKms El precio por km de la categoría.
	 */
	public void setPrecioModKms(double precioModKms) {
		this.precioModKms = precioModKms;
	}
	/**
	 * Obtiene el precio del km en la modalidad de precio por km.
	 * @return El precio del km en la modalidad de precio por km.
	 */
	public double getPrecioKmModKms() {
		return precioKmModKms;
	}
	/**
	 * Establece el precio del km en la modalidad de precio por km.
	 * @param precioKmModKms
	 */
	public void setPrecioKmModKms(double precioKmModKms) {
		this.precioKmModKms = precioKmModKms;
	}
	/**
	 * Obtiene el precio del seguro a todo riesgo para esta catagoría.
	 * @return El precio del seguro a todo riesgo.
	 */
	public double getPrecioSeguroTRiesgo() {
		return precioSeguroTRiesgo;
	}
	/**
	 * Establece el precio del seguro a todo riesgo para esta catagoría.
	 * @param precioSeguroTRiesgo El precio a establecer.
	 */
	public void setPrecioSeguroTRiesgo(double precioSeguroTRiesgo) {
		this.precioSeguroTRiesgo = precioSeguroTRiesgo;
	}
	/**
	 * Obtiene el precio del seguro a terceros para esta catagoría.
	 * @return El precio del seguro a terceros.
	 */
	public double getPrecioSeguroTerceros() {
		return precioSeguroTerceros;
	}
	/**
	 * Establece el precio del seguro a terceros para esta categoría.
	 * @param precioSeguroTerceros El precio del seguro a terceros a establecer.
	 */
	public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
		this.precioSeguroTerceros = precioSeguroTerceros;
	}
	/**
	 * Obtiene la categoría inmediatamente superior a esta.
	 * @return El objeto categoría suiperior a este.
	 */
	public String getSuperior() {
		return superior;
	}
	/**
	 * Establece la categoría superior a esta.
	 * @param categoriaSuperior El objeto categoría superior a este.
	 */
	public void setSuperior(String categoriaSuperior) {
		this.superior = categoriaSuperior;
	}
	/** 
	 * Obtiene el nombre de la categoría.
	 * @return El nombre de la categoría.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * Establece un nombre para la categoría.
	 * @param nombre El nuevo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene la lista de coches en esta catagoría.
	 * @return La lista de coches.
	 */
	public List<Coche> getListaCoches() {
		return listaCoches;
	}
	/**
	 * Establece la lista de coches en esta catagoría.
	 * @param listaCoches La lista de coches que se van a añadir a la categoría.
	 */
	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}

	/**
	 * Constructor de la clase Categoría.
	 * @param nombre El nombre de la categoría.
	 * @param precioModIlimitada El precio en modalidad ilimitada
	 * @param precioModKms El precio en modalidad por km
	 * @param precioSeguroTRiesgo El precio del seguro a todo riesgo.
	 * @param precioSeguroTerceros El precio del seguro a terceros.
	 * @param precioKmModKms El precio dedl km en modalidad por km.
	 * @param categoriaSuperior La categoría superior.
	 */
	public Categoria(String nombre, double precioModIlimitada, double precioModKms, double precioSeguroTRiesgo, double precioSeguroTerceros, double precioKmModKms, String categoriaSuperior){
		setNombre(nombre);
		setPrecioModIlimitada(precioModIlimitada); 
		setPrecioModKms(precioModKms);
		setPrecioKmModKms(precioKmModKms); 
		setPrecioSeguroTRiesgo(precioSeguroTRiesgo); 
		setPrecioSeguroTerceros(precioSeguroTerceros);
		setSuperior(categoriaSuperior);
	}
	
	/*public AlquilerVehiculos getAlquilerVehiculo() {
		return alquilerVehiculo;
	}
	public void setAlquilerVehiculo(AlquilerVehiculos alquilerVehiculo) {
		this.alquilerVehiculo = alquilerVehiculo;
	}
	public List<Reserva> getListaReservas() {
		return listaReservas;
	}
	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}*/

}