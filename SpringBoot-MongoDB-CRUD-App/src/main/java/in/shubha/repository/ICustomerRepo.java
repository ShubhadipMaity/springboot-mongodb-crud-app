package in.shubha.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.shubha.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
	
//	syntax: <ReturnType> findBy<Properties><Condition>(parameters...)
	
	public List<Customer> findByBillAmountBetween(Double start,Double end);
	
//	syntax: <ReturnType> findBy<Properties><Condition>(parameters...)

	public List<Customer> findByCaddrInAndMobileNoIsNotNull(String... address); 
}
