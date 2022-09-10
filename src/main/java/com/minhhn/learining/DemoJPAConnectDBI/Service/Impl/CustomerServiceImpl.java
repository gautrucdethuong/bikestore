package com.minhhn.learining.DemoJPAConnectDBI.Service.Impl;

import com.minhhn.learining.DemoJPAConnectDBI.Constants.StatusCode;
import com.minhhn.learining.DemoJPAConnectDBI.Constants.StatusRequest;
import com.minhhn.learining.DemoJPAConnectDBI.Entity.Customer;
import com.minhhn.learining.DemoJPAConnectDBI.Repository.CustomerRepository;
import com.minhhn.learining.DemoJPAConnectDBI.Response.ResponseObject;
import com.minhhn.learining.DemoJPAConnectDBI.Service.Interface.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public ResponseObject add(Customer customer) {

        ResponseObject object = new ResponseObject();
        object.setCode(StatusCode.CREATED.getValue());
        object.setStatus(StatusRequest.SUCCESS.getResult());
        object.setObject(customerRepository.save(customer));
        object.setMessage("Add successful!");

        return object;
    }

    @Override
    public ResponseObject edit(Customer newCustomer) {
        ResponseObject object = new ResponseObject();
        if (!customerRepository.findById(newCustomer.getId()).isPresent()) {
            object.setStatus(StatusRequest.FAIL.getResult());
            object.setMessage("Update failed!");
            object.setCode(StatusCode.SUCCESS.getValue());
            object.setObject("");
        } else {
            object.setStatus(StatusRequest.SUCCESS.getResult());
            object.setMessage("Update successful!");
            object.setCode(StatusCode.SUCCESS.getValue());
            object.setObject(customerRepository.save(newCustomer));
        }
        return object;
    }

    @Override
    public ResponseObject delete(int id) {
        ResponseObject object = new ResponseObject();
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            object.setStatus(StatusRequest.FAIL.getResult());
            object.setCode(StatusCode.SUCCESS.getValue());
            object.setMessage("Found not customer at " + id);
        } else {
            object.setStatus(StatusRequest.SUCCESS.getResult());
            object.setCode(StatusCode.SUCCESS.getValue());
            object.setMessage("Delete success!");
            customerRepository.deleteById(id);
        }
        return object;
    }

    @Override
    public ResponseObject getCustomer(int id) {
        ResponseObject object = new ResponseObject();
        Customer found = customerRepository.findById(id).orElse(null);
        if (found != null) {
            object.setStatus(StatusRequest.SUCCESS.getResult());
            object.setMessage("Find customer at " + id);
            object.setCode(StatusCode.SUCCESS.getValue());
            object.setObject(found);
        } else {
            object.setStatus(StatusRequest.FAIL.getResult());
            object.setMessage("Find not customer at " + id);
            object.setCode(StatusCode.SUCCESS.getValue());
            object.setObject("");
        }
        return object;
    }

    @Override
    public ResponseObject getAll() {
        ResponseObject object = new ResponseObject();
        object.setCode(StatusCode.SUCCESS.getValue());
        object.setStatus(StatusRequest.SUCCESS.getResult());
        object.setMessage("Get success");
        object.setObject(customerRepository.findAll());
        return object;
    }
}
