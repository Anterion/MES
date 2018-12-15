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
	static private ConnectionManager connManager;

	/**
	 * Constructor por defecto, intenta la conexión con el connectionstring = alquilervehiculosDB
	 * @throws DAOExcepcion Lanzada cuando ocurre un error al conectar a la base de datos.
	 */
	public SucursalDAOImp() throws DAOExcepcion {
		super();
		try{
		setConnManager(new ConnectionManager("alquilervehiculosBD"));
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
		PreparedStatement st = null;
		try {
			getConnManager().connect();
			String query = "INSERT INTO SUCURSAL (ID, DIRECCION)"
					+ " VALUES(?,?)";
			st = getConnManager().getDbConn().prepareStatement(query);
			st.setInt(1,sucursal.getId());
			st.setString(2, sucursal.getDireccion().trim());
			st.executeUpdate();
		    st.close();
			getConnManager().close();

		} catch (SQLException e) {
			try {
				if (st != null)
					st.close();
				getConnManager().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			getConnManager().connect();
			String query = "select * from Sucursal where ID = ?";
			st = getConnManager().getDbConn().prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();

			getConnManager().close();
			st.close();

			if (rs.next())
				return new SucursalDTO(
						rs.getInt("ID"),
						rs.getString("DIRECCION"));
			else
				return null;
		}
		catch (SQLException e){
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
				getConnManager().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOExcepcion(e);
		}
	}

	/**
	 * Busca la reserva más reciente.
	 * @return La Id de la reserva más reciente (id máximo)
	 * @throws DAOExcepcion Lanzado cuando ocurre alguna excepción en la consula SQL
	 */
	public static String buscarIdMaxReserva() throws DAOExcepcion{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			getConnManager().connect();
			String query =  "select ID from Sucursal";
			st = connManager.getDbConn().prepareStatement(query);
			rs = st.executeQuery();
			getConnManager().close();
			st.close();

			while (rs.next()){
				idmax=rs.getString("ID");
				int idmaxAux=Integer.parseInt(idmax);
				idmax = Integer.toString(idmaxAux+=1);
			}

		}
		catch (SQLException e){
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
				connManager.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOExcepcion(e);
		}


		return idmax;
	}
	/**
	 * Obtiene la lista de todas las sucursales disponibles.
	 * @return La lista de todas las sucursales.
	 * @throws DAOExcepcion Lanzada cuando hay una excepción en la consulta SQL
	 */
	public List<SucursalDTO> obtenerSucursales() throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			getConnManager().connect();
			String query = "select * from Sucursal";
			st = connManager.getDbConn().prepareStatement(query);
			rs = st.executeQuery();
			getConnManager().close();
			st.close();

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
		catch (SQLException e){
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
				connManager.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOExcepcion(e);
		}
		catch (DAOExcepcion e){		throw e;}

	}
	public static ConnectionManager getConnManager() {
		return connManager;
	}
	public static void setConnManager(ConnectionManager connManager) {
		SucursalDAOImp.connManager = connManager;
	}
}
