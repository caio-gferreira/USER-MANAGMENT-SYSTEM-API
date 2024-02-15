package com.systemmanagment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.systemmanagment.models.User;

public interface UserRepository extends MongoRepository<User, String> {
}
