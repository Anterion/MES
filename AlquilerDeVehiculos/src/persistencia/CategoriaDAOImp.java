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
	public void crearCategoria (CategoriaDTO categoria){
		try {
			connManager.connect();
			connManager.updateDB("INSERT INTO CATEGORIA (NOMBRE, PRECIOMODILIMITADA, PRECIOMODKMS, PRECIOSEGUROTRIESGO, PRECIOSEGUROTERCEROS, CATEGORIASUPERIOR, PRECIOKMMODKMS)"
					+ " VALUES('"+categoria.getNombre().trim()+"',"+categoria.getPrecioModIlimitada()+","+categoria.getPrecioModKms()+","+categoria.getPrecioSeguroTRiesgo()+","+categoria.getPrecioSeguroTerceros()+",'"+categoria.getNombreCategoriaSuperior().trim()+"',"+categoria.getPrecioKmModKms()+")");
			connManager.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CATEGORIA where NOMBRE= '"+nombre+"'");
			connManager.close();

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
		catch (SQLException e){	throw new DAOExcepcion(e);}
	}


	/**
	 * Lista todas las categor�as que existen en la base de datos.
	 * @return La lista de categor�as.
	 * @throws DAOExcepcion Excepci�n lanzada cuandose produce cualquier error en la consulta SQL.
	 */
	public List<CategoriaDTO> obtenerCategorias() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CATEGORIA");
			connManager.close();

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
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}

	}

}
