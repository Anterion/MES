package persistencia;

import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.CocheDTO;

public interface ICocheDAO {
	/**
	 * Obtiene la lista de coches de la base de datos.
	 * @param idSucursal La id de la sucursal a buscar.
	 * @return La lista de coches de la sucursal.
	 * @throws DAOExcepcion Lanzada cuando hay algun error al oobtener la lista.
	 */
	public List<CocheDTO> obtenerCoches(int idSucursal) throws DAOExcepcion;

	//public List<CocheDTO> obtenerCoches()throws DAOExcepcion;
}
