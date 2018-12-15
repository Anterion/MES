package persistencia;

import java.sql.*;

import org.hsqldb.Statement;

/**
 * @author Lois
 * Se encarga de realizar la conexi�n y desconexi�n al servidor SQL.
 */
public class ConnectionManager {
	private String sourceURL;
	private Connection dbcon = null;

	/**
	 * Obtiene la conexion a la base de datos.
	 * @return El objeto connection.
	 */
	public Connection getDbConn(){
		return this.dbcon;
	}
	/**
	 * Constructor, crea la conexi�n a la clase java hsqldb
	 * @param dbname Connection String de la base de datos.
	 * @throws ClassNotFoundException Lanzada cuando no se encuentra la librer�a en el proyecto.
	 */
	public ConnectionManager(String dbname) throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		sourceURL = "jdbc:hsqldb:file:./data/" + dbname + ";shutdown=true;";
	}

	/**
	 * Intenta una conexci�n a la base de datos.
	 * @throws SQLException Lanzada cuando no se consique realizar la conexi�n exitiosamente.
	 */
	public void connect() throws SQLException {
		if (dbcon == null)
				dbcon = DriverManager.getConnection(sourceURL);
	}

	/**
	 * Terminar conexi�n a la base de datos.
	 * @throws SQLException Lanzada cuando no se consigue terminar la conexi�n.
	 */
	public void close() throws SQLException {
		if (dbcon != null) {
				dbcon.close();
				dbcon = null;
		}
	}

	/**
	 * Manda una sentencia de actualizaci�n a la base de datos.
	 * @param sql La sentencia de actualizaci�n a enviar.
	 * @throws SQLException Lanzada cuando ocurre alg�n error al actualizar la base de datos.
	 */
	public void updateDB(String sql) throws SQLException {
		if (dbcon != null) {
				java.sql.Statement sentencia = dbcon.createStatement();
				try{
					sentencia.executeUpdate(sql);
					sentencia.close();
				}
				catch (SQLException e){
					sentencia.close();
				}
		}
	}

	/**
	 * Manda una sentencia SQL arbitraria a la base de datos.
	 * @param sql La sentencia a enviar
	 * @return La respuesta de la base de datos.
	 * @throws SQLException Lanzada cuando hay un error en la sentencia SQL mandada.
	 */
	public ResultSet queryDB(String sql) throws SQLException {
		if (dbcon != null) {
				java.sql.Statement sentencia = dbcon.createStatement();
				ResultSet res = null;
				try{
					res = sentencia.executeQuery(sql);
					sentencia.close();
				}
				catch (SQLException e){
					sentencia.close();
				}
				return res;
		}
		return null;
	}
}
