package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.EntregaDTO;

/**
 * @author Lois
 * Interefaz de la clase Entrega
 */
public interface IEntregaDAO {
	/**
	 * Obtiene la lista de todas las entregas en la base de datos.
	 * @return La lista de todas las entregas.
	 * @throws DAOExcepcion Lanzada cuando hay algún error al obtener las entregas.
	 */
	public List <EntregaDTO> obtenerEntregas() throws DAOExcepcion;
	/**
	 * Añade una nueva entrega a la base de datos.
	 * @param entregaDTO El objeto entrega a añadir a la base de datos.
	 * @throws DAOExcepcion Lanzada cuando ocurre alún error al añadir la entrega a la base de datos.
	 */
	public void crearEntrega(EntregaDTO entregaDTO) throws DAOExcepcion;
}
