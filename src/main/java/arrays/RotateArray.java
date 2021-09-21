package arrays;

public class RotateArray {
	
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6};
		int[] outputArray = new int[a.length];
		int rotateElement=2;
		int startIter=a.length-rotateElement;
		int k=0;
		for(int i=0,j=startIter;i<a.length;i++,j++) {
			if(j<=a.length-1) {
				outputArray[i]=a[j];
			}else {				
				outputArray[i]=a[k];
				k++;
			}
		}
		for(int p=0;p<=outputArray.length-1;p++) {
			System.out.println("output array "+outputArray[p]);
		}
	}

}
