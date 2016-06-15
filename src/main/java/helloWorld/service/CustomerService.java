package helloWorld.service;

import helloWorld.convertor.CustomerConvertor;
import helloWorld.domain.Customer;
//import helloWorld.dto.CustomerDTO;
import helloWorld.dto.MinCustomerInfo;
import helloWorld.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by arnavagarwal on 14/06/16.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConvertor customerConvertor;

    public void add(String firstName, String lastName, String pan) {
        customerRepository.save(new Customer(firstName, lastName, pan));
    }

    public void delFirstName(String firstName) {
        customerRepository.deleteByFirstName(firstName);
    }

    public void delLastName(String lastname) {
        customerRepository.deleteByLastName(lastname);
    }

    public void delPan(String pan) {
        customerRepository.deleteByPan(pan);
    }

    public String viewFirst(String firstName) {
        Customer customer = customerRepository.findByFirstName(firstName);
        return customer.getFirstName();

    }

    public boolean existsPan(String pan){
        boolean val = customerRepository.existsByPan(pan);
        return val;
    }


    public List<MinCustomerInfo> viewLast(String lastName){

//        List<Customer> customers =new ArrayList<>();
//        for(Customer customer:customerRepository.findByLastName(lastName)){
//            customers.add(customer);

        return customerConvertor.viewLast(lastName);

        }
      //  return customers;
    //}

    public List<Customer> viewAll(){

        List<Customer> customers =new ArrayList<>();
        for(Customer customer:customerRepository.findAll()){
            customers.add(customer);
        }
        return customers;
    }

    public Customer viewPan(String pan) {

        Customer customer = customerRepository.findByPan(pan);
        return customer;
    }




    public void view() {
        System.out.println("###############################################");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer.getFirstName()+customer.getLastName()+customer.getPan());
        }
    }

    public MinCustomerInfo getMinCustomerInfo(String pan) {
        Customer customer = customerRepository.findByPan(pan);
        return new MinCustomerInfo(customer.getPan(), customer.getFirstName() + customer.getLastName());
    }


}
