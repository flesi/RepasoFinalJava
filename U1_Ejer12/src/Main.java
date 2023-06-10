import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce nº valores: ");
		int nValores = sc.nextInt();
		
		int[] arrayValores = new int[nValores];
				
		for (int i = 0; i < arrayValores.length; i++) {
			System.out.print("Teclea Valor " + (i+1) + ": ");
			arrayValores[i]=sc.nextInt();
		}
		
		for (int i = 0; i < arrayValores.length; i++) {
			System.out.print("Divisores de " + arrayValores[i] + ": ");
			for (int divisor : divisoresNum(arrayValores[i])) {
				System.out.print(divisor + " ");
			}
			System.out.println("");
		}
				
	}

	public static ArrayList<Integer> divisoresNum(int num){
		ArrayList<Integer> divisores = new ArrayList<>();
		
		for (int i = 1; i <= num; i++) {
			if (num%i==0) {
				divisores.add(i);
			}
		}
		
		return divisores;
	}
}
