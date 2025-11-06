package com.codewithmosh.store.carts;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    @EntityGraph(attributePaths = "items.product")
    @Query("select c from Cart c WHERE c.id= :cartId")
    Optional<Cart> getCartWithItems(@Param("cartId") UUID cartId);

}