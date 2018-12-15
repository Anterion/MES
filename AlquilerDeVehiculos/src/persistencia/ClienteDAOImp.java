package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ClienteDTO;
import excepciones.DAOExcepcion;

/**
 * @author Lois
 *Implementación de la interfaz IClienteDAO, contiene los métodos CRUD de clientes en la base de datos, así como la conexión a esta.
 */
public class ClienteDAOImp implements IClienteDAO {
	int anyo;
	int mes;
	int dia;
	String hora="00:00:00";
	String completo;
	protected ConnectionManager connManager;

	/**
	 * Constructor por defecto de CLienteDAOImp. Connecta la base de datos a la connection string = "alquilervehiculosBD"
	 * @throws DAOExcepcion Lanzada cuando no existe la clase de conexión a la base de datos.
	 */
	public ClienteDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
			}
	}

	/**
	 * Crea un nuevo cliente en la base de datos
	 * @param cliente El cliente a añadir
	 * @throws DAOExcepcion Lanzada cuando se produce un error de SQL,
	 */
	public void crearCliente(ClienteDTO cliente) throws DAOExcepcion{
		PreparedStatement st = null;
		try{
			anyo=cliente.getFechaCanetConducir().getYear();
			mes=cliente.getFechaCanetConducir().getMonthValue();
			dia=cliente.getFechaCanetConducir().getDayOfMonth();
			completo=anyo+"-"+mes+"-"+dia+" "+hora;
			connManager.connect();
			String query = "INSERT INTO CLIENTE (DNI, NOMBREAPELLIDOS, DIRECCION, POBLACION, CODPOSTAL, FECHACARNETCONDUCIR, DIGITOSTC,MESTC, \"a\u00f1oTC\", CVCTC, TIPOTC)"
					+ " VALUES("
					+ "?,?,?,?,?,?,?,?,?,?,?)";
			st = connManager.getDbConn().prepareStatement(query);
			st.setString(1, cliente.getDni().trim());
			st.setString(2, cliente.getNombreyApellidos().trim());
			st.setString(3, cliente.getDireccion().trim());
			st.setString(4, cliente.getPoblacion().trim());
			st.setString(5, cliente.getCodPostal().trim());
			st.setString(6, completo);
			st.setString(7, cliente.getDigitosTC().trim());
			st.setInt(8, cliente.getMesTC());
			st.setInt(9,  cliente.getAñoTC());
			st.setInt(10,  cliente.getCvcTC());
			st.setString(11, cliente.getTipoTC().trim());
			st.close();
			connManager.close();
		}
		catch (SQLException e){
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
	 * Busca un cliente en la base de datos
	 * @param dni El DNI del cliente a buscar.
	 * @return El objeto Cliente
	 * @throws DAOExcepcion Lanzada cuando ocurre cualquier error en la consulta SQL.
	 */
	public ClienteDTO buscarCliente(String dni) throws DAOExcepcion {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			connManager.connect();
			String query = "select * from CLIENTE where DNI= ?";
			st = connManager.getDbConn().prepareStatement(query);
			st.setString(1, dni);
			rs = st.executeQuery();
			connManager.close();
			st.close();

			if (rs.next()){
				LocalDateTime fechaCanetConducir = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),
						rs.getTime("FECHACARNETCONDUCIR").toLocalTime());
				//System.out.println("DNI: "+rs.getString("DNI")+" Nombre: "+ rs.getString("NOMBREAPELLIDOS")+" Direccion: "+rs.getString("DIRECCION")+" Poblacion: "+rs.getString("POBLACION")+" CP: "+rs.getString("CODPOSTAL")+" Fecha: "+fechaCanetConducir+" Digitos: "+rs.getString("DIGITOSTC"));
				ClienteDTO prueba = new ClienteDTO(
						rs.getString("DNI"),
						rs.getString("NOMBREAPELLIDOS"),
						rs.getString("DIRECCION"),
						rs.getString("POBLACION"),
						rs.getString("CODPOSTAL"),
						fechaCanetConducir,
						rs.getString("DIGITOSTC"),
						rs.getInt("MESTC"),
						rs.getInt("AÑOTC"),
						rs.getInt("CVCTC"),
						rs.getString("TIPOTC"));

				//System.out.println(prueba.getDni());
				 return prueba;
			}else
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
	 * Obtiene una lista con todos los clientes de la base de datos.
	 * @return La lista de clientes
	 * @throws DAOExcepcion Lanzada cuando se produce un error de acceso a la base de datos, o al construir el objeto cliente.
	 */
	@Override
	public List<ClienteDTO> obtenerClientes() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE");
			connManager.close();

			List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();

			try{
				while (rs.next()){
					LocalDateTime fechaCanetConducir = LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),
							rs.getTime("FECHACARNETCONDUCIR").toLocalTime());
					ClienteDTO cliDTO = new ClienteDTO(
							rs.getString("DNI"),
							rs.getString("NOMBREAPELLIDOS"),
							rs.getString("DIRECCION"),
							rs.getString("POBLACION"),
							rs.getString("CODPOSTAL"),
							fechaCanetConducir,
							rs.getString("DIGITOSTC"),
							rs.getInt("MESTC"),
							rs.getInt("AÑOTC"),
							rs.getInt("CVCTC"),
							rs.getString("TIPOTC"));
					listaClienteDTO.add(cliDTO);
				}
				return listaClienteDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		catch (DAOExcepcion e){		throw e;}
	}

}



