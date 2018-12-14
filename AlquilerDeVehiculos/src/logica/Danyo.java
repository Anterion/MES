package logica;


/**
 * @author Lois
 * Clase Danyo, representa los desperfectos sufridos por un coche durante un préstamo.
 */
public class Danyo {

	private int id;
	private String zona;
	private String descripcion;
	private Entrega entrega;
	private Devolucion devolucion;
	
	

	/**
	 * Obtiene la zona en la que se ocasionó el daño.
	 * @return La zona donde se ocasionó el daño.
	 */
	public String getZona() {
		return zona;
	}
	/**
	 * Establece la zona donde se ocasionó el daño.
	 * @param zona La zona donde se ocasionó el daño.
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}
	/**
	 * Obtiene la descripción del daño.
	 * @return La descripción del daño.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Establece la descripción del daño.
	 * @param descripcion La nueva descripción del daño.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtiene la entrega a la que está relacionado el daño.
	 * @return
	 */
	public Entrega getEntrega() {
		return entrega;
	}
	/**
	 * Establece la entrega a la que está relacionado el daño.
	 * @param entrega
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	/**
	 * Obtiene el objeto devolución al que está relacionado el daño.
	 * @return
	 */
	public Devolucion getDevolucion() {
		return devolucion;
	}
	/**
	 * Establece el objeto devolución al que está relacionado este daño.
	 * @param devolucion El objeto devolución.
	 */
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	/**
	 * Obtiene la id del daño.
	 * @return El id del daño.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece la id del daño.
	 * @param id La nueva id del daño.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
