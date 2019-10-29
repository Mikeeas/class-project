package com.example.demo.Models.data;


import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
