package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.CocheDTO;

/**
 * @author Lois
 * Implementación de la interfaz ICocheDao, implementa métodos de acceso a la base de datos y la conexión a esta.
 */
public class CocheDAOImp implements ICocheDAO {
	private static ConnectionManager connManager;

	/**
	 * Constructor por defecto. Conecta la clase a la base de datos.
	 * @throws DAOExcepcion
	 */
	public CocheDAOImp() throws DAOExcepcion {
		super();
		try{
			setConnManager(new ConnectionManager("alquilervehiculosBD"));
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}
	/*public List<CocheDTO> obtenerCoches() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE WHERE MATRICULA NOT IN (SELECT COCHEASIGNADO FROM ENTREGA)");
			connManager.close();

			List<CocheDTO> listaCocheDTO = new ArrayList<CocheDTO>();

			try{
				while (rs.next()){

					CocheDTO cocDTO = new CocheDTO(
							rs.getString("MATRICULA"),
							rs.getDouble("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"),
							rs.getString("NOMBRE"));
					listaCocheDTO.add(cocDTO);
				}
				return listaCocheDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}
	}*/
	/**
	 * Obtiene la lista de coches ded una sucursal.
	 * @param idSucursal el Id de la sucursal.
	 * @return La lista de coches en la sucursal.
	 * @throws DAOExcepcion Lanzada cuando hay un error en la consulta SQL.
	 */
	public List<CocheDTO> obtenerCoches(int idSucursal) throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			getConnManager().connect();
			String query = "select * from COCHE where SUCURSAL= ? AND MATRICULA NOT IN (SELECT COCHEASIGNADO FROM ENTREGA)";
			st = connManager.getDbConn().prepareStatement(query);
			st.setInt(1, idSucursal);
			rs = st.executeQuery();
			getConnManager().close();
			st.close();

			List<CocheDTO> listaCocheDTO = new ArrayList<CocheDTO>();

			try{
				while (rs.next()){

							CocheDTO cocDTO = new CocheDTO(
									rs.getString("MATRICULA"),
									rs.getDouble("KMSACTUALES"),
									rs.getInt("SUCURSAL"),
									rs.getString("CATEGORIA"),
									rs.getString("NOMBRE"));
							listaCocheDTO.add(cocDTO);

				}
				return listaCocheDTO;
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
		CocheDAOImp.connManager = connManager;
	}
}
