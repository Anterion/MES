package excepciones;

@SuppressWarnings("serial")
public class LogicaExcepcion extends Exception {

	/**
	 * Lanza una excepción desde la capa de Logica de negocio
	 * @param message El mensaje para la Excepción
	 */
	public LogicaExcepcion(String message) {
		super(message);
	}

	/**
	 * Lanza una excepción desde la capa de Logica de negocio
	 * @param e La excepción a lanzar
	 */
	public LogicaExcepcion(Exception e) {
		super(e.getMessage());
	}

}
