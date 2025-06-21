package basicJava;

class Parent{
	public void poly() {
	System.out.println("Parent");
}
}
class Example extends Parent{

	private int speed;
	public void one (int speed){
		if(speed>0) {
			this.speed = speed;
			System.out.println("Speed is "+speed);
		}
			
			else {
				System.out.println("Speed is 0 or less");
			}
	
				
}
	public void poly() {
	System.out.println("in example");
}
	public void one(int a, int b) {
		System.out.println("a is " + a +" b is "+b);
	}
}


class Example2 extends Parent{
	public void one(){
		System.out.println("In class Example2");
	}
	public void poly() {
		System.out.println("in Example2");
	}
	
}
