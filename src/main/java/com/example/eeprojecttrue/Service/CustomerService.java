package com.example.eeprojecttrue.Service;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Repository.CustomerRepository;
import com.example.eeprojecttrue.Repository.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService  {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MomentRepository momentRepository;
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
        if(customerRepository.findByEmail(customer.getEmail())==null)
            return false;
        customer=customerRepository.findByEmail(customer.getEmail());
        return customer.getPassword().equals(customer.getPassword());
    }

    public List<Customer> findByName(String name)
    {
       return customerRepository.findByName(name);
    }
    public Customer findByEmail(String email)
    {
       return customerRepository.findByEmail(email);
    }
    public Customer findById(int id)
    {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    public List<Moment> findMoments(Customer customer)
    {
            Customer customer1=findById(customer.getId());
            List<Moment> moments=customer1.getMoments();
            return moments;
    }

    public void addMoments(Customer customer,Moment moment)
    {
        Customer customer1=findById(customer.getId());
        List<Moment> moments=customer1.getMoments();
        if(moments==null)
        {
            moments=new ArrayList<>();
            moments.add(moment);
            customer1.setMoments(moments);
        }
        else
            moments.add(moment);
    }
}
