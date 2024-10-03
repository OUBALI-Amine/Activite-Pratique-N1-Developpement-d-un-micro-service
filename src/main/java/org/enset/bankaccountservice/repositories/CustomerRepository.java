package org.enset.bankaccountservice.repositories;

import org.enset.bankaccountservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
