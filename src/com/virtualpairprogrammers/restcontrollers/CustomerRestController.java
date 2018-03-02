package com.virtualpairprogrammers.restcontrollers;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController //adding this annotation replaces @Controller and @ResponseBody
public class CustomerRestController
{
    @Autowired
    private CustomerManagementService customerService;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ClientErrorInformation> rulesForCustomerNotfFound()
    {
        ClientErrorInformation error = new ClientErrorInformation("The customer wasn't found");
        return new ResponseEntity<ClientErrorInformation>(error, HttpStatus.NOT_FOUND);
    }

    //we want to support GETs to /customer/3737373
    //@ResponseBody  //this annot. tells spring that the return value needs to be converted to a representation response  body. i.e. xml or json
    @RequestMapping(value = "/customer/{id}")
    public Customer findCustomerById(@PathVariable String id) throws CustomerNotFoundException
    {
        return customerService.getFullCustomerDetail(id);
    }
}
