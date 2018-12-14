//IClienteDAO
package persistencia;

import persistencia.dto.ClienteDTO;

import java.util.List;

import excepciones.*;

/**
 * Interfaz de Cliente, representa todos los métodos que debe implementar.
 * @author Lois
 *
 */
public interface IClienteDAO {
 /**
  * Busca un cliente por su Id (DNI)
 * @param dni El dni del cliente a buscar.
 * @return El objeto cliente
 * @throws DAOExcepcion Lanzada cuando hay un error al buscar el cliente.
 */
public ClienteDTO buscarCliente(String dni)throws DAOExcepcion;

 /**
  * Crea un nuevo cliente en la base de datos.
 * @param Cliente el objeto Cliente a añadir.
 * @throws DAOExcepcion
 */
public void crearCliente(ClienteDTO cliente) throws DAOExcepcion;
 
 /**
  * Obtiene todos los clientes disponibles en la base de datos.
 * @return La lista de clientes disponibles.
 * @throws DAOExcepcion Lanzada cuando ocurre algún error.
 */
public List<ClienteDTO> obtenerClientes() throws DAOExcepcion;
}
