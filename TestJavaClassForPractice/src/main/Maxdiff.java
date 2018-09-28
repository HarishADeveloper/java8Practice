package main;

public class Maxdiff {
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,1,8,3,1};
		getMaxDiffNum(arr);
	}

	private static void getMaxDiffNum(int[] arr) {
		int res = -1;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) {
					res = arr[i]-arr[j]>res ? arr[i]-arr[j]: res;
				}
			}
		}
		System.out.println(res);
	}
	
	
}
