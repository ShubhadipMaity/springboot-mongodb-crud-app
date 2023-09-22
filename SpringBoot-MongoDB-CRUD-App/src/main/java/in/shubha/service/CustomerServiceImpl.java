package in.shubha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shubha.document.Customer;
import in.shubha.repository.ICustomerRepo;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepo repo;
	
	@Override
	public String registerCustomer(Customer customer) {
		
		//perform both insert/update Operation
		
		return "Customer is saved with the id :: "+repo.save(customer).getCid();
	}

	@Override
	public List<Customer> findAllCustomer() {
		
		List<Customer> customer=repo.findAll();
		
		return customer;
	}

	@Override
	public String removeCustomer(String id) {
		
		Optional<Customer> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			
			return "Document is deleted";
			
		}
		return "Docement not found";
	}

	@Override
	public List<Customer> fetchCustomersByBillAmountRange(Double start, Double end) {
		
		
		return repo.findByBillAmountBetween(start, end);
	}

	@Override
	public List<Customer> fetchCustomerByUsingCaddrAndHavingMobileNot(String... address) {
		
		
		return repo.findByCaddrInAndMobileNoIsNotNull(address);
	}

}
