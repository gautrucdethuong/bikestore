package com.minhhn.learining.DemoJPAConnectDBI.Repository;

import com.minhhn.learining.DemoJPAConnectDBI.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByEmailAndPhone(String email, String phone);
    Customer findCustomerByEmail(String email);

}
