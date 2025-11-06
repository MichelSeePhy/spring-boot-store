package com.codewithmosh.store.orders;

import com.codewithmosh.store.users.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = "items.product")
    @Query("select o from Order o where o.customer= :customer")
    List<Order> getOrdersByCustomer(@Param("customer") User customer);

    @EntityGraph(attributePaths = "items.product")
    @Query("select o from Order o where o.id= :orderId")
    Optional<Order> getOrderWithItems(@Param("orderId") long orderId);

}