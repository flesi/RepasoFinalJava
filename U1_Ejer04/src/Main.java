
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {6,7,8,9,10};
		
		System.out.println(sumarArrays(arr1,arr2)[1]);
				
	}

	public static int[] sumarArrays(int[] arr1, int[] arr2) {
		int[] suma = new int[arr1.length];
		
		for (int i = 0; i < suma.length; i++) {
			suma[i]=arr1[i]+arr2[i];
		}
		
		return suma;
	}
	
}
