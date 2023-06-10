
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayEnteros = {5, 1, 3, 7};
		
		int[][] matriz = crearMatriz(arrayEnteros);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]); 
			}
			System.out.println();
		}
	}
	
	public static int[][] crearMatriz(int[] valores){
		int filas = valores.length;
		int columnas = 5;
		int[][] matriz = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = valores[i] +j;
			}
		}
		
		return matriz;
	}

}
