package com.ankat.repository.db3;

import com.ankat.model.db3.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "customerRepository")
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
