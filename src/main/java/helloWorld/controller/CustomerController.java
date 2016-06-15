package helloWorld.controller;

import helloWorld.domain.Customer;
//import helloWorld.dto.CustomerDTO;
import helloWorld.dto.CustomerDTO;
import helloWorld.dto.MinCustomerInfo;
import helloWorld.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arnavagarwal on 14/06/16.
 */

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    //@RequestMapping(value="add", method = RequestMethod.POST)
    /*@RequestMapping( method = RequestMethod.POST)
    public String add(@RequestParam(value = "details") String[] details) {

        customerService.add(details[0], details[1], details[2]);
        customerService.view();
        return "Added";
    }*/

/*
    @RequestMapping(method=RequestMethod.POST)
    public String addInfo(@RequestBody CustomerDTO customerDTO){

        customerService.add(customerDTO.getFirstName(),customerDTO.getLastName(),customerDTO.getPan());
        return "Added";
    }*/

    @RequestMapping(value="viewLast",method = RequestMethod.GET)
    //@RequestMapping(value="{lastName}",method = RequestMethod.GET)
    public List<MinCustomerInfo> viewlast(@RequestParam(value="name")String name){

        //List<Customer> customers=customerService.viewLast(name);
        List<MinCustomerInfo> minCustomerInfos=customerService.viewLast(name);
        return minCustomerInfos;
    }

   // @RequestMapping(value="all",method=RequestMethod.GET)
   @RequestMapping(method=RequestMethod.GET)
    public List<Customer> viewAll(){

        return customerService.viewAll();
    }


    @RequestMapping(value="minInfo",method = RequestMethod.GET)
    public MinCustomerInfo viewInfo(@RequestParam(value="pan")String pan){
        return customerService.getMinCustomerInfo(pan);

    }

    @RequestMapping(value = "viewFirst", method = RequestMethod.GET)
    public String viewFirst(@RequestParam(value = "name") String name) {

        String fullname=customerService.viewFirst(name);
        System.out.println(fullname);
        return fullname;
    }

    @RequestMapping(value="existsPan",method = RequestMethod.GET)
    public String existsPan(@RequestParam(value="pan")String pan){

        boolean val=customerService.existsPan(pan);
        if(val==true)
            return "Given Pan exists";
        else
            return "Given Pan does not exists";
    }


    @RequestMapping(value = "viewPan", method = RequestMethod.GET)
    public String viewPan(@RequestParam(value = "pan") String pan) {

        //Customer customer = customerDTO.viewPan(pan);
        Customer customer = customerService.viewPan(pan);
        System.out.println(customer.getFirstName()+customer.getLastName());
        return customer.getFirstName()+" "+customer.getLastName();
    }


    @RequestMapping(value = "firstname", method = RequestMethod.DELETE)
    public String delFirstName(@RequestParam(value = "name") String name) {

        customerService.delFirstName(name);
        customerService.view();
        return "Deleted";
    }




    @RequestMapping(value = "lastname", method = RequestMethod.DELETE)
    public String delLastName(@RequestParam("name") String name) {

        customerService.delLastName(name);
        customerService.view();
        return "Deleted";
    }


    @RequestMapping(value = "pan", method = RequestMethod.DELETE)
    public String delPan(@RequestParam("pan") String pan) {

        customerService.delPan(pan);
        customerService.view();
        return "Deleted";

    }
}
