//ICategoriaDAO
package persistencia;

import java.util.List;
import persistencia.dto.CategoriaDTO;
import excepciones.*;

/**
 * @author Lois
 * Interfaz de categoría, representa los métodos que debe implementar una categoría en el Data Acess Object
 */
public interface ICategoriaDAO {
 /**
  * Busca una categoría por su nombre.
 * @param nombre El nombre de la categoría a buscar
 * @return Devuelve la categoría buscada.
 * @throws DAOExcepcion Lanzada cuando hay un error en la búsqueda.
 */
public CategoriaDTO buscarCategoria(String nombre)throws DAOExcepcion;

/**
 * Obtiene todas las categorías que existen en la base de datos.
 * @return La lista de todas las categorías.
 * @throws DAOExcepcion Lanzada cuando se produce un error al obtener las categorías.
 */
public List <CategoriaDTO> obtenerCategorias() throws DAOExcepcion;
 
/**
 * Crea una nueva categoría.
 * @param categoria El objeto de la nueva categoría.
 * @throws DAOExcepcion Lanzada cuando ocurre un error al crear la nueva categoría.
 */
public void crearCategoria(CategoriaDTO categoria) throws DAOExcepcion;
}
