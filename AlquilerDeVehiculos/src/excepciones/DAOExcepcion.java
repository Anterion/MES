package excepciones;

@SuppressWarnings("serial")
public class DAOExcepcion extends Exception {

	
	/**
	 * Lanza una excepción desde el Data Access Object.
	 * @param message El mensaje para la excepcion.
	 */
	public DAOExcepcion(String message) {
		super(message);
	}

	/**
	 * Lanza una excepción desde el Data Access Object.
	 * @param e La excepción a lanzar.
	 */
	public DAOExcepcion(Exception e) {
		super(e.getMessage());
	}

}
