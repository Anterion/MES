//IReservaDAO
package persistencia;

import java.util.List;

import persistencia.dto.ReservaDTO;
import excepciones.*;

/**
 * @author Lois
 * Interfaz ded la Clase Reserva, gestiona los m�todos CRUD y la conexci�n a la base de datos.
 */
public interface IReservaDAO {
 /**
  * Busca una reserva a partid de su Identificador.
 * @param identificador El Id de la reserva
 * @return El objeto Reserva. 
 * @throws DAOExcepcion Lanzada cuando ocurre una excepci�n al obtener la reserva.
 */
public ReservaDTO buscarReserva(int identificador)throws DAOExcepcion;

 /**
  * Obtiene las reservas que contiene una sucursal.
 * @param idSucursal La id de la sucursal.
 * @return El objeto sucursal buscado.
 * @throws DAOExcepcion Lanzada cuando ocurre alg�n error al buscar las reservas.
 */
public List <ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion;
 /**
  * Obtiene la lista de todas las reservas de la base de datos.
 * @return La lista de reservas.
 * @throws DAOExcepcion Lanzada cuando hay alg�n error al obtener las reservas.
 */
public List <ReservaDTO> obtenerReservas() throws DAOExcepcion;
 
 /**
  * Crea una nueva reserva en la base de datos.
 * @param reserva El objeto reserva a a�adir a la base de datos.
 * @throws DAOExcepcion
 */
public void crearReserva(ReservaDTO reserva) throws DAOExcepcion;
}
