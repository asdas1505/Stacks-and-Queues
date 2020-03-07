
public class StackSort{
	
	// public static void main(String args[]){

	// 	int[] numArray = {21,5,3,4};
	// 	StackSort obj1 = new StackSort();
	// 	String[][] stringArray = obj1.kSort(numArray);
	// 	for(int i = 0; i < stringArray.length; i++){
	// 		for(int j = 0; j < stringArray[0].length; j++){
	// 		    System.out.print(stringArray[i][j] + " ");
	// 		}
	// 		System.out.println("");
	// 	}

	// }	

	public StackSort(){

	}

	public String[][] kSort(int []nums) throws EmptyStackException{

		int[] sortArray = new int[nums.length];
		String[][] ppArray = new String[nums.length][2*nums.length];
		MyStack<Integer> stackArray = new MyStack<Integer>();
		int m = 0;
		while(true){						
			int i = 0;
			int j = 0;
			int k = 0;
			stackArray.push(nums[0]);
			ppArray[m][k] = "PUSH";
			k++;
			while(!stackArray.isEmpty()){
				if(i==nums.length-1){
					sortArray[j] = stackArray.pop();
					j++;
					ppArray[m][k] = "POP";
					k++;
				}			
				else if(nums[i+1]>=stackArray.top()){
					sortArray[j] = stackArray.pop();
					j++;
					ppArray[m][k] = "POP";
					k++;
					i++;
					while(!stackArray.isEmpty()){
						if(nums[i] > stackArray.top()){
							sortArray[j] = stackArray.pop();
							j++;
							ppArray[m][k] = "POP";
							k++;
						}
						else{
							break;
						}	
					}
					stackArray.push(nums[i]);
					ppArray[m][k] = "PUSH";
					k++;
				}
				else{
					i++;
					stackArray.push(nums[i]);
					ppArray[m][k] = "PUSH";
					k++;
				}		
			}

			for(i = 1; i < sortArray.length; i++){
				if(sortArray[i-1] > sortArray[i]){
					break;	
				}
			} 

			if(i==sortArray.length){
				break;
			}

			nums = sortArray;
			m++;
		}

		String[][] ppCopy = new String[m+1][ppArray[0].length]; 

		for(int i = 0; i <= m; i++){
			for(int j = 0; j < ppArray[0].length; j++){
				ppCopy[i][j] = ppArray[i][j];
			}
		}

		return ppCopy;
	} 


	public String[] sort(int []nums) throws EmptyStackException{
	
		int[] sortArray = new int[nums.length];
		String[] ppArray = new String[2*nums.length];
		String[] impArray = {"NOTPOSSIBLE"};		
		MyStack<Integer> stackArray = new MyStack<Integer>();
		int i = 0;
		int j = 0;
		int k = 0;
		stackArray.push(nums[0]);
		ppArray[k] = "PUSH";
		k++;
		while(!stackArray.isEmpty()){
			if(i==nums.length-1){
				sortArray[j] = stackArray.pop();
				j++;
				ppArray[k] = "POP";
				k++;
			}			
			else if(nums[i+1]>stackArray.top()){
				sortArray[j] = stackArray.pop();
				j++;
				ppArray[k] = "POP";
				k++;
				i++;

				while(!stackArray.isEmpty()){
					if(nums[i] > stackArray.top()){
						sortArray[j] = stackArray.pop();
						j++;
						ppArray[k] = "POP";
						k++;
					}
					else{
						break;
					}	
				}
				stackArray.push(nums[i]);
				ppArray[k] = "PUSH";
				k++;
			}
			else{
				i++;
				stackArray.push(nums[i]);
				ppArray[k] = "PUSH";
				k++;
			}		
		}

		for(i = 1; i < sortArray.length; i++){
			if(sortArray[i-1] > sortArray[i]){
				break;	
			}
		} 

		if(i==sortArray.length){
			return ppArray;	
		}
		else{
			return impArray;
		}

	}	

}





