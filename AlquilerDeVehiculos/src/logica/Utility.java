package logica;

/**
 *
 * @author Jorvicar
 *Clase que contiene metodos de utilidad general.
 */
public class Utility {

	/**
	 * Metodo que comprueba si el valor del parametro de entrada es un Integer.
	 * @param str Cadena de la cual se desea comprobar si es Integer.
	 * @return El método devuelve true en caso de que la cadena del parametro de entrada sea
	 * un Integer, y false en el caso contrario.
	 */
	public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
