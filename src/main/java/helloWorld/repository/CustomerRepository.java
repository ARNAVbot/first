package helloWorld.repository;

import helloWorld.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by arnavagarwal on 14/06/16.
 */
public interface CustomerRepository extends MongoRepository<Customer,String>,CustomerRepositoryCustom{

    public Customer findByFirstName(String FirstName);
    public List<Customer> findByLastName(String LastName);
    public Customer findByPan(String Pan);
    public void deleteByFirstName(String fistName);
    public void deleteByLastName(String lastName);
    public void deleteByPan(String pan);


}
