package com.sweetener.libraryapp.dao;

import com.sweetener.libraryapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
