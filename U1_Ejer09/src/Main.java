import java.util.HashSet;

public class Main {

	public static void main(String[] args) {

		int[] arr = {1,4,6,5,4,2,6};
		
		for (int i : eliminarRepetidos(arr)) {
			System.out.println(i);
		}

	}

	public static int[] eliminarRepetidos(int[] arr) {
		HashSet<Integer> conjunto = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			conjunto.add(arr[i]);
		}
		
		int[] arraySinRepetidos = new int[conjunto.size()];
		int indice = 0;
		for (int elemento : conjunto) {
			arraySinRepetidos[indice++] = elemento;
		}
		
		return arraySinRepetidos;
	}
}
