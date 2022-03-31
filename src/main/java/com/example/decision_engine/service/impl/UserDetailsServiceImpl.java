package com.example.decision_engine.service.impl;

import com.example.decision_engine.entity.UserDetails;
import com.example.decision_engine.repository.UserDetailsRepository;
import com.example.decision_engine.service.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails createUserDetails (UserDetails userDetails) {
        return  userDetailsRepository.save(userDetails);
    }

    @Override
    public Optional<UserDetails> fetchUserDetailsById (Integer userDetailsId) {
        return userDetailsRepository.findById(userDetailsId);
    }

    @Override
    public UserDetails updateUserDetails (Integer userDetailsId, UserDetails userDetails) {
        UserDetails userDB= userDetailsRepository.findById(userDetailsId).get();

        userDB.setPersonalCode(userDetails.getPersonalCode());
        userDB.setSegmentation(userDetails.getSegmentation());

        return userDetailsRepository.save(userDB);
    }

    @Override
    public void deleteUserDetailsById (Integer userDetailsId) {
        userDetailsRepository.deleteById(userDetailsId);

    }

    @Override
    public UserDetails fetchUserDetailsByPersonalCode (String personalCode) {
        return userDetailsRepository.findByPersonalCode(personalCode);
    }


}
