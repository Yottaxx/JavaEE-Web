package com.example.eeprojecttrue.Service;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean Save(Customer customer)
    {
        Customer customer1=customerRepository.findByEmail(customer.getEmail());
        if(customer1==null)
        {
            customerRepository.save(customer);
            return true;
        }
        if( customer1.getName() == null) {
            customerRepository.save(customer);
            return true;
        }
        else
            return false;
    }

    public boolean Login(Customer customer)
    {
        Customer customer1=customerRepository.findByEmail(customer.getEmail());
        return customer1.getPassword().equals(customer.getPassword());
    }


}
