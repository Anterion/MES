//ISucursalDAO
package persistencia;

import java.util.List;

import persistencia.dto.SucursalDTO;
import excepciones.*;

/**
 * @author Lois
 * Interfaz de la Clase Sucursal, reepresenta el lugar donde se alquilan los vehículos y trabajan los trabajadores. Contiene métodos CRUD y la conexión a la base de datos.
 */
public interface ISucursalDAO {
 /**
  * Devuelve la lista de todas las sucursales que existen en la base de datos.
 * @return La lista en cuestión.
 * @throws DAOExcepcion Lanzada cuando hay algún error en el acceso para obtener la lista.
 */
public List <SucursalDTO> obtenerSucursales() throws DAOExcepcion;

 /**
  * Busca una sucursal por su id.
 * @param id La id a buscar 
 * @return El objeto sucursal en cuestión.
 * @throws DAOExcepcion Lanzada cuando ocurre un error al obtener la sucursal.
 */
public SucursalDTO buscarSucursal(int id)throws DAOExcepcion;
 
 /**
  * Añade una nueva sucursal a la base de datos.
 * @param sucursal El objeto sucursal en cuestión.
 * @throws DAOExcepcion Lanzada cuando ocurre algún error al añadir la nueva sucursal.
 */
public void crearSucursal(SucursalDTO sucursal) throws DAOExcepcion;
}
