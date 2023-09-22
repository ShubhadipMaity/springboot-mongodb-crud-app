package in.shubha.runner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.shubha.document.Customer;
import in.shubha.generator.IdGenerator;
import in.shubha.service.ICustomerService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerService service;

	@Override
	public void run(String... args) throws Exception {
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("WELCOME TO CUSTOMER RELATIONSHIP PROJECT");
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			
			
			System.out.print("Enter ur choice :: ");
			String choice=reader.readLine();
			
			switch(choice) {
				
			case "1":
				insertDocument();
				break;
				
			case "2":
				selectDocument();
				break;
				
			case "3":
				updateDocument();
				break;
				
				
			case "4":
				deleteDocument();
				break;
				
			case "5":
				System.out.println("Thanks for using this application");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice.. PLZ try again...");				
				break;
				
			}


		}
		
	}

	@SuppressWarnings("unused")
	private void findByCaddrInAndMobileNoIsNotNull() {
		service.fetchCustomerByUsingCaddrAndHavingMobileNot("MI","RCB","CSK").forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private void findCustomersByBillRange() {
		service.fetchCustomersByBillAmountRange(2000.0, 10000.0).forEach(System.out::println);
	}

	private void deleteDocument() {
		String id="eff3bf0308";
		System.out.println(	service.removeCustomer(id));
	}

	private void updateDocument() {
		Customer customer=new Customer();
		String documentId = "eff3bf0308";
		customer.setCid(documentId);
		customer.setCno(10);
		customer.setCname("SHUBHADIP");
		customer.setCaddr("INDIA");
		customer.setBillAmount(75000.0);
		customer.setMobileNo(1234567890L);
		System.out.println(service.registerCustomer(customer));
	}

	private void selectDocument() {
		service.findAllCustomer().forEach(System.out::println);
	}

	
	private void insertDocument() {
		
		Customer customer1=new Customer();
		customer1.setCid(IdGenerator.generateId());
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the customer id :: ");
		customer1.setCno(scanner.nextInt());
		System.out.print("Enter the customer name :: ");
		customer1.setCname(scanner.next());
		System.out.print("Enter the customer address :: ");
		customer1.setCaddr(scanner.next());
		System.out.print("Enter the customer billAmount:: ");
		customer1.setBillAmount(scanner.nextDouble());
		System.out.print("Enter the customer mobileNo :: ");
		customer1.setMobileNo(scanner.nextLong());
		System.out.println(service.registerCustomer(customer1));
	}

}
