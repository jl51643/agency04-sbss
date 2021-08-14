package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	@Modifying
	@Query(value = "UPDATE Delivery SET Delivery.username = null WHERE Delivery.username = :username", nativeQuery = true)
	void detachCustomerFromDelivery(@Param("username") String username);

}
