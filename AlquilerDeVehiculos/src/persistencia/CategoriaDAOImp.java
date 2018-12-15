package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.dto.CategoriaDTO;
import excepciones.DAOExcepcion;

/**
 * @author Lois
 * Implementaci�n de la interfaz ICategor�aDAO, implementa los m�todos de acceso a la base de datos, adem�s de la conexi�n a esta para las categor�as.
 */
public class CategoriaDAOImp implements ICategoriaDAO {
	protected ConnectionManager connManager;

	/**
	 * Constructor por defecto. Intenta establecer conexi�n al connection string = "alquilervehiculosBD"
	 * @throws DAOExcepcion Lanza esta excepci�n en caso de que no existan las librer�as de conexi�n a la base de datos.
	 */
	public CategoriaDAOImp() throws DAOExcepcion {
		super();
		try{
			connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}
	/**
	 * Crea una nueva categor�a y la sincroniza con la base de datos
	 * @param categoria La nueva categor�a a a�adir
	 */
	public void crearCategoria (CategoriaDTO categoria) {
		PreparedStatement st = null;
		try {
			connManager.connect();
			String query = "INSERT INTO CATEGORIA ("
					+ " NOMBRE, PRECIOMODILIMITADA, PRECIOMODKMS, PRECIOSEGUROTRIESGO, PRECIOSEGUROTERCEROS, CATEGORIASUPERIOR, PRECIOKMMODKMS)"
					+ " VALUES("
					+ "?,?,?,?,?,?,?)";
			st = connManager.getDbConn().prepareStatement(query);
			st.setString(1, categoria.getNombre().trim());
			st.setDouble(2, categoria.getPrecioModIlimitada());
			st.setDouble(3, categoria.getPrecioModKms());
			st.setDouble(4, categoria.getPrecioSeguroTRiesgo());
			st.setDouble(5, categoria.getPrecioSeguroTerceros());
			st.setString(6, categoria.getNombreCategoriaSuperior().trim());
			st.setDouble(7, categoria.getPrecioKmModKms());
			st.executeUpdate();
		    st.close();
			connManager.close();
		} catch (SQLException e) {
			try {
				if (st != null)
					st.close();
				connManager.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	/**
	 * Busca una categor�a en la base de datos.
	 * @param nombre El nombre a buscar.
	 * @return La categor�a buscada, o null en caso de que no exista.
	 * @throws DAOExcepcion Excepci�n lanzada cuando se produce un error en la consulta SQL.
	 */
	public CategoriaDTO buscarCategoria(String nombre) throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			connManager.connect();
			String query ="select * from CATEGORIA where NOMBRE= ?";
			st = connManager.getDbConn().prepareStatement(query);
			st.setString(1, nombre);
			rs = st.executeQuery();

			connManager.close();
			st.close();

			if (rs.next())
				return new CategoriaDTO(
							rs.getString("NOMBRE"),
							rs.getDouble("PRECIOMODILIMITADA"),
							rs.getDouble("PRECIOMODKMS"),
							rs.getDouble("PRECIOKMMODKMS"),
							rs.getDouble("PRECIOSEGUROTRIESGO"),
							rs.getDouble("PRECIOSEGUROTERCEROS"),
							rs.getString("CATEGORIASUPERIOR"));
			else
				return null;
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
	}


	/**
	 * Lista todas las categor�as que existen en la base de datos.
	 * @return La lista de categor�as.
	 * @throws DAOExcepcion Excepci�n lanzada cuandose produce cualquier error en la consulta SQL.
	 */
	public List<CategoriaDTO> obtenerCategorias() throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			connManager.connect();
			String query = "select * from CATEGORIA";
			st = connManager.getDbConn().prepareStatement(query);
			rs = st.executeQuery();
			connManager.close();
			st.close();

			List<CategoriaDTO> listaCategoriaDTO = new ArrayList<CategoriaDTO>();

			try{
				while (rs.next()){

					CategoriaDTO catDTO = new CategoriaDTO(
							rs.getString("NOMBRE"),
							rs.getDouble("PRECIOMODILIMITADA"),
							rs.getDouble("PRECIOMODKMS"),
							rs.getDouble("PRECIOKMMODKMS"),
							rs.getDouble("PRECIOSEGUROTRIESGO"),
							rs.getDouble("PRECIOSEGUROTERCEROS"),
							rs.getString("CATEGORIASUPERIOR"));
					listaCategoriaDTO.add(catDTO);
				}
				return listaCategoriaDTO;
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

}
