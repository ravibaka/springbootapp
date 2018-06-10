package com.example.demo.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domin.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomers(Model model) {
 
		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return listOfCustomers;
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllCustomers";
	}
 
	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getCustomerById(@PathVariable String id) {
		customerService.getCustomer(Long.valueOf(id));
	}
 
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addOrUpdateCustomer(customer);
 
	}
 
	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.addOrUpdateCustomer(customer); 
 
	}	
 
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
 
 
	}
	
}
