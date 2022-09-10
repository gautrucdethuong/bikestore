package com.minhhn.learining.DemoJPAConnectDBI.Service.Interface;

import com.minhhn.learining.DemoJPAConnectDBI.Entity.Customer;
import com.minhhn.learining.DemoJPAConnectDBI.Response.ResponseObject;

public interface ICustomerService {
    ResponseObject add(Customer customer);

    ResponseObject edit(Customer customer);

    //boolean delete(int id);
    ResponseObject delete(int id);

    ResponseObject getCustomer(int id);

    ResponseObject getAll();
}
