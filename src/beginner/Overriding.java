package beginner;

public class Overriding extends Fatheri {
	
	public int add(int a , int b)
	
	 {
		 int z = a+b;
		 return z;
	 }
	
	/*public int div (int a , int b)
	
	 {
		 int z = a%b;
		 return z;
	 }*/
	
	public static void main(String[] args) {
	
		Overriding Objref= new Overriding();
		
		GrandFatheri Gobj = new Overriding();
		
		System.out.println("the sum is " +Objref.add(8, 9));
		System.out.println("the div is " +Objref.div(9, 2));
		System.out.println("the pro is " +Objref.multiply(4, 2));
		System.out.println("the top cast multiply is here " +Gobj.multiply(8,6));
		
	}

}
