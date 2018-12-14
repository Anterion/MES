package persistencia.dto;

/**
 * @author Lois
 * Data transfer object de Coche, Utilizada para generar las tablas SQL
 */
public class CocheDTO {
	private String matricula;
	private double kmsactuales;
	private int sucursal;
	private String categoria;
	private String nombre;

	/**
	 * Constructor de Coche
	 * @param matricula Matr�cula (ID) del coche
	 * @param kmsactuales Kms recorridos por el coche
	 * @param sucursal Sucursal en la que se encuentra el coche.
	 * @param categoria Categor�a del coche.
	 * @param nombre Nombre (modelo) del coche.
	 */
	public CocheDTO(String matricula, double kmsactuales, int sucursal, String categoria, String nombre){
		setMatricula(matricula);
		setKmsActuales(kmsactuales);
		setSucursal(sucursal);
		setCategoria(categoria);
		setNombre(nombre);
	}

	/**
	 * Obtiene la matr�cula (Id) del coche
	 * @return La matr�cula del coche.
	 */
	public String getMatricula(){
		return matricula;
	}
	/**
	 * Establece la matr�cula (ID) del coche
	 * @param matricula La nueva matr�cula del coche
	 */
	public void setMatricula(String matricula){
		this.matricula=matricula;
	}
	/**
	 * Obtiene los kms recorridos por el coche.
	 * @return los kms recorridos por el coche.
	 */
	public double getKmsActuales(){
		return kmsactuales;
	}
	/**
	 * Establece los kms recorridos por el coche
	 * @param kmsactuales El nuevo valor para los kms recorridos por el coche.
	 */
	public void setKmsActuales(double kmsactuales){
		this.kmsactuales=kmsactuales;
	}
	/**
	 * Obtiene la sucursal en la que se encuentra el coche.
	 * @return La sucursal en la que se encuentra el coche.
	 */
	public int getSucursal(){
		return sucursal;
	}
	/**
	 * Establece la sucursal en la que se encuentra actualmente el coche.
	 * @param sucursal La nueva sucursal en la que se encuentra el coche.
	 */
	public void setSucursal(int sucursal){
		this.sucursal=sucursal;
	}
	/**
	 * Obtiene la categor�a del coche
	 * @return La categor�a del coche.
	 */
	public String getCategoria(){
		return categoria;
	}
	/**
	 * 
	 * Establece la categor�a del coche.
	 * @param categoria La nueva categor�a del coche.
	 */
	public void setCategoria(String categoria){
		this.categoria=categoria;
	}
	/**
	 * Obtiene el nombre del coche (modelo)
	 * @return El modelo del coche.
	 */
	public String getNombre(){
		return nombre;
	}
	/**
	 * Establece el nombre (modelo) del coche.
	 * @param nombre El nuevo nombre del coche.
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}