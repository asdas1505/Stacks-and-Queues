
public class MyCalculator{


	public MyCalculator(){
	
	}


	// public static void main(String args[]){

	// 	MyCalculator obj = new MyCalculator();
	// 	String expression = "((1+(4+5+2)-3)+(6+18))";
	// 	int ans = obj.calculate(expression);
	// 	System.out.print(ans);
	// }

	public int calculate (String expression) throws EmptyStackException{


		MyStack<String> operators = new MyStack<String>();
		MyStack<Integer> numbers = new MyStack<Integer>();

		String s2 = expression;
		s2 = s2.replaceAll(" ", "");
		int i = 0;
		int tempnum = 0;

		while(i < s2.length()){

			if((s2.substring(i,i+1)).equals("(")){
				String temp = s2.substring(i,i+1);
				operators.push(temp);
				i++;	
			}

			else if((s2.substring(i,i+1)).equals(")")){
				while(!(operators.top()).equals("(")){
					numbers.push(calculate(numbers.pop(),numbers.pop(),operators.pop()));	
				}
				operators.pop();
				i++;
			}

			else if((s2.substring(i,i+1)).equals("-") || (s2.substring(i,i+1)).equals("*") || (s2.substring(i,i+1)).equals("+")){				
				String temp = s2.substring(i,i+1);
				tempnum++;
				//System.out.println(i);
				if(tempnum > 1){
					if(!operators.isEmpty()){
						if(prefer(operators.top()) >= prefer(temp)){										// && !(operators.top()).equals("(") && !(operators.top()).equals(")")
							numbers.push(calculate(numbers.pop(), numbers.pop(), operators.pop()));			
							operators.push(temp);
							i++;
						}
						else{
							operators.push(temp);
							i++;
						}
					}	
					else{
						operators.push(temp);
						i++;
					}
				}

				else if(tempnum==1){
					operators.push(temp);
					i++;
				}		
			}

			else{
				String temp = "";
				while( i < s2.length() && !(s2.substring(i,i+1)).equals("-") && !(s2.substring(i,i+1)).equals("*") && !(s2.substring(i,i+1)).equals("+") && !(s2.substring(i,i+1)).equals("(") && !(s2.substring(i,i+1)).equals(")")){
					temp = temp + s2.substring(i,i+1);
					i++;	
				}
				int k = Integer.parseInt(temp);			
				numbers.push(k);	
			}

		}

		while(!operators.isEmpty()){
			numbers.push(calculate(numbers.pop(),numbers.pop(), operators.pop()));				
		}
			
		return numbers.top();		
	}


	public static int calculate(int a, int b, String c){
		if(c.equals("+")){
			return a + b;
		}
		else if(c.equals("*")){
			return a*b;
		}
		else if(c.equals("-")){
			return b-a;
		}
		return 0;
	}

	public static int prefer(String s){
		if(s.equals("*")){
			return 2;
		}

		else if(s.equals("+")){
			return 1;
		}

		else if(s.equals("-")){
			return 1;
		}
		else if(s.equals(")")){
			return -1;
		}
		else if(s.equals("(")){
			return -1;
		}

		return 0;
	}

}