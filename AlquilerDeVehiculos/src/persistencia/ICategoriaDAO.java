//ICategoriaDAO
package persistencia;

import java.util.List;
import persistencia.dto.CategoriaDTO;
import excepciones.*;

/**
 * @author Lois
 * Interfaz de categor�a, representa los m�todos que debe implementar una categor�a en el Data Acess Object
 */
public interface ICategoriaDAO {
 /**
  * Busca una categor�a por su nombre.
 * @param nombre El nombre de la categor�a a buscar
 * @return Devuelve la categor�a buscada.
 * @throws DAOExcepcion Lanzada cuando hay un error en la b�squeda.
 */
public CategoriaDTO buscarCategoria(String nombre)throws DAOExcepcion;

/**
 * Obtiene todas las categor�as que existen en la base de datos.
 * @return La lista de todas las categor�as.
 * @throws DAOExcepcion Lanzada cuando se produce un error al obtener las categor�as.
 */
public List <CategoriaDTO> obtenerCategorias() throws DAOExcepcion;
 
/**
 * Crea una nueva categor�a.
 * @param categoria El objeto de la nueva categor�a.
 * @throws DAOExcepcion Lanzada cuando ocurre un error al crear la nueva categor�a.
 */
public void crearCategoria(CategoriaDTO categoria) throws DAOExcepcion;
}
