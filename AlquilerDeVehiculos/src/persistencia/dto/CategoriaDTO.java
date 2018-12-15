package persistencia.dto;

/**
 * @author Lois
 * Data transfer object de Categor�a. Utilizada para generar las tablas SQL.
 */
public class CategoriaDTO {
	private String nombre;
	private double precioModIlimitada;
	private double precioModKms;
	private double precioKMModKms;
	private double precioSeguroTRiesgo;
	private double precioSeguroTerceros;
	private String nombreCategoriaSuperior;

	/**
	 * Constructor de categor�a
	 * @param nombre Nombre de la categor�a
	 * @param precioModIlimitada Precio en modalidad Ilimitada
	 * @param precioModKms Precio en modalidad por kil�metro
	 * @param precioKMModKms Precio por kil�metro en modalidad por kil�metro
	 * @param precioSeguroTRiesgo Precio del seguro a todo riesgo.
	 * @param precioSeguroTerceros Precio del seguro a terceros
	 * @param nombreCategoriaSuperior Nombre de la categor�a superior a �sta.
	 */
	public CategoriaDTO(String nombre, double precioModIlimitada,
			double precioModKms, double precioKMModKms,
			double precioSeguroTRiesgo, double precioSeguroTerceros,
			String nombreCategoriaSuperior) {
		//super();
		setNombre(nombre);
		setPrecioModIlimitada(precioModIlimitada);
		setPrecioModKms(precioModKms);
		setPrecioKmModKms(precioKMModKms);
		setPrecioSeguroTRiesgo(precioSeguroTRiesgo);
		setPrecioSeguroTerceros(precioSeguroTerceros);
		setNombreCategoriaSuperior(nombreCategoriaSuperior);
	}

	/**
	 * Obtiene el nombre de la categor�a.
	 * @return El nombre de la categor�a.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre de la categor�a.
	 * @param nombre El nuevo nombre de la categor�a.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene el precio en modalidad Ilimitada.
	 * @return El precio en modalidad Ilimitada.
	 */
	public double getPrecioModIlimitada() {
		return precioModIlimitada;
	}
	/**
	 * Establece el precio en modalidad ilimitada.
	 * @param precioModIlimitada El nuevo precio para la modalidad Ilimitada.
	 */
	public void setPrecioModIlimitada(double precioModIlimitada) {
		this.precioModIlimitada = precioModIlimitada;
	}
	/**
	 * Obtiene el precio en modalidad por km.
	 * @return
	 */
	public double getPrecioModKms() {
		return precioModKms;
	}
	/**
	 * Establece el precio en modalidad por km.
	 * @param precioModKms
	 */
	public void setPrecioModKms(double precioModKms) {
		this.precioModKms = precioModKms;
	}
	/**
	 * Ontiene el precio en modalidad por km.
	 * @return
	 */
	public double getPrecioKmModKms() {
		return precioKMModKms;
	}
	/**Establece el precio en modalidad por km.
	 * @param precioKMModKms
	 */
	public void setPrecioKmModKms(double precioKMModKms) {
		this.precioKMModKms = precioKMModKms;
	}
	/**
	 * Obtiene el precio del seguro a todo riesgo.
	 * @return El precio del seguro a todo riesgo.
	 */
	public double getPrecioSeguroTRiesgo() {
		return precioSeguroTRiesgo;
	}
	/**
	 * Establece el precio del seguro a todo riesgo.
	 * @param precioSeguroTRiesgo El nuevo precio del seguro a todo riesgo.
	 */
	public void setPrecioSeguroTRiesgo(double precioSeguroTRiesgo) {
		this.precioSeguroTRiesgo = precioSeguroTRiesgo;
	}
	/**
	 * Obtiene el precio del seguro a terceros.
	 * @return El precio del seguro a terceros.
	 */
	public double getPrecioSeguroTerceros() {
		return precioSeguroTerceros;
	}
	/**
	 * Establece el precio del Seguro a terceros.
	 * @param precioSeguroTerceros
	 */
	public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
		this.precioSeguroTerceros = precioSeguroTerceros;
	}
	/**
	 * Obtiene el nombre de la categor�a superior.
	 * @return El nombre de la categor�a superior.
	 */
	public String getNombreCategoriaSuperior() {
		return nombreCategoriaSuperior;
	}
	/**
	 * Establece el nombre de la categor�a superior.
	 * @param nombreCategoriaSuperior
	 */
	public void setNombreCategoriaSuperior(String nombreCategoriaSuperior) {
		this.nombreCategoriaSuperior = nombreCategoriaSuperior;
	}
}
