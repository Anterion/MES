package excepciones;

@SuppressWarnings("serial")
public class LogicaExcepcion extends Exception {

	/**
	 * Lanza una excepci�n desde la capa de Logica de negocio
	 * @param message El mensaje para la Excepci�n
	 */
	public LogicaExcepcion(String message) {
		super(message);
	}

	/**
	 * Lanza una excepci�n desde la capa de Logica de negocio
	 * @param e La excepci�n a lanzar
	 */
	public LogicaExcepcion(Exception e) {
		super(e.getMessage());
	}

}
