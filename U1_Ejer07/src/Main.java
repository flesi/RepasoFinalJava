
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayEnteros = {20, 15, 40, 5};
		
		
		for (int i = 0; i < arrayEnteros.length; i++) {
			int num = arrayEnteros[i];
			System.out.print(num + " ");
			pintarDiagramas(num);
			System.out.println("");
		}
	}
	
	public static void pintarDiagramas(int numero) {
		if (numero<=20) {
			for (int i = 0; i < numero; i++) {
				System.out.print("*");
			}
		}
	}

}
