package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import persistencia.dto.ReservaDTO;
import excepciones.DAOExcepcion;

/**
 * @author Lois
 * Implementación de la interfaz Reserva, implementa los métodos CRUD y la conexión a la base de datos de RESERVA.
 */
public class ReservaDAOImp implements IReservaDAO {
	String completoDev;
	String completoRec;
	static String idmax;
	static private ConnectionManager connManager;

	/**
	 * Constructor por defecto. Intenta la conexión a la connectionstring = "alquilervehhiculosBS"
	 * @throws DAOExcepcion
	 */
	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		setConnManager(new ConnectionManager("alquilervehiculosBD"));
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	/**
	 * Crea una nueva reserva en la base de datos.
	 * @param reserva El objeto reserva a añadir
	 * @throws DAOExcepcion Lanzada cuando hay un error en la sentencia SQL
	 */
	public void crearReserva(ReservaDTO reserva) throws DAOExcepcion{
		PreparedStatement st = null;
		try{
			completoDev=reserva.getFechaDevolucion().toString();
			completoRec=reserva.getFechaRecogida().toString();
			getConnManager().connect();
			String query = "INSERT INTO RESERVA (ID, FECHARECOGIDA, FECHADEVOLUCION, MODALIDADALQUILER, CATEGORIA, CLIENTEREALIZA, SUCURSALRECOGIDA, SUCURSALDEVOLUCION)"
					+ " VALUES(?,?,?,?,?,?,?,?)";
			st = getConnManager().getDbConn().prepareStatement(query);
			st.setInt(1, reserva.getId());
			st.setString(2, completoRec);
			st.setString(3, completoDev);
			st.setInt(4, reserva.getModalidadAlquiler());
			st.setString(5, reserva.getNombreCategoria().trim());
			st.setString(6,  reserva.getDniCliente());
			st.setInt(7, reserva.getIdSucursalRecogida());
			st.setLong(8, reserva.getIdSucursalDevolucion());
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
	 * Obtiene la lista de todas las reservas en la base de datos.
	 * @return La lista de las reservas.
	 * @throws DAOExcepcion Lanzada cuando hay un error al acceder a la base de datos, o los datos contenidos son incorrectos.
	 */
	public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			getConnManager().connect();
			String query =  "select * from RESERVA";
			st = connManager.getDbConn().prepareStatement(query);
			rs = st.executeQuery();
			getConnManager().close();
			st.close();

			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
			try{
				while (rs.next()){
					LocalDateTime fechaRecogida = LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getTime("FECHARECOGIDA").toLocalTime());
					LocalDateTime fechaDevolucion = LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getTime("FECHADEVOLUCION").toLocalTime());


					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							fechaRecogida,
							fechaDevolucion,
							rs.getInt("MODALIDADALQUILER"),
							rs.getString("CLIENTEREALIZA"),
							rs.getString("CATEGORIA").trim(),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
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
	/**
	 * Obtiene las reservas en una sucursas, según su origen,.
	 * @param idSucursal El id de la sucursal de origen.
	 * @return La lista de reservas de la sucursal que coindice con el origen.
	 * @throws DAOExcepcion Lanzada cuando ocurre un error al acceder a la base de datos, o los datos contenidos son incorrectos.
	 */
	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			getConnManager().connect();
			String query = "select * from RESERVA where SUCURSALRECOGIDA= ?";
			st = getConnManager().getDbConn().prepareStatement(query);
			st.setInt(1, idSucursal);
			rs = st.executeQuery();

			getConnManager().close();
			st.close();
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
			try{
				while (rs.next()){
					LocalDateTime fechaRecogida = LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getTime("FECHARECOGIDA").toLocalTime());
					LocalDateTime fechaDevolucion = LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getTime("FECHADEVOLUCION").toLocalTime());
					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							fechaRecogida,
							fechaDevolucion,
							rs.getInt("MODALIDADALQUILER"),
							rs.getString("CLIENTEREALIZA"),
							rs.getString("CATEGORIA").trim(),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
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
		catch (DAOExcepcion e){		throw e;}
	}
	/**
	 * Busca una  reserva en la base de datos. Por su ID
	 * @param id El id de la reserva a buscar.
	 * @return El objeto reserva buscado, o null si no existe.
	 * @throws DAOExcepcion Lanzado cuando ocurre algún error al acceder a la base de datos, o la sentencia es incorrecta.
	 */
	public ReservaDTO buscarReserva(int id) throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			getConnManager().connect();
			String query = "select * from Reserva where ID= ?";
			st = getConnManager().getDbConn().prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();

			getConnManager().close();
			st.close();

			if (rs.next()){
				LocalDateTime fechaRecogida = LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(),
						rs.getTime("FECHARECOGIDA").toLocalTime());
				LocalDateTime fechaDevolucion = LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),
						rs.getTime("FECHADEVOLUCION").toLocalTime());
				return new ReservaDTO(
						rs.getInt("ID"),
						fechaRecogida,
						fechaDevolucion,
						rs.getInt("MODALIDADALQUILER"),
						rs.getString("CLIENTEREALIZA"),
						rs.getString("CATEGORIA"),
						rs.getInt("SUCURSALRECOGIDA"),
						rs.getInt("SUCURSALDEVOLUCION"));
			}else
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
	 * Busca la reserva más reciente en la base de datos. (ID con valor más alto)
	 * @return La reserva más reciente (ID más alto)
	 * @throws DAOExcepcion Lanzada cuando ocurre un error con la sentencia SQL.
	 */
	public static String buscarIdMaxReserva() throws DAOExcepcion{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			getConnManager().connect();
			String query = "select ID from Reserva";
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

	public static ConnectionManager getConnManager() {
		return connManager;
	}

	public static void setConnManager(ConnectionManager connManager) {
		ReservaDAOImp.connManager = connManager;
	}
}