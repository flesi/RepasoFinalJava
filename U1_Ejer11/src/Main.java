import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Numero de Filas: ");
//		int nFilas = sc.nextInt();
		
		System.out.println("Numero de Columnas: ");
//		int nColumnas = sc.nextInt();
		
		System.out.println("Numero para Bordes: ");
//		int nBordes = sc.nextInt();
		
		System.out.println("Numero para Relleno: ");
//		int nRelleno = sc.nextInt();
	
		int nFilas = 5;
		int nColumnas = 6;
		int nBordes = 1;
		int nRelleno = 0;
		
		
		for (int i = 0; i < nFilas; i++) {
			for (int j = 0; j < nColumnas; j++) {
				if (i==0 || i== nFilas -1 || j==0 || j == nColumnas -1) {
					System.out.print(nBordes + " ");
				}else {
					System.out.print(nRelleno + " ");
				}
			}
			System.out.println("");
		}
		
		
	}
	

}
