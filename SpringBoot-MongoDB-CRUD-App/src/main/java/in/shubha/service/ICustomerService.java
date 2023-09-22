package in.shubha.service;

import java.util.List;

import in.shubha.document.Customer;

public interface ICustomerService {
	
	public String registerCustomer(Customer customer);
	
	public List <Customer> findAllCustomer();
	
	public String removeCustomer(String id);
	
	public List <Customer> fetchCustomersByBillAmountRange(Double start,Double end);
	
	public List<Customer> fetchCustomerByUsingCaddrAndHavingMobileNot(String...address);
}
