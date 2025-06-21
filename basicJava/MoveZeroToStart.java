package basicJava;

public class MoveZeroToStart {
	    public static void main(String[] args) {
	        int arr[] = {1,2,4,0,0,3,0};
	        int index = 0;
	        int temp = 0;
	        for(int i =0; i<arr.length ; i++){
	            if(arr[i]==0){
	             temp=arr[i];
	             arr[i]=arr[index];
	             arr[index]=temp;
	             index++;
	            }
	        }
	        for(int i = 0 ; i < arr.length ; i++){
	            System.out.print(arr[i]);
	        }
	    }
	}

