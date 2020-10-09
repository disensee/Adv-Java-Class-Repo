import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
                
        list.add("pizza");
        list.add("coke");
        list.add("doritos");
        
        //list.remove(1);
        list.remove("coke");
        for(int i = 0; i < list.size(); i++){
            System.out.println("Shopping list item: " + list.get(i));
        }
	}

}
