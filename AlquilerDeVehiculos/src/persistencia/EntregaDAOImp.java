package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.EntregaDTO;

/**
 * @author Lois
 * Implementación de la interfaz IEntregaDAO, gestiona la conexión a la base de datos y el acesso para la tabla entregas.
 */
public class EntregaDAOImp implements IEntregaDAO {
	static private ConnectionManager connManager;
	static String idmax;
	int anyo;
	int mes;
	int dia;
	String hora="00:00:00";
	String completo;

	/**
	 * Constructor por dedfecto, intenta la conexción con el connection string = "alquilervehiculosBD"
	 * @throws DAOExcepcion Lanzada cuando no se puede conectar a la base de datos.
	 */
	public EntregaDAOImp() throws DAOExcepcion {
		super();
		try{
			setConnManager(new ConnectionManager("alquilervehiculosBD"));
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	/**
	 * Obtiene la lista de todas las entregas en la base de datos.
	 * @return
	 * @throws DAOExcepcion Lanzada cuando la consulta SQL es incorrecta.
	 */
	@Override
	public List<EntregaDTO> obtenerEntregas() throws DAOExcepcion {
		List<EntregaDTO> listaEntregaDTO = new ArrayList<EntregaDTO>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			getConnManager().connect();
			String query =  "select * from ENTREGA";
			st = connManager.getDbConn().prepareStatement(query);
			rs = st.executeQuery();
			getConnManager().close();
			st.close();

			while (rs.next()){
				LocalDateTime fecha = LocalDateTime.of(rs.getDate("FECHA").toLocalDate(),
						rs.getTime("FECHA").toLocalTime());
				EntregaDTO entDTO = new EntregaDTO(
						rs.getInt("ID"),
						fecha,
						rs.getString("TIPOSEGURO"),
						rs.getDouble("KMS"),
						rs.getDouble("COMBUSTIBLE"),
						rs.getString("COCHEASIGNADO"),
						rs.getString("EMPLEADOREALIZA")

						);
				listaEntregaDTO.add(entDTO);
			}
		}catch (SQLException e){
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
		return listaEntregaDTO;
	}

	/**
	 * Crea una nueva entrega en la base de datos.
	 * @param entregaDTO La nueva entrega
	 * @throws DAOExcepcion Lanzada cuando se produce un error en la sentencia SQL de inserción.
	 */
	@Override
	public void crearEntrega(EntregaDTO entregaDTO) throws DAOExcepcion {
		PreparedStatement st = null;
		try {
			anyo=entregaDTO.getFecha().getYear();
			mes=entregaDTO.getFecha().getMonthValue();
			dia=entregaDTO.getFecha().getDayOfMonth();
			completo=anyo+"-"+mes+"-"+dia+" "+hora;
			System.out.println("Sin trim:" +entregaDTO.getCoche()+"final Longitud: "+entregaDTO.getCoche().length());
			System.out.println("Con trim:" +entregaDTO.getCoche().trim()+"final Longitud: "+entregaDTO.getCoche().trim().length());
			getConnManager().connect();
			String query ="INSERT INTO ENTREGA (ID,FECHA,TIPOSEGURO,KMS,COMBUSTIBLE,COCHEASIGNADO,EMPLEADOREALIZA)"
					+ " VALUES("
					+ "?,?,?,?,?,?,?)";
			st = getConnManager().getDbConn().prepareStatement(query);
			st.setInt(1, entregaDTO.getId());
			st.setString(2, completo);
			st.setString(3, entregaDTO.getTipoSeguro());
			st.setDouble(4, entregaDTO.getKms());
			st.setDouble(5, entregaDTO.getCombustible());
			st.setString(6, entregaDTO.getCoche().trim());
			st.setString(7, entregaDTO.getEmpleado());
			st.executeUpdate();
			getConnManager().close();
			st.close();

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
	 * Devuelve la entrega con el ID máximo (la última entrega)
	 * @return La última entrega realizada.
	 * @throws DAOExcepcion Lanzada cuando se produce un error en la base de datos.
	 */
	public static String buscarIdMaxEntrega() throws DAOExcepcion{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			getConnManager().connect();
			String query = "select ID from Entrega";
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

	private static ConnectionManager getConnManager() {
		return connManager;
	}

	private static void setConnManager(ConnectionManager connManager) {
		EntregaDAOImp.connManager = connManager;
	}

}
