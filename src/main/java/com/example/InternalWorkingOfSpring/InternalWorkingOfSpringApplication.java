package com.example.InternalWorkingOfSpring;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalWorkingOfSpringApplication implements CommandLineRunner {// we can also use the commandlineRunner for run the method 

	public static void main(String[] args) {
		SpringApplication.run(InternalWorkingOfSpringApplication.class, args);
	}
	// @Autowired
	private PaymentService obj;//here we did not used the new keyword still able to access the method that the reason we use the springboot 
									// it gives the Bean and helps to create loosely Coupling of objects


	// here we have two ways to Inject the object that is Dependency Injection 
	//1.using Constructor Injection best practice is used this becasuse we can modifty the objects declaration also
	//2. using @Autowired in this we dont have to create a constructor or setter method


	public InternalWorkingOfSpringApplication(PaymentService obj){
		this.obj=obj;
	}

	@Override // here we overdide the method and run after the main method which calls the pay methhod we also run this statement in main method just we have to make static object
	
	public void run(String... args) throws Exception {
		String payment=obj.pay();
		System.out.println("Payment Done from "+payment);
	}

	

}
