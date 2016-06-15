package helloWorld.convertor;

import helloWorld.domain.Customer;
import helloWorld.dto.MinCustomerInfo;
import helloWorld.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnavagarwal on 15/06/16.
 */
public class CustomerConvertor {


    @Autowired
    CustomerRepository customerRepository;

    public List<MinCustomerInfo> viewLast(String lastName){
        //List<Customer> customers=new ArrayList<>();
        List<MinCustomerInfo> minCustomerInfos=new ArrayList<>();
        for(Customer customer :customerRepository.findByLastName(lastName)){
            MinCustomerInfo minCustomerInfo=new MinCustomerInfo(customer.getPan(),customer.getFirstName()+customer.getLastName());
            minCustomerInfos.add(minCustomerInfo);
        }
        return minCustomerInfos;
    }
}
