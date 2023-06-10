
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] valoresDouble = {1.5, 2.7, 3.9, 4.2, 5.1};
		
		System.out.println("Valores double");
		for (double valor : valoresDouble) {
			System.out.print(valor + " ");
		}
		
		System.out.println("");
		System.out.println("Valores Int");
		int[] valoresInt = convertirDoubleAInt(valoresDouble);
		
		for (int valor : valoresInt) {
			System.out.print(valor + " ");
		}
		
		
	}

	
	public static int[] convertirDoubleAInt(double[] valoresDouble) {
		int[] valoresInt = new int[valoresDouble.length];
		
		for (int i = 0; i < valoresInt.length; i++) {
			valoresInt[i] = (int) valoresDouble[i];
		}
		
		return valoresInt;
	}
}
