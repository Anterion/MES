package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOExcepcion;
import persistencia.dto.EntregaDTO;

/**
 * @author Lois
 * Implementaci�n de la interfaz IEntregaDAO, gestiona la conexi�n a la base de datos y el acesso para la tabla entregas.
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
	 * Constructor por dedfecto, intenta la conexci�n con el connection string = "alquilervehiculosBD"
	 * @throws DAOExcepcion Lanzada cuando no se puede conectar a la base de datos.
	 */
	public EntregaDAOImp() throws DAOExcepcion {
		super();
		try{
			connManager= new ConnectionManager("alquilervehiculosBD");
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
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from ENTREGA");
			connManager.close();

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
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listaEntregaDTO;
	}

	/**
	 * Crea una nueva entrega en la base de datos.
	 * @param entregaDTO La nueva entrega
	 * @throws DAOExcepcion Lanzada cuando se produce un error en la sentencia SQL de inserci�n.
	 */
	@Override
	public void crearEntrega(EntregaDTO entregaDTO) throws DAOExcepcion {
		try {
			anyo=entregaDTO.getFecha().getYear();
			mes=entregaDTO.getFecha().getMonthValue();
			dia=entregaDTO.getFecha().getDayOfMonth();
			completo=anyo+"-"+mes+"-"+dia+" "+hora;
			System.out.println("Sin trim:" +entregaDTO.getCoche()+"final Longitud: "+entregaDTO.getCoche().length());
			System.out.println("Con trim:" +entregaDTO.getCoche().trim()+"final Longitud: "+entregaDTO.getCoche().trim().length());
			connManager.connect();
			connManager.updateDB("INSERT INTO ENTREGA (ID,FECHA,TIPOSEGURO,KMS,COMBUSTIBLE,COCHEASIGNADO,EMPLEADOREALIZA)"
					+ " VALUES("+entregaDTO.getId()+",'"+completo+"','"+entregaDTO.getTipoSeguro()+"',"+entregaDTO.getKms()+","+entregaDTO.getCombustible()+",'"+entregaDTO.getCoche().trim()+"','"+entregaDTO.getEmpleado()+"')");
			connManager.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve la entrega con el ID m�ximo (la �ltima entrega)
	 * @return La �ltima entrega realizada.
	 * @throws DAOExcepcion Lanzada cuando se produce un error en la base de datos.
	 */
	public static String buscarIdMaxEntrega() throws DAOExcepcion{

		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select ID from Entrega");
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

}
