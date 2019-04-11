package question6;

public class HashcodeEqualsDemo {
	
	private String name;
	private int id;
	
	
	public HashcodeEqualsDemo(String name , int id){
		this.name = name;
		this.id = id;
	}
	
	public HashcodeEqualsDemo(){}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
		
		HashcodeEqualsDemo demo = (HashcodeEqualsDemo)obj;
		return demo.name == this.name && demo.id == this.id;
	}
	
	@Override
	public int hashCode() {
		return id*10;
	}
	
	public static void main(String[] args) {
		HashcodeEqualsDemo demo1 = new HashcodeEqualsDemo("Vishal",123);
		HashcodeEqualsDemo demo2 = new HashcodeEqualsDemo("Vishal",321);
		
		System.out.println("Hash code is: "+demo1.hashCode());
		System.out.println("Hash code is: "+demo2.hashCode());
		
		if(demo1.equals(demo2)){
			System.out.println("Both objects are same");
		}else{
			System.out.println("Both objects are not same");
		}
		
		if(demo1.name.equals(demo2.name)){
			System.out.println("names are same");
		}
		
	}

}
