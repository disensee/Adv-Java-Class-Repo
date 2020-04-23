
public class StackDemo {

	public static void main(String[] args) {
		Stack<String> wordStack = new Stack();
		wordStack.push("reporters");
		wordStack.push("cover");
		wordStack.push("whales");
		wordStack.push("exploding");
		
		while(!wordStack.empty()) {
			System.out.println(wordStack.pop());
		}
	}

}
