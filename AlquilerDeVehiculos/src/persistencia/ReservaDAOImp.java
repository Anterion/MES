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
	int anyoDev;
	int mesDev;
	int diaDev;
	String completoDev;
	int anyoRec;
	int mesRec;
	int diaRec;
	String completoRec;
	String hora="00:00:00";
	static String idmax;
	protected static ConnectionManager connManager;

	/**
	 * Constructor por defecto. Intenta la conexión a la connectionstring = "alquilervehhiculosBS"
	 * @throws DAOExcepcion
	 */
	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
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
		try{
	    	anyoDev=reserva.getFechaDevolucion().getYear();
			mesDev=reserva.getFechaDevolucion().getMonthValue();
			diaDev=reserva.getFechaDevolucion().getDayOfMonth();
			completoDev=anyoDev+"-"+mesDev+"-"+diaDev+" "+hora;
	    	anyoRec=reserva.getFechaRecogida().getYear();
			mesRec=reserva.getFechaRecogida().getMonthValue();
			diaRec=reserva.getFechaRecogida().getDayOfMonth();
			completoRec=anyoDev+"-"+mesDev+"-"+diaDev+" "+hora;
			connManager.connect();
			connManager.updateDB("INSERT INTO RESERVA (ID, FECHARECOGIDA, FECHADEVOLUCION, MODALIDADALQUILER, CATEGORIA, CLIENTEREALIZA, SUCURSALRECOGIDA, SUCURSALDEVOLUCION)"
					+ " VALUES("+reserva.getId()+",'"+completoRec+"','"+completoDev+"','"+reserva.getModalidadAlquiler()+"','"+reserva.getNombreCategoria().trim()+"','"+reserva.getDniCliente().trim()+"',"+reserva.getIdSucursalRecogida()+","+reserva.getIdSucursalDevolucion()+")");						
			connManager.close();	
		}
		catch (SQLException e){
			e.printStackTrace();}
	}
	/**
	 * Obtiene la lista de todas las reservas en la base de datos.
	 * @return La lista de las reservas.
	 * @throws DAOExcepcion Lanzada cuando hay un error al acceder a la base de datos, o los datos contenidos son incorrectos.
	 */
	public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA");						
			connManager.close();
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
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
	/**
	 * Obtiene las reservas en una sucursas, según su origen,.
	 * @param idSucursal El id de la sucursal de origen.
	 * @return La lista de reservas de la sucursal que coindice con el origen.
	 * @throws DAOExcepcion Lanzada cuando ocurre un error al acceder a la base de datos, o los datos contenidos son incorrectos. 
	 */
	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA where SUCURSALRECOGIDA= "+idSucursal);						
			connManager.close();
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
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
	/**
	 * Busca una  reserva en la base de datos. Por su ID 
	 * @param id El id de la reserva a buscar.
	 * @return El objeto reserva buscado, o null si no existe.
	 * @throws DAOExcepcion Lanzado cuando ocurre algún error al acceder a la base de datos, o la sentencia es incorrecta.
	 */
	public ReservaDTO buscarReserva(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Reserva where ID= "+id);
			connManager.close();
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
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}
	
	/**
	 * Busca la reserva más reciente en la base de datos. (ID con valor más alto)
	 * @return La reserva más reciente (ID más alto)
	 * @throws DAOExcepcion Lanzada cuando ocurre un error con la sentencia SQL.
	 */
	public static String buscarIdMaxReserva() throws DAOExcepcion{
		
		try {
			connManager.connect();
			ResultSet rs=connManager.queryDB("select ID from Reserva");
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