package com.multiple.databases.repositories1;

import com.multiple.databases.entities1.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
