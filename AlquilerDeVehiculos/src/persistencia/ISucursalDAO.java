//ISucursalDAO
package persistencia;

import java.util.List;

import persistencia.dto.SucursalDTO;
import excepciones.*;

/**
 * @author Lois
 * Interfaz de la Clase Sucursal, reepresenta el lugar donde se alquilan los veh�culos y trabajan los trabajadores. Contiene m�todos CRUD y la conexi�n a la base de datos.
 */
public interface ISucursalDAO {
 /**
  * Devuelve la lista de todas las sucursales que existen en la base de datos.
 * @return La lista en cuesti�n.
 * @throws DAOExcepcion Lanzada cuando hay alg�n error en el acceso para obtener la lista.
 */
public List <SucursalDTO> obtenerSucursales() throws DAOExcepcion;

 /**
  * Busca una sucursal por su id.
 * @param id La id a buscar 
 * @return El objeto sucursal en cuesti�n.
 * @throws DAOExcepcion Lanzada cuando ocurre un error al obtener la sucursal.
 */
public SucursalDTO buscarSucursal(int id)throws DAOExcepcion;
 
 /**
  * A�ade una nueva sucursal a la base de datos.
 * @param sucursal El objeto sucursal en cuesti�n.
 * @throws DAOExcepcion Lanzada cuando ocurre alg�n error al a�adir la nueva sucursal.
 */
public void crearSucursal(SucursalDTO sucursal) throws DAOExcepcion;
}
