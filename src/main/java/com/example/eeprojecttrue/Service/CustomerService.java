package com.example.eeprojecttrue.Service;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Repository.CustomerRepository;
import com.example.eeprojecttrue.Repository.MomentRepository;
import com.example.eeprojecttrue.Service.Cluster.Clustering;
import com.example.eeprojecttrue.Service.Cluster.KMeansClustering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService  {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MomentRepository momentRepository;

    List<List<Customer>> result;
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

    public boolean reSave(Customer customer)
    {
         customerRepository.save(customer);
        return true;
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

    public void Cluster()
    {
        int K = 5;
        KMeansClustering xyCluster = new Clustering();
        List<Customer> customers=findAll();
        for(Customer customer:customers) {
            xyCluster.addRecord(customer);
        }
        xyCluster.setK(5);
        long a = System.currentTimeMillis();
        List<List<Customer>> cresult = xyCluster.clustering();
        long b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "ms");

        result=cresult;
    }

    public List<Customer> inCluster(Customer customer)
    {
        Cluster();
        for(List<Customer> lists:result)
        {
            if(lists.contains(customer))
                return lists;
        }
        List<Customer> list=new LinkedList<>();
        list.add(customer);
        return list;
    }
}
