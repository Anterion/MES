package logica;


/**
 * @author Lois
 * Clase Danyo, representa los desperfectos sufridos por un coche durante un pr�stamo.
 */
public class Danyo {

	private int id;
	private String zona;
	private String descripcion;
	private Entrega entrega;
	private Devolucion devolucion;
	
	

	/**
	 * Obtiene la zona en la que se ocasion� el da�o.
	 * @return La zona donde se ocasion� el da�o.
	 */
	public String getZona() {
		return zona;
	}
	/**
	 * Establece la zona donde se ocasion� el da�o.
	 * @param zona La zona donde se ocasion� el da�o.
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}
	/**
	 * Obtiene la descripci�n del da�o.
	 * @return La descripci�n del da�o.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Establece la descripci�n del da�o.
	 * @param descripcion La nueva descripci�n del da�o.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Obtiene la entrega a la que est� relacionado el da�o.
	 * @return
	 */
	public Entrega getEntrega() {
		return entrega;
	}
	/**
	 * Establece la entrega a la que est� relacionado el da�o.
	 * @param entrega
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	/**
	 * Obtiene el objeto devoluci�n al que est� relacionado el da�o.
	 * @return
	 */
	public Devolucion getDevolucion() {
		return devolucion;
	}
	/**
	 * Establece el objeto devoluci�n al que est� relacionado este da�o.
	 * @param devolucion El objeto devoluci�n.
	 */
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	/**
	 * Obtiene la id del da�o.
	 * @return El id del da�o.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece la id del da�o.
	 * @param id La nueva id del da�o.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
