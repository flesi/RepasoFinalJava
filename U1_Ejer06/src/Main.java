
public class Main {

	public static void main(String[] args) {
		String[] cadenas = {"Hola", "Mundo", "Java", "Programación"};
		String cadenasSinRepetir = concatenarCadenas(cadenas);
		System.out.println(cadenasSinRepetir);


	}

	public static String concatenarCadenas(String[] cadenas) {
		StringBuilder sb = new StringBuilder();
		
		for (String cadena : cadenas) {
			for (int i = 0; i < cadenas.length; i++) {
				char caracter = cadena.charAt(i);
				if (sb.indexOf(String.valueOf(caracter))==-1) {
					sb.append(caracter);
				}
			}
		}
		
		return sb.toString();
	}
}
