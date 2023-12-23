package com.JPAImpl1.JPAImpl1.Repository;

import com.JPAImpl1.JPAImpl1.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
