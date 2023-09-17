package maccess;
import java.util.*;
public class DemoArray2 {
	//@SuppressWarnings("removal")
	public static void main(String[] args) {
		
		Scanner s =new Scanner(System.in);
		System.out.println("Enter the size : ");
		int n=Integer.parseInt(s.nextLine());
		String ob[]=new String[n];
		System.out.println("Enter " + n + " string element");

		for(int i=0;i<ob.length;i++) {
			ob[i]=s.nextLine();
			
		}
		for(String k :ob) {
			System.out.print(k.toString()+" ");
		}
		System.out.println("\n====spliterator<T>=====");
		Spliterator<String> sp=Arrays.spliterator(ob);
		sp.forEachRemaining((k)->{
			System.out.print(k.toString()+" ");
		});
   s.close();
	}

}
