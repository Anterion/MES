package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.SucursalDTO;
import excepciones.DAOExcepcion;

/**
 * @author Lois
 * Implementación de la interfaz Sucursal, contiene los métodos CRUD y la conexión a la base de datos.
 */
public class SucursalDAOImp implements ISucursalDAO {
	static String idmax;
	protected static ConnectionManager connManager;

	/**
	 * Constructor por defecto, intenta la conexión con el connectionstring = alquilervehiculosDB
	 * @throws DAOExcepcion Lanzada cuando ocurre un error al conectar a la base de datos.
	 */
	public SucursalDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	/**
	 * Añade una nueva sucursal a la base de datos.
	 * @param sucursal El objeto sucursal a añadir.
	 */
	public void crearSucursal (SucursalDTO sucursal){
		try {
			connManager.connect();
			connManager.updateDB("INSERT INTO SUCURSAL (ID, DIRECCION)"
					+ " VALUES("+sucursal.getId()+",'"+sucursal.getDireccion().trim()+"')");						
			connManager.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Busca una sucursal en la base de datos, por su ID.
	 * @param id La ID a buscar
	 * @return La sucursal buscada, null si no existe.
	 * @throws DAOExcepcion Lanzada cuando ocurre una excepción en la sentencia SQL
	 */
	public SucursalDTO buscarSucursal(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Sucursal where ID= '"+id+"'");
			connManager.close();
		
			if (rs.next())
				return new SucursalDTO(
						rs.getInt("ID"), 
						rs.getString("DIRECCION"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	/**
	 * Busca la reserva más reciente.
	 * @return La Id de la reserva más reciente (id máximo)
	 * @throws DAOExcepcion Lanzado cuando ocurre alguna excepción en la consula SQL
	 */
	public static String buscarIdMaxReserva() throws DAOExcepcion{
		
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select ID from Sucursal");
			connManager.close();
			
			while (rs.next()){
				idmax=rs.getString("ID");
				int idmaxAux=Integer.parseInt(idmax);
				idmax = Integer.toString(idmaxAux+=1);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return idmax;
	}
	/**
	 * Obtiene la lista de todas las sucursales disponibles.
	 * @return La lista de todas las sucursales.
	 * @throws DAOExcepcion Lanzada cuando hay una excepción en la consulta SQL
	 */
	public List<SucursalDTO> obtenerSucursales() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Sucursal");						
			connManager.close();
	  	  
			List<SucursalDTO> listaSucursalDTO = new ArrayList<SucursalDTO>();
				
			try{				
				while (rs.next()){

					SucursalDTO sucDTO = new SucursalDTO(
							rs.getInt("ID"),
							rs.getString("Direccion"));
								 
					listaSucursalDTO.add(sucDTO);
				}
				return listaSucursalDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
}
