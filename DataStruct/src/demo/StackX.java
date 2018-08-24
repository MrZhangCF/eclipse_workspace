package demo;
class StackY <T> {
	private int maxSize;
	private T[] stackArray;
	private int top;
	
	@SuppressWarnings("unchecked")
	public StackY(int s){
		maxSize = s;
		stackArray = (T[])new Object[maxSize];
		top = -1;
	}
	
	public void push(T t){
		if(!this.isFull()){
			stackArray[++top] = t;
		}else{
			System.out.println("the stack is full already");
		}

	}
	
	public T pop(){
		return stackArray[top--];
	}
	
	public T peek(){
		if(top == -1){
			return null;
		}
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == maxSize - 1);
	}
}

class Reverser{
	private String input;
	private String output;
	
	public Reverser(String in){
		input = in;
	}
	
	@SuppressWarnings("unchecked")
	public String doRev() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		int stackSize = input.length();
		@SuppressWarnings("rawtypes")
		StackY stack = (StackY) Class.forName("demo.StackX").newInstance();
		
		for(int i = 0;i < stackSize; i++){
			char ch = input.charAt(i);
			stack.push(ch);
		}
		
		output = "";
		while(!stack.isEmpty()){
			char ch = (char) stack.pop();
			output += ch;
		}
		return output;
	}
}
public class StackX {
	public static void main(String[] args) {
		String input, output;
		while(true){
			System.out.println("Enter a string:");
			System.out.flush();
//			intput = 
		}
	}
}
