package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass extends TestParentClass implements TestInterFACE {
	
	 int i =10;
	public static void main(String[] args) {
		
		
		List<String> temp = null;
		System.out.println(temp.stream());
		
		int w1 = 10;
		System.out.println(w1>>2);
		w1 = 10;
		System.out.println(w1<<2);
		TestClass testclass = new TestClass();
		testclass.helloMethod();

		TestClass.hellostatcMethod();

		List<String> list = Arrays.asList(new String[] { "helllo", "Harish" });

		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		list.forEach((t) -> {
			System.out.println(t);
		});

		List<EmployeeClass> empList = getEmpList();

		empList.stream().forEach(empl -> {
			// this is used for streaming
			// write some business logic here
			// might through concurrent modification exception in some scenarios

			System.out.println("emp id: " + empl.getEmpId() + ", emp manager Id: " + empl.getManagerId());
		});

		Map<Integer, List<EmployeeClass>> groupedMap = empList.stream()
				.collect(Collectors.groupingBy(EmployeeClass::getManagerId));
		// by using stream we have many options like grouping and filtering
		// here we are doing grouping by using Collectors class from util package by
		// providing above syntax

		groupedMap.keySet().forEach(managerId -> {
			System.out.println("empl under manager : " + managerId);
			groupedMap.get(managerId).forEach(emp -> {
				System.out.println(emp.getEmpId());
			}); 
			System.out.println("============");
		});

		// integers sorting in java 8
		empList.sort((o1, o2) -> {
			return o1.getEmpId() - o2.getEmpId();
		});

		// java 7 sorting
		empList.sort(new Comparator<EmployeeClass>() {
			@Override
			public int compare(EmployeeClass o1, EmployeeClass o2) {
				return o1.getEmpId() - o2.getEmpId();
			}
		});

		// strings sorting
		/*
		 * empList.sort((o1, o2) -> { return o1.getName().compareTo(o2.getName()); });
		 */

		java.util.function.UnaryOperator<Integer> multipl; // one of the predefined functional Interfaces in Java8 which
															// has one method with single argument and returns
															// an object of same type as input argument

		multipl = (a) -> a * 2; // assigning a method logic to the interface

		System.out.println(multipl.apply(1)); // usage of the above functional interface
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		Stream<Integer> sequentialStream = myList.stream();
		
		Stream<Integer> parallemStrem = myList.parallelStream();
		
		Stream<Integer> highNumbers = parallemStrem.filter(p-> p<90);
		highNumbers.forEach(x-> System.out.println("Parallel "+x));
		
		Stream<Integer> highNumbersSeq = sequentialStream.filter(p-> p>90);
		highNumbersSeq.forEach(x->System.out.println("Sequential "+x));
		
		//finding a number is prime or not
		System.out.println("is 10 a prime : "+TestClass.isPrime(10));
		System.out.println("is 11 a prime :"+ TestClass.isPrimeRevWay(11));
		
		IntStream.range(2, 20).forEach(a->{System.out.println(a+" :"+ TestClass.isPrime(a));});
		
		IntStream.range(2, 20).forEach(a->{System.out.println(a+" :"+TestClass.isPrimeRevWay(a));});
		
		
		int[] intArr = new int[] {1,2,3,4,5,6,7,9};
		
		System.out.println(Arrays.stream(intArr).sum());
		System.out.println(Arrays.stream(intArr));
		
	}
	
	private static boolean isPrime(int num) {
		 return IntStream.rangeClosed(2, num/2).noneMatch(i->num%i==0);
		
	}
	
	private static boolean isPrimeRevWay(int num) {
		return !IntStream.rangeClosed(2, num/2).anyMatch(i->num%i==0);
	}

	private static List<EmployeeClass> getEmpList() {
		List<EmployeeClass> list = new ArrayList<EmployeeClass>();

		EmployeeClass emp;

		for (int i = 0; i < 5; i++) {
			emp = new EmployeeClass();
			emp.setEmpId(i + 1);
			if (i < 4) {
				emp.setManagerId(4);
			} else {
				emp.setManagerId(0);
			}
			list.add(emp);
		}
		return list;
	}
	
}
