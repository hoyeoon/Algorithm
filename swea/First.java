package swea;

public class First {
	static int cv;				// 1
	
	int iv;						// 2
	
	static void cMethodA() {
		
		cv = 100;
		cMethodB();
		
	}	// 3
	
	static void cMethodB() {
		
		First f = new First();
		f.iv = 10;
		f.iMethodA();
		
	}	// 4
	
	void iMethodA() {
		
		cv = 100;
		cMethodA();
		
	}			// 5
	
	void iMethodB() {
		
		iv = 100;
		iMethodA();
		
	}			// 6
	
	void iMethodC() {
		
		Second.cMethod();
		Second s = new Second();
		s.iMethod();
		
	}			// 7
			
	void iMethodD(Second s) {
		
		Second.cMethod();
		s.iMethod();
		
	}	// 8
	
	public static void main(String[] args) {
		
	}
	
}
class Second {
	static void cMethod() {}	// 9
	
	void iMethod() {}			// 10
}

