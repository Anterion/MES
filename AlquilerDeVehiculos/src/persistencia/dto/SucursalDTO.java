package persistencia.dto;

/**
 * @author Lois
 * Clase Data transfer object de Sucursal. Utilizada para generar las tablas SQL.
 */
public class SucursalDTO {
	private int id;
	private String direccion;
	
	
	/**
	 * Constructor de sucursal.
	 * @param id Id de la sucursal
	 * @param direccion Dirección física de la sucursal.
	 */
	public SucursalDTO(int id, String direccion) {
		//super();
		
		setId(id);
		setDireccion(direccion);
	}
	
	/**
	 * Obtiene el ID de la sucursal.
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el ID de la sucursal.
	 * @param id El nuevo ID para la sucursal.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene la dirección de la sucursal.
	 * @return La dirección de la sucursal.
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Establece la dirección de la sucursal.
	 * @param direccion La nueva dirección de la sucursal.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
