
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "Aa 1!";
		
		comprobarCadena(cadena);
		
	}

	public static void comprobarCadena(String cadena) {
		cadena.length();
		
		for (int i = 0; i < cadena.length(); i++) {
			System.out.print(cadena.charAt(i) + " - ");
			if (Character.isUpperCase(cadena.charAt(i))) {
				System.out.println("Es Mayuscula");
			} else if (Character.isLowerCase(cadena.charAt(i))) {
				System.out.println("Es minuscula");
			} else if (Character.isDigit(cadena.charAt(i))) {
				System.out.println("Es un numero");
			} else if (Character.isWhitespace(cadena.charAt(i))) {
				System.out.println("Es un espacio en blanco");
			} else {
				System.out.println("Es otro caracter");
			}
		
		}
		
	}
}
