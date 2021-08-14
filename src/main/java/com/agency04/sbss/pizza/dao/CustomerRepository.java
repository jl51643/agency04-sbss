package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Modifying
	@Query("UPDATE Customer c SET c.customerDetails = :newCustomerDetails WHERE c.username = :username")
	void updateCustomerDetails(@Param("newCustomerDetails") CustomerDetails newCustomerDetails, @Param("username") String username);
}
