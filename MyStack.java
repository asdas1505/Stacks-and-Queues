
public class MyStack<T>{

	public T[] stackArray;
	public int numElements = 0;
	private int maxSize = 100;


	public MyStack(){
		this.stackArray = (T[])new Object[maxSize];
	}

	@SuppressWarnings("unchecked")
	public void push(T value){

		if(numElements==this.maxSize){
			this.maxSize = 2*this.maxSize;
			T []temp = (T[])new Object[maxSize];
			for(int i = 0; i < numElements; i++){
				temp[i] = this.stackArray[i];
			}
			this.stackArray = temp;
		}
		stackArray[numElements] = value;
		numElements++;				
		return;
	}

	@SuppressWarnings("unchecked")
	public T pop() throws EmptyStackException{
		if(numElements==0){
			throw new EmptyStackException("Stack is empty");
		}
		else{
			numElements--;
			return stackArray[numElements];	
		}	
	}

	@SuppressWarnings("unchecked")
	public T top() throws EmptyStackException{
		if(numElements==0){
			throw new EmptyStackException("Stack is empty");
		}
		else{
			return stackArray[numElements-1];
		}
	}

	public boolean isEmpty(){
		if(numElements==0){
			return true;
		}	
		else{
			return false;
		}
	}

	/*	
	public static void main(String args[]){

		MyStack<Integer> ob1 = new MyStack<Integer>();	
		int i=0;
		int j=0;
		while(i <= 1){
			ob1.push(i);
			i++;
		}
		System.out.println(ob1.isEmpty());
		while(j <= 1){
			System.out.println(((MyStack)ob1).stackArray[j]);
			j++;
		}

		int c = ob1.top();
		int a = ob1.pop();
		int b = ob1.pop();
		System.out.println("c: " + c + " " + "a: "+ a + "  b " + b);	
		System.out.println(ob1.isEmpty());
	}
*/


}

class EmptyStackException extends Exception{

    public EmptyStackException(String s)
    {
    // Call constructor of parent Exception
        super(s);
        }
}

