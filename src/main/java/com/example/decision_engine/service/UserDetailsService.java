package com.example.decision_engine.service;

import com.example.decision_engine.entity.UserDetails;

import java.util.Optional;

public interface UserDetailsService {
    UserDetails createUserDetails(UserDetails userDetails);
    Optional<UserDetails> fetchUserDetailsById(Integer userDetailsId);
    UserDetails updateUserDetails(Integer userDetailsId, UserDetails userDetails);
    void deleteUserDetailsById(Integer userDetailsId);
    UserDetails fetchUserDetailsByPersonalCode(String personalCode);



}

