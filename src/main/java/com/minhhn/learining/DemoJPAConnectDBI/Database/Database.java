package com.minhhn.learining.DemoJPAConnectDBI.Database;

import com.minhhn.learining.DemoJPAConnectDBI.Entity.Customer;
import com.minhhn.learining.DemoJPAConnectDBI.Service.Interface.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ICustomerService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                Customer customer = new Customer("1", "1", "1", "1",
//                        "1", "1", "1", "1");
//                Customer customer2 = new Customer("2", "2", "2", "2",
//                        "2", "2", "1", "2");
//                logger.info("data insert:" + service.add(customer));
//                logger.info("data insert:" + service.add(customer2));
            }
        };
    }
}
