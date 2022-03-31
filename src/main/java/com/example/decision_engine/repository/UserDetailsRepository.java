package com.example.decision_engine.repository;

import com.example.decision_engine.entity.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

    UserDetails findByPersonalCode(String PersonalCode);

}
