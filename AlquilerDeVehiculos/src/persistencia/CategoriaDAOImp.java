package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.dto.CategoriaDTO;
import excepciones.DAOExcepcion;

/**
 * @author Lois
 * Implementación de la interfaz ICategoríaDAO, implementa los métodos de acceso a la base de datos, además de la conexión a esta para las categorías.
 */
public class CategoriaDAOImp implements ICategoriaDAO {
	protected ConnectionManager connManager;

	/**
	 * Constructor por defecto. Intenta establecer conexión al connection string = "alquilervehiculosBD"
	 * @throws DAOExcepcion Lanza esta excepción en caso de que no existan las librerías de conexión a la base de datos.
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
	 * Crea una nueva categoría y la sincroniza con la base de datos
	 * @param categoria La nueva categoría a añadir
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
	 * Busca una categoría en la base de datos.
	 * @param nombre El nombre a buscar.
	 * @return La categoría buscada, o null en caso de que no exista.
	 * @throws DAOExcepcion Excepción lanzada cuando se produce un error en la consulta SQL.
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
	 * Lista todas las categorías que existen en la base de datos.
	 * @return La lista de categorías.
	 * @throws DAOExcepcion Excepción lanzada cuandose produce cualquier error en la consulta SQL.
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
