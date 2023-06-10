import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.print("Numero entero: ");
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		
		for (int i = 1; i <= numero; i++) {
			System.out.println(i + " - " + obtenerLetras(numero));
		}

	}

	
	public static String obtenerLetras(int numero) {
		StringBuilder sb = new StringBuilder();
		char letra = 'a';
		for (int i = 0; i < numero; i++) {
			sb.append(letra);
			letra++;
		}
		
		if (letra > 'z') {
			letra = 'a';
		}
		
		return sb.toString();
	}
}
