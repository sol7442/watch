package com.mom.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mom.watch.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
