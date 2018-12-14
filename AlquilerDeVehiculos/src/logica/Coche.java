package logica;

import java.util.List;


/**
 * @author Lois
 * Clase coche, representa un vehículo a alquilar, contiene todos los métodos para crear y modificar los parámetros.
 */
public class Coche {

	
	private String matricula;
	private double  kmsActuales;
	private int sucursal;
	private String categoria;
	private String nombre;
	private List<Entrega> listaEntrega;
	private int id;
	
	
	/**
	 * Constructor de la clase coche
	 * @param matricula La matrícula del coche, se utiliza como su ID.
	 * @param kmsactuales Los km que ha recorrido el vehículo
	 * @param sucursal La sucursal en la que se encuentra.
	 * @param categoria La categoría del vehículo.
	 * @param nombre El nombre del vehículo (su modelo)
	 */
	public Coche(String matricula, double kmsactuales, int sucursal, String categoria, String nombre){
		setMatricula(matricula);
		setKmsActuales(kmsactuales);
		setSucursal(sucursal);
		setCategoria(categoria);
		setNombre(nombre);
	}
	
	
	
	/**
	 * Obtiene el nombre (modelo) del Coche.
	 * @return El nombre del coche.
	 */
	public String getNombre(){
		return nombre;
	}
	/**
	 * Establece el nombre del Coche.
	 * @param nombre El nuevo nombre del Coche.
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	/**
	 * Obtiene la matrícula (id) del Coche.
	 * @return La matrícula del coche.
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * Establece la matrícula del coche.
	 * @param matricula La nueva matrícula del coche.
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * Devuelve los kilómetros que ha recorrido actualmente el coche.
	 * @return Los km que ha recorrido el coche.
	 */
	public double getKmsActuales() {
		return kmsActuales;
	}
	/**
	 * Establece los km que ha recorrido el coche.
	 * @param kmsActuales Los km que ha recorrido.
	 */
	public void setKmsActuales(double kmsActuales) {
		this.kmsActuales = kmsActuales;
	}
	/**
	 * Obtiene la sucursal en la que se encuentra el vehículo actualmente.
	 * @return El ID de la Sucursal en el que se encuentra el coche.
	 */
	public int getSucursal() {
		return sucursal;
	}
	/**
	 * Establece la sucursal en la que se encuentra el vehículo actualmente.
	 * @param sucursal La ID de la sucursal en la que se encontrará el Coche.
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * Obtiene la lista de entregas que tiene el Coche almacenadas.
	 * @return La lista de entregas.
	 */
	public List<Entrega> getListaEntega() {
		return listaEntrega;
	}
	/**
	 * Establece la nueva lista de entregas que el vehículo tiene almacenadas.
	 * @param listaEntega La nueva lista de entregas.
	 */
	public void setListaEntega(List<Entrega> listaEntega) {
		this.listaEntrega = listaEntega;
	}
	/**
	 * Obtiene la categoría a la que pertence el vehículo.
	 * @return El nombre de la categoría a la que pertenece.
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * Establece la categoria a la que pertenece el Coche
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * Obtiene el ID (matrícula) del coche.
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el ID (matrícula) del coche
	 * @param id La nueva matrícula.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
