package com.minhhn.learining.DemoJPAConnectDBI.Controller;

import com.minhhn.learining.DemoJPAConnectDBI.Entity.Customer;
import com.minhhn.learining.DemoJPAConnectDBI.Response.ResponseObject;
import com.minhhn.learining.DemoJPAConnectDBI.Service.Interface.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {
    // tao ra doi tuong service 1 lan ngay khi app duoc khoi tao
    @Autowired
    private ICustomerService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> add(@RequestBody Customer customer) {
        return new ResponseEntity<>
                (service.add(customer), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> get(@PathVariable int id) {
        return new ResponseEntity<>
                (service.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseObject> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseObject> edit(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.edit(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable int id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }


}
