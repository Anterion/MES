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
		try{
			anyo=cliente.getFechaCanetConducir().getYear();
			mes=cliente.getFechaCanetConducir().getMonthValue();
			dia=cliente.getFechaCanetConducir().getDayOfMonth();
			completo=anyo+"-"+mes+"-"+dia+" "+hora;
			connManager.connect();
			connManager.updateDB("INSERT INTO CLIENTE (DNI, NOMBREAPELLIDOS, DIRECCION, POBLACION, CODPOSTAL, FECHACARNETCONDUCIR, DIGITOSTC,MESTC, \"a\u00f1oTC\", CVCTC, TIPOTC)"
					+ " VALUES('"+cliente.getDni().trim()+"','"+cliente.getNombreyApellidos().trim()+"','"+cliente.getDireccion().trim()+"','"+cliente.getPoblacion().trim()+"','"+cliente.getCodPostal().trim()+"','"+completo+"','"+cliente.getDigitosTC().trim()+"',"+cliente.getMesTC()+","+cliente.getAñoTC()+","+cliente.getCvcTC()+",'"+cliente.getTipoTC().trim()+"')");						
			connManager.close();
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}
		
	}

	/**
	 * Busca un cliente en la base de datos
	 * @param dni El DNI del cliente a buscar.
	 * @return El objeto Cliente
	 * @throws DAOExcepcion Lanzada cuando ocurre cualquier error en la consulta SQL.
	 */
	public ClienteDTO buscarCliente(String dni) throws DAOExcepcion {
		
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE where DNI= '"+dni+"'");
			connManager.close();
		
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
		catch (SQLException e){	throw new DAOExcepcion(e);}	
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



