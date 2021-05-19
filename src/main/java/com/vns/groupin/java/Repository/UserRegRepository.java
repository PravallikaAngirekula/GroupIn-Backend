package com.vns.groupin.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vns.groupin.java.Entity.UserRegistration;

@Repository
public interface UserRegRepository extends JpaRepository<UserRegistration, Long> {

	UserRegistration findByMobileNumber(String mobileNumber);

}
