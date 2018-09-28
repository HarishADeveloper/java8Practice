package main;

public interface TestInterFACE {

	default void helloMethod() {
		System.out.println("Hello world");
	}
	
	static void hellostaticMethod() {
		System.out.println("Hello from static method");
	}
}
