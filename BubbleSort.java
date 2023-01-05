public class BubbleSort extends BubbleSortBase {
    //Was told to stick to spec all I added was return statement
	BubbleSort(){
		super();
	}

	@Override
	public int[] bubblesort(int[] sorted) {
		    for(int i = 0; i < sorted.length-1; i++){
		    for(int j = 0; j < (sorted.length-1-i); j++){
		        if(sorted[j+1] < sorted[j]){
		            int temp = sorted[j];
		            sorted[j] = sorted[j+1];
		            sorted[j+1] = temp;
		        }
		    }
		}
		    return sorted;
		}
	}
	